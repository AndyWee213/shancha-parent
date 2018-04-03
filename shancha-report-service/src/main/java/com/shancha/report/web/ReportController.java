package com.shancha.report.web;

import com.github.pagehelper.PageInfo;
import com.shancha.report.model.AuctioningItem;
import com.shancha.report.service.AuctioningItemService;
import com.shancha.report.util.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by weiq on 2018/03/30.
 *
 * @author weiq
 */
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    AuctioningItemService auctioningItemService;

    @PostMapping("/auctioningitems")
    public String getAuctioningItems(int pageNum, int pageSize) {
        PageInfo<AuctioningItem> pageInfo = auctioningItemService.getAuctioningItemsOnshelfToday(pageNum, pageSize);
        return FastJsonUtils.resultSuccess(200, "成功", pageInfo);
    }

}
