package com.shancha.admin.web;

import javax.servlet.http.HttpServletRequest;

import com.shancha.admin.contants.Constant;
import com.shancha.admin.domain.SysAdminUserService;
import com.shancha.admin.model.SysAdminUser;
import com.shancha.admin.util.EncryptUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * 公共控制器
 * @author leo
 *
 */
public class CommonController {
	@Autowired
	private SysAdminUserService sysAdminUserService;
	
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public SysAdminUser getCurrentUser(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String authKey = request.getHeader(Constant.AUTH_KEY);
		if(StringUtils.isNotBlank(authKey)) {
			String decryptAuthKey = EncryptUtil.decryptBase64(authKey, Constant.SECRET_KEY);
			String[]  auths = decryptAuthKey.split("\\|");
			String username = auths[0];
			String password = auths[1];
			SysAdminUser record = new SysAdminUser();
			record.setUsername(username);
			record.setPassword(password);
			return sysAdminUserService.selectOne(record);
		}
		return null;
	}
}
