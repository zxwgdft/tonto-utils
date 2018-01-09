package tonto.test.document.webservice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonto2.common.utils.document.interfaces.Attribution;
import com.tonto2.common.utils.document.interfaces.DefaultAttribution;
import com.tonto2.common.utils.document.interfaces.ServiceDocument;
import com.tonto2.common.utils.document.interfaces.WebService;
import com.tonto2.common.utils.random.RandomObject;

public class WebServiceTest {
	
	
	public void VehicleMovement() throws IOException
	{
		List<Attribution> request =new ArrayList<>();
		request.add(new DefaultAttribution("sysUloc", String.class, true, "工位值，遗留字段，可为空，或与aviUloc字段相同", "S-Success"));
		request.add(new DefaultAttribution("aviUloc", String.class, true, "avi工位值", ""));
		request.add(new DefaultAttribution("nextVin", String.class, true, "下一辆车VIN码", ""));
		request.add(new DefaultAttribution("plantNo", String.class, true, "工位关联值", ""));
		request.add(new DefaultAttribution("workshopNo", String.class, true, "工位关联值", ""));
		
		WebService s = new WebService();
		s.setName("获取该工位下前一辆车");
		s.setUrl("http://host:port/imes/service/VehicleMovement/getLastVehicleByUloc");
		s.setRequestType("POST");
		s.setServiceRequestAttributions(request);
		s.setSystemRequestAttributions(new ArrayList<Attribution>());
		s.setObjectListClass(VehicleMovement.class, false);
		ServiceDocument.createServiceDocument(s, new FileWriter("d:/VehicleMovement.doc"));
		
		Response response = new Response();
		
		response.setMessage("");
		response.setStatus("S");
		response.setResult(ro.createRandomObject(VehicleMovement.class));
		
		System.out.println(om.writeValueAsString(response));
		
	}
	
	private ObjectMapper om = new ObjectMapper();
	private RandomObject ro = new RandomObject();
	
	
	public void OperateCertificate() throws IOException
	{
		List<Attribution> request =new ArrayList<>();
		request.add(new DefaultAttribution("uloc", String.class, true, "工位号", ""));
		request.add(new DefaultAttribution("vinNo", String.class, true, "辆车VIN码", ""));
		request.add(new DefaultAttribution("plantNo", String.class, true, "工厂号", ""));
		request.add(new DefaultAttribution("workshopNo", String.class, true, "车间号", ""));
		
		WebService s = new WebService();
		s.setName("查询前车未扫描的关键件类型");		
		s.setRequestType("POST");
		s.setUrl("http://host:port/imes/service/OperateCertificate/enquiryOnlineKeypartsInLastVehicle");
		s.setServiceRequestAttributions(request);
		s.setSystemRequestAttributions(new ArrayList<Attribution>());
		s.setObjectListClass(KeypartTrack.class, false);
		ServiceDocument.createServiceDocument(s, new FileWriter("d:/OperateCertificate.doc"));
		
		Response response = new Response();
		
		response.setMessage("");
		response.setStatus("S");
		response.setResult(ro.createRandomObject(KeypartTrack.class));
		
		System.out.println(om.writeValueAsString(response));
		
	}
	
		
	public void OperateCertificate2() throws IOException
	{
		List<Attribution> request =new ArrayList<>();
		request.add(new DefaultAttribution("uloc", String.class, true, "工位号", ""));
		request.add(new DefaultAttribution("vinNo", String.class, true, "辆车VIN码", ""));
		request.add(new DefaultAttribution("plantNo", String.class, true, "工厂号", ""));
		request.add(new DefaultAttribution("workshopNo", String.class, true, "车间号", ""));
		
		WebService s = new WebService();
		s.setName("获取车辆已经扫描的关键件");		
		s.setRequestType("POST");
		s.setUrl("http://host:port/imes/service/OperateCertificate/findOfflineTracksOfMG");
		s.setServiceRequestAttributions(request);
		s.setSystemRequestAttributions(new ArrayList<Attribution>());
		s.setObjectListClass(KeypartTrack.class, false);
		ServiceDocument.createServiceDocument(s, new FileWriter("d:/OperateCertificate2.doc"));
		
		Response response = new Response();
		
		response.setMessage("");
		response.setStatus("S");
		response.setResult(ro.createRandomObject(KeypartTrack.class));
		
		System.out.println(om.writeValueAsString(response));
		
	}
		
	
	public void OperateCertificate3() throws IOException
	{
		List<Attribution> request =new ArrayList<>();
		request.add(new DefaultAttribution("uloc", String.class, true, "工位号", ""));
		//request.add(new DefaultAttribution("vinNo", String.class, true, "辆车VIN码", ""));
		request.add(new DefaultAttribution("plantNo", String.class, true, "工厂号", ""));
		request.add(new DefaultAttribution("workshopNo", String.class, true, "车间号", ""));
		
		WebService s = new WebService();
		s.setName("追溯关键件");		
		s.setRequestType("POST");
		s.setUrl("http://host:port/imes/service/OperateCertificate/trackKeyparts");
		s.setServiceRequestAttributions(request);
		s.setSystemRequestAttributions(new ArrayList<Attribution>());
		s.setObjectListClass(KeypartTrack.class, false);
		ServiceDocument.createServiceDocument(s, new FileWriter("d:/OperateCertificate3.doc"));
		
		Response response = new Response();
		
		response.setMessage("");
		response.setStatus("S");
		response.setResult(ro.createRandomObject(KeypartTrack.class));
		
		System.out.println(om.writeValueAsString(response));
		
	}
	
	
	public void OperateCertificate4() throws IOException
	{
		List<Attribution> request =new ArrayList<>();
		request.add(new DefaultAttribution("uloc", String.class, true, "工位号", ""));
		request.add(new DefaultAttribution("vinNo", String.class, true, "辆车VIN码", ""));
		request.add(new DefaultAttribution("plantNo", String.class, true, "工厂号", ""));
		request.add(new DefaultAttribution("workshopNo", String.class, true, "车间号", ""));
		
		WebService s = new WebService();
		s.setName("获取车辆未扫描的关键件");		
		s.setRequestType("POST");
		s.setUrl("http://host:port/imes/service/OperateCertificate/findOnlineKeyparts");
		s.setServiceRequestAttributions(request);
		s.setSystemRequestAttributions(new ArrayList<Attribution>());
		s.setObjectListClass(KeypartTrack.class, false);
		ServiceDocument.createServiceDocument(s, new FileWriter("d:/OperateCertificate4.doc"));
		
		Response response = new Response();
		
		response.setMessage("");
		response.setStatus("S");
		response.setResult(ro.createRandomObject(KeypartTrack.class));
		
		System.out.println(om.writeValueAsString(response));
		
	}
	
	@Test
	public void OperateCertificate5() throws IOException
	{
		
		Map<String,KeypartTrack> rs = new HashMap<>();
		
		rs.put("offlineTracks", ro.createRandomObject(KeypartTrack.class));
		rs.put("historyTracks", ro.createRandomObject(KeypartTrack.class));
		rs.put("onllineTracks", ro.createRandomObject(KeypartTrack.class));
		
		Response response = new Response();
		
		response.setMessage("");
		response.setStatus("S");
		response.setResult(rs);
		
		System.out.println(om.writeValueAsString(response));
		
	}
	
	
}
