package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;


public class TypeInfo implements Serializable {

//	类型编号
	private Integer typeId;
//	所属管理员
	private AdminInfo admininfo;
//	类型(此表做了自关联,类别可再分类别,等同评论表)
	private TypeInfo typeinfo;
//	类别名称
	private String typeName;
//	类别描述
	private String typeDesc;
//	是否删除,软删除
	private Boolean typeIsDel;
//	再分类
	private List<TypeInfo> types;
//	对应的文章
	private List<TypeArticle> typeArticles;
	
public TypeInfo() {}

public TypeInfo(Integer typeId) {
	this.typeId = typeId;
}

public TypeInfo(Integer typeId, AdminInfo admininfo, TypeInfo typeinfo,
		String typeName, String typeDesc, Boolean typeIsDel,
		List<TypeInfo> types, List<TypeArticle> typeArticles) {
	this.typeId = typeId;
	this.admininfo = admininfo;
	this.typeinfo = typeinfo;
	this.typeName = typeName;
	this.typeDesc = typeDesc;
	this.typeIsDel = typeIsDel;
	this.types = types;
	this.typeArticles = typeArticles;
}

public Integer getTypeId() {
	return typeId;
}

public void setTypeId(Integer typeId) {
	this.typeId = typeId;
}

public AdminInfo getAdmininfo() {
	return admininfo;
}

public void setAdmininfo(AdminInfo admininfo) {
	this.admininfo = admininfo;
}

public TypeInfo getTypeinfo() {
	return typeinfo;
}

public void setTypeinfo(TypeInfo typeinfo) {
	this.typeinfo = typeinfo;
}

public String getTypeName() {
	return typeName;
}

public void setTypeName(String typeName) {
	this.typeName = typeName;
}

public String getTypeDesc() {
	return typeDesc;
}

public void setTypeDesc(String typeDesc) {
	this.typeDesc = typeDesc;
}

public Boolean getTypeIsDel() {
	return typeIsDel;
}

public void setTypeIsDel(Boolean typeIsDel) {
	this.typeIsDel = typeIsDel;
}

public List<TypeInfo> getTypes() {
	return types;
}

public void setTypes(List<TypeInfo> types) {
	this.types = types;
}

public List<TypeArticle> getTypeArticles() {
	return typeArticles;
}

public void setTypeArticles(List<TypeArticle> typeArticles) {
	this.typeArticles = typeArticles;
}

@Override
public String toString() {
	return "TypeInfo [typeId=" + typeId + ", admininfo=" + admininfo
			+ ", typeinfo=" + typeinfo + ", typeName=" + typeName
			+ ", typeDesc=" + typeDesc + ", typeIsDel=" + typeIsDel
			+ ", types=" + types + ", typeArticles=" + typeArticles + "]";
}


	
}