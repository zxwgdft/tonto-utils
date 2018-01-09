package tonto.test.excel.read;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tonto2.common.excel.base.DefaultSheet;
import com.tonto2.common.excel.base.ISheet;
import com.tonto2.common.excel.read.DefaultReadColumn;
import com.tonto2.common.excel.read.ExcelReader;
import com.tonto2.common.excel.read.ReadColumn;
import com.tonto2.common.utils.StringParser;

public class KeyValueTest {

	public static void main(String[] args) throws Exception {

		Constant a = new Constant("PRODUCING_NATIONALITY",13,247 - 13,7,8);
		a.write(new FileOutputStream("D:/PRODUCING_NATIONALITY.sql"));
		

		System.out.println("completed");
	}

	public static class Constant {

		private String codekind;

		private int startRow;

		private int rowCount;

		private int codeIndex;

		private int valueIndex;

		public Constant(String kind, int start, int count, int codeIndex, int valueIndex) {
			this.codekind = kind;
			this.startRow = start;
			this.rowCount = count;
			this.codeIndex = codeIndex;
			this.valueIndex = valueIndex;
		}

		public List<KV> readKV() throws Exception {

			XSSFWorkbook workbook = new XSSFWorkbook(ExcelReaderTest.class.getResourceAsStream("C.xlsx"));
			
			DefaultReadColumn codeColumn = new DefaultReadColumn();
			DefaultReadColumn valueColumn = new DefaultReadColumn();

			codeColumn.setId("code");
			codeColumn.setType(String.class);
			codeColumn.setCellIndex(codeIndex);
			
			valueColumn.setId("name");
			valueColumn.setType(String.class);
			valueColumn.setCellIndex(valueIndex);
			
			
			List<ReadColumn> cols = new ArrayList<>();
			cols.add(codeColumn);
			cols.add(valueColumn);
			
			MyReader reader = new MyReader( new DefaultSheet( workbook.getSheetAt(1)),startRow,cols);
			
			
			
			List<KV> kvs = new ArrayList<>(rowCount);

			for (int i = rowCount; i > 0; i--)
				kvs.add(reader.readRow());
			return kvs;
		}

		
		public void write(OutputStream output) throws Exception
		{
			List<KV> kvs = readKV();
			
			StringBuilder sb = new StringBuilder();
			
			for(KV kv:kvs)
			{
				sb.append("INSERT INTO ACOM_SYSCODE (\"CODEKIND\", \"CODEKIND_DESCRIPTION\", \"CODEVALUE\", \"CODENAME\",  \"STATUS\", \"SYSCODE_PID\", \"CODEKIND_TYPE\") VALUES(")
					.append(StringParser.parseSqlParam(codekind)).append(",")
					.append(StringParser.parseSqlParam(kv.name)).append(",")
					.append(StringParser.parseSqlParam(kv.code)).append(",")
					.append(StringParser.parseSqlParam(kv.name)).append(",")
					.append("'0'").append(",")
					.append(StringParser.parseSqlParam(codekind+"_"+kv.code)).append(",")
					.append("'0');\n");					
				
			}			
			
			
			output.write(sb.toString().getBytes());
			
		}
	}
	
	public static class MyReader extends ExcelReader<KV>{
		
		public MyReader(ISheet sheet, int startRow , List<ReadColumn> columns) {		
			super(KV.class, sheet, startRow);		
			this.columns = columns;		
		}
		
	}
	
	

	public static class KV {
		
		private String code;

		private String name;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
