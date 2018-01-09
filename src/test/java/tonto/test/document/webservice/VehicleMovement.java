package tonto.test.document.webservice;

import java.util.Date;
 
public class VehicleMovement{

    /** 车辆跟踪信息ID  */
    private long vehicleMovementId;
    
    /**前一TPS*/
    private String preTps;
    
    /**后车TPS*/
    private String behindTps;
    
    /** 车辆VIN  */
    private String vin;
    
    /**工艺路径ID*/
    private Long routeId;
    
    /**更改的工艺路径编号*/
    private String routeNo;
    
    /**工艺路径编号*/
    private String routeDesc;
    
    /**工厂*/
    private String plant;
    
    /** 车辆ID */
    private long vehicleId;

    /** 到达工位ID */
    private long uLocId;

    /** 录入系统的时间 */
    private String inputTime;

    /** 车辆到达时间 */
    private Date scanTime;

    /** 扫描补登用户 */
    private String scanUserName;

    /** 在该扫描点是否车辆废弃 */
    private int isDiscard;

    /** 是否setout扫描记录 */
    private int isSetout;

    /** 上次更改时间 */
    private String lastUpdateTime;

    /** 更改用户 */
    private String lastUpdateUserName;

    /** 归档计数 */
    private long pid;

    /** 归档记录是否可删除 */
    private int pidIsClosed;
    
    /** 车辆tps */
    private String tps;
    
    /** 备注 */
    private String extraInfo;
    
    /** 前车tps */
    private String tpsBehind;
    
    /** 工位编号 */
	private String uLocNo;
	
	/**工位*/
	private String ulocDesc;
	
	/**车辆编号*/
	private String workShopNo;
	
	/**扫描人*/
	private String scanUser;
	
	/**整车物料号*/
	private String materialNo;
	/**定单号*/
	private String orderNo;
	/**Fc01*/
	private String fc01;
	/**Fc02*/
	private String fc02;
	/**Fc03*/
	private String fc03;
	/**Fc04*/
	private String fc04;
	/**Fc05*/
	private String fc05;
	/**TPSFc01*/
	private String tpsFc01;
	/**TPSFc02*/
	private String tpsFc02;
	/**TPSFc03*/
	private String tpsFc03;
	
	/**扫描类型*/
	private Long scanType;
	
	private String isDelete;
	
	//新增字段  2013-07-22
	/**车身流水号 */
	private String csn_ba;
	/** 油漆流水号 */
	private String csn_pa;
	/** 总装流水号 */
	private String csn_ga;
	
	/**
	 * 工号名称
	 * 
	 */
	private String ulocName;
	
	
    public String getUlocName() {
		return ulocName;
	}

	public void setUlocName(String ulocName) {
		this.ulocName = ulocName;
	}

	/**
     * 返回车辆跟踪信息ID 值
     *
     * @return long 车辆跟踪信息ID 
     */
    public long getVehicleMovementId(){
        return this.vehicleMovementId;
    }

    /**
     * 设置车辆跟踪信息ID 值
     *
     * @param vehicleMovementId 车辆跟踪信息ID 
     */
    public void setVehicleMovementId(long vehicleMovementId){
        this.vehicleMovementId = vehicleMovementId;
    }

    /**
     * 返回车辆ID值
     *
     * @return long 车辆ID
     */
    public long getVehicleId(){
        return this.vehicleId;
    }

    /**
     * 设置车辆ID值
     *
     * @param vehicleId 车辆ID
     */
    public void setVehicleId(long vehicleId){
        this.vehicleId = vehicleId;
    }

    /**
     * 返回到达工位ID值
     *
     * @return long 到达工位ID
     */
    public long getULocId(){
        return this.uLocId;
    }

    /**
     * 设置到达工位ID值
     *
     * @param uLocId 到达工位ID
     */
    public void setULocId(long uLocId){
        this.uLocId = uLocId;
    }

    /**
     * 返回录入系统的时间值
     *
     * @return String 录入系统的时间
     */
    public String getInputTime(){
        return this.inputTime;
    }

    /**
     * 设置录入系统的时间值
     *
     * @param inputTime 录入系统的时间
     */
    public void setInputTime(String inputTime){
        this.inputTime = inputTime;
    }

    /**
     * 返回扫描补登用户值
     *
     * @return String 扫描补登用户
     */
    public String getScanUserName(){
        return this.scanUserName;
    }

    /**
     * 设置扫描补登用户值
     *
     * @param scanUserName 扫描补登用户
     */
    public void setScanUserName(String scanUserName){
        this.scanUserName = scanUserName;
    }

    /**
     * 返回在该扫描点是否车辆废弃值
     *
     * @return int 在该扫描点是否车辆废弃
     */
    public int getIsDiscard(){
        return this.isDiscard;
    }

    /**
     * 设置在该扫描点是否车辆废弃值
     *
     * @param isDiscard 在该扫描点是否车辆废弃
     */
    public void setIsDiscard(int isDiscard){
        this.isDiscard = isDiscard;
    }

