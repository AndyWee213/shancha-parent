package com.shancha.task.enums;

/**
 * Created by weiq on 2018/03/13.
 *
 * @author weiq
 */
public enum CommunityExtensionTypeEnum {

    KINDERGARTEN("01", "幼儿园"),
    PRIMARY_SCHOOL("02", "小学"),
    SECONDARY_SCHOOL("03", "中学"),
    HOSPITAL("04", "医院"),
    BUS_STATION("05", "公交车站"),
    SUB_WAY("06", "地铁站"),
    SHOPPING_MALL("07", "商场"),
    PARK("08", "公园"),
    UNKNOWN("unkonwn", "unknown");

    private String code;
    private String value;

    CommunityExtensionTypeEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public static CommunityExtensionTypeEnum getByCode(String code) {
        switch (code) {
            case "01":
                return KINDERGARTEN;
            case "02":
                return PRIMARY_SCHOOL;
            case "03":
                return SECONDARY_SCHOOL;
            case "04":
                return HOSPITAL;
            case "05":
                return BUS_STATION;
            case "06":
                return SUB_WAY;
            case "07":
                return SHOPPING_MALL;
            case "08":
                return PARK;
            default:
                return UNKNOWN;
        }
    }

    public String getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
