package org.qingshan.dbrw.datatype;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 345480567@qq.com
 * 
 */
public class TableMeta implements Serializable {
	
	private static final long serialVersionUID = 4789166931857015322L;
	
	private List<FieldMeta> fieldMetaList = new ArrayList<FieldMeta>();
	
	private Map<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
	
	public TableMeta(ResultSet rs) throws SQLException {
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		for(int i=1; i<=columnCount; i++) {
			FieldMeta fieldMeta = new FieldMeta(rsmd, i);
			appendFieldMeta(fieldMeta);
			fieldIndexMap.put(fieldMeta.getFieldLabel(), i);
		}
	}
	
	public void appendFieldMeta(FieldMeta fieldMeta) {
		fieldMetaList.add(fieldMeta);
	}
	
	public int getColumnSize() {
		return fieldMetaList.size();
	}
	
	public FieldMeta getFieldMeta(int columnIndex) {
		return this.fieldMetaList.get(columnIndex);
	}
	
	public Integer getColumnIndexWithName(String labelName) {
		Integer columnIndex = fieldIndexMap.get(labelName);
		return columnIndex;
	}
}
