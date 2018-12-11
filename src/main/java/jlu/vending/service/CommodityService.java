package jlu.vending.service;

import jlu.vending.entity.Commodity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品操作Service类
 * 连接Controller与Dao
 */
public interface CommodityService {

    /**
     * 获取商品列表
     * @param topN topN
     * @param rowSize 行
     * @param colSize 列
     * @return List<List<Commodity>>
     */
    List<List<Commodity>> getTopNCommodity(Integer topN, Integer rowSize, Integer colSize);

    /**
     * 删除商品
     * @param id 商品id
     * @return true: 成功删除; false: 删除失败
     */
    boolean deleteCommodity(Integer id);

    /**
     * 获取商品
     * @param id 商品id
     * @return {@link Commodity}
     */
    Commodity getCommodity(Integer id);
}
