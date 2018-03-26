package com.shancha.admin.service;

import com.shancha.admin.base.BaseService;
import com.shancha.admin.model.SysAdminStructure;

import java.util.List;
import java.util.Map;

/**
 * Created by weiq on 2018/03/26.
 *
 * @author weiq
 */
public interface SysAdminStructureService extends BaseService<SysAdminStructure> {

    List<Map<String, Object>> getDataList();
}
