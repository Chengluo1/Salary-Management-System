package com.model;

public class staff3 {
    private String code;
    private String date;
    private int normal;
    private int actual;
    private int overattendence;
    private String department;
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department=department;
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
    public int getOverattendence() {
        return overattendence;
    }
    public void setOverattendence(int overattendence) {
        this.overattendence = overattendence;
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

}
