package com.shancha.admin.service;

import com.shancha.admin.base.BaseService;
import com.shancha.admin.model.SysAdminPost;

import java.util.List;

/**
 * Created by weiq on 2018/03/26.
 *
 * @author weiq
 */
public interface SysAdminPostService extends BaseService<SysAdminPost> {

    List<SysAdminPost> getDataList(String name);
}
