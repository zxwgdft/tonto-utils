package com.tonto2.database;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractObject {
	
	/**
	 * 名称
	 */
	protected String name;

	/**
	 * 数据属性关系集合
	 */
	private ConcurrentHashMap<String, DataRelation> relationMap = new ConcurrentHashMap<>();
	
	
	/**
	 * 创建一个数据关系
	 * @param name
	 * @return
	 * @throws DataObjectException 
	 */
	public DataRelation createRelation(String name, Relation relation) throws DataObjectException{		
		if(StringUtils.isEmpty(name))
			throw new DataObjectException("属性名称不能为空");
		DataRelation dataRelation = new DataRelation(this, relation);
		if (relationMap.putIfAbsent(name, dataRelation) != dataRelation)
			throw new DataObjectException("数据对象[" + name + "]" + "已经存在名为[" + name + "]的关系");
		return dataRelation;
	}
	
	/**
	 * 获取所有数据关系
	 * 
	 * @return
	 */
	public List<DataRelation> getRelations() {
		return new ArrayList<DataRelation>(relationMap.values());
	}
	
	/**  
	 * 名称  
	 */
	public String getName() {
		return name;
	}

	/**  
	 * 名称  
	 */
	public void setName(String name) {
		this.name = name;
	}

	
}
