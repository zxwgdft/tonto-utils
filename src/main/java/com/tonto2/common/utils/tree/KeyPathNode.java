package com.tonto2.common.utils.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tonto2.common.utils.StringParser;


/**
 * 
 * <h2>标识线索地址节点类</h2>
 * <p>本身是一个树节点，通过标识关键字绑定树节点，从而达到线索标识寻址功能</p>
 * 
 * @author TontZhou
 *
 */
public class KeyPathNode {

	/**
	 * 关键字
	 */
	private String key;

	/**
	 * 值
	 */
	private Object value;

	/**
	 * 父节点
	 */
	private KeyPathNode parent;

	/**
	 * 子节点集合
	 */
	private Map<String, KeyPathNode> childrenMap = new HashMap<>();

	public KeyPathNode(String key, Object value) {
		this.key = key;
		this.value = value;
	}

	/**
	 * 通过向上递归获取完整关键字，或者说是完整地址
	 * 
	 * @return
	 */
	public String getPath() {

		if (parent == null)
			return null;

		String parentPath = parent.getPath();

		return parentPath == null ? key : parentPath + "." + key;
	}

	/**
	 * @see findNode(String, int, int)
	 * @param path
	 * @return
	 */
	public KeyPathNode findNode(String path) {

		if (path == null)
			return null;

		String[] keys = path.split(".");

		return findNode(keys, 0, keys.length - 1);
	}

	/**
	 * @see findNode(String, int, int)
	 * @param keys
	 * @param startIndex
	 * @return
	 */
	public KeyPathNode findNode(String[] keys, int startIndex) {
		if (keys == null)
			return null;
		return findNode(keys, startIndex, keys.length - 1);
	}

	/**
	 * <p>
	 * 根据地址规则解析地址找到对应节点
	 * </p>
	 * <p>
	 * 例如["com","tonto","test"]，startIndex = 1，endIndex = 2，会找到tonto节点下的test节点
	 * </p>
	 * 
	 * @param keys
	 *            关键字，线索集合
	 * @param startIndex
	 *            开始位置
	 * @param endIndex
	 *            结束为止
	 * @return
	 */
	public KeyPathNode findNode(String[] keys, int startIndex, int endIndex) {

		if (keys == null || keys.length <= startIndex || startIndex > endIndex)
			return null;

		String key = keys[startIndex];

		KeyPathNode node = childrenMap.get(key);

		if (node == null)
			return null;

		if (startIndex == endIndex)
			return node;

		return node.findNode(keys, ++startIndex, endIndex);
	}

	/**
	 * 添加一个子节点到当前节点下
	 * @param key
	 * @param value
	 */
	public void addChildNode(String key, Object value) {

		if (key == null || "".equals(key))
			throw new IllegalArgumentException("参数Key不能为空！");

		if (value instanceof KeyPathNode) {
			childrenMap.put(key, (KeyPathNode) value);
		} else {
			KeyPathNode node = new KeyPathNode(key, value);
			node.parent = this;

			childrenMap.put(key, node);
		}
	}
	
	/**
	 * 添加一个子节点到当前节点下
	 * @param node
	 */
	public void addChildNode(KeyPathNode node) {

		if (node == null)
			throw new IllegalArgumentException("参数KeyPathNode不能为空！");

		childrenMap.put(node.getKey(), node);		
	}

	/**
	 * 根据地址添加一个子节点
	 * @param path
	 * @param value
	 */
	public void addKeyPathNode(String path, Object value) {
		
		if (path == null || "".equals(path))
			throw new IllegalArgumentException("参数path不能为空！");
		
		String[] keys = path.split(".");
		
		if(keys.length == 1)
			addChildNode(keys[0],value);
		
		if(keys.length > 1)
		{
			KeyPathNode node = findNode(keys, 0, keys.length - 2);
			if(node == null)
				throw new IllegalArgumentException("参数path不正确，无法找到地址[" + path +"]对应的节点");
			
			node.addChildNode(keys[keys.length - 1], value);
		}
	}
	
	public void addKeyPathNode(String[] keys, int startIndex, int endIndex, Object value) {
		
		if (keys == null)
			throw new IllegalArgumentException("参数path不能为空！");
				
		if(keys.length == 1)
			addChildNode(keys[0],value);
		
		if(keys.length > 1)
		{
			KeyPathNode node = findNode(keys, startIndex, endIndex - 1);
			if(node == null)
				throw new IllegalArgumentException("参数path不正确，无法找到地址[" + StringParser.parseString(keys) +"]对应的节点");
			
			node.addChildNode(keys[keys.length - 1], value);
		}
	}

	/**
	 * 值
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * 值
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * 关键字
	 */
	public String getKey() {
		return key;
	}

	/**
	 * 父节点
	 */
	public KeyPathNode getParent() {
		return parent;
	}

	/**
	 * 子节点集合
	 */
	public List<KeyPathNode> getChildrenMap() {
		return new ArrayList<KeyPathNode>(childrenMap.values());
	}

}
