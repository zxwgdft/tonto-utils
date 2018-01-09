/**********************************************************************
 * FILE : KeypartTrack.java
 * CREATE DATE : 2008-06-20
 * DESCRIPTION :
 *		
 *		
 *		
 *      
 * CHANGE HISTORY LOG
 *---------------------------------------------------------------------
 * NO.|    DATE    |     NAME     |     REASON     | DESCRIPTION
 *---------------------------------------------------------------------
 * 1  | 2009-01-05 |  wxh         |    创建草稿版本
 *---------------------------------------------------------------------
 * 2  | 2009-01-05 |  chenjl      |    添加tracktype、startseq、endseq、plantName、plantId、materialNo、maptype、qibLength、isEnginNo、scanType属性
 * 3  | 2010-11-23 |  zhiyang     |    添加workshopNo属性
 * 4  | 2011-05-23 |  fangxu      |    添加hasEnginNo属性
 * 5  | 2011-07-21 |  fangxu      |    添加engStart/engEnd属性
 * 6  | 2012-08-03 |  fangxu      |    添加isTox/isIccidSim属性
 *---------------------------------------------------------------------              
 **********************************************************************
 */
package tonto.test.document.webservice;

import java.io.Serializable;

public class KeypartTrack implements Serializable {

	private Long id;

	/** 关键件追溯ID */
	private long keypartTrackId;

	/** 车辆ID */
	private long vehicleId;

	/** 关键件类型ID */
	private long keypartTypeId;

	/** 关键件条码 */
	private String keypartNo;
	
	private String keypartTypeNo;
	
	private String keypartName;

	/** 扫描人员 */
	private String scanUserName;

	/** 扫描时间 */
	private String scanTime;

	/** 扫描工位ID */
	private long scanULocId;

	private String ulocNo;

	private String ulocName;

	private String familyCode;

	private String tps;

	private String csn;

	private String vinNo;

	/** 上次更改时间 */
	private String lastUpdateTime;

	/** 更改用户 */
	private String lastUpdateUserName;

	/** 归档计数 */
	private long pid;

	/** 归档记录是否可删除 */
	private int pidIsClosed;
	
	/** */
	private Integer markStatus;
	
	/** 是否企标 */
	private Integer markForQib;
	
	/** 零件长度 */
	private Integer verifyNum;
	
	/** 关键件类型(Feature Code类型和零件类型追溯) **/
	private String tracktype;
	
	/** 按零件类型追溯(需要有起始位置和结束位置) **/
	private Integer startseq;
	private Integer endseq;
	
	/** 工厂 **/
	private String plantName;
	
	/** 工厂ID **/
	private Long plantId;
	
	/** 整车物料号 **/
	private String materialNo;
	
	/** 防误方式 **/
	private String maptype;
	
	/**  
	* 企标截取长度
	*/
	private Integer qibLength;
	
	/** 是否为发动机 */
	private Integer isEnginNo;
	
	/** 扫描方式（0：随线扫描  1：下线扫描） **/
	private Integer scanType;

	/** 车间 **/
	private String workshopNo;
	
	/** 是否包含发动机型号 */
	private Integer hasEnginNo;
	
	/** 发动机号保存(起始位置和结束位置) **/
	private Integer engStart;
	private Integer engEnd;
	
	private Boolean isTbox;
	private Boolean isIccidSim;
	
	private Boolean isAvn;
	
	private Boolean isBatteryGroup;
	
	private String vpps;
	private String partNo;
	private String supplierNo;
	private String orignalLabel;
	
	//add by panxiaoxin 零件号码截取长度
	private Integer partNoCutLength;
	
	public String getWorkshopNo() {
		return workshopNo;
	}

	public void setWorkshopNo(String workshopNo) {
		this.workshopNo = workshopNo;
	}
	
	public Integer getScanType() {
		return scanType;
	}

	public void setScanType(Integer scanType) {
		this.scanType = scanType;
	}

	public Integer getIsEnginNo() {
		return isEnginNo;
	}

	public void setIsEnginNo(Integer isEnginNo) {
		this.isEnginNo = isEnginNo;
	}

	public Integer getQibLength() {
		return qibLength;
	}

	public void setQibLength(Integer qibLength) {
		this.qibLength = qibLength;
	}

