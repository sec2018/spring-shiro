package com.example.controller;

import com.example.util.AESUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by WangZJ on 2018/8/12.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/sublogin",method = RequestMethod.POST)
    public String subLogin(String username,String password,HttpSession session,Model model){
        Subject subject = SecurityUtils.getSubject();
        try {
            password = AESUtil.encryptData(password);
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            if (!subject.isAuthenticated()){
                //使用shiro来验证
                token.setRememberMe(true);
                subject.login(token);//验证角色和权限
                System.out.println(username+" success login");
            }
        } catch (Exception e) {
        	return "login";
        }
        model.addAttribute("hello","Hello, Spring Boot!");
        return "index";
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String Test(){
    	System.out.println(10/0);
        return "okkkk！";
    }

    @RequestMapping(value = "/logout")
    @ResponseBody
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        System.out.println("logout...");
        return "logout！";
    }
}
