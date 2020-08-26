package com.zzu.erepair.account.dao;

import com.zzu.erepair.account.bean.AccountInfo;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Repository
public interface IAccountDao {

    // username
    // priority
    AccountInfo checkAccount(String username, String passwordMd5);

    // billId
    // building
    // floor
    // equipmentName
    // askRepairName
    // remark
    // imgURL
    // position
    // state
    // askDateD
    // askDate
    AccountInfo askRepairCheck();

    // username
    // billId
    // building
    // floor
    // equipmentName
    // remark
    // imgURL
    // position
    // equipmentType
    // askDate
    void askRepairNew(AccountInfo info);

    // billId
    // building
    // floor
    // equipmentName
    // remark
    // imgURL
    // position
    // askDate
    // state
    // assignee
    AccountInfo assignmentCheck();

    // assignees
    AccountInfo assignmentAssignees();

    void assignment(String assignee,int[] billIds);

    // building
    // floor
    // equipmentName
    // remark
    // imgURL
    // position
    // askDate
    // state
    // completeDate
    // repairRemark
    AccountInfo repairCheck(String username);

    void repair(String repairRemark, int[] billIds, LocalDateTime completeTimeD);
}
