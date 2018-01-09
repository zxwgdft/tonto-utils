package tonto.test.document.webservice;


public class Response<T> {
	
	private String status;
	
	private String message;
	
	private T result;

	/**  
	 * status  
	 */
	public String getStatus() {
		return status;
	}

	/**  
	 * status  
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**  
	 * message  
	 */
	public String getMessage() {
		return message;
	}

	/**  
	 * message  
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**  
	 * result  
	 */
	public T getResult() {
		return result;
	}

	/**  
	 * result  
	 */
	public void setResult(T result) {
		this.result = result;
	}
	
}
