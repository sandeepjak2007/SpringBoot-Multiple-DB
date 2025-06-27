package com.sandeep.multi.db.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.sandeep.multi.db.postgres"],
    entityManagerFactoryRef = "postgresEntityManager",
    transactionManagerRef = "postgresTransactionManager"
)
class PostgresConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    fun postgresDataSource(): DataSource = DataSourceBuilder.create().build()

    @Bean
    @Primary
    fun postgresEntityManager() = LocalContainerEntityManagerFactoryBean().apply {
        dataSource = postgresDataSource()
        setPackagesToScan("com.sandeep.multi.db.postgres.entity")
        persistenceUnitName = "postgres"
        jpaVendorAdapter = HibernateJpaVendorAdapter()
        setJpaPropertyMap(
            mapOf(
                "hibernate.hbm2ddl.auto" to "update",
                "hibernate.dialect" to "org.hibernate.dialect.PostgreSQLDialect"
            )
        )
    }

    @Bean
    @Primary
    fun postgresTransactionManager(@Qualifier("postgresEntityManager") emf: EntityManagerFactory) =
        JpaTransactionManager(emf)
}