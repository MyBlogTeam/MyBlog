package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public class NoticeInfo implements Serializable{
//	通知编号
	private Integer noticeId;
//	通知发布人
	private AdminInfo admininfo;
//	通知主题
	private String noticeTopic;
//	通知内容
	private String noticeContent;
//	通知时间
	private Timestamp noticeDate;
//	是否删除,软删除
	private Boolean noticeIsDel;
//	通知对应的用户
	private List<UserNotice> userNotices;
	
public NoticeInfo() {}


public NoticeInfo(Integer noticeId, AdminInfo admininfo, String noticeTopic,
		String noticeContent, Timestamp noticeDate, Boolean noticeIsDel,
		List<UserNotice> userNotices) {
	this.noticeId = noticeId;
	this.admininfo = admininfo;
	this.noticeTopic = noticeTopic;
	this.noticeContent = noticeContent;
	this.noticeDate = noticeDate;
	this.noticeIsDel = noticeIsDel;
	this.userNotices = userNotices;
}


public Integer getNoticeId() {
	return noticeId;
}


public void setNoticeId(Integer noticeId) {
	this.noticeId = noticeId;
}


public AdminInfo getAdmininfo() {
	return admininfo;
}


public void setAdmininfo(AdminInfo admininfo) {
	this.admininfo = admininfo;
}


public String getNoticeTopic() {
	return noticeTopic;
}


public void setNoticeTopic(String noticeTopic) {
	this.noticeTopic = noticeTopic;
}


public String getNoticeContent() {
	return noticeContent;
}


public void setNoticeContent(String noticeContent) {
	this.noticeContent = noticeContent;
}


public Timestamp getNoticeDate() {
	return noticeDate;
}


public void setNoticeDate(Timestamp noticeDate) {
	this.noticeDate = noticeDate;
}


public Boolean getNoticeIsDel() {
	return noticeIsDel;
}


public void setNoticeIsDel(Boolean noticeIsDel) {
	this.noticeIsDel = noticeIsDel;
}


public List<UserNotice> getUserNotices() {
	return userNotices;
}


public void setUserNotices(List<UserNotice> userNotices) {
	this.userNotices = userNotices;
}


}
