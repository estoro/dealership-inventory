package com.storo.dealership;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.querydsl.core.annotations.QueryEntity;

import lombok.Data;

@Data
@Entity
@QueryEntity
public class Vehicle {

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(Boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public Boolean getIsFourWheelDrive() {
        return isFourWheelDrive;
    }

    public void setIsFourWheelDrive(Boolean isFourWheelDrive) {
        this.isFourWheelDrive = isFourWheelDrive;
    }

    public Boolean getHasLowMiles() {
        return hasLowMiles;
    }

    public void setHasLowMiles(Boolean hasLowMiles) {
        this.hasLowMiles = hasLowMiles;
    }

    public Boolean getHasPowerWindows() {
        return hasPowerWindows;
    }

    public void setHasPowerWindows(Boolean hasPowerWindows) {
        this.hasPowerWindows = hasPowerWindows;
    }

    public Boolean getHasNavigation() {
        return hasNavigation;
    }

    public void setHasNavigation(Boolean hasNavigation) {
        this.hasNavigation = hasNavigation;
    }

    public Boolean getHasHeatedSeats() {
        return hasHeatedSeats;
    }

    public void setHasHeatedSeats(Boolean hasHeatedSeats) {
        this.hasHeatedSeats = hasHeatedSeats;
    }

    @Id
    private String _id;
    private String make;
    private Integer year;
    private String color;
    private Integer price;
    private Boolean hasSunroof;
    private Boolean isFourWheelDrive;
    private Boolean hasLowMiles;
    private Boolean hasPowerWindows;
    private Boolean hasNavigation;
    private Boolean hasHeatedSeats;

    public Vehicle() {

    }

    public Vehicle(String _id, String make, Integer year, String color, Integer price, Boolean hasSunroof, Boolean isFourWheelDrive, Boolean hasLowMiles,
            Boolean hasPowerWindows, Boolean hasNavigation, Boolean hasHeatedSeats) {
        this._id = _id;
        this.make = make;
        this.year = year;
        this.color = color;
        this.price = price;
        this.hasSunroof = hasSunroof;
        this.isFourWheelDrive = isFourWheelDrive;
        this.hasLowMiles = hasLowMiles;
        this.hasPowerWindows = hasPowerWindows;
        this.hasNavigation = hasNavigation;
        this.hasHeatedSeats = hasHeatedSeats;
    }
}
