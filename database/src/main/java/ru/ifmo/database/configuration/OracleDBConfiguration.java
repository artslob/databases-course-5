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
import ru.ifmo.database.entity.oracle.*;
import ru.ifmo.database.repository.oracle.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = {
                OracleDepartmentRepository.class,
                OracleDisciplineRepository.class,
                OracleEducationRepository.class,
                OracleGradeRepository.class,
                OraclePersonRepository.class,
                OracleScheduleRepository.class,
                OracleSpecialityRepository.class,
                OracleWorkDisciplineRepository.class,
                OracleWorkRepository.class
        },
        entityManagerFactoryRef = "oracleDSEmFactory",
        transactionManagerRef = "oracleDSTransactionManager"
)
public class OracleDBConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource3")
    public DataSourceProperties oracleDSProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource oracleDS(@Qualifier("oracleDSProperties") DataSourceProperties oracleDSProperties) {
        return oracleDSProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean oracleDSEmFactory(@Qualifier("oracleDS") DataSource oracleDS, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(oracleDS).packages(
                OracleDepartment.class,
                OracleDiscipline.class,
                OracleEducation.class,
                OracleGrade.class,
                OraclePerson.class,
                OracleSchedule.class,
                OracleSpeciality.class,
                OracleWork.class,
                OracleWorkDiscipline.class,
                OracleWorkDisciplinePK.class
        ).build();
    }

    @Bean
    public PlatformTransactionManager oracleDSTransactionManager(@Qualifier("oracleDSEmFactory") EntityManagerFactory oracleDSEmFactory) {
        return new JpaTransactionManager(oracleDSEmFactory);
    }

}
