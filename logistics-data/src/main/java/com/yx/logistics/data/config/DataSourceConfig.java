package com.yx.logistics.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * author : Guo LiXiao
 * date : 2017-6-1  12:10
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value={"classpath:db.properties"})
public class DataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${jdbc_url}")
    private String url;

    @Value("${jdbc_username}")
	private String username;

    @Value("${jdbc_password}")
	private String password;

	@Value("${druid_initialSize}")
	private Integer initialSize;

	@Value("${druid_minIdle}")
	private Integer minIdle;

	@Value("${druid_maxActive}")
	private Integer maxActive;

	@Value("${druid_maxWait}")
	private Long maxWait;

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
		dataSource.setPassword(password);
		//配置初始化大小、最小、最大
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
		dataSource.setMaxActive(maxActive);

		//配置获取连接等待超时的时间
        dataSource.setMaxWait(maxWait);
		dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);

		dataSource.setPoolPreparedStatements(true);
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(100);
       /* try {
            dataSource.setFilters("config");
            Properties properties = new Properties();
            properties.setProperty("config.decrypt", "true");
            dataSource.setConnectProperties(properties);
        } catch (SQLException e) {
            log.error("datasource init failed", e);
        }*/
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setConfigLocation(new ClassPathResource("sqlMapConfig.xml"));
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:com/yx/logistics/data/*/mapper/*Mapper.xml"));
		//sessionFactory.setTypeAliasesPackage("com.yx.logistics.*.domain");
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        sessionFactory.setConfigurationProperties(properties);
        return sessionFactory.getObject();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
