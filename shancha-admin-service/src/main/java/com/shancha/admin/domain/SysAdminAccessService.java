package com.shancha.admin.domain;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.dao.SysAdminAccessDao;
import com.shancha.admin.model.SysAdminAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;

@Service
public class SysAdminAccessService extends BaseServiceImpl<SysAdminAccess> {
	
	@Autowired
	private SysAdminAccessDao sysAdminAccessDao;
	
	@Override
	public Mapper<SysAdminAccess> getMapper() {
		return sysAdminAccessDao;
	}

}
