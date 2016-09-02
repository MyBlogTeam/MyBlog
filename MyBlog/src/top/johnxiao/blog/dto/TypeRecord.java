package top.johnxiao.blog.dto;

import java.io.Serializable;

/**
 * 多级分类,从属关系记录表
 * @author 肖伟
 *
 */
public class TypeRecord implements Serializable{
//	类型层次表Id,自增
	private int trId;
//	父级Id
	private TypeInfo Typ_typeId;
//	子级Id
	private TypeInfo typeId;
//	是否删除
	private boolean trIsDel;
	
	public TypeRecord() {}

	public TypeRecord(int trId, TypeInfo typ_typeId, TypeInfo typeId,
			boolean trIsDel) {
		this.trId = trId;
		Typ_typeId = typ_typeId;
		this.typeId = typeId;
		this.trIsDel = trIsDel;
	}

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public TypeInfo getTyp_typeId() {
		return Typ_typeId;
	}

	public void setTyp_typeId(TypeInfo typ_typeId) {
		Typ_typeId = typ_typeId;
	}

	public TypeInfo getTypeId() {
		return typeId;
	}

	public void setTypeId(TypeInfo typeId) {
		this.typeId = typeId;
	}

	public boolean getTrIsDel() {
		return trIsDel;
	}

	public void setTrIsDel(boolean trIsDel) {
		this.trIsDel = trIsDel;
	}

	@Override
	public String toString() {
		return "TypeRecord [trId=" + trId + ", Typ_typeId=" + Typ_typeId
				+ ", typeId=" + typeId + ", trIsDel=" + trIsDel + "]";
	}
	

}
