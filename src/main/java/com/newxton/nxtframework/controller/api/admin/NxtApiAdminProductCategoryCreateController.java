package com.newxton.nxtframework.controller.api.admin;

import com.newxton.nxtframework.entity.NxtProductCategory;
import com.newxton.nxtframework.service.NxtProductCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author soyojo.earth@gmail.com
 * @time 2020/7/23
 * @address Shenzhen, China
 * @copyright NxtFramework
 */
@RestController
public class NxtApiAdminProductCategoryCreateController {

    @Resource
    private NxtProductCategoryService nxtProductCategoryService;

    @RequestMapping(value = "/api/admin/product_category/create", method = RequestMethod.POST)
    public Map<String, Object> index(@RequestParam(value = "category_name", required=false) String categoryName,
                                     @RequestParam(value = "category_pid", required=false) Long categoryPid
    ) {

        Map<String, Object> result = new HashMap<>();
        result.put("status", 0);
        result.put("message", "");

        if (categoryName == null) {
            result.put("status", 52);
            result.put("message", "参数错误");
            return result;
        }

        if (categoryPid == null){
            categoryPid = 0L;
        }

        if (categoryPid > 0){
            NxtProductCategory parentCategory = nxtProductCategoryService.queryById(categoryPid);
            if (parentCategory == null){
                result.put("status", 47);
                result.put("message", "没有对应的上级分类");
                return result;
            }
        }

        NxtProductCategory newCategory = new NxtProductCategory();
        newCategory.setCategoryName(categoryName.trim());
        newCategory.setCategoryPid(categoryPid);

        //增加
        NxtProductCategory categoryCreated = nxtProductCategoryService.insert(newCategory);

        if (categoryCreated.getId() == null){
            result.put("status", 50);
            result.put("message", "系统错误");
            return result;
        }

        result.put("category",categoryCreated);

        return result;

    }

}
