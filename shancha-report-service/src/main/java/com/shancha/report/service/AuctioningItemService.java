package com.shancha.report.service;

import com.github.pagehelper.PageInfo;
import com.shancha.report.base.BaseService;
import com.shancha.report.model.AuctioningItem;

/**
 * Created by weiq on 2018/04/02.
 *
 * @author weiq
 */
public interface AuctioningItemService extends BaseService<AuctioningItem> {

    /**
     * 获取今天上架的所有拍卖标的物
     *
     * @return
     */
    PageInfo<AuctioningItem> getAuctioningItemsOnshelfToday(int pageNum, int pageSize);
}
