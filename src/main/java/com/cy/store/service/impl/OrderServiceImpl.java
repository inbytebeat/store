package com.cy.store.service.impl;

import com.cy.store.entity.Address;
import com.cy.store.entity.Order;
import com.cy.store.entity.OrderItem;
import com.cy.store.mapper.CartMapper;
import com.cy.store.mapper.OrderMapper;
import com.cy.store.service.IAddressService;
import com.cy.store.service.ICartService;
import com.cy.store.service.IOrderService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-07-03 14:16
 * @Description: 订单模块业务层实现
 */
@Service
public class OrderServiceImpl implements IOrderService
{
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IAddressService addressService;
    @Autowired
    private ICartService cartService;

    @Override
    public Order createOrder(Integer aid, Integer uid, String username, Integer[] cids)
    {
        Long totalPrice = 0L;
        //获取即将下单的商品列表
        List<CartVO> results = cartService.getByCids(uid, cids);
        for (CartVO cartVo : results) {
            totalPrice += cartVo.getRealPrice() * cartVo.getNum();
        }
        Address address = addressService.getById(aid, uid);
        Order order = new Order();
        order.setUid(uid);
        order.setRecvName(address.getName());
        order.setRecvPhone(address.getPhone());
        order.setRecvCity(address.getCityCode());
        order.setRecvArea(address.getAreaName());
        order.setRecvAddress(address.getAddress());
        //支付状态，总价，创建日期
        order.setStatus(0);
        order.setTotalPrice(totalPrice);
        order.setModifiedTime(new Date());
        //日志信息
        order.setCreatedUser(username);
        order.setCreatedTime(new Date());
        order.setModifiedUser(username);
        order.setModifiedTime(new Date());

        Integer rows = orderMapper.insertOrder(order);
        if(rows != 1)
        {
            throw new InsertException("插入数据时异常");
        }

        for (CartVO cartVo : results) {
            //创建订单项的详细数据
            OrderItem orderItem = new OrderItem();
            orderItem.setTitle(cartVo.getTitle());
            orderItem.setOid(order.getOid());
            orderItem.setPid(cartVo.getPid());
            orderItem.setImage(cartVo.getImage());
            orderItem.setPrice(cartVo.getRealPrice());
            orderItem.setNum(cartVo.getNum());

            orderItem.setCreatedUser(username);
            orderItem.setCreatedTime(new Date());
            orderItem.setModifiedUser(username);
            orderItem.setModifiedTime(new Date());
            Integer rows2 = orderMapper.insertOrderItem(orderItem);
            if(rows2 != 1)
            {
                throw new InsertException("插入订单项时产生异常");
            }
        }
        return order;
    }
}