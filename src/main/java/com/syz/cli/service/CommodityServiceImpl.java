package com.syz.cli.service;

import com.syz.cli.Dao.CommodityRepository;
import com.syz.cli.entity.Commodity;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl {
    @Autowired
    private CommodityRepository commodityRepository;


    @Autowired
    public ElasticsearchTemplate elasticsearchTemplate;

    public long count() {
        return commodityRepository.count();
    }

    public Commodity save(Commodity commodity) {

        //Commodity commodity = new Commodity();
        //commodity.setSkuId("1501009005");
        //commodity.setName("葡萄吐司面包（10片装）");
        //commodity.setCategory("101");
        //commodity.setPrice(160);
        //commodity.setBrand("良品铺子");
        //
        //IndexQuery indexQuery = new IndexQueryBuilder().withObject(commodity).build();
        //elasticsearchTemplate.index(indexQuery);

        return commodityRepository.save(commodity);
    }

    public void delete(Commodity commodity) {
        commodityRepository.delete(commodity);
        commodityRepository.deleteById(commodity.getSkuId());
    }


    public Iterable<Commodity> getAll() {
        return commodityRepository.findAll();
    }

    public List<Commodity> getByName(String name) {
        List<Commodity> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<Commodity> iterable = commodityRepository.search(matchQueryBuilder);
        iterable.forEach(e -> list.add(e));
        return list;
    }

    public Page<Commodity> pageQuery(Integer pageNo, Integer pageSize, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(pageNo, pageSize))
                .build();
        return commodityRepository.search(searchQuery);
    }
}
