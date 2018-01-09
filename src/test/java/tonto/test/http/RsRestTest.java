package tonto.test.http;

import java.io.IOException;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import com.tonto2.common.im.IMConstants;
import com.tonto2.common.im.IMServletContainer;
import com.tonto2.common.utils.http.HttpClientManager;

public class RsRestTest {
	
	public static void main(String[] args) throws IOException{
	

		
		
		HttpPost post=new HttpPost("http://10.90.87.49:8080/imes/service/pushDDSheet/push");
		post.setEntity(new InputStreamEntity(RsRestTest.class.getResourceAsStream("a.txt"),IMConstants.TEXT_PLAIN));
		
		
		CloseableHttpResponse response = HttpClientManager.sendHttpRequest(post);
		
		String result = EntityUtils.toString(response.getEntity(), Consts.UTF_8);
		
		System.out.println(result);
		
	}
	
}
