package com.davidmogar.alsa.infraestructure.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.davidmogar.alsa"
})
@EnableTransactionManagement
public class PersistenceContext {

    private static final String[] ENTITY_PACKAGES = {
            "com.davidmogar.alsa.domain"
    };

    private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
    private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DB_URL = "db.url";
    private static final String PROPERTY_NAME_DB_USER = "db.username";
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    /**
     * Creates and configures the HikariCP datasource Bean.
     *
     * @param environment the runtime environment of the application.
     * @return the HikariCP datasource Bean.
     */
    @Bean(destroyMethod = "close")
    DataSource dataSource(Environment environment) {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(environment.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
        dataSourceConfig.setJdbcUrl(environment.getRequiredProperty(PROPERTY_NAME_DB_URL));
        dataSourceConfig.setUsername(environment.getRequiredProperty(PROPERTY_NAME_DB_USER));
        dataSourceConfig.setPassword(environment.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));

        return new HikariDataSource(dataSourceConfig);
    }

    /**
     * Creates the bean that creates the JPA entity manager factory.
     *
     * @param dataSource  the datasource that provides the database connections.
     * @param environment the runtime environment of the application.
     * @return the bean that creates the JPA entity manager factory.
     */
    @Bean(name = "entityManagerFactory")
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, Environment environment) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

        Properties jpaProperties = new Properties();

        /* Configures the used database dialect. This allows Hibernate to create SQL that is optimized for the used
         * database.
         */
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, environment.getRequiredProperty
                (PROPERTY_NAME_HIBERNATE_DIALECT));

        /* Specifies the action that is invoked to the database when the Hibernate SessionFactory is created or closed
        . */
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, environment.getRequiredProperty
                (PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));

        /* Configures the naming strategy that is used when Hibernate creates new database objects and schema
        elements */
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY, environment.getRequiredProperty
                (PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));

        /* If the value of this property is true, Hibernate writes all SQL statements to the console. */
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, environment.getRequiredProperty
                (PROPERTY_NAME_HIBERNATE_SHOW_SQL));

        /* If the value of this property is true, Hibernate will use prettyprint when it writes SQL to the console. */
        jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, environment.getRequiredProperty
                (PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }

    /**
     * Creates the transaction manager bean that integrates the used JPA provider with the Spring transaction mechanism.
     *
     * @param entityManagerFactory the used JPA entity manager factory.
     * @return the new transaction manager.
     */
    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

}
