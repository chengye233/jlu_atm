package jlu.vending.service.impl;

import jlu.vending.dao.CommodityDao;
import jlu.vending.entity.Commodity;
import jlu.vending.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link CommodityService}实现类
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    /**
     * 获取商品列表
     * @param topN    topN
     * @param rowSize 行
     * @param colSize 列
     * @return List<List < Commodity>>
     */
    @Override
    public List<List<Commodity>> getTopNCommodity(Integer topN, Integer rowSize, Integer colSize) {
        List<List<Commodity>> commodityLists = new ArrayList<>();
        List<Commodity> commodities = commodityDao.selectTopN(topN);
        for (int i = 0; i < rowSize; i++) {
            List<Commodity> commodityList = new ArrayList<>();
            for (int j = 0; j < colSize && !commodities.isEmpty(); j++) {
                commodityList.add(commodities.remove(0));
            }
            commodityLists.add(commodityList);
        }
        return commodityLists;
    }

    /**
     * 删除商品
     * @param id 商品id
     * @return true: 成功删除; false: 删除失败
     */
    @Override
    public boolean deleteCommodity(Integer id) {
        Integer result = commodityDao.deleteById(id);
        // 根据删除行数判断
        if (result == null || result <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 获取商品
     * @param id 商品id
     * @return {@link Commodity}
     */
    @Override
    public Commodity getCommodity(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        return commodityDao.selectById(id);
    }

    /**
     * 支付
     * @param id    商品id
     * @param money 投币金额
     * @return 结果和找零
     */
    @Override
    public Map<String, Object> pay(Integer id, Double money) {
        Map<String, Object> resultMap = new HashMap<>();
        Boolean result = false;
        Double change = 0.0;
        // 非法
        if (id == null || id <= 0 || money == null || money <= 0) {
            resultMap.put("result", result);
            return resultMap;
        }
        Commodity commodity = commodityDao.selectById(id);
        // 数量或金额不足
        if (commodity.getNumber() <= 0 || money < commodity.getPrice()) {
            resultMap.put("result", result);
            return resultMap;
        }
        commodity.setNumber(commodity.getNumber()-1);
        commodityDao.modifyById(commodity.getId(), commodity);
        result = true;
        change = money - commodity.getPrice();
        resultMap.put("result", result);
        resultMap.put("change", change);
        return resultMap;
    }

    /**
     * 修改商品
     * @param commodity 商品
     * @return 结果和找零
     */
    public boolean modifyCommodity(Commodity commodity){
        if(commodity == null ){
            return false;
        }
        if(commodityDao.selectById(commodity.getId()) == null){
            commodityDao.addCommodity(commodity);
        }
        commodityDao.modifyById(commodity.getId(), commodity);
        return true;
    }
}