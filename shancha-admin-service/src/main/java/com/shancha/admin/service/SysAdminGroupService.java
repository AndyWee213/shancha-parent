package com.shancha.admin.service;

import com.shancha.admin.base.BaseService;
import com.shancha.admin.model.SysAdminGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SysAdminGroupService extends BaseService<SysAdminGroup>{
	/**
	 * 列表
	 * @return
	 */
	List<Map<String, Object>> getDataList();

}
