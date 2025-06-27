package com.sandeep.multi.db.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.sandeep.multi.db.mysql"],
    entityManagerFactoryRef = "mySqlEntityManager",
    transactionManagerRef = "mySqlTransactionManager"
)
class MySqlConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    fun mySqlDataSource(): DataSource = DataSourceBuilder.create().build()

    @Bean
    fun mySqlEntityManager() = LocalContainerEntityManagerFactoryBean().apply {
        dataSource = mySqlDataSource()
        setPackagesToScan("com.sandeep.multi.db.mysql.entity")
        persistenceUnitName = "mysql"
        jpaVendorAdapter = HibernateJpaVendorAdapter()
        setJpaPropertyMap(
            mapOf(
                "hibernate.hbm2ddl.auto" to "update",
                "hibernate.dialect" to "org.hibernate.dialect.MySQLDialect"
            )
        )
    }

    @Bean
    fun mySqlTransactionManager(@Qualifier("mySqlEntityManager") emf: EntityManagerFactory) = JpaTransactionManager(emf)
}