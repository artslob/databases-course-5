package ru.ifmo.database.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.ifmo.database.entity.mysql.*;
import ru.ifmo.database.repository.mysql.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = {
                MySQLBookRepository.class,
                MySQLConferenceRepository.class,
                MySQLConferenceParticipantsRepository.class,
                MySQLEditionRepository.class,
                MySQLPersonRepository.class,
                MySQLProjectRepository.class,
                MySQLProjectParticipantsRepository.class,
                MySQLPublicationRepository.class,
                MySQLPublicationCoauthorsRepository.class,
                MySQLReaderListRepository.class
        },
        entityManagerFactoryRef = "mySQLDSEmFactory",
        transactionManagerRef = "mySQLDSTransactionManager")
public class MySQLDBConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource1")
    public DataSourceProperties mySQLDSProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    public DataSource mySQLDS(@Qualifier("mySQLDSProperties") DataSourceProperties mySQLDSProperties) {
        return mySQLDSProperties.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean mySQLDSEmFactory(@Qualifier("mySQLDS") DataSource mySQLDS, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(mySQLDS).packages(
                MySQLBook.class,
                MySQLConference.class,
                MySQLConferenceParticipants.class,
                MySQLConferenceParticipantsPK.class,
                MySQLEdition.class,
                MySQLPerson.class,
                MySQLProject.class,
                MySQLProjectParticipants.class,
                MySQLProjectParticipantsPK.class,
                MySQLPublication.class,
                MySQLPublicationCoauthors.class,
                MySQLPublicationCoauthorsPK.class,
                MySQLReaderList.class
        ).build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager mySQLDSTransactionManager(@Qualifier("mySQLDSEmFactory") EntityManagerFactory mySQLDSEmFactory) {
        return new JpaTransactionManager(mySQLDSEmFactory);
    }

}
