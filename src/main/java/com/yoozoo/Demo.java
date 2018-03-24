package com.yoozoo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.security.Principal;

/**
 * Created by Hao on 2018/3/24.
 */
public class Demo {

    public static void main(String[] agrs){

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken token = new UsernamePasswordToken("chenghao1","1234");

        try{
            subject.login(token);

            Object principal =subject.getPrincipal();

            System.out.println("登录成功"+principal);
        }catch (UnknownAccountException e){
            System.out.println("用户名不存在");

        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (Exception e){
            System.out.println("系统异常");
        }

    };
}
