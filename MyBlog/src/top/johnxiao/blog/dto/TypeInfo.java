package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;


public class TypeInfo implements Serializable {
//	分类编号,自增
	private int typeId;
//	对应管理员
	private AdminInfo admininfo;
//	分类名称
	private String typeName;
//	分类描述
	private String typeDesc;
//	是否删除
	private boolean typeIsDel;
//	父级分类
	private List<TypeRecord> Typ_types ;
//	对应博文
	private List<TypeArticle> typeArticles;
//	子级分类
	private List<TypeRecord> types;
	
public TypeInfo() {}

public TypeInfo(int typeId, AdminInfo admininfo, String typeName,
		String typeDesc, boolean typeIsDel, List<TypeRecord> typ_types,
		List<TypeArticle> typeArticles, List<TypeRecord> types) {
	this.typeId = typeId;
	this.admininfo = admininfo;
	this.typeName = typeName;
	this.typeDesc = typeDesc;
	this.typeIsDel = typeIsDel;
	Typ_types = typ_types;
	this.typeArticles = typeArticles;
	this.types = types;
}

public int getTypeId() {
	return typeId;
}

public void setTypeId(int typeId) {
	this.typeId = typeId;
}

public AdminInfo getAdmininfo() {
	return admininfo;
}

public void setAdmininfo(AdminInfo admininfo) {
	this.admininfo = admininfo;
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

public boolean getTypeIsDel() {
	return typeIsDel;
}

public void setTypeIsDel(boolean typeIsDel) {
	this.typeIsDel = typeIsDel;
}

public List<TypeRecord> getTyp_types() {
	return Typ_types;
}

public void setTyp_types(List<TypeRecord> typ_types) {
	Typ_types = typ_types;
}

public List<TypeArticle> getTypeArticles() {
	return typeArticles;
}

public void setTypeArticles(List<TypeArticle> typeArticles) {
	this.typeArticles = typeArticles;
}

public List<TypeRecord> getTypes() {
	return types;
}

public void setTypes(List<TypeRecord> types) {
	this.types = types;
}

@Override
public String toString() {
	return "TypeInfo [typeId=" + typeId + ", admininfo=" + admininfo
			+ ", typeName=" + typeName + ", typeDesc=" + typeDesc
			+ ", typeIsDel=" + typeIsDel + ", Typ_types=" + Typ_types
			+ ", typeArticles=" + typeArticles + ", types=" + types + "]";
}

	
}