package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class DiscussInfo implements Serializable{
//	评论编号
	private int discussId;
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
	private List<ReplyInfo> replys;
	
	
public DiscussInfo() {}


public DiscussInfo(int discussId, ArticleInfo article, UserInfo user,
		String discussContent, Timestamp discussDate, boolean discussIsDel,
		List<ReplyInfo> replys) {
	this.discussId = discussId;
	this.article = article;
	this.user = user;
	this.discussContent = discussContent;
	this.discussDate = discussDate;
	this.discussIsDel = discussIsDel;
	this.replys = replys;
}


public int getDiscussId() {
	return discussId;
}


public void setDiscussId(int discussId) {
	this.discussId = discussId;
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


public boolean getDiscussIsDel() {
	return discussIsDel;
}


public void setDiscussIsDel(boolean discussIsDel) {
	this.discussIsDel = discussIsDel;
}


public List<ReplyInfo> getReplys() {
	return replys;
}


public void setReplys(List<ReplyInfo> replys) {
	this.replys = replys;
}


@Override
public String toString() {
	return "DiscussInfo [discussId=" + discussId + ", article=" + article
			+ ", user=" + user + ", discussContent=" + discussContent
			+ ", discussDate=" + discussDate + ", discussIsDel=" + discussIsDel
			+ ", replys=" + replys + "]";
}

}
