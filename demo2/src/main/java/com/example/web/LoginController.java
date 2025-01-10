package com.example.web;

import com.example.entity.SmbmsProvider;
import com.example.entity.SmbmsUser;
import com.example.service.SmbmsProviderService;
import com.example.service.SmbmsUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/user")

public class LoginController {
    //将业务层注入
    @Resource
    private SmbmsUserService smbmsUserService;
    @Resource
    private SmbmsProviderService smbmsProviderService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
//        System.out.println(username+"-------------");
//        System.out.println(password+"-------------");
        session.setAttribute("username", username);
        boolean login = smbmsUserService.login(username,password);//调用业务层
        if(login)
        {
            //成功后跳转跳转
            return "welcome";
        }
        else {
            //失败继续登录
            return "login";
        }
    }
    @RequestMapping("/showList")
    //查询
    public String showList(Model model, String uname, @RequestParam(defaultValue = "1") int pageNum){
        PageInfo<SmbmsUser> pageInfo = smbmsUserService.showList(uname,pageNum);
        if(pageInfo.getList().size()>0){
            //将list存储起来
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("uname", uname);
            return "userList";
        }
        else {
            return "error";
        }
    }

    @RequestMapping("/showPList")
    //查询供应商
    /**
     * 1.接收请求参数：
     * 接收前端传递的 pageNum（当前页码）。
     * 接收其他查询条件（如 pname）。
     * 函数的@RequestsParam接收请求行传值,但如果是普通的类型的话，可以省略
     * 2.调用 Service 层方法：
     * 调用 Service 层的分页查询方法，获取分页数据。
     * 3.返回结果：
     * 将分页数据传递给前端页面（通常通过 Model）。
     */
    public String showPList(Model model,String pname,@RequestParam(defaultValue = "1") int pageNum){
        PageInfo<SmbmsProvider> pageInfo = smbmsProviderService.showPList(pname,pageNum);
        if(!pageInfo.getList().isEmpty()){
            //将list存储起来
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("uname", pname);
            return "providerList";
        }
        else {
            return "error";
        }
    }

    @RequestMapping("/viewUser")
    public String viewUser(Model model,int id){
        SmbmsUser smbmsUser = smbmsUserService.viewUser(id);
        if(smbmsUser != null){
            model.addAttribute("smbmsUser", smbmsUser);
            return "userView";
        }
        else{
            return "error";
        }

    }
}
