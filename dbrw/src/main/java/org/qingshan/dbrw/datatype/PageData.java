package org.qingshan.dbrw.datatype;

import java.io.Serializable;

/**
 * @author 345480567@qq.com
 * 
 */
public class PageData<T extends Serializable> implements Serializable {

	private static final long serialVersionUID = -5870088156916653224L;

	private int pageNo = 1;
	private int pageTotal = 0;
	private int recordCount = 0;
	//TableData|List<T>
	private T records = null;
	
	public PageData() {
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public T getRecords() {
		return records;
	}

	public void setRecords(T records) {
		this.records = records;
	}

}
