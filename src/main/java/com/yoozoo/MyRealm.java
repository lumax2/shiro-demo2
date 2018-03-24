package com.yoozoo;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Hao on 2018/3/24.
 */
public class MyRealm extends AuthorizingRealm {


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("正在执行认证");

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String firstInputUsername = usernamePasswordToken.getUsername();

        String usernameFromDatabase = "chenghao";
        String passwordFromDatabase = "1234";

        if(!usernameFromDatabase.equals(firstInputUsername)){
            return null;
        }

        return new SimpleAuthenticationInfo("登录认证结果信息",passwordFromDatabase,"多个realm的名字");
    }

}
