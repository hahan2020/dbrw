package org.qingshan.dbrw.datamap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eyuanku.web.framework.storage.db.IPrepare;

class JavaUtilDatePrepare implements IPrepare {		
	@Override
	public void prepare(PreparedStatement ps, int index, Object obj) throws SQLException {
		java.sql.Timestamp ts = new java.sql.Timestamp(((java.util.Date)obj).getTime());
		ps.setTimestamp(index, ts);
	}
}