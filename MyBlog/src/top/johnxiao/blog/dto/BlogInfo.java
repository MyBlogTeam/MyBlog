package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;

public class BlogInfo implements Serializable{
	
//	博客编号
	private int blogId;
//	所属用户
	private UserInfo userId;
//	博客名称
	private String blogName;
//	博客描述
	private String blogDesc;
//	博客状态
	private int blogState;
//	注册时间
	private String blogDate;
//	背景音乐
	private String blogMusic;
//	背景图片
	private String blogPic;
//	是否删除
	private boolean blogIsDel;
	
	
public BlogInfo() {}

public BlogInfo(int blogId, UserInfo userId, String blogName, String blogDesc,
		int blogState, String blogDate, String blogMusic, String blogPic,
		boolean blogIsDel) {
	this.blogId = blogId;
	this.userId = userId;
	this.blogName = blogName;
	this.blogDesc = blogDesc;
	this.blogState = blogState;
	this.blogDate = blogDate;
	this.blogMusic = blogMusic;
	this.blogPic = blogPic;
	this.blogIsDel = blogIsDel;
}




public int getBlogId() {
	return blogId;
}


public void setBlogId(int blogId) {
	this.blogId = blogId;
}


public UserInfo getUserId() {
	return userId;
}


public void setUserId(UserInfo userId) {
	this.userId = userId;
}


public String getBlogName() {
	return blogName;
}


public void setBlogName(String blogName) {
	this.blogName = blogName;
}


public String getBlogDesc() {
	return blogDesc;
}


public void setBlogDesc(String blogDesc) {
	this.blogDesc = blogDesc;
}


public int getBlogState() {
	return blogState;
}


public void setBlogState(int blogState) {
	this.blogState = blogState;
}


public String getBlogDate() {
	return blogDate;
}


public void setBlogDate(String blogDate) {
	this.blogDate = blogDate;
}


public String getBlogMusic() {
	return blogMusic;
}


public void setBlogMusic(String blogMusic) {
	this.blogMusic = blogMusic;
}


public String getBlogPic() {
	return blogPic;
}


public void setBlogPic(String blogPic) {
	this.blogPic = blogPic;
}

public boolean getBlogIsDel() {
	return blogIsDel;
}

public void setBlogIsDel(boolean blogIsDel) {
	this.blogIsDel = blogIsDel;
}
	
}
