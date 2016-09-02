package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class ReplyInfo implements Serializable{
	
	private int replyId;
	private DiscussInfo discussInfo;
	private UserInfo userInfo;
	private String replyContent;
	private Timestamp replyDate;
	private boolean replyIsDel;
	
	public ReplyInfo() {}

	public ReplyInfo(int replyId, DiscussInfo discussInfo, UserInfo userInfo,
			String replyContent, Timestamp replyDate, boolean replyIsDel) {
		this.replyId = replyId;
		this.discussInfo = discussInfo;
		this.userInfo = userInfo;
		this.replyContent = replyContent;
		this.replyDate = replyDate;
		this.replyIsDel = replyIsDel;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public DiscussInfo getDiscussInfo() {
		return discussInfo;
	}

	public void setDiscussInfo(DiscussInfo discussInfo) {
		this.discussInfo = discussInfo;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public Timestamp getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Timestamp replyDate) {
		this.replyDate = replyDate;
	}

	public boolean getReplyIsDel() {
		return replyIsDel;
	}

	public void setReplyIsDel(boolean replyIsDel) {
		this.replyIsDel = replyIsDel;
	}

	@Override
	public String toString() {
		return "ReplyInfo [replyId=" + replyId + ", discussInfo=" + discussInfo
				+ ", userInfo=" + userInfo + ", replyContent=" + replyContent
				+ ", replyDate=" + replyDate + ", replyIsDel=" + replyIsDel
				+ "]";
	}
	
}
