package com.syz.cli.Dao;

import com.syz.cli.entity.Commodity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends ElasticsearchRepository<Commodity, String> {

}