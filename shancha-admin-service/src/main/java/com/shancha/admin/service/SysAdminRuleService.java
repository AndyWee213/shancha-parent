package com.shancha.admin.service;

import com.shancha.admin.base.BaseService;
import com.shancha.admin.model.SysAdminRule;

import java.util.List;
import java.util.Map;

/**
 * Created by weiq on 2018/03/26.
 *
 * @author weiq
 */
public interface SysAdminRuleService extends BaseService<SysAdminRule> {

    /**
     * 根据用户名获取rule数组
     * @param userId 用户id
     */
    List<SysAdminRule> getTreeRuleByUserId(Integer userId);
    /**
     * 列表页面
     * @param userId 用户id
     * @param type  类型 tree,其它
     * @return
     */
    List<Map<String, Object>> getDataList(Integer userId, String type);

    /**
     * 给树状规则表处理成 module-controller-action
     * @return treeNodes
     */
    List<String> rulesDeal(List<SysAdminRule> treeNodes);
}
