package tonto.test.unit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tonto2.common.excel.base.DefaultSheet;
import com.tonto2.common.excel.read.DefaultExcelReader;
import com.tonto2.common.excel.read.ExcelReader;
import com.tonto2.common.excel.read.exception.ExcelReadException;

public class MainAA {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		List<Unit> us = getUnit();
		List<UserUnit> uus = getUserUnit();

		Map<String, Unit> unitMap = new HashMap<>();

		Unit father = new Unit();
		father.setUnitId("402881ea22aa56870122aa6defaf000d");
		father.setUnitName("昆山数字卫生");

		us.add(father);

		for (Unit u : us) {
			unitMap.put(u.getUnitId(), u);
		}

		for (Unit u : us) {

			String pid = u.getParentUnitId();
			Unit parent = unitMap.get(pid);
			if (parent != null) {
				u.setParent(parent);
				parent.getChildren().add(u);
			}

		}
		
		StringBuilder roleUserBuilder = new StringBuilder();
		

		for (UserUnit uu : uus) {
			String unitId = uu.getUnitId();
			String userId = uu.getUserId();

			Unit u = unitMap.get(unitId);
			if (u != null) {
				u.getUsers().add(uu);
			} else {

				System.out.println(userId + "找不到单位：" + unitId);
				continue;
			}
			
			int level = u.getLevel();
			
			String roleId = "";
			
			switch(level){
			case 1:roleId = "402808b33fc23e1c013fc250f5f301b2";break;
			case 2:roleId = "402808b33fc23e1c013fc2513f3701b3";break;
			case 3:roleId = "402808b33fc23e1c013fc250f5f301b2";break;
				default:{
					roleId = "402808b33fc23e1c013fc250f5f301b2";
				}
			}
			
			roleUserBuilder.append("INSERT INTO UP_ORG_USER_BUSIROLE VALUES('"+roleId+"','")
				.append(userId).append("');\n");
		}
		
		
		
		
		
		FileOutputStream out2 = new FileOutputStream("d:/user_role.sql");
		out2.write(roleUserBuilder.toString().getBytes());
		

		StringBuilder sb = new StringBuilder();

		printUnit(father, sb);
		printUnitExt(father, sb);
		printDimension(father, sb);

		printUserExt(father, sb);
		
		FileOutputStream out = new FileOutputStream("d:/unit.sql");
		out.write(sb.toString().getBytes());

	}

	public static List<Unit> getUnit() throws ExcelReadException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(MainAA.class.getResourceAsStream("UP_ORG_DIMENSION_UNIT.xlsx"));
		ExcelReader<Unit> reader = new DefaultExcelReader<Unit>(Unit.class, new DefaultSheet(workbook.getSheetAt(0)), 0);
		return reader.readRows();

	}

	public static List<UserUnit> getUserUnit() throws ExcelReadException, IOException {
		XSSFWorkbook workbook = new XSSFWorkbook(MainAA.class.getResourceAsStream("UP_ORG_USER_UNIT.xlsx"));
		ExcelReader<UserUnit> reader = new DefaultExcelReader<UserUnit>(UserUnit.class, new DefaultSheet(
				workbook.getSheetAt(0)), 0);
		return reader.readRows();

	}

	public static void printUnit(Unit u, StringBuilder sb) {

		if (u.getParentUnitId() != null)
			sb.append("INSERT INTO UP_ORG_UNIT VALUES ('").append(u.getUnitId()).append("','").append(u.getUnitName())
					.append("',null,'").append(u.getParentUnitId()).append("','").append(u.getUnitType())
					.append("');\n");
		else
			sb.append("INSERT INTO UP_ORG_UNIT VALUES ('").append(u.getUnitId()).append("','").append(u.getUnitName())
					.append("',null,null,'").append(u.getUnitType()).append("');\n");

		for (Unit us : u.getChildren())
			printUnit(us, sb);
	}

	public static void printUnitExt(Unit u, StringBuilder sb) {

		sb.append("INSERT INTO UP_ORG_UNIT_EXT(UNIT_ID) VALUES ('").append(u.getUnitId()).append("');\n");

		for (Unit us : u.getChildren())
			printUnitExt(us, sb);
	}

	public static void printDimension(Unit u, StringBuilder sb) {

		if (u.getParentUnitId() != null)
			sb.append("INSERT INTO UP_ORG_DIMENSION_UNIT VALUES ('").append(u.getUnitId())
					.append("','defaultDimension','").append(u.getParentUnitId()).append("','").append(u.getUnitName())
					.append("',null);\n");
		else
			sb.append("INSERT INTO UP_ORG_DIMENSION_UNIT VALUES ('").append(u.getUnitId())
					.append("','defaultDimension',null,'").append(u.getUnitName()).append("',null);\n");

		for (Unit us : u.getChildren())
			printDimension(us, sb);
	}

	public static void printUserExt(Unit u, StringBuilder sb) {

		List<UserUnit> uus = u.getUsers();

		String USER_OFFICE_ID = u.getUnitId();
		String USER_UNIT_ID = u.getParent() != null ? u.getParent().getUnitId() : USER_OFFICE_ID;
		String MANAGE_RANGE_TYPE = "0";
		String MANAGE_RANGE_CODE = USER_OFFICE_ID;
		String MANAGE_RANGE_GRADE = u.getChildren().size() == 0 ? "3" : "2";

		if (u.getParent() == null)
			MANAGE_RANGE_GRADE = "1";

		for (UserUnit uu : uus) {
			sb.append(
					"INSERT INTO UP_ORG_USER_EXT(" + "USER_ID," + "USER_UNIT_ID," + "USER_OFFICE_ID,"
							+ "MANAGE_RANGE_TYPE," + "MANAGE_RANGE_CODE," + "MANAGE_RANGE_GRADE)" + " VALUES ('")
					.append(uu.getUserId()).append("','").append(USER_UNIT_ID).append("','").append(USER_OFFICE_ID)
					.append("','").append(MANAGE_RANGE_TYPE).append("','").append(MANAGE_RANGE_CODE).append("','")
					.append(MANAGE_RANGE_GRADE).append("');\n");

		}

		for (Unit us : u.getChildren())
			printUserExt(us, sb);
	}
}
