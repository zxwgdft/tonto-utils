package com.tonto2.database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

public class DataObject extends AbstractObject{

	/**
	 * 数据对象属性集合
	 */
	private ConcurrentHashMap<String, DataProperty> propertyMap = new ConcurrentHashMap<>();


	/**
	 * 获取所有数据属性
	 * 
	 * @return
	 */
	public List<DataProperty> getProperties() {
		return new ArrayList<DataProperty>(propertyMap.values());
	}

	
	/**
	 * 创建一个数据属性
	 * @param name
	 * @return
	 * @throws DataObjectException 
	 */
	public DataProperty createProperty(String name) throws DataObjectException{		
		if(StringUtils.isEmpty(name))
			throw new DataObjectException("属性名称不能为空");
		DataProperty property = new DataProperty(this);
		if (propertyMap.putIfAbsent(name, property) != property)
			throw new DataObjectException("数据对象[" + name + "]" + "已经存在名为[" + name + "]的属性");
		return property;
	}
	
}
