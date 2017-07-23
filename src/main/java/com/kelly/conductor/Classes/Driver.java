package com.kelly.conductor.Classes;

/**
 * Created by KELLY on 23-Jul-17.
 */

public class Driver {
    private String name;
    private String phone;
    private String brandCar;
    private String color;
    private String company;
    private String licensePlate;
    public Driver (String name,String phone,String brandCar, String color, String company,
                   String licensePlate){
        this.name=name;
        this.phone=phone;
        this.brandCar=brandCar;
        this.color=color;
        this.company=company;
        this.licensePlate=licensePlate;
    }
    public Driver(int slost,String name,String phone){
        this.name=name;
        this.phone=phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

