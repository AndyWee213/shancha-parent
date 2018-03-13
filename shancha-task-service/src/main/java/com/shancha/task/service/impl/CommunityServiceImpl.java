package com.shancha.task.service.impl;

import com.shancha.task.dao.CommunityDao;
import com.shancha.task.model.AuctioningItem;
import com.shancha.task.model.Community;
import com.shancha.task.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by weiq on 2018/03/12.
 *
 * @author weiq
 */
@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityDao dao;

    @Override
    public List<Community> getCommunitiesByCommunityIds(Collection<String> ids) {
        Example example = new Example(AuctioningItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        return ids.isEmpty() ? Collections.EMPTY_LIST : dao.selectByExample(example);
    }
}
