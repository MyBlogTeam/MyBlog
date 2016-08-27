package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.util.List;

public class PageList<T> implements Serializable{
	
	private int sumCount;
	private int pageCount;
	private List<T> list;
	
	public int getSumCount() {
		return sumCount;
	}
	public void setSumCount(int sumCount) {
		this.sumCount = sumCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
