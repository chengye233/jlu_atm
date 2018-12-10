package jlu.vending.dao;

import jlu.vending.entity.Admin;

/**
 * admin表的操作类{@link AdminDao}
 *
 */
public interface AdminDao {

    /**
     * 插入{@link Admin}管理员
     * @param admin 要插入的管理员
     * @return Integer 插入的管理员id
     */
    Integer insertAdmin(Admin admin);
}