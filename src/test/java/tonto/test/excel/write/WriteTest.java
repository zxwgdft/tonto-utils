package tonto.test.excel.write;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import tonto.test.excel.JDBCHelper;
import tonto.test.excel.JDBCHelper.QueryHandler;

import com.alibaba.druid.pool.DruidDataSource;
import com.tonto2.common.excel.write.DefaultExcelWriter;
import com.tonto2.common.excel.write.ExcelWriter;
import com.tonto2.common.excel.write.exception.ExcelWriteException;

public class WriteTest {
	
	@Test
	public void test() throws ExcelWriteException, FileNotFoundException, IOException, SQLException
	{
	
		String sql = "SELECT " +
							"A.TABLE_NAME," +
							"A.COLUMN_NAME," +
							"A.DATA_TYPE," +
							"A.DATA_LENGTH, " +
							"B.COMMENTS " +
						"FROM " +
							"USER_TAB_COLS A " +
						"LEFT JOIN USER_COL_COMMENTS B ON B.TABLE_NAME = A .TABLE_NAME " +
						"AND B.COLUMN_NAME = A .COLUMN_NAME " +
						"WHERE " +
						"	A.COLUMN_NAME LIKE '%MATERIAL%' " +
						"OR B.COMMENTS LIKE '%整车%物料%' " +
						"ORDER BY " +
						"	A .TABLE_NAME ";
		
		
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS=(PROTOCOL=TCP)(HOST=10.91.234.103)(PORT = 1521))(ADDRESS=(PROTOCOL=TCP)(HOST=10.91.234.104)(PORT =1521))(LOAD_BALANCE = yes)(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME=srv_pkimes)))");
		dataSource.setPassword("test");
		dataSource.setUsername("IMES_APUSR01");
		dataSource.setName("PK11G");
		dataSource.setMaxWait(10000);
		
		dataSource.init();
		
		
		List<Matrial> ms = JDBCHelper.queryList(sql, dataSource, new QueryHandler<List<Matrial>>(){

			@Override
			public List<Matrial> handle(ResultSet resultSet) throws SQLException {
				
				List<Matrial> ms = new ArrayList<>();
				
				while(resultSet.next())
				{
					String table_name = resultSet.getString("TABLE_NAME");
					String column_name = resultSet.getString("COLUMN_NAME");
					String data_type = resultSet.getString("DATA_TYPE");
					Object data_length = resultSet.getObject("DATA_LENGTH");
					String comments = resultSet.getString("COMMENTS");
					
					Matrial m = new Matrial();
					m.setColumn_name(column_name);
					m.setComments(comments);
					m.setData_length(toInteger(data_length));
					m.setData_type(data_type);
					m.setTable_name(table_name);
					
					ms.add(m);
				}
				
				return ms;
			}
			
		});
		
		
		Workbook workbook = new HSSFWorkbook();
		
		ExcelWriter<Matrial> writer= new DefaultExcelWriter<Matrial>(workbook,Matrial.class);
		writer.writeTitle();
		writer.write(ms);
		writer.output(new FileOutputStream("d:/b.xls"));
		
	}
	private static Integer toInteger(Object number) {
		if (number instanceof Number) {
			return ((Number) number).intValue();
		}

		return null;
	}
}
