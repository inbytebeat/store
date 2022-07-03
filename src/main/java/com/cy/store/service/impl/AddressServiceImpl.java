package com.cy.store.service.impl;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;
import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.IDistrictService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-25 21:39
 * @Description: 实现地址处理的Service实现类
 */
@Service
public class AddressServiceImpl implements IAddressService
{
    @Autowired
    private AddressMapper addressMapper;
    //添加用户的地址信息依赖于设置地址的IDistrictService的业务层接口
    @Autowired
    private IDistrictService districtService;

    //获取配置文件中的所设定的最大数
    @Value("${user.address.max-count}")
    private Integer maxCountOfAddress;

    @Override
    public void addNewAddress(String username, Integer uid, Address address)
    {
        Integer count = addressMapper.countByUid(uid);
        if(count >= maxCountOfAddress)
        {
            throw new AddressCountLimitException("用户的地址条数已打上限");
        }

        //从districtService中获取省，市，区的信息，然后添加到address对象中，获取完整的地址信息
        String provinceName = districtService.fineNameByCode(address.getProvinceCode());
        String cityName = districtService.fineNameByCode(address.getCityCode());
        String areaName = districtService.fineNameByCode(address.getAreaCode());
        address.setAreaName(areaName);
        address.setProvinceName(provinceName);
        address.setCityName(cityName);

        //补全uid，isDelete
        address.setUid(uid);
        //如果查询到当前用户的地址数为0，则设置该条插入的记录为默认地址，isDefault设置为1
        Integer isDefault = (count == 0 ? 1 : 0);
        address.setIsDefault(isDefault);

        //补全四项日志 方便后期维护纠错
        address.setCreatedTime(new Date());
        address.setCreatedUser(username);
        address.setModifiedTime(new Date());
        address.setModifiedUser(username);
        Integer result = addressMapper.insert(address);

        if(result != 1)
        {
            throw new InsertException("用户插入地址时产生异常");
        }
    }

    @Override
    public List<Address> selectAddressByUid(Integer uid)
    {
        List<Address> addresses = addressMapper.findByUid(uid);
        for (Address address : addresses) {
            address.setProvinceCode(null);
            address.setCityCode(null);
            address.setAreaCode(null);
            address.setTel(null);
            address.setCreatedTime(null);
            address.setIsDefault(null);
            address.setModifiedUser(null);
            address.setModifiedTime(null);
        }
        return addresses;
    }


    @Override
    public void setDefault(Integer aid, Integer uid, String username)
    {
        Address address = addressMapper.selectByAid(aid,uid);
        if(address == null)
        {
            throw new AddressNotFoundException("该地址可能已经被删除");
        }
        if(address.getUid() != uid)
        {
            throw new AddressDeniedException("该地址为非法数据");
        }
        //先将所有的地址设置为非默认
        Integer rows1 = addressMapper.setNoDefault(uid);
        if(rows1 < 1)
        {
            throw new UpdateException("更新地址信息时产生未知的异常");
        }
        //将指定地址设置为默认地址
        Integer rows2 = addressMapper.setDefault(aid, username, new Date());
        if(rows2 != 1)
        {
            throw new UpdateException("设置默认地址时产生未知的异常");
        }
    }

    @Override
    public void deleteAddress(Integer aid, Integer uid, String username)
    {
        Address address = addressMapper.selectByAid(aid,uid);
        if(address == null)
        {
            throw new AddressNotFoundException("地址不存在");
        }
        if(!address.getUid().equals(uid))
        {
            throw new AddressDeniedException("非法的地址数据");
        }
        Integer row = addressMapper.deleteByAid(aid);
        if (row != 1)
        {
            throw new DeleteAddressException("删除时产生位置的异常");
        }
        
        Integer count = addressMapper.countByUid(uid);
        if(count == 0)
            return;

        //如果删除的地址记录并不是默认的，则执行完毕
        if(address.getIsDefault() == 0)
        {
            return;
        }

        //如果删除的是默认的记录，则需要将最新修改的一条记录设置为用户的默认收货地址
        Address address1 = addressMapper.orderByCreateTime(uid);
        Integer integer = addressMapper.setDefault(address1.getAid(), username, new Date());
        if(integer != 1)
        {
            throw new UpdateException("更新数据时产生未知的异常");
        }


    }

    @Override
    public Address getById(Integer aid,Integer uid)
    {
        Address selectByAid = addressMapper.selectByAid(aid,uid);
        if(selectByAid == null)
        {
            throw new AddressNotFoundException("地址不存在");
        }
        if(!selectByAid.getUid().equals(uid))
        {
            throw new AddressDeniedException("非法的地址数据");
        }
        selectByAid.setProvinceCode(null);
        selectByAid.setCityCode(null);
        selectByAid.setAreaCode(null);
        selectByAid.setCreatedUser(null);
        selectByAid.setCreatedTime(null);
        selectByAid.setModifiedUser(null);
        selectByAid.setModifiedTime(null);
        return selectByAid;
    }


}