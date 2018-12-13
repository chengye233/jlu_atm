package jlu.vending.web.controller.buy;

import jlu.vending.entity.Admin;
import jlu.vending.entity.Commodity;
import jlu.vending.service.AdminService;
import jlu.vending.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * 管理商品控制器类
 */
@Controller
@RequestMapping(value = "/manage")
public class ManageCommodityController {
    @Autowired
    private CommodityService commodityService;

    @Autowired
    private AdminService adminService;

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
     * @return manage/main
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String toMainPage(Model model) {
        List<List<Commodity>> commodityLists = commodityService.getTopNCommodity(topN, rowSize, colSize);
        model.addAttribute("commodityLists", commodityLists);
        return "manage/main";
    }

    /**
     * 登陆验证
     *
     * @return 登陆跳转页面
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(
            HttpServletRequest request,
            @RequestParam(value = "userid") String userid,
            @RequestParam(value = "pass") String password,
            Model model)
    {
        String returnPage = "redirect:/manage/main";

        if(!adminService.verifyLogin(userid, password)){
            String errorMessage = "";
            errorMessage = "用户名与密码错误，请尝试重新输入";
            model.addAttribute("errorMessage", errorMessage);
            returnPage = "manage/login";
        }
        Admin admin = adminService.getAdmin(userid);
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);
        return returnPage;
    }


    /**
     * 要修改的商品详细信息
     *
     * @return manage/edit
     */
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String commodityInfo(
            HttpServletRequest request,
            @RequestParam(value = "id") Integer id,
            Model model) {
        if(id == -1){
            model.addAttribute("commodity", new Commodity());
        }
        else{
            Commodity commodity = commodityService.getCommodity(id);
            model.addAttribute("commodity", commodity);
        }
        return "manage/edit";
    }

    /**
     * 提交商品的更改
     *
     * @return manage/edit
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String commodityEdit(
            HttpServletRequest request,
            Commodity commodity,
            @RequestParam(value = "file") MultipartFile file,
            Model model) {

        String fileName = commodity.getName()+commodity.getId()+".jpg";

        if (!file.isEmpty()) {
            try {

                byte[] bytes = file.getBytes();

                // Creating the directory to store file
                String rootPath = "D:/images";
                File dir = new File(rootPath);
                if (!dir.exists())
                    dir.mkdirs();

                // Create the file on server
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + fileName);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (Exception e) {
                String errorMessage = "You failed to upload";
                model.addAttribute("errorMessage",errorMessage);
                model.addAttribute("commodity", commodity);
                return "/manage/edit";
            }
        } else {
            String errorMessage = "You failed to upload";
            model.addAttribute("errorMessage",errorMessage);
            model.addAttribute("commodity", commodity);
            return "/manage/edit";
        }

        commodity.setPicture(fileName);
        commodity.setState(0);

        if(!commodityService.modifyCommodity(commodity)){
            String errorMessage = "更改失败";
            model.addAttribute("errorMessage",errorMessage);
            model.addAttribute("commodity", commodity);
            return "/manage/edit";
        }

        return "redirect:/manage/main";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLoginPage() {
        return "manage/login";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCommodity(
        @RequestParam(value = "id") Integer id,
        Model model
    ) {
        if(!commodityService.deleteCommodity(id)){
            String errorMessage = "删除失败";
            model.addAttribute("errorMessage",errorMessage);
            model.addAttribute("commodity", new Commodity());
            return "/manage/edit";
        }
        return "redirect:/manage/main";
    }
}
