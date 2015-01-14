package org.qingshan.dbrw.datatype;

import java.io.Serializable;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 345480567@qq.com
 * 
 */
public class FieldMeta implements Serializable {

	private static final long serialVersionUID = 5908273745548125924L;
	private static Logger logger = LoggerFactory.getLogger(FieldMeta.class);
	
	private String fieldLabel = "";
	private String fieldName = "";
	private String fieldClassName = "";
	private int fieldType = 0;
	private String fieldTypeName = "";
	
	public FieldMeta(ResultSetMetaData rsmd, Integer i) throws SQLException {
		String columnLabel = rsmd.getColumnLabel(i);
		String columnName = rsmd.getColumnName(i);
		if (!columnLabel.equalsIgnoreCase(columnName)) {
			logger.warn("columnLabel is {},columnName is {}", columnLabel, columnName);
		}
		setFieldName(columnName);
		setFieldLabel(columnLabel);
		setFieldClassName(rsmd.getColumnClassName(i));
		setFieldType(rsmd.getColumnType(i));
		setFieldTypeName(rsmd.getColumnTypeName(i));
	}
	public String getFieldLabel() {
		return fieldLabel;
	}
	public void setFieldLabel(String fieldLabel) {
		this.fieldLabel = fieldLabel;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldClassName() {
		return fieldClassName;
	}
	public void setFieldClassName(String fieldClassName) {
		this.fieldClassName = fieldClassName;
	}
	public int getFieldType() {
		return fieldType;
	}
	public void setFieldType(int fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldTypeName() {
		return fieldTypeName;
	}
	public void setFieldTypeName(String fieldTypeName) {
		this.fieldTypeName = fieldTypeName;
	}
}
