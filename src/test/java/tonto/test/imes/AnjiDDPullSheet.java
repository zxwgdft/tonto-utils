package tonto.test.imes;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonto2.common.utils.random.RandomObject;

public class AnjiDDPullSheet {
	
	private String SheetNo;
	
	private String PublishTime;
	
	private String ExpectTime;
	
	private String DivisionNo;
	
	private String FacilityNo;
	
	private String Path;
	
	private String DockNo;
	
	private String SheetType;
	
	private String Status;
	
	private String Version;
	
	private String SupplierNo;
	
	private String ModifiedTime;
	
	private List<AnjiDDPullSheetItem> Items;

	public String getDivisionNo() {
		return DivisionNo;
	}

	public void setDivisionNo(String divisionNo) {
		DivisionNo = divisionNo;
	}

	public String getDockNo() {
		return DockNo;
	}

	public void setDockNo(String dockNo) {
		DockNo = dockNo;
	}

	public String getExpectTime() {
		return ExpectTime;
	}

	public void setExpectTime(String expectTime) {
		ExpectTime = expectTime;
	}

	public String getFacilityNo() {
		return FacilityNo;
	}

	public void setFacilityNo(String facilityNo) {
		FacilityNo = facilityNo;
	}

	public List<AnjiDDPullSheetItem> getItems() {
		return Items;
	}

	public void setItems(List<AnjiDDPullSheetItem> items) {
		Items = items;
	}

	public String getModifiedTime() {
		return ModifiedTime;
	}

	public void setModifiedTime(String modifiedTime) {
		ModifiedTime = modifiedTime;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}

	public String getPublishTime() {
		return PublishTime;
	}

	public void setPublishTime(String publishTime) {
		PublishTime = publishTime;
	}

	public String getSheetNo() {
		return SheetNo;
	}

	public void setSheetNo(String sheetNo) {
		SheetNo = sheetNo;
	}

	public String getSheetType() {
		return SheetType;
	}

	public void setSheetType(String sheetType) {
		SheetType = sheetType;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getSupplierNo() {
		return SupplierNo;
	}

	public void setSupplierNo(String supplierNo) {
		SupplierNo = supplierNo;
	}

	public String getVersion() {
		return Version;
	}

	public void setVersion(String version) {
		Version = version;
	}
	
	
	public static void  main(String[] args) throws JsonProcessingException
	{
		RandomObject ro = new RandomObject();
		AnjiDDPullSheetRequest request = ro.createRandomObject(AnjiDDPullSheetRequest.class);
		String json = new ObjectMapper().writeValueAsString(request);
		System.out.println(json);
	}
	
}
