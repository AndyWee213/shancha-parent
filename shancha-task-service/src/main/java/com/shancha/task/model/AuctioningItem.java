package com.shancha.task.model;

import lombok.Data;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by weiq on 2018/03/08.
 *
 * @author weiq
 */
@Table(name = "auctioning_item_detail")
public class AuctioningItem implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String url;
    private String title;
    private Long sellStart;
    private Long sellEnd;
    private String type;
    private String state;
    private String province;
    private String city;
    private String sellType;
    private String startPrice;
    private String stepPrice;
    private String securityDeposit;
    private String valuation;
    private String prePay;
    private String preferredCustomer;
    private String sellOrg;
    private String reviewOrg;
    private String contact;
    private String contactPhone;
    private String communityId;
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

    public Long getSellStart() {
        return sellStart;
    }

    public void setSellStart(Long sellStart) {
        this.sellStart = sellStart;
    }

    public Long getSellEnd() {
        return sellEnd;
    }

    public void setSellEnd(Long sellEnd) {
        this.sellEnd = sellEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getSellType() {
        return sellType;
    }

    public void setSellType(String sellType) {
        this.sellType = sellType;
    }

    public String getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(String startPrice) {
        this.startPrice = startPrice;
    }

    public String getStepPrice() {
        return stepPrice;
    }

    public void setStepPrice(String stepPrice) {
        this.stepPrice = stepPrice;
    }

    public String getSecurityDeposit() {
        return securityDeposit;
    }

    public void setSecurityDeposit(String securityDeposit) {
        this.securityDeposit = securityDeposit;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public String getPrePay() {
        return prePay;
    }

    public void setPrePay(String prePay) {
        this.prePay = prePay;
    }

    public String getPreferredCustomer() {
        return preferredCustomer;
    }

    public void setPreferredCustomer(String preferredCustomer) {
        this.preferredCustomer = preferredCustomer;
    }

    public String getSellOrg() {
        return sellOrg;
    }

    public void setSellOrg(String sellOrg) {
        this.sellOrg = sellOrg;
    }

    public String getReviewOrg() {
        return reviewOrg;
    }

    public void setReviewOrg(String reviewOrg) {
        this.reviewOrg = reviewOrg;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
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

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }
}
