package top.johnxiao.blog.dto;

import java.io.Serializable;

/**
 * 此表为类别表和文章表多对多关系的第三张表
 * 因此单独添加ID字段作为主键，避免外键作为主键
 * @author 肖伟
 *
 */

public class TypeArticle implements Serializable {

//	编号
	private Integer atId;
//	是否删除
	private boolean atIsDel;
//	类别,指向类别编号
	private TypeInfo typeinfo;
//	文章,指向文章编号
	private ArticleInfo articleinfo;
	
	
public TypeArticle() {}


public TypeArticle(Integer atId, boolean atIsDel, TypeInfo typeinfo,
		ArticleInfo articleinfo) {
	this.atId = atId;
	this.atIsDel = atIsDel;
	this.typeinfo = typeinfo;
	this.articleinfo = articleinfo;
}


public Integer getAtId() {
	return atId;
}

public void setAtId(Integer atId) {
	this.atId = atId;
}

public boolean getAtIsDel() {
	return atIsDel;
}


public void setAtIsDel(boolean atIsDel) {
	this.atIsDel = atIsDel;
}


public TypeInfo getTypeinfo() {
	return typeinfo;
}

public void setTypeinfo(TypeInfo typeinfo) {
	this.typeinfo = typeinfo;
}

public ArticleInfo getArticleinfo() {
	return articleinfo;
}

public void setArticleinfo(ArticleInfo articleinfo) {
	this.articleinfo = articleinfo;
}

}