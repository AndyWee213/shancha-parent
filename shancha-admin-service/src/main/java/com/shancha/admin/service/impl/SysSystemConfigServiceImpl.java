package com.shancha.admin.service.impl;

import com.shancha.admin.service.SysSystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.dao.SysSystemConfigMapper;
import com.shancha.admin.model.SysSystemConfig;
import tk.mybatis.mapper.common.Mapper;
@Service
public class SysSystemConfigServiceImpl extends BaseServiceImpl<SysSystemConfig> implements SysSystemConfigService {
	@Autowired
	private SysSystemConfigMapper sysSystemConfigDao;
	
	@Override
	public Mapper<SysSystemConfig> getMapper() {
		return sysSystemConfigDao;
	}

}
