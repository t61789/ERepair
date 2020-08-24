package com.zzu.erepair.account.controller;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.utility.SecurityKeys;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private SecurityKeys securityKeys;

    @RequestMapping("/test")
    @ResponseBody
    public Object test(@RequestBody AccountInfo info) {

        Object result = "-1";
        try {
            result = securityKeys.getSecurityMD5(info.username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
