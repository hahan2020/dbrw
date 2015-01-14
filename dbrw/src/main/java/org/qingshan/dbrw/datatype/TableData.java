package org.qingshan.dbrw.datatype;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 345480567@qq.com
 * 
 */
public class TableData implements Serializable{
	
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
		List<Field> fieldList = new ArrayList<Field>();
		for(RowData rowData : rowDataList) {
			Field field = rowData.getField(columnIndex);
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
	public Field getCell(Integer rowIndex, Integer columnIndex) {
		RowData rowData = getRow(rowIndex);
		Field field = rowData.getField(columnIndex);
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
