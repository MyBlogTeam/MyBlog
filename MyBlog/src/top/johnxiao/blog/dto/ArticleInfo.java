package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class ArticleInfo implements Serializable{

//	文章编号
	private int articleId;
//	文章标题
	private String articleTitle;
//	发布日期
	private Timestamp articleDate;
//	博文内容
	private String articleContent;
//	浏览人数
	private int articlePeople;
//	文章状态
	private int articleState;
//	文章图片
	private String articlePic;
//	是否删除,软删除
	private boolean articleIsDel;
	
//	文章类别与子类别(设计时，文章类别做了自关联,类别还可再分为多个子类别)
	private List<TypeArticle> typeArticles;
//	文章评论
	private List<DiscussInfo> discusss;
//	文章收藏,一篇文章可被多个人收藏
	private List<CollectInfo> collects;
//	文章标签,一篇文章有多个标签，也可以没有
	private List<LabelArticle> labelArticles;
	
	
public ArticleInfo() {}


public ArticleInfo(int articleId, String articleTitle, Timestamp articleDate,
		String articleContent, int articlePeople, int articleState,
		String articlePic, boolean articleIsDel,
		List<TypeArticle> typeArticles, List<DiscussInfo> discusss,
		List<CollectInfo> collects, List<LabelArticle> labelArticles) {
	this.articleId = articleId;
	this.articleTitle = articleTitle;
	this.articleDate = articleDate;
	this.articleContent = articleContent;
	this.articlePeople = articlePeople;
	this.articleState = articleState;
	this.articlePic = articlePic;
	this.articleIsDel = articleIsDel;
	this.typeArticles = typeArticles;
	this.discusss = discusss;
	this.collects = collects;
	this.labelArticles = labelArticles;
}


public int getArticleId() {
	return articleId;
}


public void setArticleId(int articleId) {
	this.articleId = articleId;
}


public String getArticleTitle() {
	return articleTitle;
}


public void setArticleTitle(String articleTitle) {
	this.articleTitle = articleTitle;
}


public Timestamp getArticleDate() {
	return articleDate;
}


public void setArticleDate(Timestamp articleDate) {
	this.articleDate = articleDate;
}


public String getArticleContent() {
	return articleContent;
}


public void setArticleContent(String articleContent) {
	this.articleContent = articleContent;
}


public int getArticlePeople() {
	return articlePeople;
}


public void setArticlePeople(int articlePeople) {
	this.articlePeople = articlePeople;
}


public int getArticleState() {
	return articleState;
}


public void setArticleState(int articleState) {
	this.articleState = articleState;
}


public String getArticlePic() {
	return articlePic;
}


public void setArticlePic(String articlePic) {
	this.articlePic = articlePic;
}


public boolean getArticleIsDel() {
	return articleIsDel;
}


public void setArticleIsDel(boolean articleIsDel) {
	this.articleIsDel = articleIsDel;
}


public List<TypeArticle> getTypeArticles() {
	return typeArticles;
}


public void setTypeArticles(List<TypeArticle> typeArticles) {
	this.typeArticles = typeArticles;
}


public List<DiscussInfo> getDiscusss() {
	return discusss;
}


public void setDiscusss(List<DiscussInfo> discusss) {
	this.discusss = discusss;
}


public List<CollectInfo> getCollects() {
	return collects;
}


public void setCollects(List<CollectInfo> collects) {
	this.collects = collects;
}


public List<LabelArticle> getLabelArticles() {
	return labelArticles;
}


public void setLabelArticles(List<LabelArticle> labelArticles) {
	this.labelArticles = labelArticles;
}


@Override
public String toString() {
	return "ArticleInfo [articleId=" + articleId + ", articleTitle="
			+ articleTitle + ", articleDate=" + articleDate
			+ ", articleContent=" + articleContent + ", articlePeople="
			+ articlePeople + ", articleState=" + articleState
			+ ", articlePic=" + articlePic + ", articleIsDel=" + articleIsDel
			+ ", typeArticles=" + typeArticles + ", discusss=" + discusss
			+ ", collects=" + collects + ", labelArticles=" + labelArticles
			+ "]";
}
	
}
