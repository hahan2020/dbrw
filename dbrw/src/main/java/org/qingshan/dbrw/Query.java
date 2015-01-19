package org.qingshan.dbrw;

import java.io.Serializable;
import java.util.List;

import org.qingshan.dbrw.datatype.PageData;
import org.qingshan.dbrw.datatype.RowData;
import org.qingshan.dbrw.datatype.TableData;

public interface Query {

	/* sql语句查询部分 */
	public TableData query(String sql);

	public TableData query(String sql, Object[] params);

	public RowData find(String sql);

	public RowData find(String sql, Object[] params);

	/* 对象查询部分 */
	public <T extends Serializable> List<T> queryObjectList(Class<T> clz, String sql);

	public <T extends Serializable> List<T> queryObjectList(Class<T> clz, String sql, Object[] params);

	public <T extends Serializable> T findObject(Class<T> clz, String sql);

	public <T extends Serializable> T findObjectByPk(T t);
	
	/* 分页查询部分 */
	public Query setPage(Integer pageNo, Integer pageSize);
	
	public PageData<TableData> pageQuery(String sql);
	
	public PageData<TableData> pageQuery(String sql, Object[] params);

	public <T extends Serializable> PageData<T> pageQueryObjectList(Class<T> clz, String sql);
	
	public <T extends Serializable> PageData<T> pageQueryObjectList(Class<T> clz, String sql, Object[] params);
}