package com.zzu.erepair.account.bean;

import java.time.LocalDateTime;
import java.util.List;

public class AccountInfo {
    public String username;
    public String password;
    public int priority;
    public int status;
    public int billId;
    public int building;
    public int floor;
    public String equipmentName;
    public String askRepairName;
    public String remark;
    public String imgURL;
    public String position;
    public int state;
    public LocalDateTime askDateD;
    public String askDate;
    public int[] floors;
    public String[] equipmentNames;
    public int[] buildings;
    public String[] equipmentTypes;
    public List<AccountInfo> bills;
    public int[] billIds;
    public String assignee;
    public List<String> assignees;
    public LocalDateTime completeDateD;
    public String completeDate;
    public String repairRemark;

}
