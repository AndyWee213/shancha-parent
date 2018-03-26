package com.shancha.admin.dao;

import java.util.List;

import com.shancha.admin.model.SysAdminMenu;
import com.shancha.admin.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface SysAdminMenuMapper extends BaseMapper<SysAdminMenu> {
	/**
	 * 根据ruleIds查询菜单信息
	 * @param ruleIds 权限id
	 * @param status 状态值
	 * @return List<SysAdminMenu>
	 */
	List<SysAdminMenu> selectInRuleIds(@Param("ruleIds") String ruleIds, @Param("status") int status);
}