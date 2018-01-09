/**********************************************************************
 * FILE : AnjiSheetRequest.java
 * CREATE DATE : 2016-12-28
 * DESCRIPTION : 安吉单据请求对象        
 *      
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2016-12-28 |    Liu Yi    |    创建草稿版本
 *---------------------------------------------------------------------              
 ***********************************************************************/
package tonto.test.imes;


public class AnjiSheetRequest {
	
	/** 工厂 */
	private String DivisionNo;
	
	/** 请求Token */
	private String Token;
	
	/** GUID */
	private String GUID;
	
	/** msgID 用于记录生成的接口消息id */
	private String msgId;

	public String getDivisionNo() {
		return DivisionNo;
	}

	public void setDivisionNo(String divisionNo) {
		DivisionNo = divisionNo;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getGUID() {
		return GUID;
	}

	public void setGUID(String guid) {
		GUID = guid;
	}

}
