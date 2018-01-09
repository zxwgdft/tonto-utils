package tonto.test.excel.read;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.tonto2.common.excel.base.DefaultSheet;
import com.tonto2.common.excel.read.DefaultExcelReader;
import com.tonto2.common.excel.read.ExcelReader;
import com.tonto2.common.excel.read.annotation.ReadProperty;
import com.tonto2.common.template.ObjectMessageTemplate;

public class EquipmentTest {

	
	public void alterTable() throws Exception {
		
		List<Equipment> equipments = getEquipmentType();
		
		StringBuilder sb = new StringBuilder();

		for (Equipment equipment : equipments) {
			sb.append("alter table HS_EQM_INFO ADD " + equipment.name + " " + equipment.type + " NULL;\n");
		}
		for (Equipment equipment : equipments) {
			sb.append("COMMENT ON COLUMN \"HS_EQM_INFO\".\"" + equipment.name + "\" IS '" + equipment.comment + "';\n");
		}

		new FileOutputStream("d:/equipment.sql").write(sb.toString().getBytes());
		
		System.out.println("completed");

	}
	
	
	
	@Test
	public void createJspForm() throws Exception {
		
		ObjectMessageTemplate jspTemplate = new ObjectMessageTemplate(EquipmentTest.class.getResourceAsStream("templateA.txt"),'$');
		
		List<Equipment> equipments = getEquipmentType();
		
		StringBuilder sb = new StringBuilder();

		for (Equipment equipment : equipments) {
			sb.append(jspTemplate.createMessage(equipment)).append("\n");
		}
		
		new FileOutputStream("d:/equipment_jsp.html").write(sb.toString().getBytes());
		
		System.out.println("completed");
	}
	
	
	
	private List<Equipment> getEquipmentType() throws Exception {
		
		XSSFWorkbook workbook = new XSSFWorkbook(EquipmentTest.class.getResourceAsStream("C.xlsx"));
		ExcelReader<Equipment> reader = new DefaultExcelReader<Equipment>(Equipment.class, new DefaultSheet(
				workbook.getSheetAt(2)), 3);

		return reader.readRows();
		
	}
	

	public static class Equipment {

		@ReadProperty(cellIndex = 5)
		String name;

		@ReadProperty(cellIndex = 6)
		String type;

		String defaultValue;

		@ReadProperty(cellIndex = 3)
		String comment;

		/**
		 * name
		 */
		public String getName() {
			return name.toLowerCase();
		}

		/**
		 * name
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * type
		 */
		public String getType() {
			return type;
		}

		/**
		 * type
		 */
		public void setType(String type) {
			this.type = type;
		}

		/**
		 * defaultValue
		 */
		public String getDefaultValue() {
			return defaultValue;
		}

		/**
		 * defaultValue
		 */
		public void setDefaultValue(String defaultValue) {
			this.defaultValue = defaultValue;
		}

		/**
		 * comment
		 */
		public String getComment() {
			return comment;
		}

		/**
		 * comment
		 */
		public void setComment(String comment) {
			this.comment = comment;
		}

	}

}
