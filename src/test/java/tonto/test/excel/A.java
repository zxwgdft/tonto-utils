package tonto.test.excel;

import com.tonto2.common.excel.read.annotation.ReadProperty;

public class A {
	
	@ReadProperty(cellIndex = 0)
	private String id;
	@ReadProperty(cellIndex = 1)
	private String code;
	@ReadProperty(cellIndex = 2)
	private String name;
	@ReadProperty(cellIndex = 3)
	private String parentId;
	
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
	 * parentId  
	 */
	public String getParentId() {
		return parentId;
	}
	/**  
	 * parentId  
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
}
