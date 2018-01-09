package com.tonto2.database;

/**
 * 
 * 数据关系
 * <p>这里的关系都是两者之间的关系</p>
 * 
 * @author TontZhou
 *
 */
public class DataRelation{
	
	/**
	 * 关键字
	 */
	private String key;
	
	/**
	 * 拥有者
	 */
	private AbstractObject owner;
	
	/**
	 * 关系
	 */
	private Relation relation;
	
	protected DataRelation(AbstractObject owner, Relation relation)
	{
		this.owner = owner;
		this.relation = relation;
	}

	/**  
	 * 拥有者  
	 */
	public AbstractObject getOwner() {
		return owner;
	}


	/**  
	 * 关系  
	 */
	public Relation getRelation() {
		return relation;
	}

	/**  
	 * 关键字  
	 */
	public String getKey() {
		return key;
	}
	
	
	
	
}
