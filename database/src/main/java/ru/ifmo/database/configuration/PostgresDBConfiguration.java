package ru.ifmo.database.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.ifmo.database.entity.postgres.*;
import ru.ifmo.database.repository.postgres.PostgresPersonRepository;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = PostgresPersonRepository.class, entityManagerFactoryRef = "postgresDSEmFactory", transactionManagerRef = "postgresDSTransactionManager")
public class PostgresDBConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource2")
    public DataSourceProperties postgresDSProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource postgresDS(@Qualifier("postgresDSProperties") DataSourceProperties postgresDSProperties) {
        return postgresDSProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean postgresDSEmFactory(@Qualifier("postgresDS") DataSource postgresDS, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(postgresDS).packages(
                PostgresDepartment.class,
                PostgresDiscipline.class,
                PostgresGrade.class,
                PostgresPerson.class,
                PostgresUniversity.class).build();
    }

    @Bean
    public PlatformTransactionManager postgresDSTransactionManager(@Qualifier("postgresDSEmFactory") EntityManagerFactory postgresDSEmFactory) {
        return new JpaTransactionManager(postgresDSEmFactory);
    }

}
