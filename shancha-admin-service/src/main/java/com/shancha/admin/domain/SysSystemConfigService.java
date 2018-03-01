package com.shancha.admin.domain;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.dao.SysSystemConfigDao;
import com.shancha.admin.model.SysSystemConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.mybatis.mapper.common.Mapper;
@Service
public class SysSystemConfigService extends BaseServiceImpl<SysSystemConfig> {
	@Autowired
	private SysSystemConfigDao sysSystemConfigDao;
	
	@Override
	public Mapper<SysSystemConfig> getMapper() {
		return sysSystemConfigDao;
	}

}
