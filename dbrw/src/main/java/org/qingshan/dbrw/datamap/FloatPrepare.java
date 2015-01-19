package org.qingshan.dbrw.datamap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eyuanku.web.framework.storage.db.IPrepare;

class FloatPrepare implements IPrepare {
	@Override
	public void prepare(PreparedStatement ps, int index, Object obj) throws SQLException {
		ps.setFloat(index, (Float)obj);
	}
}