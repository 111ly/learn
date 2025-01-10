package com.example.service.impl;

import com.example.dao.SmbmsUserDao;
import com.example.entity.SmbmsUser;
import com.example.service.SmbmsUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//代表业务层实现
public class SmbmsUserServiceImpl implements SmbmsUserService {
    //将数据库注入进来
    @Autowired
    //注解的作用：Spring 会自动将 SmbmsUserDao 的实现类注入到 smbmsUserDao 变量中。
    // 通过 smbmsUserDao，服务层可以调用数据访问层的方法来查询数据库
    private SmbmsUserDao smbmsUserDao;
    //登录功能实现
    @Override
    public boolean login(String name, String password) {
        SmbmsUser user = smbmsUserDao.getSmbmsUserByName(name);

        if (user != null) {
            if (user.getUserPassword().equals(password)) {
                return true;
            }
            else{
            return false;}
        }
        return false;
    }

    @Override
    public PageInfo<SmbmsUser> showList(String name,int pageNum) {
        //设置当前页，页面容量
        PageHelper.startPage(pageNum,5);
        SmbmsUser smbmsUser = new SmbmsUser();
        smbmsUser.setUserName(name);
        List<SmbmsUser> list = smbmsUserDao.showUserList(smbmsUser);
        //将数据放在PageInfo
        PageInfo<SmbmsUser> pageInfo = new PageInfo<>(list);
        if(pageInfo.getList().size()>0){
            return pageInfo;
        }else{
            return null;
        }

    }

    @Override
    public SmbmsUser viewUser(int id) {
        SmbmsUser smbmsUser = new SmbmsUser();
        smbmsUser.setId(id);

        List<SmbmsUser> list = smbmsUserDao.showUserList(smbmsUser);
        if(!list.isEmpty()){
            return list.get(0);
        }else{
            return null;
        }

    }
}
