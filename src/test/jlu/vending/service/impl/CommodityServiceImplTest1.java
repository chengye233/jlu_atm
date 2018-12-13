package jlu.vending.service.impl;

import jlu.vending.BaseTest;
import jlu.vending.entity.Commodity;
import jlu.vending.service.CommodityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CommodityServiceImplTest1 extends BaseTest {

    @Autowired
    private CommodityService commodityService;

    @Test
    public void getTopNCommodity() {
        List<List<Commodity>> cs = commodityService.getTopNCommodity(13, 3, 5);
        for (int i = 0; i < cs.size(); i++) {
            for (int j = 0; j < cs.get(i).size(); j++) {
                System.out.print(cs.get(i).get(j).getName() +"\t");
            }
            System.out.println();
        }
    }

    @Test
    public void deleteCommodity() {
    }

    @Test
    public void getCommodity() {
    }
}