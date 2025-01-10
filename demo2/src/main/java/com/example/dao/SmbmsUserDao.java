package com.example.dao;

import com.example.entity.SmbmsUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmbmsUserDao {
    //通过用户名查询用户信息
   //为什么写这个方法这么写，用了第二种方式
    public SmbmsUser getSmbmsUserByName(String name);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<SmbmsUser> showUserList(SmbmsUser smbmsUser);
}
