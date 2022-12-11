package com.bankatm.api;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan(basePackages = "com.bankatm.api.*")
@EnableJpaRepositories(basePackages = "com.bankatm.api.repository")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ApiApplication {

    public static void main(String[] args) {SpringApplication.run(ApiApplication.class, args);}

}
