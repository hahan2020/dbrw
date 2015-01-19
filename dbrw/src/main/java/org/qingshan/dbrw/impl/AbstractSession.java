package org.qingshan.dbrw.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.qingshan.dbrw.datamap.AbsDataMapping;

public abstract class AbstractSession {

	protected DataSource dataSource = null;

	protected Connection conn = null;

	protected PreparedStatement pstat = null;

	protected Map<Class<?>, AbsDataMapping> dataMap = null;

	public AbstractSession(DataSource dataSource) {
		this.dataSource = dataSource;
	};

	protected void prepare(PreparedStatement ps, Object parameters[]) throws SQLException {
		if (null != parameters) {
			for (int i = 0; i < parameters.length; i++) {
				Object parameter = parameters[i];
				dataMap
				.get(parameter.getClass())
				.prepare(ps, i, parameter);
			}
		}
	}

}
