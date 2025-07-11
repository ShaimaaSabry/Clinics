package shaimaa.clinics.slots.internal.repository;

import jakarta.persistence.EntityManagerFactory;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.doctor.booking_appointment.slots", // ✅ your repository package
        entityManagerFactoryRef = "slotsEntityManagerFactory",
        transactionManagerRef = "slotsTransactionManager"
)
public class SlotsDbConfig {

    @Primary
    @Bean(name = "slotsDataSource")
    @ConfigurationProperties("spring.datasource.slots")
    DataSource slotsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean slotsEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("slotsDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.doctor.booking_appointment.slots") // ✅ your entity package
                .persistenceUnit("slots")
                .build();
    }

    @Primary
    @Bean
    public PlatformTransactionManager slotsTransactionManager(
            @Qualifier("slotsEntityManagerFactory") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    @Bean(initMethod = "migrate")
    public Flyway slotsFlyway(@Qualifier("slotsDataSource") DataSource dataSource) {
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration/slots")
                .load();
    }
}
