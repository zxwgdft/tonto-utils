package com.tonto2.database.relation;

import com.tonto2.database.DataProperty;
import com.tonto2.database.Relation;

/**
 * 
 * 相同属性关系，外键
 * 
 * @author TontZhou
 *
 */
public class EqualPropertyRelation implements Relation {

	/**
	 * 映射类型，自身相对目标的关系
	 */
	private MappingType mappingType;

	/**
	 * 相同属性目标
	 */
	private DataProperty target;
	
	
	public EqualPropertyRelation(MappingType type,DataProperty target){
		
		mappingType = type;
		this.target = target;
	}
	
	
	/**
	 * 
	 * 映射类型
	 * <ul>
	 * <li>ONE_TO_ONE：一对一</li>
	 * <li>MANY_TO_ONE：多对多</li>
	 * <li>MANY_TO_MANY：多对一</li>
	 * <li>ONE_TO_MANY：一对多</li>
	 * </ul>
	 * 
	 * @author TontZhou
	 * 
	 */
	public static enum MappingType {
		ONE_TO_ONE, ONE_TO_MANY, MANY_TO_ONE, MANY_TO_MANY;
	}

	/**  
	 * 映射类型，自身相对目标的关系  
	 */
	public MappingType getMappingType() {
		return mappingType;
	}

	/**  
	 * 相同属性目标  
	 */
	public DataProperty getTarget() {
		return target;
	}


}
