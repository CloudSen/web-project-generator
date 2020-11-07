package com.clouds3n.generator.webprojectgenerator.config.template.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * dynamic datasource settings data-module
 * @author clouds3n
 * @time 2020-11-05 09:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DynamicDatasourceSettings {

    /**
     * default datasource nick name
     */
    @NotBlank(message = "Please specify spring.datasource.dynamic.primary")
    private String primary;

    /**
     * whether use strict mode
     */
    private boolean strict = true;

    /**
     * whether print sql
     */
    private boolean p6spy = false;

    /**
     * common druid settings
     */
    private DruidSettings commonDruidSettings;

    /**
     * multiple datasource settings
     */
    private List<DatasourceSettings> datasourceSettings;

    /**
     * alibaba druid settings data-module
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class DruidSettings {

        /**
         * specify druid filters,separated by comma
         * <p>default is "stat"</p>
         */
        private String filters = "stat";

        /**
         * initial size of connection pool
         * <p>default is 5</p>
         */
        private Integer initialSize = 5;

        /**
         * min idle connection
         * <p>default is 5</p>
         */
        private Integer minIdle = 5;

        /**
         * max wait time ms
         * <p>default is 6s</p>
         */
        private Integer maxWait = 6000;

        /**
         * max active connection
         * <p>default is 20</p>
         */
        private Integer maxActive = 20;

        /**
         * whether test connection status while idle
         * <p>default is true</p>
         */
        private boolean testWhileIdle = true;

        /**
         * whether test connection status on borrow
         * <p>default is false</p>
         */
        private boolean testOnBorrow = false;

        /**
         * whether test connection status on return
         * <p>default is false</p>
         */
        private boolean testOnReturn = false;

        /**
         * whether prepared statements, if use oracle recommend to enable
         * <p>default is true</p>
         */
        private boolean poolPreparedStatements = true;

        /**
         * max prepared statements size per connection
         * <p>default is 100</p>
         */
        private Integer maxPreparedStatementsPerConnectionSize = 100;

        /**
         * used to test connection status
         * <p>if use oracle db, then specify "select 1 from dual".</p>
         */
        private String validationQuery = "select 1 from dual";

        /**
         * test query timeout
         * <p>default is 6s</p>
         */
        private Integer validationQueryTimeout = 6000;

    }

    /**
     * datasource settings data-module
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class DatasourceSettings {
        private String nickName;
        private String username;
        private String password;
        private String url;
        private String driverName;
        private DruidSettings customDruidSettings;
    }
}
