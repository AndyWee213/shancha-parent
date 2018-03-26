package com.shancha.admin.service;

import com.github.pagehelper.PageInfo;
import com.shancha.admin.base.BaseService;
import com.shancha.admin.model.SysAdminUser;

/**
 * Created by weiq on 2018/03/26.
 *
 * @author weiq
 */
public interface SysAdminUserService extends BaseService<SysAdminUser> {
    /**
     * 修改密码
     * @param currentUser 当前登录的用户信息
     * @param old_pwd
     * @param new_pwd
     * @return 修改失败返回错误信息，修改成功返回authKey信息。
     */
    String setInfo(SysAdminUser currentUser, String old_pwd, String new_pwd);

    PageInfo<SysAdminUser> getDataList(SysAdminUser record);
}
