package it.academy.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:datasource.properties")
@ComponentScan("it.academy")
@EnableJpaRepositories(basePackages = "it.academy.repository")
public class DataConfiguration {

    private static final String DATASOURCE_DRIVER = "datasource.driver_class";
    private static final String DATASOURCE_URL = "datasource.url";
    private static final String DATASOURCE_USERNAME = "datasource.username";
    private static final String DATASOURCE_PASSWORD = "datasource.password";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "entitymanager.packages.to.scan";

    @Autowired
    // позволяет читать свойства из property-файла
    private Environment env;

    public DataConfiguration() {
        super();
    }

    @Bean
    public DataSource dataSource(){
        final BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(env.getProperty(DATASOURCE_URL));
        dataSource.setUsername(env.getProperty(DATASOURCE_USERNAME));
        dataSource.setPassword(env.getProperty(DATASOURCE_PASSWORD));
        dataSource.setDriverClassName(env.getProperty(DATASOURCE_DRIVER));
        dataSource.setInitialSize(20);
        dataSource.setMaxTotal(30);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(env.getProperty(ENTITYMANAGER_PACKAGES_TO_SCAN));

        final Properties hibernateProperties = new Properties();
        hibernateProperties.put(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
        hibernateProperties.put(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
        hibernateProperties.put(HIBERNATE_HBM2DDL_AUTO, env.getProperty(HIBERNATE_HBM2DDL_AUTO));

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaProperties(hibernateProperties);
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            final EntityManagerFactory emf){

        final JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }

}
