package jlu.vending.web.controller.buy;

import jlu.vending.entity.Commodity;
import jlu.vending.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 购买商品控制器类
 */
@Controller
@RequestMapping(value = "/buy")
public class BuyCommodityController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 商品列表数量
     */
    private Integer topN = 13;

    /**
     * 每列5个
     */
    private Integer colSize = 5;

    /**
     * 共3行
     */
    private Integer rowSize = 3;


    /**
     * 跳转到主页
     *
     * @return buy/main
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String toMainPage(Model model) {
        List<List<Commodity>> commodityLists = commodityService.getTopNCommodity(topN, rowSize, colSize);
        // TODO: commodityList null redirect
        model.addAttribute("commodityLists", commodityLists);
        return "buy/main";
    }

    /**
     * 要购买的商品详细信息
     *
     * @return buy/info
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String commodityInfo(
            HttpServletRequest request,
            @RequestParam(value = "id") Integer id,
            Model model) {
        Commodity commodity = commodityService.getCommodity(id);
        // TODO commodity null redirect
        model.addAttribute("commodity", commodity);
        return "buy/info";
    }

    /**
     * 支付并跳转购物结果
     *
     * @return buy/success || buy/failure
     */
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String buyCommodity(HttpServletRequest request, Model model,
                               @RequestParam("id") Integer id, @RequestParam("money") Double money) {
        Map<String, Object> resultMap = commodityService.pay(id, money);
        boolean result = (boolean) resultMap.get("result");
        if (result) {
            double change = (double) resultMap.get("change");
            model.addAttribute("change", change);
            return "buy/success";
        }
        model.addAttribute("money", money);
        return "buy/failure";
    }
}
