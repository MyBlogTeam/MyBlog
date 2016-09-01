package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserInfo implements Serializable{
	
//	用户编号
	private Integer userId;
//	对应的博客信息
	private BlogInfo bloginfo;
//	登录名
	private String userName;
//	登录密码
	private String userPwd;
//	用户昵称
	private String userNickName;
//	用户性别
	private String userSex;
//	用户出生日期
	private Date userBirthday;
//	家庭住址
	private String userAddress;
//	联系电话
	private String userTel;
//	电子邮箱
	private String userEmail;
//	用户头像
	private String userPic;
//	用户等级
	private Integer userRank;
//	用户状态
	private Integer userState;
//	是否删除,软删除
	private Boolean userIsDel;
//	留言发送者,一对多
	private List<MessageInfo> senders;
//	留言接受者,一对多
	private List<MessageInfo> receivers;
//	对应的文件,一对多
	private List<FileInfo> files;
//	点赞人
	private List<ClickLikeInfo> clickLikes;
//	收藏者
	private List<CollectInfo> collects;
//	评论者
	private List<DiscussInfo> discussInfos;
//	用户通知
	private List<UserNotice> userNotices;
//	用户相册
	private List<AlbumInfo> albums;
//	用户标签
	private List<LabelInfo> labels;
//	第三方oauth认证
	private List<AuthsInfo> auths;
	
public UserInfo() {}

public UserInfo(Integer userId, BlogInfo bloginfo, String userName,
		String userPwd, String userNickName, String userSex, Date userBirthday,
		String userAddress, String userTel, String userEmail, String userPic,
		Integer userRank, Integer userState, Boolean userIsDel,
		List<MessageInfo> senders, List<MessageInfo> receivers,
		List<FileInfo> files, List<ClickLikeInfo> clickLikes,
		List<CollectInfo> collects, List<DiscussInfo> discussInfos,
		List<UserNotice> userNotices, List<AlbumInfo> albums,
		List<LabelInfo> labels, List<AuthsInfo> auths) {
	this.userId = userId;
	this.bloginfo = bloginfo;
	this.userName = userName;
	this.userPwd = userPwd;
	this.userNickName = userNickName;
	this.userSex = userSex;
	this.userBirthday = userBirthday;
	this.userAddress = userAddress;
	this.userTel = userTel;
	this.userEmail = userEmail;
	this.userPic = userPic;
	this.userRank = userRank;
	this.userState = userState;
	this.userIsDel = userIsDel;
	this.senders = senders;
	this.receivers = receivers;
	this.files = files;
	this.clickLikes = clickLikes;
	this.collects = collects;
	this.discussInfos = discussInfos;
	this.userNotices = userNotices;
	this.albums = albums;
	this.labels = labels;
	this.auths = auths;
}

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;
}

public BlogInfo getBloginfo() {
	return bloginfo;
}

public void setBloginfo(BlogInfo bloginfo) {
	this.bloginfo = bloginfo;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getUserPwd() {
	return userPwd;
}

public void setUserPwd(String userPwd) {
	this.userPwd = userPwd;
}

public String getUserNickName() {
	return userNickName;
}

public void setUserNickName(String userNickName) {
	this.userNickName = userNickName;
}

public String getUserSex() {
	return userSex;
}

public void setUserSex(String userSex) {
	this.userSex = userSex;
}

public Date getUserBirthday() {
	return userBirthday;
}

public void setUserBirthday(Date userBirthday) {
	this.userBirthday = userBirthday;
}

public String getUserAddress() {
	return userAddress;
}

public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
}

public String getUserTel() {
	return userTel;
}

public void setUserTel(String userTel) {
	this.userTel = userTel;
}

public String getUserEmail() {
	return userEmail;
}

public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}

public String getUserPic() {
	return userPic;
}

public void setUserPic(String userPic) {
	this.userPic = userPic;
}

public Integer getUserRank() {
	return userRank;
}

public void setUserRank(Integer userRank) {
	this.userRank = userRank;
}

public Integer getUserState() {
	return userState;
}

public void setUserState(Integer userState) {
	this.userState = userState;
}

public Boolean getUserIsDel() {
	return userIsDel;
}

public void setUserIsDel(Boolean userIsDel) {
	this.userIsDel = userIsDel;
}

public List<MessageInfo> getSenders() {
	return senders;
}

public void setSenders(List<MessageInfo> senders) {
	this.senders = senders;
}

public List<MessageInfo> getReceivers() {
	return receivers;
}

public void setReceivers(List<MessageInfo> receivers) {
	this.receivers = receivers;
}

public List<FileInfo> getFiles() {
	return files;
}

public void setFiles(List<FileInfo> files) {
	this.files = files;
}

public List<ClickLikeInfo> getClickLikes() {
	return clickLikes;
}

public void setClickLikes(List<ClickLikeInfo> clickLikes) {
	this.clickLikes = clickLikes;
}

public List<CollectInfo> getCollects() {
	return collects;
}

public void setCollects(List<CollectInfo> collects) {
	this.collects = collects;
}

public List<DiscussInfo> getDiscussInfos() {
	return discussInfos;
}

public void setDiscussInfos(List<DiscussInfo> discussInfos) {
	this.discussInfos = discussInfos;
}

public List<UserNotice> getUserNotices() {
	return userNotices;
}

public void setUserNotices(List<UserNotice> userNotices) {
	this.userNotices = userNotices;
}

public List<AlbumInfo> getAlbums() {
	return albums;
}

public void setAlbums(List<AlbumInfo> albums) {
	this.albums = albums;
}

public List<LabelInfo> getLabels() {
	return labels;
}

public void setLabels(List<LabelInfo> labels) {
	this.labels = labels;
}

public List<AuthsInfo> getAuths() {
	return auths;
}

public void setAuths(List<AuthsInfo> auths) {
	this.auths = auths;
}

	
}
