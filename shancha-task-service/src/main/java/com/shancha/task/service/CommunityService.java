package com.shancha.task.service;

import com.shancha.task.model.Community;

import java.util.Collection;
import java.util.List;

/**
 * Created by weiq on 2018/03/12.
 *
 * @author weiq
 */
public interface CommunityService {

    List<Community> getCommunitiesByCommunityIds(Collection<String> communityIds);
}
