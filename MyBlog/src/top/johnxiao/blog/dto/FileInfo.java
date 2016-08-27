package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class FileInfo implements Serializable{
//	文件编号
	private int fileId;
//	文件所属人
	private UserInfo user;
//	文件名称
	private String fileName;
//	文件描述
	private String  fileDesc;
//	上传时间
	private Timestamp  fileDate;
//	文件路径
	private String  filePath;
//	文件相关图片
	private String  fileImg;
//	是否删除
	private boolean fileIsDel;
	
	
public FileInfo() {}


public FileInfo(int fileId, UserInfo user, String fileName, String fileDesc,
		Timestamp fileDate, String filePath, String fileImg, boolean fileIsDel) {
	this.fileId = fileId;
	this.user = user;
	this.fileName = fileName;
	this.fileDesc = fileDesc;
	this.fileDate = fileDate;
	this.filePath = filePath;
	this.fileImg = fileImg;
	this.fileIsDel = fileIsDel;
}


public int getFileId() {
	return fileId;
}

public void setFileId(int fileId) {
	this.fileId = fileId;
}

public UserInfo getUser() {
	return user;
}

public void setUser(UserInfo user) {
	this.user = user;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getFileDesc() {
	return fileDesc;
}

public void setFileDesc(String fileDesc) {
	this.fileDesc = fileDesc;
}

public Timestamp getFileDate() {
	return fileDate;
}

public void setFileDate(Timestamp fileDate) {
	this.fileDate = fileDate;
}

public String getFilePath() {
	return filePath;
}

public void setFilePath(String filePath) {
	this.filePath = filePath;
}

public String getFileImg() {
	return fileImg;
}

public void setFileImg(String fileImg) {
	this.fileImg = fileImg;
}


public boolean getFileIsDel() {
	return fileIsDel;
}


public void setFileIsDel(boolean fileIsDel) {
	this.fileIsDel = fileIsDel;
}


}
