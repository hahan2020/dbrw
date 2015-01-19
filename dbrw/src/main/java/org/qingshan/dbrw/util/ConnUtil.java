package org.qingshan.dbrw.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnUtil {

	protected static Logger logger = LoggerFactory
			.getLogger(ConnUtil.class);
	
	public static void close(ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {
			logger.error("{}：{}", sqle.getMessage(), sqle.getCause().toString());
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement ps){
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException sqle) {
			logger.error("{}：{}", sqle.getMessage(), sqle.getCause().toString());
			sqle.printStackTrace();
		}
	}

	public static void close(Connection conn){
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sqle) {
			logger.error("{}：{}", sqle.getMessage(), sqle.getCause().toString());
			sqle.printStackTrace();
		}
	}

}
