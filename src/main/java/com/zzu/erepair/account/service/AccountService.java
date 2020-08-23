package com.zzu.erepair.account.service;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.account.dao.IAccountDao;
import com.zzu.erepair.utility.SecurityKeys;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountService implements  IAccountService{

    @Resource
    private IAccountDao accountDao;

    @Resource
    private SecurityKeys securityKeys;

    @Override
    public Object login(String username, String password) {
        String md5 = securityKeys.getSecurityMD5(password);
        AccountInfo info = accountDao.checkAccount(username,md5);
        info.status = (info.username==null?0:1);
        return info;
    }
}
