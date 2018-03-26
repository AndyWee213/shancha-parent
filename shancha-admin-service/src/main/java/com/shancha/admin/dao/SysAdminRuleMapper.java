package com.shancha.admin.dao;

import java.util.List;

import com.shancha.admin.model.SysAdminRule;
import com.shancha.admin.util.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SysAdminRuleMapper extends BaseMapper<SysAdminRule> {

	List<SysAdminRule> selectInIds(@Param("ruleIds") String ruleIds,@Param("status") Integer status);

	@Select("select * from sys_admin_rule where status = #{status}")
	List<SysAdminRule> selectByStatus(@Param("status") Integer status);
}