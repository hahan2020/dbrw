package org.qingshan.dbrw.ds;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.qingshan.dbrw.dialect.Dialect;

public class MasterSlaveDataSource implements DataSource {

	private DataSource master = null;
	
	private DataSource slave = null;

	private Dialect dialect = null;
	
	private ThreadLocal<Connection> masterConnection = new ThreadLocal<Connection>();
	
	private ThreadLocal<Connection> slaveConncetion = new ThreadLocal<Connection>();
	
	public void setMaster(DataSource master) {
		this.master = master;
	}

	public void setSlave(DataSource slave) {
		this.slave = slave;
	}
	
	public DataSource getMaster() {
		return master;
	}

	public DataSource getSlave() {
		return slave;
	}

	public Dialect getDialect() {
		return dialect;
	}

	public void setDialect(Dialect dialect) {
		this.dialect = dialect;
	}

	public Connection currentPersistenceConnection() {
		Connection connection;// = masterConnection.get();
//		if (null == connection) {
			try {
				connection = master.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("创建持久化连接错误。", e);
			}
			masterConnection.set(connection);
//		}
		return connection;
	}
	
	public Connection currentQueryConnection() {
		Connection connection;// = slaveConncetion.get();
//		if (null == connection) {
			try {
				connection = slave.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("创建查询连接错误。", e);
			}
			slaveConncetion.set(connection);
//		}
		return connection;
	}

	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
