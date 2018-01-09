package tonto.test.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestMain {

	public static void main(String[] args) throws JsonProcessingException
	{
		ObjectMapper om = new ObjectMapper();
		
		TestMain a = new TestMain();
		a.setGUID("sssss");
		
		a.setName("sfsdfds");
		
		
		
		System.out.println(om.writeValueAsString(a));
	}
	
	private String GUID;
	
	private String Name;

	/**  
	 * gUID  
	 */
	public String getGUID() {
		return GUID;
	}

	/**  
	 * gUID  
	 */
	public void setGUID(String gUID) {
		GUID = gUID;
	}

	/**  
	 * name  
	 */
	public String getName() {
		return Name;
	}

	/**  
	 * name  
	 */
	public void setName(String name) {
		Name = name;
	}
	
	
}
