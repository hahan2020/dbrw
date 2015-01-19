package org.qingshan.dbrw;

import javax.sql.DataSource;

import org.qingshan.dbrw.ds.MasterSlaveDataSource;


/**
 * 
 * @author 345480567@qq.com
 */
public class DbSessionFactory {

	public Persistence createPersistence(DataSource ds){
		return null;
	}
	
	public Query createQuery(DataSource ds) {
		return null;
	}
	
	public Persistence createPersistence(MasterSlaveDataSource ds){
		DataSource master = ds.getMaster();
		return createPersistence(master);
	}
	
	public Query createQuery(MasterSlaveDataSource ds) {
		DataSource slave = ds.getSlave();
		return createQuery(slave);
	}
	
}
