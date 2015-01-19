package org.qingshan.dbrw.dialect;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eyuanku.web.framework.storage.db.p.orm.dt.ColPlaceAndValue;

public interface Dialect {
	public String getCountSql(String sql);
	public String getPageSql(String sql, int start, int end);
		
	public ColPlaceAndValue getColPlaceAndValue(Field field, Object fieldValue, Connection conn);
	
	public void set(PreparedStatement ps, int index, Object obj) throws SQLException;
	
}
