package ssxt.com.zeng.xml;

 
// Generated 2016-12-22 10:10:52 by Hibernate Tools 3.6.0.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * BasDeviceInfo generated by hbm2java
 */
public class BasDeviceInfo implements java.io.Serializable {

	private Long id;
	private String deviceSn;
	private Integer delFlag;
	private String deviceName;
	private String stcd;
	private String stnm;
	private Integer deviceType;
	private int maintType;
	private String deviceModel;
	private String ver;
	private String serialNo;
	private Integer status;
	private String idenitfication;
	private String regionId;
	private String ownerId;
	private String deviceInfo;
	private String factoryName;
	private String factoryTel;
	private String supplyerName;
	private String supplyerTel;
	private Date installTime;
	private String maintNo;
	private String maintName;
	private String barcode;
	private Integer pollInterval;
	private Integer reportFreq;
	private String remark;
	private String deviceAddr;
	private String nt;
	private BigDecimal log;
	private BigDecimal lat;
	private String address;
	private String folderName;

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public BasDeviceInfo() {
	}

	public BasDeviceInfo(int maintType) {
		this.maintType = maintType;
	}

	public BasDeviceInfo(String deviceSn, Integer delFlag, String deviceName, String stcd, String stnm,
			Integer deviceType, int maintType, String deviceModel, String ver, String serialNo, Integer status,
			String idenitfication, String regionId, String ownerId, String deviceInfo, String factoryName,
			String factoryTel, String supplyerName, String supplyerTel, Date installTime, String maintNo,
			String maintName, String barcode, Integer pollInterval, Integer reportFreq, String remark,
			String deviceAddr, String nt, BigDecimal log, BigDecimal lat, String address,String folderName) {
		this.deviceSn = deviceSn;
		this.delFlag = delFlag;
		this.deviceName = deviceName;
		this.stcd = stcd;
		this.stnm = stnm;
		this.deviceType = deviceType;
		this.maintType = maintType;
		this.deviceModel = deviceModel;
		this.ver = ver;
		this.serialNo = serialNo;
		this.status = status;
		this.idenitfication = idenitfication;
		this.regionId = regionId;
		this.ownerId = ownerId;
		this.deviceInfo = deviceInfo;
		this.factoryName = factoryName;
		this.factoryTel = factoryTel;
		this.supplyerName = supplyerName;
		this.supplyerTel = supplyerTel;
		this.installTime = installTime;
		this.maintNo = maintNo;
		this.maintName = maintName;
		this.barcode = barcode;
		this.pollInterval = pollInterval;
		this.reportFreq = reportFreq;
		this.remark = remark;
		this.deviceAddr = deviceAddr;
		this.nt = nt;
		this.log = log;
		this.lat = lat;
		this.address = address;
		this.folderName=folderName;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeviceSn() {
		return this.deviceSn;
	}

	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}

	public Integer getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getStcd() {
		return this.stcd;
	}

	public void setStcd(String stcd) {
		this.stcd = stcd;
	}

	public String getStnm() {
		return this.stnm;
	}

	public void setStnm(String stnm) {
		this.stnm = stnm;
	}

	public Integer getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public int getMaintType() {
		return this.maintType;
	}

	public void setMaintType(int maintType) {
		this.maintType = maintType;
	}

	public String getDeviceModel() {
		return this.deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getVer() {
		return this.ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public String getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIdenitfication() {
		return this.idenitfication;
	}

	public void setIdenitfication(String idenitfication) {
		this.idenitfication = idenitfication;
	}

	public String getRegionId() {
		return this.regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getOwnerId() {
		return this.ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getDeviceInfo() {
		return this.deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getFactoryName() {
		return this.factoryName;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public String getFactoryTel() {
		return this.factoryTel;
	}

	public void setFactoryTel(String factoryTel) {
		this.factoryTel = factoryTel;
	}

	public String getSupplyerName() {
		return this.supplyerName;
	}

	public void setSupplyerName(String supplyerName) {
		this.supplyerName = supplyerName;
	}

	public String getSupplyerTel() {
		return this.supplyerTel;
	}

	public void setSupplyerTel(String supplyerTel) {
		this.supplyerTel = supplyerTel;
	}

	public Date getInstallTime() {
		return this.installTime;
	}

	public void setInstallTime(Date installTime) {
		this.installTime = installTime;
	}

	public String getMaintNo() {
		return this.maintNo;
	}

	public void setMaintNo(String maintNo) {
		this.maintNo = maintNo;
	}

	public String getMaintName() {
		return this.maintName;
	}

	public void setMaintName(String maintName) {
		this.maintName = maintName;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getPollInterval() {
		return this.pollInterval;
	}

	public void setPollInterval(Integer pollInterval) {
		this.pollInterval = pollInterval;
	}

	public Integer getReportFreq() {
		return this.reportFreq;
	}

	public void setReportFreq(Integer reportFreq) {
		this.reportFreq = reportFreq;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDeviceAddr() {
		return this.deviceAddr;
	}

	public void setDeviceAddr(String deviceAddr) {
		this.deviceAddr = deviceAddr;
	}

	public String getNt() {
		return this.nt;
	}

	public void setNt(String nt) {
		this.nt = nt;
	}

	public BigDecimal getLog() {
		return this.log;
	}

	public void setLog(BigDecimal log) {
		this.log = log;
	}

	public BigDecimal getLat() {
		return this.lat;
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


	
	private Map<String,Object> lastMsg;

	public Map<String, Object> getLastMsg() {
		return lastMsg;
	}

	public void setLastMsg(Map<String, Object> lastMsg) {
		this.lastMsg = lastMsg;
	}


	private int alertStatus=0;
	public int getAlertStatus() {
		return alertStatus;
	}

	public void setAlertStatus(int alertStatus) {
		this.alertStatus = alertStatus;
	}

	private Map<String,Object> stationCfg;

	public Map<String, Object> getStationCfg() {
		return stationCfg;
	}

	public void setStationCfg(Map<String, Object> stationCfg) {
		this.stationCfg = stationCfg;
	}


}