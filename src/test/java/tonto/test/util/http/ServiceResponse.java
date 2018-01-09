package tonto.test.util.http;

/**
 * 
 * 统一的业务返回对象
 * 
 * @author TontZhou
 *
 * @param <T>
 */
public class ServiceResponse<T> {
	
	/**
	 * 消息体
	 */
	private T body;
	
	/**
	 * 是否成功
	 */
	private Boolean success;
	
	/**
	 * 信息
	 */
	private String message;
	
	/**
	 * 状态码
	 */
	private Integer code;	
	
	/**
	 * 头信息
	 */
	private Header header;
	
	/**
	 * 信息头
	 * @author TontZhou
	 *
	 */
	public static class Header{
		
		/**
		 * 版本号
		 */
		private String version;

		/**  
		 * 版本号  
		 */
		public String getVersion() {
			return version;
		}

		/**  
		 * 版本号  
		 */
		public void setVersion(String version) {
			this.version = version;
		}
		
	}

	/**  
	 * 消息体  
	 */
	public T getBody() {
		return body;
	}

	/**  
	 * 消息体  
	 */
	public void setBody(T body) {
		this.body = body;
	}

	/**  
	 * 是否成功  
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**  
	 * 是否成功  
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**  
	 * 信息  
	 */
	public String getMessage() {
		return message;
	}

	/**  
	 * 信息  
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**  
	 * 状态码  
	 */
	public Integer getCode() {
		return code;
	}

	/**  
	 * 状态码  
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**  
	 * 头信息  
	 */
	public Header getHeader() {
		return header;
	}

	/**  
	 * 头信息  
	 */
	public void setHeader(Header header) {
		this.header = header;
	}
	
}
