package com.example.dao;

import com.example.entity.SmbmsProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmbmsProviderDao {
    //通过供应商名查询供应商信息
    //为什么写这个方法这么写，用了第二种方式
    //public SmbmsProvider getSmbmsProviderByName(String name);

    /**
     * 查询所有供应商信息+模糊查询
     * @return
     */
    public List<SmbmsProvider> showProviderList(String name);
}
