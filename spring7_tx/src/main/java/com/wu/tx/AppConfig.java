package com.wu.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-11 20:50
 */

@Configuration
@ComponentScan(basePackages = {"com.wu.tx"})
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        DataSource ds = new ComboPooledDataSource();
        ((ComboPooledDataSource) ds).setDriverClass("com.mysql.cj.jdbc.Driver");
        ((ComboPooledDataSource) ds).setJdbcUrl("jdbc:mysql://127.0.0.1:3306/testBank?useUnicode=true&characterEncoding=UTF-8&useSSL=true&serverTimezone=UTC");
        ((ComboPooledDataSource) ds).setUser("root");
        ((ComboPooledDataSource) ds).setPassword("Wl123456");
        return ds;
    }

    //创建事务管理器（注入数据源）
    @Bean
    public TransactionManager DataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
