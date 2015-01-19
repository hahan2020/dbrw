package org.qingshan.dbrw.datamap;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.qingshan.dbrw.datatype.FieldData;

class BooleanMap extends AbsDataMapping {
	public void toDb(PreparedStatement ps, int index, Object obj)
			throws SQLException {
		ps.setBoolean(index, (Boolean)obj);
	}
	
	public <T extends Serializable> void setter(T t, Field field, FieldData fieldData) throws IllegalArgumentException, IllegalAccessException {
		field.setBoolean(t, fieldData.getBoolean());
	}

	@Override
	public void prepare(PreparedStatement ps, Integer index, Object obj) throws SQLException {
		ps.setBoolean(index, (Boolean)obj);		
	}
	
}