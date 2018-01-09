package tonto.test.util.http;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonto2.common.im.IMConstants;
import com.tonto2.common.utils.http.HttpClientManager;
import com.tonto2.common.utils.random.RandomObject;

public class HttpClientTest {


	public void sendHttpRequest() throws Exception {

		HttpPost post = new HttpPost(new URI("http://localhost:8080/IMESSubService/pkmes/service/VehicleCtrl/scan"));
		post.addHeader("Content-Type", "application/json");
		ObjectMapper objectMapper = new ObjectMapper();

		//String bodyJson = "{\"body\":[{\"scanType\":\"0\",\"tps\":\"D0963293\",\"mesScanNo\":\"GA11C1010\",\"scanTime\":\"2017-03-09 14:48:33\",\"plantNo\":\"5200\",\"workShopNo\":\"GA1\",\"aviScanNo\":\"GA11C1010\",\"flag\":null}],\"success\":true,\"message\":\"业务处理成功\",\"head\":{\"version\":\"20170309144833008860000005\"},\"_TK\":null,\"code\":200}";
		
		ServiceResponse response = new RandomObject().createRandomObject(ServiceResponse.class);
		
		DefScan[] ss = new RandomObject().createRandomObject(DefScan[].class);
		
		response.setBody(ss);
		
		String bodyJson = objectMapper
				.writeValueAsString(response);

		System.out.println(bodyJson);
		
		post.setEntity(new StringEntity(bodyJson, IMConstants.TEXT_PLAIN));

		HttpClientManager.sendHttpRequest(post);

	}

	public String sendHttpToken2DEF() throws Exception{
		
		String bodyJson = "{\"account\":\"imes\", \"password\":\"123456\"}";
		HttpPost post = new HttpPost(new URI("http://10.91.233.222:8000/DEFService/accessToken.jhtml"));
		post.setEntity(new StringEntity(bodyJson, IMConstants.TEXT_PLAIN));
		post.setHeader("x-requested-with", "XMLHttpRequest");
		
		CloseableHttpResponse response = HttpClientManager.sendHttpRequest(post);
		
		String result = EntityUtils.toString(response.getEntity(), IMConstants.TEXT_PLAIN.getCharset());
		
		System.out.println(result);
		//HttpPost post = new HttpPost(new URI("http://10.91.233.222:8000/DEFService/inbound/materialPullData/put.jhtml"));
		ObjectMapper objectMapper = new ObjectMapper();
		return (String) objectMapper.readValue(result, Map.class).get("_TK");
	}
	
	
	@Test
	public void sendHttp2DEF() throws Exception{
		
		String token = sendHttpToken2DEF();
		String version = "2017082411244300000000";
		String andonNo = "88889000";
		String base = "{\"head\":{\"version\":\"2017082411244300000000\"},\"body\":[{\"plant_no\":\"A100\",\"workshop_no\":\"GA1\",\"andon_no\":\"88888900\",\"andon_card_no\":\"ANKH06\",\"part_no\":\"10006618-ESA\",\"part_name_c\":\"PANEL ASM-BODY L/PLR UPR TR\",\"pull_qty\":\"10.0\",\"dpath_no\":\"KBFN11\",\"uloc_no\":\"CH-10L\",\"darea_no\":\"FN11\",\"warehouse_no\":\"1003\",\"dloc_no\":\"1003LS\",\"loc_no\":\"NOTUSE\",\"part_type\":\"1\",\"plan_linearrive_time\":0,\"delivery_rep_time\":0,\"change_flag\":\"1\"}]}";
		
		
		
		for(int i=0;i<10;i++)
		{
			String is = String.valueOf(i);
			int l = is.length();
			
			String vn = version.substring(0, version.length() - l) + is;
			String an = andonNo.substring(0, andonNo.length() - l) + is;
			
			
			
			base = base.replace(version, vn);
			base = base.replace(andonNo, an);
			
			version = vn;
			andonNo = an;
			
			HttpPost post = new HttpPost(new URI("http://10.91.233.222:8000/DEFService/inbound/materialPullData/put.jhtml"));
			post.setEntity(new StringEntity(base, IMConstants.TEXT_PLAIN));
			post.setHeader("x-requested-with", "XMLHttpRequest");
			post.setHeader("_TK", token); // 设置token		
			CloseableHttpResponse response = HttpClientManager.sendHttpRequest(post);		
			String result = EntityUtils.toString(response.getEntity(), IMConstants.TEXT_PLAIN.getCharset());
			System.out.println(result);
			
			Thread.sleep(1000);
			//HttpPost post = new HttpPost(new URI("http://10.91.233.222:8000/DEFService/inbound/materialPullData/put.jhtml"));
		}
	}
}
