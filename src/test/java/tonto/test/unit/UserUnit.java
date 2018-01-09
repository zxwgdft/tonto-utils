package tonto.test.unit;

import com.tonto2.common.excel.read.annotation.ReadProperty;

public class UserUnit {
	
	@ReadProperty(cellIndex = 0)
	private String userId;
	
	@ReadProperty(cellIndex = 1)
	private String unitId;

	/**  
	 * userId  
	 */
	public String getUserId() {
		return userId;
	}

	/**  
	 * userId  
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**  
	 * unitId  
	 */
	public String getUnitId() {
		return unitId;
	}

	/**  
	 * unitId  
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}
	
}
