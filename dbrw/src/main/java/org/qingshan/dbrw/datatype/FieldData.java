package org.qingshan.dbrw.datatype;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author 345480567@qq.com
 * 
 */
public class FieldData implements Serializable {

	private static final long serialVersionUID = -8182666564876333748L;
	private FieldMeta fieldMeta = null;
	private Object dbObj = null;
	public FieldData(FieldMeta fieldMeta, Object dbObj) {
		this.fieldMeta = fieldMeta;
		this.dbObj = dbObj;
	}

	public FieldMeta getFieldMeta() {
		return fieldMeta;
	}

	public boolean getboolean() {
		return false;
	}
	
	public Boolean getBoolean() {
		return null;
	}
	
	public int getInt(){
		return 0;
	}

	public Integer getInteger(){
		return null;
	}
	
	public float getfloat() {
		return 0;
	}
	
	public Float getFloat() {
		return null;
	}
	
	public double getdouble() {
		return 0;
	}
	
	public Double getDouble() {
		return null;
	}
	
	public String getString() {
		return null;
	}

	public Timestamp getTimestamp() {
		return null;
	}
	
	public Object getValue() {
		return dbObj;
	}

}
