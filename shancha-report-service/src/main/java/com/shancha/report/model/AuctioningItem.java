package com.shancha.report.model;

import com.shancha.report.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Table;

/**
 * Created by weiq on 2018/03/30.
 *
 * @author weiq
 */
@EqualsAndHashCode(callSuper = true)
@Table(name = "auctioning_item_detail")
@Data
public class AuctioningItem extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String url;
    private String title;
    private Long sellStart;
    private Long sellEnd;
    private String type;
    private String state;
    private String province;
    private String city;
    private Long createTime;
    private Long modifyTime;
    private String detailed;
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
}
