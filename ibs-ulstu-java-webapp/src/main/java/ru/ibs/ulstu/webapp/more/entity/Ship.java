/**
 * 
 */
package ru.ibs.ulstu.webapp.more.entity;

/**
 * POJO судна. В рамках программы по сути является сущностью (Entity)
 * 
 * @author KHValentin
 * Created on 18 нояб. 2016 г.
 */
public interface Ship extends Comparable<Ship>{
	

	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public String getNameLat();
	public void setNameLat(String nameLat);
	public String getCallSign();
	public void setCallSign(String callSign);
	public String getImo();
	public void setImo(String imo);
	public String getMmsi();
	public void setMmsi(String mmsi);
	public Integer getRrr();
	public void setRrr(Integer rrr);
	public Integer getRmrs();
	public void setRmrs(Integer rmrs);
	public String getFlag();
	public void setFlag(String flag);
	public String getLastLocationDate();
	public void setLastLocationDate(String lastLocationDate);
	public String getLastLocationSource();
	public void setLastLocationSource(String lastLocationSource);
	public String getLastLocationCoordinates();
	public void setLastLocationCoordinates(String lastLocationCoordinates);
	public String getLastLocationSpeed();
	public void setLastLocationSpeed(String lastLocationSpeed);
	public String getLastLocationCource();
	public void setLastLocationCource(String lastLocationCource);
	public Boolean getDangerCargo();
	public void setDangerCargo(Boolean dangerCargo);
	public Boolean getHighTargetFactor();
	public void setHighTargetFactor(Boolean highTargetFactor);
	public Boolean getSsas();
	public void setSsas(Boolean ssas);

    @Override
    public int compareTo(Ship o);
}
