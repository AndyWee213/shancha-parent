package com.shancha.task.service;

import com.shancha.task.model.CommunityExtension;

import java.util.Collection;
import java.util.List;

/**
 * Created by weiq on 2018/03/13.
 *
 * @author weiq
 */
public interface CommunityExtensionService {

    List<CommunityExtension> getCommunityExtensionByCommunityIds(Collection<String> communityIds);
}
