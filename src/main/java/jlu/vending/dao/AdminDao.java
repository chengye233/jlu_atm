package jlu.vending.dao;

import jlu.vending.entity.Admin;

/**
 * admin表的操作类{@link AdminDao}
 *
 */
public interface AdminDao {
    /**
     * 通过id查询{@link Admin}管理员
     * @param id 要查询的管理员id
     * @return Admin 返回的管理员对象
     */
    Admin selectById(Integer id);

    /**
     * 通过用户名查询{@link Admin}管理员
     * @param name 要查询的管理员id
     * @return Admin 返回的管理员对象
     */
    Admin selectByName(String name);
    
    /**
     * 插入{@link Admin}管理员
     * @param admin 要插入的管理员
     * @return Integer 插入的管理员id
     */
    Integer insertAdmin(Admin admin);
}