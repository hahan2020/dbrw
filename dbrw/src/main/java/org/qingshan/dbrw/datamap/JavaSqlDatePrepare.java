package org.qingshan.dbrw.datamap;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.eyuanku.web.framework.storage.db.IPrepare;

class JavaSqlDatePrepare implements IPrepare {
	@Override
	public void prepare(PreparedStatement ps, int index, Object obj) throws SQLException {
		Date date = (Date)obj;
		ps.setTimestamp(index, new Timestamp(date.getTime()));
	}
}