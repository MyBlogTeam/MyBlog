package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class ClickLikeInfo implements Serializable{
//	点赞编号
	private int likeId;
//	点赞人
	private UserInfo userId;
//	点赞类别,此处用1、2,表示博文和评论,博文和评论均可点赞
	private int likeType;
//	被赞编号,此处通过业务逻辑来输入编号,因此此处不与博文和评论做关联
	private int likedId;
//	点赞时间
	private Timestamp likeDate;
//	是否删除
	private boolean likeIsDel;
	
public ClickLikeInfo() {}


public ClickLikeInfo(int likeId, UserInfo userId, int likeType, int likedId,
		Timestamp likeDate, boolean likeIsDel) {
	this.likeId = likeId;
	this.userId = userId;
	this.likeType = likeType;
	this.likedId = likedId;
	this.likeDate = likeDate;
	this.likeIsDel = likeIsDel;
}


public int getLikeId() {
	return likeId;
}

public void setLikeId(int likeId) {
	this.likeId = likeId;
}

public UserInfo getUserId() {
	return userId;
}

public void setUserId(UserInfo userId) {
	this.userId = userId;
}

public int getLikeType() {
	return likeType;
}

public void setLikeType(int likeType) {
	this.likeType = likeType;
}

public int getLikedId() {
	return likedId;
}

public void setLikedId(int likedId) {
	this.likedId = likedId;
}

public Timestamp getLikeDate() {
	return likeDate;
}

public void setLikeDate(Timestamp likeDate) {
	this.likeDate = likeDate;
}


public boolean getLikeIsDel() {
	return likeIsDel;
}


public void setLikeIsDel(boolean likeIsDel) {
	this.likeIsDel = likeIsDel;
}


}
