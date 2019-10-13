package com.lghcode.bishe001.util;

import java.util.List;

/**
 * @Description: 封装分页后的数据格式
 */
public class PagedResult {
	
	private int pageNum;			// 当前页码
	private int totalPage;			// 总页数
	private long totalRecord;		// 总记录数
	private List<?> rows;		// 每行显示的内容

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
}
