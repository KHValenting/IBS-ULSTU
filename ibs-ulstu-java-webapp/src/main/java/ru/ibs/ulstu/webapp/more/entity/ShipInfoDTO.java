package ru.ibs.ulstu.webapp.more.entity;

/**
 * Created by PDudarin on 20.11.2016.
 */
public class ShipInfoDTO {
    private int id;
    private String flagImage;
    private String  name;
    private String nameLat;
    private String callSign;
    private String imo;
    private String mmsi;
    private String country;
    private String riverReg;
    private String marineReg;
    private String buildDate;
    private String ownerName;
    private int cntPassanger;
    private int targetFactor;


    public ShipInfoDTO(int id, String flagImage, String name, String nameLat, String callSign, String imo, String mmsi) {
        this.id = id;
        this.flagImage = flagImage;
        this.name = name;
        this.nameLat = nameLat;
        this.callSign = callSign;
        this.imo = imo;
        this.mmsi = mmsi;
    }

    public ShipInfoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameLat() {
        return nameLat;
    }

    public void setNameLat(String nameLat) {
        this.nameLat = nameLat;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public String getImo() {
        return imo;
    }

    public void setImo(String imo) {
        this.imo = imo;
    }

    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRiverReg() {
        return riverReg;
    }

    public void setRiverReg(String riverReg) {
        this.riverReg = riverReg;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getCntPassanger() {
        return cntPassanger;
    }

    public void setCntPassanger(int cntPassanger) {
        this.cntPassanger = cntPassanger;
    }

    public int getTargetFactor() {
        return targetFactor;
    }

    public void setTargetFactor(int targetFactor) {
        this.targetFactor = targetFactor;
    }

    public String getMarineReg() {
        return marineReg;
    }

    public void setMarineReg(String marineReg) {
        this.marineReg = marineReg;
    }

    @Override
    public String toString(){
        return this.getName();
    }

}