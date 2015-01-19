package org.qingshan.dbrw.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.qingshan.dbrw.Query;
import org.qingshan.dbrw.datatype.PageData;
import org.qingshan.dbrw.datatype.RowData;
import org.qingshan.dbrw.datatype.TableData;
import org.qingshan.dbrw.ds.MasterSlaveDataSource;
import org.qingshan.dbrw.util.ConnUtil;
import org.qingshan.dbrw.util.ResultSetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QueryImpl extends AbstractSession implements Query {

	protected static Logger logger = LoggerFactory
			.getLogger(QueryImpl.class);
	
	private ResultSet rs = null;
	
	public QueryImpl(MasterSlaveDataSource dataSource) {
		super(dataSource);
	};

	public TableData query(String sql) {
		return query(sql, null);
	}

	public TableData query(String sql, Object[] parameters) {
		boolean isCreatePstat = false;
		boolean isCreateRset = false;
		try {
			conn = dataSource.getConnection();
			pstat = conn.prepareStatement(sql);
			isCreatePstat = true;
			prepare(pstat, parameters);
			rs = pstat.executeQuery();
			isCreateRset = true;
			
			if (rs != null) {
				TableData tableData = new TableData(rs);
				return tableData;
			} else {
				return null;
			}
		} catch (SQLException sqle) {
			logger.error("query exception:", sql);
			return null;
		} finally {
			if (isCreateRset) {
				ConnUtil.close(rs);
			}
			if (isCreatePstat) {
				ConnUtil.close(pstat);
			}
			ConnUtil.close(conn);
		}
	}

	public RowData find(String sql) {
		return find(sql, new Object[0]);
	}

	/**
	 * @param sql
	 * @param param
	 * @return 如果找不到满足条件的数据则返回null
	 */
	public RowData find(String sql, String param) {
		return find(sql, new String[]{ param });
	}

	public RowData find(String sql, Object[] parameters) {
		TableData tableData = query(sql, parameters);
		if (tableData == null || tableData.getRowSize() != 1) {
			//TODO:
			return null;
		} else {
			return tableData.getRow(0);
		}
	}

	public <T extends Serializable> List<T> queryObjectList(Class<T> clz, String sql) {
		return queryObjectList(clz, sql, null);
	}

	public <T extends Serializable> List<T> queryObjectList(Class<T> clz, String sql, Object[] parameters) {
		TableData tableData = query(sql, parameters);
		List<T> objList = new ArrayList<T>();
		if (tableData != null) {
			for(RowData rowData : tableData) {
				try {
					objList.add(ResultSetUtil.read2Object(clz, rowData));
				} catch (Exception e) {
					logger.error("rowdata to Object accour exception:", e);
				}
			}
		}
		return objList;
	}

	public <T extends Serializable> T findObject(Class<T> clz, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Serializable> T findObjectByPk(T t) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query setPage(Integer pageNo, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageData<TableData> pageQuery(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public PageData<TableData> pageQuery(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Serializable> PageData<T> pageQueryObjectList(
			Class<T> clz, String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Serializable> PageData<T> pageQueryObjectList(
			Class<T> clz, String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
