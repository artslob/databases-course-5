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
import ru.ifmo.database.entity.union.*;
import ru.ifmo.database.repository.union.*;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = {
                UnionDepartmentRepository.class,
                UnionDisciplineRepository.class,
                UnionEducationRepository.class,
                UnionGradeRepository.class,
                UnionPersonRepository.class,
                UnionSpecialityRepository.class,
                UnionUniversityRepository.class,
                UnionWorkRepository.class,
                UnionWorkDisciplineRepository.class,
                UnionScheduleRepository.class,
                UnionReaderListRepository.class,
                UnionBookRepository.class,
                UnionReaderInfoRepository.class,
                UnionConferenceRepository.class,
                UnionConferenceParticipantsRepository.class,
                UnionProjectRepository.class,
                UnionProjectParticipantsRepository.class,
                UnionPublicationRepository.class,
                UnionPublicationCoauthorsRepository.class,
                UnionEditionRepository.class
        },
        entityManagerFactoryRef = "unionDSEmFactory",
        transactionManagerRef = "unionDSTransactionManager"
)
public class UnionDBConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource4")
    public DataSourceProperties unionDSProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource unionDS(@Qualifier("unionDSProperties") DataSourceProperties unionDSProperties) {
        return unionDSProperties.initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean unionDSEmFactory(@Qualifier("unionDS") DataSource unionDS, EntityManagerFactoryBuilder builder) {
        return builder.dataSource(unionDS).packages(
                UnionAccommodation.class,
                UnionBook.class,
                UnionConference.class,
                UnionConferenceParticipants.class,
                UnionConferenceParticipantsPK.class,
                UnionDepartment.class,
                UnionDiscipline.class,
                UnionDisinfection.class,
                UnionEdition.class,
                UnionEducation.class,
                UnionGrade.class,
                UnionHostel.class,
                UnionPerson.class,
                UnionProject.class,
                UnionProjectParticipants.class,
                UnionProjectParticipantsPK.class,
                UnionPublication.class,
                UnionPublicationCoauthors.class,
                UnionPublicationCoauthorsPK.class,
                UnionReaderInfo.class,
                UnionReaderList.class,
                UnionRoom.class,
                UnionSchedule.class,
                UnionSpeciality.class,
                UnionUniversity.class,
                UnionVisit.class,
                UnionWarning.class,
                UnionWork.class,
                UnionWorkDiscipline.class,
                UnionWorkDisciplinePK.class
        ).build();
    }

    @Bean
    public PlatformTransactionManager unionDSTransactionManager(@Qualifier("unionDSEmFactory") EntityManagerFactory unionDSEmFactory) {
        return new JpaTransactionManager(unionDSEmFactory);
    }

}
