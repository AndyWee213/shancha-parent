package com.shancha.admin.service.impl;

import java.util.List;
import java.util.Map;

import com.shancha.admin.service.SysAdminGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.dao.SysAdminGroupMapper;
import com.shancha.admin.model.SysAdminGroup;
import com.shancha.admin.util.BeanToMapUtil;
import com.shancha.admin.util.Category;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
@Service
public class SysAdminGroupServiceImpl extends BaseServiceImpl<SysAdminGroup> implements SysAdminGroupService {
	@Autowired
	private SysAdminGroupMapper sysAdminGroupDao;
	
	@Override
	public Mapper<SysAdminGroup> getMapper() {
		return sysAdminGroupDao;
	}
	/**
	 * 列表
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getDataList() {
		Example example = new Example(SysAdminGroup.class);
		List<SysAdminGroup> rootSysAdminGroups = sysAdminGroupDao.selectByExample(example);
		Map<String, String> fields = Maps.newHashMap();
		fields.put("cid", "id");
		fields.put("fid", "pid");
		fields.put("name", "title");
		fields.put("fullname", "title");
		List<Map<String, Object>> rawList = Lists.newArrayList();
		rootSysAdminGroups.forEach((m)->{
			rawList.add(BeanToMapUtil.convertBean(m));
		});
		Category cate = new Category(fields, rawList);
		return cate.getList(Integer.valueOf("0"));
	}

}
