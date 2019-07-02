package com.xjtu.controller;

import com.xjtu.pojo.Mail;
import com.xjtu.pojo.User;
import com.xjtu.service.MailService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@Controller
public class MailController {
    @Resource
    private MailService mailServiceImpl;
    //单元方法----登录
    @RequestMapping("/login")
    public String userLogin(String uname , String upwd, HttpServletRequest req){
        //校验登录
        User user = mailServiceImpl.selUserInfoService(uname,upwd);
        if(user!=null){//登录成功 重定向main单元方法，再请求转发到main.jsp，因为main.jsp在WEB-INF文件夹下
            //获取session对象
            HttpSession session = req.getSession();
            //将用户信息存储到session中
            session.setAttribute("user",user);
            return "redirect:/main";
        }else{//登录失败，跳转到登录页面
            return "redirect:/login.jsp";
        }
    }


    //登录成功时处理ajax请求，显示当前用户所有接收的邮件
    @ResponseBody
    @RequestMapping("/myMails")
    public List<Mail> myMails(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取session对象
        HttpSession session = req.getSession();
        int uid = ((User)session.getAttribute("user")).getUid();
        //查询当前用户的收件信息
        List<Mail> mailList = mailServiceImpl.selMailInfoService(uid);
        return mailList;
        //响应数据
        //设置响应编码格式
        /*resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(new Gson().toJson(mailList));*/
    }
    //单元方法---发送邮件
    @RequestMapping("/sendMail")
    public String sendMail(Mail mail, MultipartFile file,HttpServletRequest req) throws IOException {
        //将附件存储到服务器硬盘中
            //校验文件类型
                //获取文件原始名
        String oldName = file.getOriginalFilename();
                //获取文件后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        if(!".docx".equals(suffix)){
            return "error";
        }
            //创建文件的新名字
        String newName = UUID.randomUUID().toString()+System.currentTimeMillis()+suffix;
            //创建文件存储路径
                //动态获取项目下的路径
        String path = req.getServletContext().getRealPath("/WEB-INF/docx");
        //文件不存在，则创建
        File f = new File(path);
        if(!f.exists()){
            f.mkdirs();
        }
            //存储文件
        file.transferTo(new File(path,newName));
            //将邮件信息插入到数据库表中
                //获取发件人Id,即当前登录的用户id,从session中获取
        HttpSession session = req.getSession();
        int sendId = ((User) session.getAttribute("user")).getUid();
        //获取收件人id
        int receiveId = Integer.parseInt(req.getParameter("receiveId"));
        String mtitle = req.getParameter("mtitle");
        String mcontent = req.getParameter("mcontent");
        //获取文件类型、
        String contentType = file.getContentType();
        mail.setMtitle(mtitle);
        mail.setMcontent(mcontent);
        mail.setFileOldName(oldName);
        mail.setFileNewName(newName);
        mail.setContentType(contentType);
        mail.setSendId(sendId);
        mail.setReceiveId(receiveId);
        //调用业务层方法
        int i = mailServiceImpl.insMailService(mail);
        if(i>0){
            return "success";
        }else{
            return "error";
        }

    }
    //声明公共资源跳转单元方法
    @RequestMapping("{uri}")
    public String getSend(@PathVariable("uri")String uri){
        return uri;
    }

    //单元方法---下载
    @RequestMapping("/download")
    public void download(HttpServletRequest req,HttpServletResponse resp,String fileOldName,String fileNewName) throws IOException {
        //设置响应类型
        resp.setContentType("application/octet-stream");
        //设置响应头为另存为
        String name = new String(fileOldName.getBytes("utf-8"),"iso-8859-1");
        resp.setHeader("Content-Disposition","attachment;filename="+name);
        //获取文件存储路径
        String path = req.getServletContext().getRealPath("/WEB-INF/docx");
        //获取响应输出流对象
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(FileUtils.readFileToByteArray(new File(path,fileNewName)));
        outputStream.close();

    }
}
