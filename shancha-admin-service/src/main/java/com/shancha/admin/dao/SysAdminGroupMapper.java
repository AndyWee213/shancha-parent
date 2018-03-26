package com.shancha.admin.dao;

import java.util.List;

import com.shancha.admin.model.SysAdminGroup;
import com.shancha.admin.util.BaseMapper;
import org.apache.ibatis.annotations.Param;

public interface SysAdminGroupMapper extends BaseMapper<SysAdminGroup> {
	/**
	 * 查询分组信息
	 * @param userId 用户ID
	 * @param status 状态
	 * @return
	 */
	List<SysAdminGroup> selectByUserId(@Param("userId") Integer userId,@Param("status") Byte status);
}