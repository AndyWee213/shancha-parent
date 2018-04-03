package com.shancha.report.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shancha.report.base.BaseServiceImpl;
import com.shancha.report.dao.AuctioningItemMapper;
import com.shancha.report.model.AuctioningItem;
import com.shancha.report.service.AuctioningItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by weiq on 2018/04/02.
 *
 * @author weiq
 */
@Service
public class AuctioningItemServiceImpl extends BaseServiceImpl<AuctioningItem> implements AuctioningItemService {

    @Autowired
    AuctioningItemMapper auctioningItemMapper;

    @Override
    public Mapper<AuctioningItem> getMapper() {
        return auctioningItemMapper;
    }

    @Override
    public PageInfo<AuctioningItem> getAuctioningItemsOnshelfToday(int pageNum, int pageSize) {
        Example example = new Example(AuctioningItem.class, false);
        Example.Criteria criteria = example.createCriteria();
//        criteria.andBetween("createTime", "", "");
        PageHelper.startPage(pageNum, pageSize);
        List<AuctioningItem> list = getMapper().selectByExample(example);
        return new PageInfo<>(list);
    }
}
