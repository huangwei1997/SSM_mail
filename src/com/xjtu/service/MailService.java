package com.xjtu.service;

import com.xjtu.pojo.Mail;
import com.xjtu.pojo.User;

import java.util.List;

public interface MailService {
    //用户登录
    User selUserInfoService(String uname ,String upwd);
    //查询用户邮件信息
    List<Mail> selMailInfoService(int receiveId);
    //新增发送邮件记录
    int insMailService(Mail mail);
}
