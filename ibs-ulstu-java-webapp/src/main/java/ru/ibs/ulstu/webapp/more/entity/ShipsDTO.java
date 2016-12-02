package ru.ibs.ulstu.webapp.more.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PDudarin on 20.11.2016.
 */
public class ShipsDTO {


    private boolean success;

    private List<ShipInfoDTO> list;


    public ShipsDTO(boolean success, List<ShipInfoDTO> list) {
        this.success = success;
        this.list = list;
    }

    public ShipsDTO() {
        this.success = false;
        this.list = new ArrayList<>();
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ShipInfoDTO> getList() {
        return list;
    }

    public void setList(List<ShipInfoDTO> list) {
        this.list = list;
    }



    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (ShipInfoDTO si : list) {
            sb.append(" ").append(si.getName());
        }
        return sb.toString();
    }

}
