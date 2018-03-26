package com.shancha.admin.service;

import com.shancha.admin.base.BaseService;
import com.shancha.admin.model.SysAdminMenu;

import java.util.List;
import java.util.Map;

/**
 * Created by weiq on 2018/03/26.
 *
 * @author weiq
 */
public interface SysAdminMenuService extends BaseService<SysAdminMenu> {

    /**
     * 获取用户对应的菜单
     *
     * @param userId
     * @return
     */
    List<SysAdminMenu> getTreeMenuByUserId(Integer userId);

    /**
     * 查询对应用户Id的菜单
     *
     * @param userId
     * @return
     */
    List<Map<String, Object>> getDataList(Integer userId, Byte status);
}
