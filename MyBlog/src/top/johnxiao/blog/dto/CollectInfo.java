package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 此表为用户和博文之间多对多关系构成的第三张表
 * 该表单独添加一个ID字段,避免外键作为主键，不好操作
 * @author 肖伟
 *
 */
public class CollectInfo implements Serializable{
//	收藏编号
	private int collectId;
//	收藏人
	private UserInfo user;
//	收藏的博文的编号
	private ArticleInfo article;
//	收藏时间
	private Timestamp collectDate;
//	是否删除
	private boolean collectIsDel;
	
public CollectInfo() {}


public CollectInfo(int collectId, UserInfo user, ArticleInfo article,
		Timestamp collectDate, boolean collectIsDel) {
	this.collectId = collectId;
	this.user = user;
	this.article = article;
	this.collectDate = collectDate;
	this.collectIsDel = collectIsDel;
}

public int getCollectId() {
	return collectId;
}

public void setCollectId(int collectId) {
	this.collectId = collectId;
}

public UserInfo getUser() {
	return user;
}

public void setUser(UserInfo user) {
	this.user = user;
}

public ArticleInfo getArticle() {
	return article;
}

public void setArticle(ArticleInfo article) {
	this.article = article;
}

public Timestamp getCollectDate() {
	return collectDate;
}

public void setCollectDate(Timestamp collectDate) {
	this.collectDate = collectDate;
}


public boolean getCollectIsDel() {
	return collectIsDel;
}


public void setCollectIsDel(boolean collectIsDel) {
	this.collectIsDel = collectIsDel;
}


}
