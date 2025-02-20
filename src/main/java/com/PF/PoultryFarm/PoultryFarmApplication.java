package com.PF.PoultryFarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import javax.sql.DataSource;


@SpringBootApplication(scanBasePackages = "com.PF.PoultryFarm")
@EnableJpaRepositories(basePackages = "com.PF.PoultryFarm.dao")
@EntityScan(basePackages = "com.PF.PoultryFarm.entity")
public class PoultryFarmApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoultryFarmApplication.class, args);
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.PF.PoultryFarm.entity")  // Ensure this is your
				// entity package
				.persistenceUnit("poultry_farm")
				.build();
	}

}
