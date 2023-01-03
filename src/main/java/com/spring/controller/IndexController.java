package com.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.*;

import java.util.*;

import dao.CommDAO;
import net.jntoo.db.Query;
import com.alibaba.fastjson.*;

/**
 * 首页控制器
 */
@Controller
public class IndexController extends BaseController {

    // 首页
    @RequestMapping(value = {"/", "index"})
    public String Index() {

        ArrayList<HashMap> bhtList = Query.make("lunbotu").order("id desc").limit(5).select();
        assign("bhtList", bhtList);


        ArrayList<HashMap> yiliaofuwulist1 = Query.make("yiliaofuwu").limit(5).order("id desc").select();
        assign("yiliaofuwulist1", yiliaofuwulist1);


        ArrayList<HashMap> shangpinxinxilist2 = Query.make("shangpinxinxi").limit(8).order("id desc").select();
        assign("shangpinxinxilist2", shangpinxinxilist2);


        ArrayList<HashMap> fenxiangqushilist3 = Query.make("fenxiangqushi").limit(8).order("id desc").select();
        assign("fenxiangqushilist3", fenxiangqushilist3);


        ArrayList<HashMap> chongwuzixunlist4 = Query.make("chongwuzixun").limit(4).order("id desc").select();
        assign("chongwuzixunlist4", chongwuzixunlist4);
        if (isAjax()) {
            return json();
        }
        return "index";

    }


}
