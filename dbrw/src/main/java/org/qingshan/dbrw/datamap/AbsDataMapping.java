package org.qingshan.dbrw.datamap;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.qingshan.dbrw.datatype.FieldData;

public abstract class AbsDataMapping {

	public static Map<Class<?>, AbsDataMapping> getInstanceMap() {
		return null;
	}
	
	public abstract void prepare(PreparedStatement ps, Integer index, Object obj) throws SQLException ;
	
	public abstract <T extends Serializable> void setter(T t, Field field, FieldData fieldData) throws IllegalArgumentException, IllegalAccessException ;
}
