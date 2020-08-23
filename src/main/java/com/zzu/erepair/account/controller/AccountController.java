package com.zzu.erepair.account.controller;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.account.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccountController {

    @javax.annotation.Resource
    private IAccountService accountService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody AccountInfo param) {

        Object result = "-1";
        try {
            result = accountService.login(param.username,param.password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

