package com.zhiyou.video.util;

import java.util.List;

/**
 * Descr: 封装的分页数据类
 *
 */
public class PageInfo<T> {
	private int pageNum;//页码
	private int pageSize;//每页数量
	private int allNum;//总数据量
	private int pageNums;//总页码
	
	private List<T> results;//结果集合

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAllNum() {
		return allNum;
	}

	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}

	public int getPageNums() {
		return pageNums;
	}

	public void setPageNums(int pageNums) {
		this.pageNums = pageNums;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "PageInfo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", allNum=" + allNum + ", pageNums="
				+ pageNums + ", results=" + results + "]";
	}
	
}
