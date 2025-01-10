package com.example.service;

import com.example.entity.SmbmsUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface SmbmsUserService {
    /**
     * 登录功能
     * @param name 用户名
     * @param password 密码
     * @return 布尔值，true成功,false失败
     */
    public boolean login(String name, String password);

    /**
     * 查询所有用户并支持模糊查询
     * @return
     */
    public PageInfo<SmbmsUser> showList(String name, int pageNum);

    /**
     * 查看功能
     * @param id
     * @return
     */
    public SmbmsUser viewUser(int id);


}
