package com.shancha.task.bean;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by weiq on 2018/03/08.
 *
 * @author weiq
 */
@XmlRootElement
public class ReportDataBean implements Serializable {
    private String url;
    private String title;
    private String sellStart;
    private String sellEnd;
    private String valuation;
    private String sellOrg;

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

    public String getSellStart() {
        return sellStart;
    }

    public void setSellStart(String sellStart) {
        this.sellStart = sellStart;
    }

    public String getSellEnd() {
        return sellEnd;
    }

    public void setSellEnd(String sellEnd) {
        this.sellEnd = sellEnd;
    }

    public String getValuation() {
        return valuation;
    }

    public void setValuation(String valuation) {
        this.valuation = valuation;
    }

    public String getSellOrg() {
        return sellOrg;
    }

    public void setSellOrg(String sellOrg) {
        this.sellOrg = sellOrg;
    }
}
