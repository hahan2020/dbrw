package org.qingshan.dbrw.datamap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eyuanku.web.framework.storage.db.IPrepare;

public class StringPrepare implements IPrepare {

	@Override
	public void prepare(PreparedStatement ps, int index, Object obj)
			throws SQLException {
		ps.setString(index, (String)obj);
	}

}
