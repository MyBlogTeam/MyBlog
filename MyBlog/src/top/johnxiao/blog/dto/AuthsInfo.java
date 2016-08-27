package top.johnxiao.blog.dto;

import java.io.Serializable;

public class AuthsInfo implements Serializable{
//	第三方认证主键，自增，认证编号
	private int authsId;
//	所属用户
	private UserInfo user;
//	认证类型
	private String authsType;
//	认证token
	private String authsToken;
//	认证expires
	private String authsExpires;
//	是否删除
	private boolean authsIsDel;
	
	public AuthsInfo(){}

	public AuthsInfo(int authsId, UserInfo user, String authsType,
			String authsToken, String authsExpires, boolean authsIsDel) {
		this.authsId = authsId;
		this.user = user;
		this.authsType = authsType;
		this.authsToken = authsToken;
		this.authsExpires = authsExpires;
		this.authsIsDel = authsIsDel;
	}


	public int getAuthsId() {
		return authsId;
	}

	public void setAuthsId(int authsId) {
		this.authsId = authsId;
	}

	public UserInfo getUser() {
		return user;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public String getAuthsType() {
		return authsType;
	}

	public void setAuthsType(String authsType) {
		this.authsType = authsType;
	}

	public String getAuthsToken() {
		return authsToken;
	}

	public void setAuthsToken(String authsToken) {
		this.authsToken = authsToken;
	}

	public String getAuthsExpires() {
		return authsExpires;
	}

	public void setAuthsExpires(String authsExpires) {
		this.authsExpires = authsExpires;
	}

	public boolean getAuthsIsDel() {
		return authsIsDel;
	}

	public void setAuthsIsDel(boolean authsIsDel) {
		this.authsIsDel = authsIsDel;
	}
	
	
}
