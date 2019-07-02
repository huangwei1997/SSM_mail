package com.xjtu.mapper;

import com.xjtu.pojo.Mail;
import com.xjtu.pojo.User;

import java.util.List;

public interface MailMapper {
    //用户登录
    User selUser(String uname ,String upwd);
    //查询当前用户的邮件信息
    List<Mail> selMail(int receiveId);
    //插入发送邮件记录
    int insMail(Mail mail);
}
