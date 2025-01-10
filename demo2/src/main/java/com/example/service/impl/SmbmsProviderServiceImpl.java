package com.example.service.impl;

import com.example.dao.SmbmsProviderDao;
import com.example.entity.SmbmsProvider;
import com.example.entity.SmbmsUser;
import com.example.service.SmbmsProviderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SmbmsProviderServiceImpl implements SmbmsProviderService {
    @Autowired
    private SmbmsProviderDao smbmsProviderDao;//将数据库注入进来
    /**
     * 使用 PageHelper.startPage(pageNum, pageSize) 设置分页参数。
     * 调用 DAO 层方法获取数据。
     * 将查询结果封装到 PageInfo 对象中并返回
     * controller层需要pageInfo,所以还需要返回pageInfo
     */
    @Override
    public PageInfo<SmbmsProvider> showPList(String name,int pageNum) {

        //设置当前页，页面容量
        PageHelper.startPage(pageNum,5);
        List<SmbmsProvider> list  = smbmsProviderDao.showProviderList(name);
        PageInfo<SmbmsProvider> pageInfo = new PageInfo<>(list);
        if (!pageInfo.getList().isEmpty()) {
            return pageInfo;
        }
        else{
            return null;
        }

    }


}
