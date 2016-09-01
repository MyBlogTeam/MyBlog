package top.johnxiao.blog.dto;

import java.io.Serializable;



public class UserNotice implements Serializable {

//	用户通知编号
	private Integer unId;
//	通知,指向通知编号
	private NoticeInfo noticeinfo;
//	用户,指向用户编号
	private UserInfo userinfo;
//	是否删除,软删除
	private boolean unIsDel;
	
public UserNotice() {}

public UserNotice(Integer unId, NoticeInfo noticeinfo, UserInfo userinfo,
		boolean unIsDel) {
	this.unId = unId;
	this.noticeinfo = noticeinfo;
	this.userinfo = userinfo;
	this.unIsDel = unIsDel;
}

public Integer getUnId() {
	return unId;
}

public void setUnId(Integer unId) {
	this.unId = unId;
}

public NoticeInfo getNoticeinfo() {
	return noticeinfo;
}

public void setNoticeinfo(NoticeInfo noticeinfo) {
	this.noticeinfo = noticeinfo;
}

public UserInfo getUserinfo() {
	return userinfo;
}

public void setUserinfo(UserInfo userinfo) {
	this.userinfo = userinfo;
}

public boolean getUnIsDel() {
	return unIsDel;
}

public void setUnIsDel(boolean unIsDel) {
	this.unIsDel = unIsDel;
}

}