package top.johnxiao.blog.dto;

import java.io.Serializable;

/**
 * 此表为文章和标签之间多对多关系形成的第三张表
 * 另外添加Id字段作为该表主键
 * 避免外键作为主键
 * @author 肖伟
 *
 */
public class LabelArticle implements Serializable{
//	标签编号
	private int laId;
//	标签所对应的文章,指向文章编号
	private ArticleInfo article;
//	文章所对应的标签,指向标签编号
	private LabelInfo label;
//	是否删除
	private boolean laIsDel;
	
	
public LabelArticle() {}


public LabelArticle(int laId, ArticleInfo article, LabelInfo label,
		boolean laIsDel) {
	this.laId = laId;
	this.article = article;
	this.label = label;
	this.laIsDel = laIsDel;
}


public int getLaId() {
	return laId;
}

public void setLaId(int laId) {
	this.laId = laId;
}

public ArticleInfo getArticle() {
	return article;
}

public void setArticle(ArticleInfo article) {
	this.article = article;
}

public LabelInfo getLabel() {
	return label;
}

public void setLabel(LabelInfo label) {
	this.label = label;
}


public boolean getLaIsDel() {
	return laIsDel;
}


public void setLaIsDel(boolean laIsDel) {
	this.laIsDel = laIsDel;
}


}
