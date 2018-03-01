package com.shancha.admin.dao;

import java.util.List;

import com.shancha.admin.model.SysAdminRule;
import com.shancha.admin.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface SysAdminRuleDao extends MyMapper<SysAdminRule> {

	List<SysAdminRule> selectInIds(@Param("ruleIds") String ruleIds,@Param("status") Integer status);

	List<SysAdminRule> selectByStatus(@Param("status") Integer status);
}