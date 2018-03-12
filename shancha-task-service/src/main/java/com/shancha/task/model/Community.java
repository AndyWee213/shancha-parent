package com.shancha.task.model;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by weiq on 2018/03/12.
 *
 * @author weiq
 */
@Table(name = "community")
public class Community implements Serializable {
    private String id;
    private String url;
    private String title;
    private String type;
    private String segment;
    private String province;
    private String city;
    private String county;
    private String plate;
    private String developerCompany;
    private String position;
    private String monthPrice;
    private String buildingYear;
    private String buildingCount;
    private String familyCount;
    private String propertyCompany;
    private String propertyPrice;
    private String buildingType;
    private String elevator;
    private String porking;
    private String plotRation;
    private String greeningRate;
    private Long createTime;
    private Long modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getDeveloperCompany() {
        return developerCompany;
    }

    public void setDeveloperCompany(String developerCompany) {
        this.developerCompany = developerCompany;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getMonthPrice() {
        return monthPrice;
    }

    public void setMonthPrice(String monthPrice) {
        this.monthPrice = monthPrice;
    }

    public String getBuildingYear() {
        return buildingYear;
    }

    public void setBuildingYear(String buildingYear) {
        this.buildingYear = buildingYear;
    }

    public String getBuildingCount() {
        return buildingCount;
    }

    public void setBuildingCount(String buildingCount) {
        this.buildingCount = buildingCount;
    }

    public String getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(String familyCount) {
        this.familyCount = familyCount;
    }

    public String getPropertyCompany() {
        return propertyCompany;
    }

    public void setPropertyCompany(String propertyCompany) {
        this.propertyCompany = propertyCompany;
    }

    public String getPropertyPrice() {
        return propertyPrice;
    }

    public void setPropertyPrice(String propertyPrice) {
        this.propertyPrice = propertyPrice;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getPorking() {
        return porking;
    }

    public void setPorking(String porking) {
        this.porking = porking;
    }

    public String getPlotRation() {
        return plotRation;
    }

    public void setPlotRation(String plotRation) {
        this.plotRation = plotRation;
    }

    public String getGreeningRate() {
        return greeningRate;
    }

    public void setGreeningRate(String greeningRate) {
        this.greeningRate = greeningRate;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Long modifyTime) {
        this.modifyTime = modifyTime;
    }
}