	public Long getPlantId() {
		return plantId;
	}

	public void setPlantId(Long plantId) {
		this.plantId = plantId;
	}

	public String getMaptype() {
		return maptype;
	}

	public void setMaptype(String maptype) {
		this.maptype = maptype;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public Integer getEndseq() {
		return endseq;
	}

	public void setEndseq(Integer endseq) {
		this.endseq = endseq;
	}

	public Integer getStartseq() {
		return startseq;
	}

	public void setStartseq(Integer startseq) {
		this.startseq = startseq;
	}

	public String getTracktype() {
		return tracktype;
	}

	public void setTracktype(String tracktype) {
		this.tracktype = tracktype;
	}

	/**
	 * 返回关键件追溯ID值
	 * 
	 * @return long 关键件追溯ID
	 */
	public long getKeypartTrackId() {
		return this.keypartTrackId;
	}

	/**
	 * 设置关键件追溯ID值
	 * 
	 * @param keypartTrackId
	 *            关键件追溯ID
	 */
	public void setKeypartTrackId(long keypartTrackId) {
		this.keypartTrackId = keypartTrackId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回车辆ID 值
	 * 
	 * @return long 车辆ID
	 */
	public long getVehicleId() {
		return this.vehicleId;
	}

	/**
	 * 设置车辆ID 值
	 * 
	 * @param vehicleId
	 *            车辆ID
	 */
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	

	public String getKeypartTypeNo() {
		return keypartTypeNo;
	}

	public void setKeypartTypeNo(String keypartTypeNo) {
		this.keypartTypeNo = keypartTypeNo;
	}

	/**
	 * 返回关键件类型ID 值
	 * 
	 * @return long 关键件类型ID
	 */
	public long getKeypartTypeId() {
		return this.keypartTypeId;
	}

	/**
	 * 设置关键件类型ID 值
	 * 
	 * @param keypartTypeId
	 *            关键件类型ID
	 */
	public void setKeypartTypeId(long keypartTypeId) {
		this.keypartTypeId = keypartTypeId;
	}

	/**
	 * 返回关键件条码 值
	 * 
	 * @return String 关键件条码
	 */
	public String getKeypartNo() {
		return this.keypartNo;
	}

	/**
	 * 设置关键件条码 值
	 * 
	 * @param keypartNo
	 *            关键件条码
	 */
	public void setKeypartNo(String keypartNo) {
		this.keypartNo = keypartNo;
	}

	/**
	 * 返回扫描人员 值
	 * 
	 * @return String 扫描人员
	 */
	public String getScanUserName() {
		return this.scanUserName;
	}

	/**
	 * 设置扫描人员 值
	 * 
	 * @param scanUserName
	 *            扫描人员
	 */
	public void setScanUserName(String scanUserName) {
		this.scanUserName = scanUserName;
	}

	/**
	 * 返回扫描时间值
	 * 
	 * @return String 扫描时间
	 */
	public String getScanTime() {
		return this.scanTime;
	}

	/**
	 * 设置扫描时间值
	 * 
	 * @param scanTime
	 *            扫描时间
	 */
	public void setScanTime(String scanTime) {
		this.scanTime = scanTime;
	}

	/**
	 * 返回扫描工位ID值
	 * 
	 * @return long 扫描工位ID
	 */
	public long getScanULocId() {
		return this.scanULocId;
	}

	/**
	 * 设置扫描工位ID值
	 * 
	 * @param scanULocId
	 *            扫描工位ID
	 */
	public void setScanULocId(long scanULocId) {
		this.scanULocId = scanULocId;
	}

	/**
	 * 返回上次更改时间值
	 * 
	 * @return String 上次更改时间
	 */
	public String getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	/**
	 * 设置上次更改时间值
	 * 
	 * @param lastUpdateTime
	 *            上次更改时间
	 */
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * 返回更改用户 值
	 * 
	 * @return String 更改用户
	 */
	public String getLastUpdateUserName() {
		return this.lastUpdateUserName;
	}

	/**
	 * 设置更改用户 值
	 * 
	 * @param lastUpdateUserName
	 *            更改用户
	 */
	public void setLastUpdateUserName(String lastUpdateUserName) {
		this.lastUpdateUserName = lastUpdateUserName;
	}

	/**
	 * 返回归档计数 值
	 * 
	 * @return long 归档计数
	 */
	public long getPid() {
		return this.pid;
	}

	/**
	 * 设置归档计数 值
	 * 
	 * @param pid
	 *            归档计数
	 */
	public void setPid(long pid) {
		this.pid = pid;
	}

	/**
	 * 返回归档记录是否可删除 值
	 * 
	 * @return int 归档记录是否可删除
	 */
	public int getPidIsClosed() {
		return this.pidIsClosed;
	}

	/**
	 * 设置归档记录是否可删除 值
	 * 
	 * @param pidIsClosed
	 *            归档记录是否可删除
	 */
	public void setPidIsClosed(int pidIsClosed) {
		this.pidIsClosed = pidIsClosed;
	}

	public String getCsn() {
		return csn;
	}

	public void setCsn(String csn) {
		this.csn = csn;
	}

	public String getFamilyCode() {
		return familyCode;
	}

	public void setFamilyCode(String familyCode) {
		this.familyCode = familyCode;
	}

	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}

	public String getUlocName() {
		return ulocName;
	}

	public void setUlocName(String ulocName) {
		this.ulocName = ulocName;
	}

	public String getUlocNo() {
		return ulocNo;
	}

	public void setUlocNo(String ulocNo) {
		this.ulocNo = ulocNo;
	}

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getKeypartName() {
		return keypartName;
	}

	public void setKeypartName(String keypartName) {
		this.keypartName = keypartName;
	}

	public Integer getMarkStatus() {
		return markStatus;
	}

	public void setMarkStatus(Integer markStatus) {
		this.markStatus = markStatus;
	}

	/**
	 * @return the markForQib
	 */
	public Integer getMarkForQib() {
		return markForQib;
	}

	/**
	 * @param markForQib the markForQib to set
	 */
	public void setMarkForQib(Integer markForQib) {
		this.markForQib = markForQib;
	}

	/**
	 * @return the verifyNum
	 */
	public Integer getVerifyNum() {
		return verifyNum;
	}

	/**
	 * @param verifyNum the verifyNum to set
	 */
	public void setVerifyNum(Integer verifyNum) {
		this.verifyNum = verifyNum;
	}

	/**
	 * @return the hasEnginNo
	 */
	public Integer getHasEnginNo() {
		return hasEnginNo;
	}

	/**
	 * @param hasEnginNo the hasEnginNo to set
	 */
	public void setHasEnginNo(Integer hasEnginNo) {
		this.hasEnginNo = hasEnginNo;
	}

	public Integer getEngEnd() {
		return engEnd;
	}

	public void setEngEnd(Integer engEnd) {
		this.engEnd = engEnd;
	}

	public Integer getEngStart() {
		return engStart;
	}

	public void setEngStart(Integer engStart) {
		this.engStart = engStart;
	}

	public Boolean getIsIccidSim() {
		return isIccidSim;
	}

	public void setIsIccidSim(Boolean isIccidSim) {
		this.isIccidSim = isIccidSim;
	}

	public Boolean getIsTbox() {
		return isTbox;
	}

	public void setIsTbox(Boolean isTbox) {
		this.isTbox = isTbox;
	}

	public Boolean getIsAvn() {
		return isAvn;
	}

	public void setIsAvn(Boolean isAvn) {
		this.isAvn = isAvn;
	}

	public Boolean getIsBatteryGroup() {
		return isBatteryGroup;
	}

	public void setIsBatteryGroup(Boolean isBatteryGroup) {
		this.isBatteryGroup = isBatteryGroup;
	}

	public String getOrignalLabel() {
		return orignalLabel;
	}

	public void setOrignalLabel(String orignalLabel) {
		this.orignalLabel = orignalLabel;
	}

	public String getPartNo() {
		return partNo;
	}

	public void setPartNo(String partNo) {
		this.partNo = partNo;
	}

	public String getSupplierNo() {
		return supplierNo;
	}

	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}

	public String getVpps() {
		return vpps;
	}

	public void setVpps(String vpps) {
		this.vpps = vpps;
	}

	public Integer getPartNoCutLength() {
		return partNoCutLength;
	}

	public void setPartNoCutLength(Integer partNoCutLength) {
		this.partNoCutLength = partNoCutLength;
	}

	
	
	
	
	
}
