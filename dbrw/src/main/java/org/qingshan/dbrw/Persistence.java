package org.qingshan.dbrw;

import java.sql.Savepoint;
import java.util.List;

public interface Persistence {
	
	/* sql语句一级的操作 */
	public Integer execute(String sql);
	public Integer execute(String sql, Object[] objects);
	public Integer insert(String sql);
	public Integer insert(String sql, Object[] objects);
	public Integer[] batchExecute(String sql, List<Object[]> parametersList);
	public Integer[] batchInsert(String sql, List<Object[]> parametersList);
	
	/* 对象一级的操作 */
	public Integer insertObject(Object obj);
	public void beginObjectUpdate(Object obj);
	public Integer updateObject(Object obj);
	public Integer deleteObject(Object obj);
	
	/* 事务一级的操作 */
	public void beginTransaction();
	public boolean isInTransaction();			//Persistence是否在一个事务中
	public void commitTransaction();
	public void rollback();
	public void rollback(Savepoint savepoint);
	public void releaseSavepoint(Savepoint savepoint);
	public Query getMasterQuery();
}
