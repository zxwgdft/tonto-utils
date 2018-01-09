package tonto.test.excel;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tonto2.common.excel.base.DefaultSheet;
import com.tonto2.common.excel.read.DefaultExcelReader;
import com.tonto2.common.excel.read.ExcelReader;
import com.tonto2.common.utils.uuid.UUIDUtil;

public class DistrictImport {

	public static void main(String[] args) throws Exception {
		XSSFWorkbook workbook = new XSSFWorkbook(DistrictImport.class.getResourceAsStream("A.xlsx"));
		ExcelReader<A> reader = new DefaultExcelReader<A>(A.class, new DefaultSheet(workbook.getSheetAt(0)), 1);
		List<A> as = reader.readRows();

		Map<String, District> map = new HashMap<>();
		District root = null;
		int order = 1;
		for (A a : as) {
			String aid = a.getId();

			if (map.get(aid) != null) {
				throw new Exception("有重复数据");
			}

			District d = new District();
			d.setId(UUIDUtil.createUUID().toUpperCase());
			d.setCode(a.getCode());
			d.setName(a.getName());
			d.setOrderNum(order++);
			d.setAid(aid);

			map.put(aid, d);

		}

		for (A a : as) {
			String aid = a.getId();
			String pAid = a.getParentId();

			if("ASDSAFDASFE0230".equals(aid))
			{
				System.out.println();
			}
			
			District d = map.get(aid);
			District pd = map.get(pAid);

			if (pd != null) {
				d.setParent(pd);
				pd.getChildren().add(d);
			} else {
				root = d;
			}
		}

		District kunshan = new District();
		kunshan.setId(UUIDUtil.createUUID().toUpperCase());
		kunshan.setCode("320000");
		kunshan.setName("江苏省");
		kunshan.setOrderNum(0);

		kunshan.getChildren().add(root);
		root.setParent(kunshan);

		map.put("00000", kunshan);
		StringBuilder sb = new StringBuilder();

		for (District d : map.values()) {
			sb.append("insert into ACOM_DISTRICT_CODE VALUES('").append(d.getId()).append("','").append(d.getCode())
					.append("','").append(d.getName());

			if (d.getParent() != null)
				sb.append("','").append(d.getParent().getCode()).append("',");
			else
				sb.append("',null,");

			sb.append(d.getOrderNum()).append(",'").append(d.getLevel()).append("');\n");

		}

		FileOutputStream out = new FileOutputStream("d:/district.sql");
		out.write(sb.toString().getBytes());

		StringBuilder sb2 = new StringBuilder();
		print(kunshan, sb2);
		FileOutputStream out2 = new FileOutputStream("d:/district_relation.sql");
		out2.write(sb2.toString().getBytes());

	}

	private static void print(District root, StringBuilder sb) {
		District parent = root.getParent();

		while (parent != null) {
			print(parent, root, sb);
			parent = parent.getParent();
		}

		List<District> children = root.getChildren();

		if (children.size() > 0) {
			print(root, root, sb);
			for (District child : root.getChildren())
				print(child, sb);
		}
	}

	private static void print(District parent, District child, StringBuilder sb) {

		sb.append("insert into ACOM_DISTRICT_RELATION VALUES('").append(parent.getCode()).append("','")
				.append(child.getCode()).append("','").append(child.getLevel()).append("','").append(parent.getLevel())
				.append("');\n");

	}

}
