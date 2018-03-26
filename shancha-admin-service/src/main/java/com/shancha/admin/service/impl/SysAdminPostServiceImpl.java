package com.shancha.admin.service.impl;

import java.util.List;

import com.shancha.admin.service.SysAdminPostService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shancha.admin.base.BaseServiceImpl;
import com.shancha.admin.model.SysAdminPost;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Service
public class SysAdminPostServiceImpl extends BaseServiceImpl<SysAdminPost> implements SysAdminPostService{
	
	@Autowired
	private Mapper<SysAdminPost> sysAdminPostDao;
	
	@Override
	public Mapper<SysAdminPost> getMapper() {
		return sysAdminPostDao;
	}

	public List<SysAdminPost> getDataList(String name) {
		Example example = new Example(SysAdminPost.class,false);
		Criteria criteria = example.createCriteria();
		if(StringUtils.isNotBlank(name)){
			criteria.andLike("name", name);
		}
		return sysAdminPostDao.selectByExample(example);
	}

}
