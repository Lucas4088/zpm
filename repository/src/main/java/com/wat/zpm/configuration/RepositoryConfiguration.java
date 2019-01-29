package com.wat.zpm.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.wat.zpm.repository",
})
@EnableTransactionManagement
@ComponentScan
/*@EntityScan(basePackages = {
        "com.wat.zpm.repository",
        "com.wat.zpm.repository.user",
        "com.wat.zpm.repository.address"
})*/
public class RepositoryConfiguration {

}
