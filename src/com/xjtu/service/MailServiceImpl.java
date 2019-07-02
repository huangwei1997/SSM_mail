package com.xjtu.service;

import com.xjtu.mapper.MailMapper;
import com.xjtu.pojo.Mail;
import com.xjtu.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MailServiceImpl implements MailService {
    //声明mapper接口对象
    @Resource
    private MailMapper mailMapper;
    @Override
    public User selUserInfoService(String uname, String upwd) {
        return mailMapper.selUser(uname,upwd);
    }

    @Override
    public List<Mail> selMailInfoService(int receiveId) {
        return mailMapper.selMail(receiveId);
    }

    @Override
    public int insMailService(Mail mail) {
        return mailMapper.insMail(mail);
    }
}
