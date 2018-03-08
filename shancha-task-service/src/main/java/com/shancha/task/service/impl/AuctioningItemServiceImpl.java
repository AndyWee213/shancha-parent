package com.shancha.task.service.impl;

import com.shancha.task.dao.AuctioningItemDao;
import com.shancha.task.model.AuctioningItem;
import com.shancha.task.service.AuctioningItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class AuctioningItemServiceImpl implements AuctioningItemService {

    @Autowired
    AuctioningItemDao dao;

    public Mapper<AuctioningItem> getDao() {
        return dao;
    }

    @Override
    public List<AuctioningItem> getAll() {
        return dao.selectAll();
    }

    @Override
    public List<AuctioningItem> getAllAuctioningItemCrawledToday() {
        Example example = new Example(AuctioningItem.class);
        Example.Criteria criteria = example.createCriteria();
        LocalDateTime startOfDay = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        long param = startOfDay.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        criteria.andGreaterThan("createTime", param*1000);
        return dao.selectByExample(example);
    }

}
