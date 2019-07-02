package com.xjtu.pojo;

public class Mail {
    private int mid;//邮件Id
    private String mtitle;//邮件标题
    private String mcontent;//邮件内容
    private String fileOldName;//附件原始名
    private String fileNewName;//附件新名
    private String contentType;//附件类型
    private int sendId;//发送者id
    private int receiveId;//接收者Id
    private String mTime;//发送时间

    private User user;//存储发送人信息

    public Mail(){}

    public Mail(int mid, String mtitle, String mcontent, String fileOldName, String fileNewName, String contentType, int sendId, int receiveId, String mTime, User user) {
        this.mid = mid;
        this.mtitle = mtitle;
        this.mcontent = mcontent;
        this.fileOldName = fileOldName;
        this.fileNewName = fileNewName;
        this.contentType = contentType;
        this.sendId = sendId;
        this.receiveId = receiveId;
        this.mTime = mTime;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "mid=" + mid +
                ", mtitle='" + mtitle + '\'' +
                ", mcontent='" + mcontent + '\'' +
                ", fileOldName='" + fileOldName + '\'' +
                ", fileNewName='" + fileNewName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                ", mTime='" + mTime + '\'' +
                ", user=" + user +
                '}';
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public String getFileOldName() {
        return fileOldName;
    }

    public void setFileOldName(String fileOldName) {
        this.fileOldName = fileOldName;
    }

    public String getFileNewName() {
        return fileNewName;
    }

    public void setFileNewName(String fileNewName) {
        this.fileNewName = fileNewName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getSendId() {
        return sendId;
    }

    public void setSendId(int sendId) {
        this.sendId = sendId;
    }

    public int getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(int receiveId) {
        this.receiveId = receiveId;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
