package com.shancha.admin.service.impl;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.dao.SysAdminAccessMapper;
import com.shancha.admin.service.SysAdminAccessService;
import com.shancha.admin.model.SysAdminAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

@Service
public class SysAdminAccessServiceImpl extends BaseServiceImpl<SysAdminAccess> implements SysAdminAccessService {
	
	@Autowired
	private SysAdminAccessMapper sysAdminAccessDao;
	
	@Override
	public Mapper<SysAdminAccess> getMapper() {
		return sysAdminAccessDao;
	}

}
