package tonto.test.excel;

import java.util.ArrayList;
import java.util.List;

public class District {

	private String aid;
	
	private String id;
	private String code;
	private String name;
	private int orderNum;
	private District parent;
	private List<District> children = new ArrayList<>();

	public int getLevel() {
		int i = 1;
		if (parent != null)
			i += parent.getLevel();
		return i;
	}

	/**  
	 * id  
	 */
	public String getId() {
		return id;
	}

	/**  
	 * id  
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**  
	 * code  
	 */
	public String getCode() {
		return code;
	}

	/**  
	 * code  
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**  
	 * name  
	 */
	public String getName() {
		return name;
	}

	/**  
	 * name  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**  
	 * parent  
	 */
	public District getParent() {
		return parent;
	}

	/**  
	 * parent  
	 */
	public void setParent(District parent) {
		this.parent = parent;
	}

	/**  
	 * children  
	 */
	public List<District> getChildren() {
		return children;
	}

	/**  
	 * children  
	 */
	public void setChildren(List<District> children) {
		this.children = children;
	}

	/**  
	 * orderNum  
	 */
	public int getOrderNum() {
		return orderNum;
	}

	/**  
	 * orderNum  
	 */
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/**  
	 * aid  
	 */
	public String getAid() {
		return aid;
	}

	/**  
	 * aid  
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}
}
