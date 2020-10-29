package top.fuyuaaa.jtaatomikossample.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author : fuyuaaa
 * @date : 2020-10-29 15:22
 */
@Configuration
@MapperScan(basePackages = "top.fuyuaaa.jtaatomikossample.mapper.order", sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDatasourceConfig {
    @Autowired
    @Qualifier("orderDataSource")
    private DataSource ds;

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(ds);
        //指定mapper xml目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mapper/order/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate orderSqlSessionTemplate() throws Exception {
        // 使用上面配置的Factory
        return new SqlSessionTemplate(orderSqlSessionFactory());
    }
}
