package com.syz.cli.init.config;


import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@MapperScan("com.syz.cli.Dao")
public class MybatisPlusConfig {


   @Value("${mybatis-plus.mapper-locations}")
   private String mapperLocations;
   @Value("${mybatis-plus.global-config.refresh-mapper}")
   private Boolean refreshMapper;


   private static final ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();

   /**
    * 分页插件
    * @return
    */
   @Bean
   public PaginationInterceptor paginationInterceptor() {
      return new PaginationInterceptor();
   }

   /**
    * MP XML 热部署
    * @param sqlSessionFactory
    * @return
    */
   @Bean
   public MybatisMapperRefresh mybatisMapperRefresh(SqlSessionFactory sqlSessionFactory){
      Resource[] resources = new Resource[0];
      try {
         resources = resourceResolver.getResources(mapperLocations);
      } catch (IOException e) {
         e.printStackTrace();
      }
      return new MybatisMapperRefresh(resources,sqlSessionFactory,10,20,refreshMapper);
   }
}