package jlu.vending.dao;

import jlu.vending.entity.Commodity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * commodity表的操作类{@link CommodityDao}
 *
 */
public interface CommodityDao {

    /**
     * 通过id删{@link Commodity}商品
     * @param id 主键
     * @return Integer 删除的数目
     */
    Integer deleteById(@Param("id") Integer id);


    /**
     * 选择前topN个{@link Commodity}商品
     * @param topN 前n个
     * @return {@link List<Commodity>}商品列表
     */
    List<Commodity> selectTopN(@Param("topN") Integer topN);

    /**
     * 用id查
     * @param id 商品id
     * @return {@link Commodity}商品
     */
    Commodity selectById(@Param("id") Integer id);
}