    /**
     * 返回是否setout扫描记录值
     *
     * @return int 是否setout扫描记录
     */
    public int getIsSetout(){
        return this.isSetout;
    }

    /**
     * 设置是否setout扫描记录值
     *
     * @param isSetout 是否setout扫描记录
     */
    public void setIsSetout(int isSetout){
        this.isSetout = isSetout;
    }

    /**
     * 返回上次更改时间值
     *
     * @return String 上次更改时间
     */
    public String getLastUpdateTime(){
        return this.lastUpdateTime;
    }

    /**
     * 设置上次更改时间值
     *
     * @param lastUpdateTime 上次更改时间
     */
    public void setLastUpdateTime(String lastUpdateTime){
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * 返回更改用户值
     *
     * @return String 更改用户
     */
    public String getLastUpdateUserName(){
        return this.lastUpdateUserName;
    }

    /**
     * 设置更改用户值
     *
     * @param lastUpdateUserName 更改用户
     */
    public void setLastUpdateUserName(String lastUpdateUserName){
        this.lastUpdateUserName = lastUpdateUserName;
    }

    /**
     * 返回归档计数值
     *
     * @return long 归档计数
     */
    public long getPid(){
        return this.pid;
    }

    /**
     * 设置归档计数值
     *
     * @param pid 归档计数
     */
    public void setPid(long pid){
        this.pid = pid;
    }

    /**
     * 返回归档记录是否可删除值
     *
     * @return int 归档记录是否可删除
     */
    public int getPidIsClosed(){
        return this.pidIsClosed;
    }

    /**
     * 设置归档记录是否可删除值
     *
     * @param pidIsClosed 归档记录是否可删除
     */
    public void setPidIsClosed(int pidIsClosed){
        this.pidIsClosed = pidIsClosed;
    }

	public Date getScanTime() {
		return scanTime;
	}

	public void setScanTime(Date scanTime) {
		this.scanTime = scanTime;
	}

	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}

	public String getTpsBehind() {
		return tpsBehind;
	}

	public void setTpsBehind(String tpsBehind) {
		this.tpsBehind = tpsBehind;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}


	public String getULocNo() {
		return uLocNo;
	}

	public void setULocNo(String locNo) {
		uLocNo = locNo;
	}

	public String getPreTps() {
		return preTps;
	}

	public void setPreTps(String preTps) {
		this.preTps = preTps;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getRouteNo() {
		return routeNo;
	}

	public void setRouteNo(String routeNo) {
		this.routeNo = routeNo;
	}

	public String getRouteDesc() {
		return routeDesc;
	}

	public void setRouteDesc(String routeDesc) {
		this.routeDesc = routeDesc;
	}

	public String getFc01() {
		return fc01;
	}

	public void setFc01(String fc01) {
		this.fc01 = fc01;
	}

	public String getFc02() {
		return fc02;
	}

	public void setFc02(String fc02) {
		this.fc02 = fc02;
	}

	public String getFc03() {
		return fc03;
	}

	public void setFc03(String fc03) {
		this.fc03 = fc03;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getScanUser() {
		return scanUser;
	}

	public void setScanUser(String scanUser) {
		this.scanUser = scanUser;
	}

	public String getUlocDesc() {
		return ulocDesc;
	}

	public void setUlocDesc(String ulocDesc) {
		this.ulocDesc = ulocDesc;
	}

	public String getWorkShopNo() {
		return workShopNo;
	}

	public void setWorkShopNo(String workShopNo) {
		this.workShopNo = workShopNo;
	}

	public Long getRouteId() {
		return routeId;
	}

	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}

	public Long getScanType() {
		return scanType;
	}

	public void setScanType(Long scanType) {
		this.scanType = scanType;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getBehindTps() {
		return behindTps;
	}

	public void setBehindTps(String behindTps) {
		this.behindTps = behindTps;
	}

	public String getFc04() {
		return fc04;
	}

	public void setFc04(String fc04) {
		this.fc04 = fc04;
	}

	public String getFc05() {
		return fc05;
	}

	public void setFc05(String fc05) {
		this.fc05 = fc05;
	}

	public String getTpsFc01() {
		return tpsFc01;
	}

	public void setTpsFc01(String tpsFc01) {
		this.tpsFc01 = tpsFc01;
	}

	public String getTpsFc02() {
		return tpsFc02;
	}

	public void setTpsFc02(String tpsFc02) {
		this.tpsFc02 = tpsFc02;
	}

	public String getTpsFc03() {
		return tpsFc03;
	}

	public void setTpsFc03(String tpsFc03) {
		this.tpsFc03 = tpsFc03;
	}

	//新增三个getter和setter方法
	public String getCsn_ba() {
		return csn_ba;
	}

	public void setCsn_ba(String csn_ba) {
		this.csn_ba = csn_ba;
	}

	public String getCsn_ga() {
		return csn_ga;
	}

	public void setCsn_ga(String csn_ga) {
		this.csn_ga = csn_ga;
	}

	public String getCsn_pa() {
		return csn_pa;
	}

	public void setCsn_pa(String csn_pa) {
		this.csn_pa = csn_pa;
	}
	
	
}
