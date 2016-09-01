package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;

public class AlbumInfo implements Serializable{
//	相册编号
	private int albumId;
//	所属用户，外键
	private UserInfo userInfo;
//	相册名称
	private String albumName;
//	相册状态,仿照QQ相册
	private int albumState;
//	相册密码
	private String albumPwd;
//	相册问题
	private String albumQuest;
//	问题答案
	private String albumAnswer;
//	相册封面
	private String albumPic;
//	是否删除,软删除
	private boolean albumIsDel;
//	照片,外键,一个相册对应多张照片
	private List<PhotoInfo> photos;
	
	
public AlbumInfo() {}


public AlbumInfo(int albumId, UserInfo userInfo, String albumName,
		int albumState, String albumPwd, String albumQuest, String albumAnswer,
		String albumPic, boolean albumIsDel, List<PhotoInfo> photos) {
	this.albumId = albumId;
	this.userInfo = userInfo;
	this.albumName = albumName;
	this.albumState = albumState;
	this.albumPwd = albumPwd;
	this.albumQuest = albumQuest;
	this.albumAnswer = albumAnswer;
	this.albumPic = albumPic;
	this.albumIsDel = albumIsDel;
	this.photos = photos;
}


public int getAlbumId() {
	return albumId;
}


public void setAlbumId(int albumId) {
	this.albumId = albumId;
}


public UserInfo getUserInfo() {
	return userInfo;
}


public void setUserInfo(UserInfo userInfo) {
	this.userInfo = userInfo;
}


public String getAlbumName() {
	return albumName;
}


public void setAlbumName(String albumName) {
	this.albumName = albumName;
}


public int getAlbumState() {
	return albumState;
}


public void setAlbumState(int albumState) {
	this.albumState = albumState;
}


public String getAlbumPwd() {
	return albumPwd;
}


public void setAlbumPwd(String albumPwd) {
	this.albumPwd = albumPwd;
}


public String getAlbumQuest() {
	return albumQuest;
}


public void setAlbumQuest(String albumQuest) {
	this.albumQuest = albumQuest;
}


public String getAlbumAnswer() {
	return albumAnswer;
}


public void setAlbumAnswer(String albumAnswer) {
	this.albumAnswer = albumAnswer;
}


public String getAlbumPic() {
	return albumPic;
}


public void setAlbumPic(String albumPic) {
	this.albumPic = albumPic;
}


public boolean getAlbumIsDel() {
	return albumIsDel;
}


public void setAlbumIsDel(boolean albumIsDel) {
	this.albumIsDel = albumIsDel;
}


public List<PhotoInfo> getPhotos() {
	return photos;
}


public void setPhotos(List<PhotoInfo> photos) {
	this.photos = photos;
}
	

}
