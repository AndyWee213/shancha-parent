package com.shancha.admin.domain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.dao.SysAdminStructureDao;
import com.shancha.admin.model.SysAdminStructure;
import com.shancha.admin.util.BeanToMapUtil;
import com.shancha.admin.util.Category;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
@Service
public class SysAdminStructureService extends BaseServiceImpl<SysAdminStructure>{

	@Autowired
	private SysAdminStructureDao sysAdminStructureDao;
	
	@Override
	public Mapper<SysAdminStructure> getMapper() {
		return sysAdminStructureDao;
	}

	public List<Map<String, Object>> getDataList() {
		Example example = new Example(SysAdminStructure.class);
		example.setOrderByClause(" id asc");
		List<SysAdminStructure> rootSysAdminStructure = sysAdminStructureDao.selectByExample(example);
		Map<String, String> fields = Maps.newHashMap();
		fields.put("cid", "id");
		fields.put("fid", "pid");
		fields.put("name", "name");
		fields.put("fullname", "title");
		List<Map<String, Object>> rawList = Lists.newArrayList();
		rootSysAdminStructure.forEach((m)->{
			rawList.add(BeanToMapUtil.convertBean(m));
		});
		Category cate = new Category(fields, rawList);
		return cate.getList(Integer.valueOf("0"));
	}

}