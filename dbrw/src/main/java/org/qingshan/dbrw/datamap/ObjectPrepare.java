package org.qingshan.dbrw.datamap;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eyuanku.web.framework.storage.db.IPrepare;

public class ObjectPrepare implements IPrepare {

	@Override
	public void prepare(PreparedStatement ps, int index, Object obj)
			throws SQLException {
		ps.setObject(index, obj);
	}

}
