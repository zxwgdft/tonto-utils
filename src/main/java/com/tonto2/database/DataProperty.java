package com.tonto2.database;

/**
 * 数据类型属性
 * 
 * @author TontZhou
 *
 */
public class DataProperty extends AbstractObject{
	
	/**
	 * 类型
	 */
	private String type;
	
	/**
	 * 拥有者
	 */
	private DataObject owner;
	
	/**
	 * 注释
	 */
	private String comment;
		
	
	protected DataProperty(DataObject owner)
	{
		this.owner = owner;
	}

	/**  
	 * 类型  
	 */
	public String getType() {
		return type;
	}

	/**  
	 * 类型  
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**  
	 * 注释  
	 */
	public String getComment() {
		return comment;
	}

	/**  
	 * 注释  
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**  
	 * 拥有者  
	 */
	public DataObject getOwner() {
		return owner;
	}
}
