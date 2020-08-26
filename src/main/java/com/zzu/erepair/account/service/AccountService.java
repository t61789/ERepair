package com.zzu.erepair.account.service;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.account.dao.IAccountDao;
import com.zzu.erepair.utility.CommonProperties;
import com.zzu.erepair.utility.SecurityKeys;
import com.zzu.erepair.utility.Utility;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class AccountService implements  IAccountService{

    @Resource
    private IAccountDao accountDao;

    @Resource
    private SecurityKeys securityKeys;

    @Resource
    private CommonProperties commonProperties;


    @Override
    public Object login(String username, String password, HttpServletRequest request) {
        String md5 = securityKeys.getSecurityMD5(password);
        AccountInfo info = accountDao.checkAccount(username,md5);
        info = info==null? new AccountInfo():info;
        info.status = info.username==null?0:1;
        request.getSession().setAttribute("username",username);
        return info;
    }

    @Override
    public Object askRepairCheck() {

        return accountDao.askRepairCheck();
    }

    @Override
    public Object askRepairNewCheck() {

        AccountInfo result = new AccountInfo();
        result.floors = castInta(commonProperties.getProperty("floors").split(","));
        result.equipmentNames = commonProperties.getProperty("equipmentNames").split(",");
        result.buildings = castInta(commonProperties.getProperty("buildings").split(","));
        result.equipmentTypes = commonProperties.getProperty("equipmentTypes").split(",");

        return result;
    }

    @Override
    public Object askRepairUploadImg(MultipartFile img) {

        String basePath = commonProperties.getProperty("imgBasePath");

        basePath += "/"+securityKeys.getSecurityMD5(LocalDateTime.now().toString()+LocalDateTime.now().getNano());
        if(!img.isEmpty()){
            try {
                img.transferTo(new File(basePath));
                return basePath;
            } catch (IOException e) {
                e.printStackTrace();
                return "0";
            }
        }
        return "-1";
    }

    // billId
    // building
    // floor
    // equipmentName
    // remark
    // imgURL
    // position
    // equipmentType
    @Override
    public Object askRepairNew(AccountInfo info,HttpServletRequest request) {
        info.username = (String) request.getSession().getAttribute("username");
        info.askDateD = LocalDateTime.now();
        try{
            accountDao.askRepairNew(info);
            return "1";
        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
    }

    @Override
    public Object assignmentCheck() {

        return accountDao.assignmentCheck();
    }

    @Override
    public Object assignmentAssignees() {

        return accountDao.assignmentAssignees();
    }

    @Override
    public Object assignment(String assignee, int[] billIds) {

        try{
            accountDao.assignment(assignee,billIds);
        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    @Override
    public Object repairCheck(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");

        return accountDao.repairCheck(username);
    }

    @Override
    public Object repair(String repairRemark, int[] billIds) {
        try{
            accountDao.repair(repairRemark, billIds,LocalDateTime.now());
        }catch(Exception e){
            e.printStackTrace();
            return "0";
        }
        return "1";
    }

    private int[] castInta(String[] s){
        int[] tempInt = new int[s.length];
        for(int i=0;i<s.length;i++)
            tempInt[i] = Integer.parseInt(s[i]);
        return tempInt;
    }
}
