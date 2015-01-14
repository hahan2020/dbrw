package org.qingshan.dbrw.datatype;

import java.io.Serializable;
import java.util.List;

/**
 * @author 345480567@qq.com
 * 
 */
public class ColumnData implements Serializable {

	private static final long serialVersionUID = 666290529635155989L;
	private FieldMeta fieldMeta = null;
	private List<FieldData> fieldList = null;
	
	public ColumnData(FieldMeta fieldMeta, List<FieldData> fieldList) {
		this.fieldMeta = fieldMeta;
		this.fieldList = fieldList;
	}
	
	public String getColumnLabel() {
		return fieldMeta.getFieldLabel();
	}
	
	public FieldData getField(Integer rowIndex) {
		return fieldList.get(rowIndex);
	}
}
