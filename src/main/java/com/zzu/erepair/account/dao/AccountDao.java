package com.zzu.erepair.account.dao;

import com.zzu.erepair.account.bean.AccountInfo;
import com.zzu.erepair.utility.SqlSessionDaoSupportAbstract;
import com.zzu.erepair.utility.Utility;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Repository
public class AccountDao extends SqlSessionDaoSupportAbstract implements IAccountDao {


    @Resource
    private Utility utility;

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

        for (AccountInfo a : result.bills){
            if(a.askDateD!=null){
                a.askDate = utility.Ltime2Stime(a.askDateD);
                a.askDateD = null;
            }
        }

        return result;
    }

    @Override
    public void askRepairNew(AccountInfo info) {
        this.getSqlSession().insert("com.zzu.erepair.askRepairNew",info);
    }

    @Override
    public AccountInfo assignmentCheck() {
        AccountInfo result = new AccountInfo();
        result.bills = this.getSqlSession().selectList("com.zzu.erepair.assignmentCheck");

        for (AccountInfo a : result.bills){
            if(a.askDateD!=null){
                a.askDate = utility.Ltime2Stime(a.askDateD);
                a.askDateD = null;
            }
        }

        return result;
    }

    @Override
    public AccountInfo assignmentAssignees() {
        AccountInfo result = new AccountInfo();
        result.assignees = this.getSqlSession().selectList("com.zzu.erepair.assignmentAssignees");

        return result;
    }

    @Override
    public void assignment(String assignee, int[] billIds) {
        AccountInfo info = new AccountInfo();
        info.assignee = assignee;
        info.billIds = billIds;

        this.getSqlSession().update("com.zzu.erepair.assignment",info);
    }

    @Override
    public AccountInfo repairCheck(String username) {
        AccountInfo info = new AccountInfo();
        info.username = username;
        info.bills = this.getSqlSession().selectList("com.zzu.erepair.repairCheck",info);
        info.username = null;

        for (AccountInfo a : info.bills){
            if(a.askDateD!=null){
                a.askDate = utility.Ltime2Stime(a.askDateD);
                a.askDateD = null;
            }
            if(a.completeDateD!=null){
                a.completeDate = utility.Ltime2Stime(a.completeDateD);
                a.completeDateD = null;
            }
        }

        return info;
    }

    @Override
    public void repair(String repairRemark, int[] billIds,  LocalDateTime completeTimeD) {
        AccountInfo info = new AccountInfo();
        info.billIds = billIds;
        info.repairRemark = repairRemark;
        info.completeDateD = completeTimeD;

        this.getSqlSession().update("com.zzu.erepair.repair",info);
    }
}
