package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XTY~
 * @version 1.0
 * @Date: 2022-06-27 11:41
 * @Description:
 */
@Service
public class DistrictServiceImpl implements IDistrictService
{
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getParent(String parent)
    {
        List<District> byParent = districtMapper.findByParent(parent);
        /**
         * 为了提升效率，我们可以在进行网络传输时，为了避免无效数据的传递，可以将无效数据设置为null
         * 提升了流量，也提升了效率
         */
        for (District district : byParent) {
            district.setId(null);
            district.setParent(null);
        }
        return new ArrayList<>(byParent);
    }

    @Override
    public String fineNameByCode(String code)
    {
        return districtMapper.findNameByCode(code);
    }
}