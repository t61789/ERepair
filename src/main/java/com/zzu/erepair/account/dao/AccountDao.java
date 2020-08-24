package com.zzu.erepair.account.dao;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.utility.SqlSessionDaoSupportAbstract;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDao extends SqlSessionDaoSupportAbstract implements IAccountDao {

    @Override
    public AccountInfo checkAccount(String username, String passwordMd5) {
        AccountInfo param = new AccountInfo();
        param.username = username;
        param.password = passwordMd5;

        return this.getSqlSession().selectOne("com.zzu.erepair.checkAccount",param);
    }

    @Override
    public AccountInfo askRepairCheck() {
        AccountInfo result = new AccountInfo();
        result.bills = this.getSqlSession().selectList("com.zzu.erepair.askRepairCheck");

        return result;
    }

    @Override
    public void askRepairNew(AccountInfo info) {
        this.getSqlSession().insert("com.zzu.erepair.askRepairNew",info);
    }
}
