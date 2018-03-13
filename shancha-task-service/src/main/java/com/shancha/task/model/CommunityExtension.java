package com.shancha.task.model;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by weiq on 2018/03/13.
 *
 * @author weiq
 */
@Table(name = "community_ext")
public class CommunityExtension implements Serializable {
    private static final long serialVersionUID = 1L;
    private String communityId;
    private String type;
    private String name;
    private String distance;

    public String getCommunityId() {
        return communityId;
    }

    public void setCommunityId(String communityId) {
        this.communityId = communityId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
