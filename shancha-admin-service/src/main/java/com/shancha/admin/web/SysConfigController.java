package com.shancha.admin.web;

import com.shancha.admin.model.SysSystemConfig;
import com.shancha.admin.service.SysSystemConfigService;
import com.shancha.admin.util.FastJsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统配置 控制层
 * @author andy.wee
 */
@RestController
@RequestMapping("/admin")
@Api(value = "SysConfigController", description = "系统配置接口")
public class SysConfigController extends CommonController{
	@Autowired
	private SysSystemConfigService sysSystemConfigService;
	
	@ApiOperation(value = "获取配置", httpMethod="POST")
	@PostMapping(value = "/configs", produces = {"application/json;charset=UTF-8"})
	public String configs(@RequestBody(required=false) SysSystemConfig record,HttpServletRequest request) {
		Map<String, Object> data = new HashMap<String, Object>();
		List<SysSystemConfig> configs = sysSystemConfigService.select(record);
		for (SysSystemConfig c : configs) {
			data.put(c.getName(), c.getValue());
		}
		return FastJsonUtils.resultSuccess(200, "查询配置成功", data);
	}
}
