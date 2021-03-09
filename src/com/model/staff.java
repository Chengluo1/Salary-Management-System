package com.model;

public class staff {
    private String department;
    private String code;
    private String name;
    private int normal;
    private int actual;
    private double basic;
    private double bonus;
    private double overtimepays;
    private double insurance;
    private double common;
    private double finalwage;
    private double tax;
    private double fulltimewage;
    private double chargebacks;
    private double lunchsubsidy;
    private String date;
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
    public  double getLunchsubsidy(){
        return lunchsubsidy;
    }
    public void setLunchsubsidy(double lunchsubsidy){
        this.lunchsubsidy=lunchsubsidy;
    }
    public double getChargebacks() {
        return chargebacks;
    }
    public void setChargebacks(double chargebacks) {
        this.chargebacks = chargebacks;
    }
    public double getFulltimewage() {
        return fulltimewage;
    }
    public void setFulltimewage(double fulltimewage) {
        this.fulltimewage = fulltimewage;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNormal() {
        return normal;
    }
    public void setNormal(int normal) {
        this.normal = normal;
    }
    public int getActual() {
        return actual;
    }
    public void setActual(int actual) {
        this.actual = actual;
    }
    public double getBasic() {
        return basic;
    }
    public void setBasic(double basic) {
        this.basic = basic;
    }
    public double getBonus() {
        return bonus;
    }
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    public double getOvertimepays() {
        return overtimepays;
    }
    public void setOvertimepays(double overtimepays) {
        this.overtimepays = overtimepays;
    }
    public double getInsurance() {
        return insurance;
    }
    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }
    public double getCommon() {
        return common;
    }
    public void setCommon(double common) {
        this.common = common;
    }
    public double getFinalwage() {
        return finalwage;
    }
    public void setFinalwage(double finalwage) {
        this.finalwage = finalwage;
    }

}
