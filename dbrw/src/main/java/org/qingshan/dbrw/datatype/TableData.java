package org.qingshan.dbrw.datatype;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 345480567@qq.com
 * 
 */
public class TableData implements Serializable, Iterable<RowData> {
	
	private static final long serialVersionUID = 4724585893654754202L;
	
	private TableMeta tableMeta = null;
	private List<RowData> rowDataList = new ArrayList<RowData>();
	
	public TableData(ResultSet rs) throws SQLException {
		this.tableMeta = new TableMeta(rs);
		while(rs.next()) {
			RowData rowData = new RowData(tableMeta, rs);
			rowDataList.add(rowData);
		}
	}
	private TableData(){}

	//取得数据列数
	public Integer getColumnSize() {
		return tableMeta.getColumnSize();
	}
	
	//取得数据行数
	public Integer getRowSize() {
		return rowDataList.size();
	}

	//取得某一行
	public RowData getRow(Integer rowIndex) {
		return rowDataList.get(rowIndex);
	}

	//取得某列
	public ColumnData getColumn(Integer columnIndex) {
		FieldMeta fieldMeta = tableMeta.getFieldMeta(columnIndex);
		List<FieldData> fieldList = new ArrayList<FieldData>();
		for(RowData rowData : rowDataList) {
			FieldData field = rowData.getFieldData(columnIndex);
			fieldList.add(field);
		}
		ColumnData columnData = new ColumnData(fieldMeta, fieldList);
		return columnData;
	}
	
	public ColumnData getColumn(String columnName) {
		Integer columnIndex = this.tableMeta.getColumnIndexWithName(columnName);
		return getColumn(columnIndex);
	}
	
	//取得某行、某列的值
	public FieldData getCell(Integer rowIndex, Integer columnIndex) {
		RowData rowData = getRow(rowIndex);
		FieldData field = rowData.getFieldData(columnIndex);
		return field;
	}

	//行截断
	public TableData subRow(Integer begin) {
		return subRow(begin, getRowSize());
	}
	
	//行截断
	public TableData subRow(Integer begin, Integer end) {
		TableData tableData = new TableData();
		tableData.tableMeta = tableMeta;
		List<RowData> list = new ArrayList<RowData>(end-begin);
		for(int i=begin; i<end; i++) {
			list.add(rowDataList.get(i));
		}
		tableData.rowDataList = list;
		return tableData;
	}
	
	public Iterator<RowData> iterator() {
		return rowDataList.iterator();
	}
	
	//TODO:添加实现
//	public TableData subColumn(Integer begin, Integer end) {
//		TableData tableData = new TableData();
//		tableData.tableMeta = tableMeta;
//		List<RowData> list = new ArrayList<RowData>(end-begin);
//		for(int i=begin; i<end; i++) {
//			list.add(rowDataList.get(i));
//		}
//		tableData.rowDataList = list;
//		return tableData;
//	}
}
