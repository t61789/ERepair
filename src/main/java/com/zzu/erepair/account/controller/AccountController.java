package com.zzu.erepair.account.controller;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.account.service.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

    @javax.annotation.Resource
    private IAccountService accountService;

    @RequestMapping("/login")
    @ResponseBody
    public Object login(@RequestBody AccountInfo param, HttpServletRequest request) {

        Object result = "-1";
        try {
            result = accountService.login(param.username,param.password,request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/askRepairCheck")
    @ResponseBody
    public Object askRepairCheck() {

        Object result = "-1";
        try {
            result = accountService.askRepairCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/askRepairNewCheck")
    @ResponseBody
    public Object askRepairNewCheck() {

        Object result = "-1";
        try {
            result = accountService.askRepairNewCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/askRepairUploadImg")
    @ResponseBody
    public Object askRepairUploadImg(MultipartFile img) {

        Object result = "-1";
        try {
            result = accountService.askRepairUploadImg(img);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/askRepairNew")
    @ResponseBody
    public Object askRepairNew(@RequestBody AccountInfo info,HttpServletRequest request) {

        Object result = "-1";
        try {
            result = accountService.askRepairNew(info,request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/assignmentCheck")
    @ResponseBody
    public Object assignmentCheck() {

        Object result = "-1";
        try {
            result = accountService.assignmentCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/assignmentAssignees")
    @ResponseBody
    public Object assignmentAssignees() {

        Object result = "-1";
        try {
            result = accountService.assignmentAssignees();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/assignment")
    @ResponseBody
    public Object assignment(@RequestBody AccountInfo info) {

        Object result = "-1";
        try {
            result = accountService.assignment(info.assignee,info.billIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/repairCheck")
    @ResponseBody
    public Object repairCheck(HttpServletRequest request) {

        Object result = "-1";
        try {
            result = accountService.repairCheck(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @RequestMapping("/repair")
    @ResponseBody
    public Object repair(@RequestBody AccountInfo info) {

        Object result = "-1";
        try {
            result = accountService.repair(info.repairRemark,info.billIds);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

