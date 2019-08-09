package com.syz.cli.controller;

import com.alibaba.fastjson.JSON;
import com.syz.cli.entity.Commodity;
import com.syz.cli.service.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author syz
 * @Version 1.0
 * @Create 2019-07-25 15:02
 **/
@RestController
@RequestMapping("es")
public class EsController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("count")
    public Long count() {
        return commodityService.count();
    }

    @RequestMapping("save")
    public String  save() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009001");
        commodity.setName("原味切片面包（10片装）");
        commodity.setCategory("101");
        commodity.setPrice(880);
        commodity.setBrand("良品铺子");
        System.out.println(JSON.toJSON(commodity));
        commodityService.save(commodity);

        commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodity.setName("原味切片面包（6片装）");
        commodity.setCategory("101");
        commodity.setPrice(680);
        commodity.setBrand("良品铺子");
        commodityService.save(commodity);
        commodity = new Commodity();
        commodity.setSkuId("1501009004");
        commodity.setName("元气吐司850g");
        commodity.setCategory("101");
        commodity.setPrice(120);
        commodity.setBrand("百草味");
        commodityService.save(commodity);
        return "成功";
    }

    @RequestMapping("delete")
    public String  delete() {
        Commodity commodity = new Commodity();
        commodity.setSkuId("1501009002");
        commodityService.delete(commodity);
        return "成功";
    }

    @RequestMapping("getAll")
    public Iterable  getAll() {
        Iterable<Commodity> iterable = commodityService.getAll();
        return iterable;
    }

    @RequestMapping("getByName")
    public List<Commodity> getByName() {
        List<Commodity> list = commodityService.getByName("面包");
        return list;
    }

    @RequestMapping("page")
    public Page page() {
        Page<Commodity> page = commodityService.pageQuery(0, 10, "切片");
        return page;
    }






}
