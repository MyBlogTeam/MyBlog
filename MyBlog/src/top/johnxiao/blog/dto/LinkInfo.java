package top.johnxiao.blog.dto;

import java.io.Serializable;
/**
 * 该链接用于商家推广或者页脚的链接地址
 * @author 肖伟
 *
 */
public class LinkInfo implements Serializable{
//	链接编号
	private int linkId;
//	对应管理员
	private AdminInfo admin;
//	链接名称
	private String linkName;
//	链接地址
	private String linkUrl;
//	链接LOGO
	private String linkLogo;
//	显示顺序
	private int showOrder;
//	是否删除
	private boolean linkIsDel;
	
public LinkInfo() {}

public LinkInfo(int linkId, AdminInfo admin, String linkName, String linkUrl,
		String linkLogo, int showOrder, boolean linkIsDel) {
	this.linkId = linkId;
	this.admin = admin;
	this.linkName = linkName;
	this.linkUrl = linkUrl;
	this.linkLogo = linkLogo;
	this.showOrder = showOrder;
	this.linkIsDel = linkIsDel;
}

public int getLinkId() {
	return linkId;
}

public void setLinkId(int linkId) {
	this.linkId = linkId;
}

public AdminInfo getAdmin() {
	return admin;
}

public void setAdmin(AdminInfo admin) {
	this.admin = admin;
}

public String getLinkName() {
	return linkName;
}

public void setLinkName(String linkName) {
	this.linkName = linkName;
}

public String getLinkUrl() {
	return linkUrl;
}

public void setLinkUrl(String linkUrl) {
	this.linkUrl = linkUrl;
}

public String getLinkLogo() {
	return linkLogo;
}

public void setLinkLogo(String linkLogo) {
	this.linkLogo = linkLogo;
}

public int getShowOrder() {
	return showOrder;
}

public void setShowOrder(int showOrder) {
	this.showOrder = showOrder;
}

public boolean getLinkIsDel() {
	return linkIsDel;
}

public void setLinkIsDel(boolean linkIsDel) {
	this.linkIsDel = linkIsDel;
}



}
