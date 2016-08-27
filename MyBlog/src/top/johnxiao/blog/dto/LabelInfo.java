package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;

public class LabelInfo implements Serializable{
//	标签编号
	private int labelId;
//	标签所属人
	private UserInfo user;
//	标签名称
	private String labelName;
//	是否删除,软删除
	private boolean labelIsDel;
//	一个标签对应多个文章
	private List<LabelArticle> labelArticles;
	
public LabelInfo() {}

public LabelInfo(int labelId, UserInfo user, String labelName,
		boolean labelIsDel, List<LabelArticle> labelArticles) {
	this.labelId = labelId;
	this.user = user;
	this.labelName = labelName;
	this.labelIsDel = labelIsDel;
	this.labelArticles = labelArticles;
}

public int getLabelId() {
	return labelId;
}

public void setLabelId(int labelId) {
	this.labelId = labelId;
}

public UserInfo getUser() {
	return user;
}

public void setUser(UserInfo user) {
	this.user = user;
}

public String getLabelName() {
	return labelName;
}

public void setLabelName(String labelName) {
	this.labelName = labelName;
}

public boolean getLabelIsDel() {
	return labelIsDel;
}

public void setLabelIsDel(boolean labelIsDel) {
	this.labelIsDel = labelIsDel;
}

public List<LabelArticle> getLabelArticles() {
	return labelArticles;
}

public void setLabelArticles(List<LabelArticle> labelArticles) {
	this.labelArticles = labelArticles;
}


}
