package tonto.test.excel.write;

import com.tonto2.common.excel.write.annotation.WriteProperty;

public class Matrial {
	@WriteProperty(cellIndex = 1,name="表名",width=40)
	private String table_name;
	
	@WriteProperty(cellIndex = 2,name="列名",width=40)
	private String column_name;
	
	@WriteProperty(cellIndex = 3,name="类型",width=20)
	private String data_type;
	
	@WriteProperty(cellIndex = 4,name="长度",width=20)
	private Integer data_length;
	
	@WriteProperty(cellIndex = 5,name="注释",width=100)
	private String comments;

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getColumn_name() {
		return column_name;
	}

	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}

	public String getData_type() {
		return data_type;
	}

	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	public Integer getData_length() {
		return data_length;
	}

	public void setData_length(Integer data_length) {
		this.data_length = data_length;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
