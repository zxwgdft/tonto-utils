package tonto.test.unit;

import java.util.ArrayList;
import java.util.List;

import com.tonto2.common.excel.read.annotation.ReadProperty;

public class Unit {

	@ReadProperty(cellIndex = 0)
	private String unitId;

	@ReadProperty(cellIndex = 03)
	private String unitName;

	private String unitDescriptioin;

	@ReadProperty(cellIndex = 2)
	private String parentUnitId;

	private Unit parent;

	private List<Unit> children = new ArrayList<>();

	private List<UserUnit> users = new ArrayList<>();
	
	public int getLevel()
	{
		int l = 1;
		if(parent !=null)
			l += parent.getLevel();
		return l;
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

	/**
	 * unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * unitName
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * unitDescriptioin
	 */
	public String getUnitDescriptioin() {
		return unitDescriptioin;
	}

	/**
	 * unitDescriptioin
	 */
	public void setUnitDescriptioin(String unitDescriptioin) {
		this.unitDescriptioin = unitDescriptioin;
	}

	/**
	 * parentUnitId
	 */
	public String getParentUnitId() {
		return parentUnitId;
	}

	/**
	 * parentUnitId
	 */
	public void setParentUnitId(String parentUnitId) {
		this.parentUnitId = parentUnitId;
	}

	/**
	 * unitType
	 */
	public String getUnitType() {

		if (children.size() > 0) {
			if (unitName != null) {			 
				if (unitName.contains("昆山经济技术开发区蓬朗社区卫生服务中心"))
					return "A";
				if (unitName.contains("血"))
					return "F";
				if (unitName.contains("预防保健") || unitName.contains("服务中心"))
					return "B";
				if (unitName.contains("保健"))
					return "G";
				if (unitName.contains("医院"))
					return "A";
				if (unitName.contains("急救"))
					return "E";
				if (unitName.contains("卫生局") || unitName.contains("促进中心"))
					return "Z";
				if (unitName.contains("疾病"))
					return "J";
				if (unitName.contains("监督"))
					return "K";
			}
			return "Z";
		} else
			return parent != null ? parent.getUnitType() : "AA";
	}

	/**
	 * parent
	 */
	public Unit getParent() {
		return parent;
	}

	/**
	 * parent
	 */
	public void setParent(Unit parent) {
		this.parent = parent;
	}

	/**
	 * children
	 */
	public List<Unit> getChildren() {
		return children;
	}

	/**
	 * children
	 */
	public void setChildren(List<Unit> children) {
		this.children = children;
	}

	/**  
	 * users  
	 */
	public List<UserUnit> getUsers() {
		return users;
	}

	/**  
	 * users  
	 */
	public void setUsers(List<UserUnit> users) {
		this.users = users;
	}
	
}
