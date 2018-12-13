package jlu.vending.service;

import jlu.vending.entity.Admin;

/**
 * 管理员Service类
 * 连接Controller与Dao
 */
public interface AdminService {
    /**
     * 通过用户名获取管理员
     */
    Admin getAdmin(String name);

    /**
     * 验证用户名密码
     */
    boolean verifyLogin(String name, String password);

}