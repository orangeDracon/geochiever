package com.orangedracon.geochiever.sql.zone_achi;

import java.sql.Date;

/**
 *
 * @author orangeDracon
 */
public class ZoneAchi {

    private int id;
    private String name;
    private String description;
    private String info;
    private double north_border;
    private double south_border;
    private double east_border;
    private double west_border;
    private String country_type;
    private Date date_added;
    private String logo_url;
    private int active;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getNorth_border() {
        return north_border;
    }

    public void setNorth_border(double north_border) {
        this.north_border = north_border;
    }

    public double getSouth_border() {
        return south_border;
    }

    public void setSouth_border(double south_border) {
        this.south_border = south_border;
    }

    public double getEast_border() {
        return east_border;
    }

    public void setEast_border(double east_border) {
        this.east_border = east_border;
    }

    public double getWest_border() {
        return west_border;
    }

    public void setWest_border(double west_border) {
        this.west_border = west_border;
    }

    public String getCountry_type() {
        return country_type;
    }

    public void setCountry_type(String country_type) {
        this.country_type = country_type;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getLogo_url() {
        return logo_url;
    }

    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
