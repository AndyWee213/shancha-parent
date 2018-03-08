package com.shancha.task.model;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by weiq on 2018/03/08.
 *
 * @author weiq
 */
@Table(name = "auctioning_item_detail")
@Data
public class AuctioningItem {
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
    private Long createTime;
    private Long modifyTime;
}
