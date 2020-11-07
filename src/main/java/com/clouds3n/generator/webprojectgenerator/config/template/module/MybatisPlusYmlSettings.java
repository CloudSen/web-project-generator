package com.clouds3n.generator.webprojectgenerator.config.template.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * java yml configuration settings for mybatis-plus + dynamic datasource
 * @author clouds3n
 * @time 2020-11-05 10:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MybatisPlusYmlSettings {

    /**
     * running port
     */
    @NotBlank(message = "Please specify the project running port")
    private String port;

    /**
     * used for spring.application.name
     */
    @NotBlank(message = "Please specify application name")
    private String appName;

    /**
     * used for spring.profiles.active
     */
    @NotBlank(message = "Please specify active profile")
    private String activeProfile;

    /**
     * used for different spring environments(dev,test,prod,etc.)
     */
    @Valid
    private List<YmlEnvironment> environments;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class YmlEnvironment {

        /**
         * used for spring.profiles
         */
        @NotBlank(message = "Please specify spring.profiles")
        private String profileName;
        /**
         * used for <code>spring.datasource.dynamic</code>
         */
        @Valid
        private DynamicDatasourceSettings dynamicDatasourceSettings;

        /**
         * used for <code>config.starter</code>
         */
        @Valid
        private MyStarterSettings myStarterSettings;
    }
}
