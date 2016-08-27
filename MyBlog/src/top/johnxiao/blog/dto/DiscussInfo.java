package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class DiscussInfo implements Serializable{
//	评论编号
	private int discussId;
//	若评论评论,此处指向评论的ID
	private DiscussInfo discuss;
//	评论的文章对象
	private ArticleInfo article;
//	评论人
	private UserInfo user;
//	评论内容
	private String discussContent;
//	评论时间
	private Timestamp discussDate;
//	是否删除
	private boolean discussIsDel;
//	此处表示对某文章或评论的多次评论
	private List<DiscussInfo> discusss;
	
public DiscussInfo() {}


public DiscussInfo(int discussId, DiscussInfo discuss, ArticleInfo article,
		UserInfo user, String discussContent, Timestamp discussDate,
		boolean discussIsDel, List<DiscussInfo> discusss) {
	this.discussId = discussId;
	this.discuss = discuss;
	this.article = article;
	this.user = user;
	this.discussContent = discussContent;
	this.discussDate = discussDate;
	this.discussIsDel = discussIsDel;
	this.discusss = discusss;
}


public int getDiscussId() {
	return discussId;
}

public void setDiscussId(int discussId) {
	this.discussId = discussId;
}

public DiscussInfo getDiscuss() {
	return discuss;
}

public void setDiscuss(DiscussInfo discuss) {
	this.discuss = discuss;
}

public ArticleInfo getArticle() {
	return article;
}

public void setArticle(ArticleInfo article) {
	this.article = article;
}

public UserInfo getUser() {
	return user;
}

public void setUser(UserInfo user) {
	this.user = user;
}

public String getDiscussContent() {
	return discussContent;
}

public void setDiscussContent(String discussContent) {
	this.discussContent = discussContent;
}

public Timestamp getDiscussDate() {
	return discussDate;
}

public void setDiscussDate(Timestamp discussDate) {
	this.discussDate = discussDate;
}

public List<DiscussInfo> getDiscusss() {
	return discusss;
}

public void setDiscusss(List<DiscussInfo> discusss) {
	this.discusss = discusss;
}


public boolean isDiscussIsDel() {
	return discussIsDel;
}


public void setDiscussIsDel(boolean discussIsDel) {
	this.discussIsDel = discussIsDel;
}

}
