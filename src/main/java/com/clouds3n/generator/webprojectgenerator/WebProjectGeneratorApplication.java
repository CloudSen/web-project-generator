package com.clouds3n.generator.webprojectgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author clouds3n
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebProjectGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProjectGeneratorApplication.class);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
