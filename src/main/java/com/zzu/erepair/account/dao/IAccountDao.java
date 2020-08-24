package com.zzu.erepair.account.dao;

import com.zzu.erepair.account.bean.AccountInfo;
import org.springframework.stereotype.Repository;

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
}
