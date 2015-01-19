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
public class RowData implements Serializable {

	private static final long serialVersionUID = -5523165521475396462L;

	private TableMeta tableMeta = null;
	
	private List<FieldData> fieldList = new ArrayList<FieldData>();
	
	public RowData(TableMeta tableMeta, ResultSet rs) throws SQLException {
		this.tableMeta = tableMeta;
		Integer len = tableMeta.getColumnSize();
		for (int i=1; i<=len; i++) {
			FieldData field = new FieldData(tableMeta.getFieldMeta(i), rs.getObject(i));
			fieldList.add(field);
		}
	}

	public Integer getColumnSize() {
		return tableMeta.getColumnSize();
	}

	public FieldData getFieldData(Integer columnIndex) {
		FieldData field = fieldList.get(columnIndex);
		return field;
	}

	public FieldData getFieldData(String labelName) {
		Integer columnIndex = tableMeta.getColumnIndexWithName(labelName);
		FieldData field = fieldList.get(columnIndex);
		return field;
	}

}
