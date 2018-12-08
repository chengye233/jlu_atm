package jlu.vending.dao;

import jlu.vending.BaseTest;
import jlu.vending.entity.Commodity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommodityDaoTest1 extends BaseTest {
    @Autowired
    private CommodityDao commodityDao;

    /**
     * testSelectTopN
     */
    @Test
    public void testSelectTopN() {
        List<Commodity> commodityList = commodityDao.selectTopN(8);
        for (Commodity commodity : commodityList) {
            System.out.println(commodity);
        }
    }

    /**
     * testSelectById
     */
    @Test
    public void testSelectById() {
        Commodity commodity = commodityDao.selectById(6);
        System.out.println(commodity);
    }

    /**
     * testDeleteById
     */
    @Test
    public void testDeleteById() {
        int count = commodityDao.deleteById(7);
        System.out.println(count);
    }
}