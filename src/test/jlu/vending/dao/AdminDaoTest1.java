package jlu.vending.dao;

import jlu.vending.BaseTest;
import jlu.vending.entity.Admin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class AdminDaoTest1 extends BaseTest {
    @Autowired
    private AdminDao adminDao;

    @Autowired
    PlatformTransactionManager transactionManager;



    /**
     * testInsertAdmin
     */
    @Test
    public void testInsertAdmin() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try{
          Admin admin = new Admin();
          admin.setName("dog f");
          admin.setPassword("wangwang");
          adminDao.insertAdmin(admin);
          assertEquals(6, (long) admin.getId());
        } finally {
            transactionManager.rollback(status);
        }
    }

    @Test
    public void testSelectAdmin() {
        Admin admin = adminDao.selectByName("maple");
        assertEquals("123456", admin.getPassword());
    }

}