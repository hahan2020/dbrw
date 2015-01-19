package org.qingshan.dbrw.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

import org.qingshan.dbrw.datamap.AbsDataMapping;
import org.qingshan.dbrw.datatype.FieldData;
import org.qingshan.dbrw.datatype.RowData;
import org.qingshan.dbrw.orm.anno.Column;
import org.qingshan.dbrw.orm.anno.Table;

public class ResultSetUtil {

	public static <T extends Serializable> T read2Object(Class<T> clz, RowData rowData) throws InstantiationException, IllegalAccessException {
		if (clz == null || !clz.isAnnotationPresent(Table.class)) {
			//TODO:
			return null;
		} else {
			T t = clz.newInstance();
			Field[] fields = clz.getDeclaredFields();
			Map<Class<?>, AbsDataMapping> dataMap = AbsDataMapping.getInstanceMap();
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					Column ca = field.getAnnotation(Column.class);
					//映射的数据库表名称
					String columnName = ca.value();
					//取得数据库里面的值
					FieldData fieldData  = rowData.getFieldData(columnName);
					//
					Class<?> fieldType = field.getType();
					AbsDataMapping dataMapping = dataMap.get(fieldType);
					dataMapping.setter(t, field, fieldData);
				}
			}
			return t;
		}
	}
	
}
