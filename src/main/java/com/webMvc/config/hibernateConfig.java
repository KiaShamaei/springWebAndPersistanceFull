//package com.webMvc.config;
//
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.beans.PropertyVetoException;
//import java.io.IOException;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//@PropertySource("classpath:properties-hibernate.properties")
//public class hibernateConfig {
//    @Autowired
//    Environment environment;
//
//    @Bean
//    public DataSource dataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//
//        dataSource.setDriverClass(environment.getProperty("jdbc.driverClassName"));
//        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
//        dataSource.setUser(environment.getProperty("jdbc.username"));
//        dataSource.setPassword(environment.getProperty("jdbc.password"));
//
//        return dataSource;
//    }
//
//    @Bean
//    public SessionFactory hibernateSession() throws IOException, PropertyVetoException {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        sessionFactoryBean.setPackagesToScan("com.webMvc.entity");
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.afterPropertiesSet();
//        return sessionFactoryBean.getObject();
//    }
//
//    public Properties hibernateProperties() {
//
//        Properties props = new Properties();
//        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
//        props.put("hibernate.show_sql", true);
//        props.put("hibernate.format_sql", true);
//        props.put("hibernate.use_sql_comments", true);
//        props.put("hibernate.max_fetch_depth", 3);
//        props.put("hibernate.jdbc.fetch_size", 50);
//        props.put("hibernate.jdbc.batch_size", 500);
//        props.put("hibernate.hbm2ddl.auto", "update");
//        return props;
//
//    }
//
//    @Bean
//    public HibernateTransactionManager hibernateTransactionManager() throws PropertyVetoException, IOException {
//        return  new HibernateTransactionManager(hibernateSession());
//    }
//
//}
