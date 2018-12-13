package jlu.vending.service.impl;

import jlu.vending.dao.AdminDao;
import jlu.vending.entity.Admin;
import jlu.vending.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {@link AdminService}实现类
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    /**
     * 获取管理员信息
     * @param name    管理员信息
     * @return Admin
     */
    @Override
    public Admin getAdmin(String name){
        if(name == null){
            return null;
        }
        return adminDao.selectByName(name);
    }

    /**
     * 验证用户名密码
     */
    @Override
    public boolean verifyLogin(String name, String password){
        if(name == null || password == null){
            return false;
        }

        Admin admin = this.getAdmin(name);
        if(admin != null && (password.equals(admin.getPassword()))){
            return true;
        }
        return false;
    }

}
