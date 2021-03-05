package it.academy.config;

import com.mysql.cj.jdbc.Driver;
import it.academy.model.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("it.academy")
@EnableTransactionManagement
@Profile("test")
public class TestDataBaseConfig {

    private static final String DATASOURCE_URL =
            "jdbc:mysql://localhost:3306/test_doc_management?serverTimezone=UTC&createDatabaseIfNotExist=true";
    private static final String DATASOURCE_USERNAME = "root";
    private static final String DATASOURCE_PASSWORD = "root";
    private static final String HIBERNATE_DIALECT = "org.hibernate.dialect.MySQL57Dialect";
    private static final String HIBERNATE_SHOW_SQL = "true";
    private static final String HIBERNATE_HBM2DDL_AUTO = "create-drop";
    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "it.academy.model";

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(DATASOURCE_URL);
        dataSource.setUsername(DATASOURCE_USERNAME);
        dataSource.setPassword(DATASOURCE_PASSWORD);
        dataSource.setDriverClassName(Driver.class.getName());
        dataSource.setInitialSize(20);
        dataSource.setMaxTotal(30);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactoryBean =
                new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

        Properties properties = new Properties();
        properties.put("hibernate.dialect", HIBERNATE_DIALECT);
        properties.put("hibernate_show_sql", HIBERNATE_SHOW_SQL);
        properties.put("hibernate_hbm2ddl_auto", HIBERNATE_HBM2DDL_AUTO);
        sessionFactoryBean.setHibernateProperties(properties);
        return sessionFactoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
        return new HibernateTransactionManager(sessionFactory);
    }

}
