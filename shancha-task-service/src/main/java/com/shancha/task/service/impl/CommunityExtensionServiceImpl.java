package com.shancha.task.service.impl;

import com.shancha.task.dao.CommunityExtDao;
import com.shancha.task.model.CommunityExtension;
import com.shancha.task.service.CommunityExtensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by weiq on 2018/03/13.
 *
 * @author weiq
 */
@Service
public class CommunityExtensionServiceImpl implements CommunityExtensionService {

    @Autowired
    private CommunityExtDao dao;

    @Override
    public List<CommunityExtension> getCommunityExtensionByCommunityIds(Collection<String> communityIds) {
        Example example = new Example(CommunityExtension.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("communityId", communityIds);
        return communityIds.isEmpty() ? Collections.EMPTY_LIST : dao.selectByExample(example);
    }
}
