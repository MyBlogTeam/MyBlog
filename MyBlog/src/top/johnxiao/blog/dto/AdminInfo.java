package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;

public class AdminInfo implements Serializable{
//	管理员编号，自增
	private int adminId;
//	用户名
	private String adminName;
//	登录密码
	private String adminPwd;
//	联系电话
	private String adminTel;
//	电子邮箱
	private String adminEmail;
//	头像
	private String adminPic;
//	是否删除,软删除
	private boolean adminIsDel;
	
	private List<LinkInfo> links;
	
	private List<NoticeInfo> notices;
	
	private List<TypeInfo> types;
	
	public AdminInfo(){}

	public AdminInfo(int adminId) {
		this.adminId = adminId;
	}

	public AdminInfo(int adminId, String adminName, String adminPwd,
			String adminTel, String adminEmail, String adminPic,
			boolean adminIsDel, List<LinkInfo> links, List<NoticeInfo> notices,
			List<TypeInfo> types) {
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.adminTel = adminTel;
		this.adminEmail = adminEmail;
		this.adminPic = adminPic;
		this.adminIsDel = adminIsDel;
		this.links = links;
		this.notices = notices;
		this.types = types;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public String getAdminTel() {
		return adminTel;
	}

	public void setAdminTel(String adminTel) {
		this.adminTel = adminTel;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPic() {
		return adminPic;
	}

	public void setAdminPic(String adminPic) {
		this.adminPic = adminPic;
	}

	public boolean getAdminIsDel() {
		return adminIsDel;
	}

	public void setAdminIsDel(boolean adminIsDel) {
		this.adminIsDel = adminIsDel;
	}

	public List<LinkInfo> getLinks() {
		return links;
	}

	public void setLinks(List<LinkInfo> links) {
		this.links = links;
	}

	public List<NoticeInfo> getNotices() {
		return notices;
	}

	public void setNotices(List<NoticeInfo> notices) {
		this.notices = notices;
	}

	public List<TypeInfo> getTypes() {
		return types;
	}

	public void setTypes(List<TypeInfo> types) {
		this.types = types;
	}
	
}
