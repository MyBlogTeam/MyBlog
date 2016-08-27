package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;


public class PhotoInfo implements Serializable{
//	照片编号
	private Integer photoId;
//	所属相册
	private AlbumInfo albuminfo;
//	照片名称
	private String photoName;
//	照片存储路径
	private String photoPath;
//	照片描述
	private String photoDesc;
//	上传时间
	private Timestamp photoDate;
//	是否删除
	private boolean photoIsDel;
	
public PhotoInfo() {}


public PhotoInfo(Integer photoId, AlbumInfo albuminfo, String photoName,
		String photoPath, String photoDesc, Timestamp photoDate,
		boolean photoIsDel) {
	this.photoId = photoId;
	this.albuminfo = albuminfo;
	this.photoName = photoName;
	this.photoPath = photoPath;
	this.photoDesc = photoDesc;
	this.photoDate = photoDate;
	this.photoIsDel = photoIsDel;
}


public Integer getPhotoId() {
	return photoId;
}

public void setPhotoId(Integer photoId) {
	this.photoId = photoId;
}

public AlbumInfo getAlbuminfo() {
	return albuminfo;
}

public void setAlbuminfo(AlbumInfo albuminfo) {
	this.albuminfo = albuminfo;
}

public String getPhotoName() {
	return photoName;
}

public void setPhotoName(String photoName) {
	this.photoName = photoName;
}

public String getPhotoPath() {
	return photoPath;
}

public void setPhotoPath(String photoPath) {
	this.photoPath = photoPath;
}

public String getPhotoDesc() {
	return photoDesc;
}

public void setPhotoDesc(String photoDesc) {
	this.photoDesc = photoDesc;
}

public Timestamp getPhotoDate() {
	return photoDate;
}

public void setPhotoDate(Timestamp photoDate) {
	this.photoDate = photoDate;
}


public boolean getPhotoIsDel() {
	return photoIsDel;
}


public void setPhotoIsDel(boolean photoIsDel) {
	this.photoIsDel = photoIsDel;
}

}
