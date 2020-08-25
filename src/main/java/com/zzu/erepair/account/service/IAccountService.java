package com.zzu.erepair.account.service;

import com.zzu.erepair.account.bean.AccountInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface IAccountService {

    Object login(String username, String password, HttpServletRequest request);

    Object askRepairCheck();

    Object askRepairNewCheck();

    Object askRepairUploadImg(MultipartFile img);

    Object askRepairNew(AccountInfo info, HttpServletRequest request);

    Object assignmentCheck();

    Object assignmentAssignees();

    Object assignment(String assignee,int[] billIds);

    Object repairCheck(HttpServletRequest request);

    Object repair(String repairRemark,int[] billIds);
}
