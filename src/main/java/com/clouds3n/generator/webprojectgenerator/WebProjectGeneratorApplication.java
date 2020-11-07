package com.clouds3n.generator.webprojectgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author clouds3n
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WebProjectGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebProjectGeneratorApplication.class);
    }

}
