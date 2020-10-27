package com.example.multisource.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.multisource.model.Student;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.multisource.repository.student",
        entityManagerFactoryRef = "dbStudentEntityManagerFactory"
)
public class DBStudentConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dbStudentDataSourceProperties() {

        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "dbStudentDataSource")
    @ConfigurationProperties("spring.datasource.configuration")
    public DataSource dbStudentDataSource() {

        return dbStudentDataSourceProperties().initializeDataSourceBuilder()
                .type(BasicDataSource.class).build();
    }

    @Primary
    @Bean(name = "dbStudentEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean dbVisEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {

        return builder
                .dataSource(dbStudentDataSource())
                .packages(Student.class)
                .build();
    }
}
