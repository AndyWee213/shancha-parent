package com.shancha.report.model;

import lombok.Data;

import javax.persistence.Table;

/**
 * Created by weiq on 2018/03/30.
 *
 * @author weiq
 */
@Table(name = "auctioning_item")
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
    private Long create_time;
    private Long modify_time;
    private String detailed;
}
