package org.qingshan.dbrw.datamap;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.qingshan.dbrw.datatype.FieldData;

class DoubleMapping extends AbsDataMapping {

	@Override
	public void prepare(PreparedStatement ps, Integer index, Object obj)
			throws SQLException {
		ps.setDouble(index, (Double)obj);
	}

	@Override
	public <T extends Serializable> void setter(T t, Field field,
			FieldData fieldData) throws IllegalArgumentException,
			IllegalAccessException {
		// TODO Auto-generated method stub
		
	}
}