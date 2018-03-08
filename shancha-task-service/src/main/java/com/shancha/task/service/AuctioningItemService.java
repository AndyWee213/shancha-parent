package com.shancha.task.service;

import com.shancha.task.model.AuctioningItem;

import java.util.List;

public interface AuctioningItemService {

    List<AuctioningItem> getAll();
    List<AuctioningItem> getAllAuctioningItemCrawledToday();
}
