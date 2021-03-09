package com.model;

public class staff4 {
    private String code;
    private String date;
    private Double bonus;
    private Double overtimepays;
    private Double chargebacks;
    private Double fulltimewage;
    private Double lunchsubsidy;
    public  double getLunchsubsidy(){
        return lunchsubsidy;
    }
    public void setLunchsubsidy(double lunchsubsidy){
        this.lunchsubsidy=lunchsubsidy;
    }
    public Double getFulltimewage() {
        return fulltimewage;
    }
    public void setFulltimewage(Double fulltimewage) {
        this.fulltimewage = fulltimewage;
    }

    public Double getChargebacks() {
        return chargebacks;
    }
    public void setChargebacks(Double chargebacks) {
        this.chargebacks = chargebacks;
    }


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Double getBonus() {
        return bonus;
    }
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
    public Double getOvertimepays() {
        return overtimepays;
    }
    public void setOvertimepays(Double overtimepays) {
        this.overtimepays = overtimepays;
    }
}
