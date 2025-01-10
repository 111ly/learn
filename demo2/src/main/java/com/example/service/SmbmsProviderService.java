package com.example.service;

import com.example.entity.SmbmsProvider;
import com.example.entity.SmbmsUser;
import com.github.pagehelper.PageInfo;


import java.util.List;

public interface SmbmsProviderService {
    /**
     * 查询所有供应商并支持模糊查询
     * @return
     */
    public PageInfo<SmbmsProvider> showPList(String name, int pageNum);
}
