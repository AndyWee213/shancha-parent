package com.shancha.task.service.impl;

import com.shancha.task.conf.CommunityDao;
import com.shancha.task.model.AuctioningItem;
import com.shancha.task.model.Community;
import com.shancha.task.service.CommunityService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by weiq on 2018/03/12.
 *
 * @author weiq
 */
@Service
public class CommunityServiceImpl implements CommunityService {

    private CommunityDao dao;

    @Override
    public List<Community> getCommunitiesByCommunityIds(List<String> communityIds) {
        Example example = new Example(AuctioningItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", communityIds);
        return dao.selectByExample(example);
    }
}
