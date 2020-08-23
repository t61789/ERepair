package com.zzu.erepair.account.dao;

import com.zzu.erepair.account.bean.AccountInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountDao {

    // username
    // priority
    AccountInfo checkAccount(String username, String passwordMd5);
}
