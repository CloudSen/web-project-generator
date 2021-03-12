package com.clouds3n.generator.webprojectgenerator.module.mp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * dynamic datasource settings data-module
 *
 * @author clouds3n
 * @time 2020-11-05 09:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class DynamicDatasourceSettings {

    /**
     * 默认数据源，指定别名
     */
    @NotBlank(message = "Please specify spring.datasource.dynamic.primary")
    private String primary;

    /**
     * 是否使用严格模式
     */
    private boolean strict = true;

    /**
     * 是否打印sql
     */
    private boolean p6spy = false;

    /**
     * 全局Druid设置
     */
    private DruidSettings commonDruidSettings;

    /**
     * 数据源设置列表
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
         * 指定过滤器，以逗号分割
         * <p>默认为"stat"</p>
         */
        private String filters = "stat";
        /**
         * 连接池初始化大小
         * <p>默认为5</p>
         */
        private Integer initialSize = 5;
        /**
         * 最小空闲连接数
         * <p>默认为5</p>
         */
        private Integer minIdle = 5;
        /**
         * 最长等待时间
         * <p>默认为6s</p>
         */
        private Integer maxWait = 6000;
        /**
         * 最大连接数
         * <p>默认为20</p>
         */
        private Integer maxActive = 20;
        /**
         * 是否在Borrow时执行数据库连接状态测试
         * <p>默认为true</p>
         */
        private boolean testWhileIdle = true;
        /**
         * 是否在空闲时执行数据库连接状态测试
         * <p>默认为false</p>
         */
        private boolean testOnBorrow = false;
        /**
         * 是否在返回时执行数据库连接状态测试
         * <p>默认为false</p>
         */
        private boolean testOnReturn = false;
        /**
         * 是否预处理语句，若是Oracle则设置为true
         * <p>默认为true</p>
         */
        private boolean poolPreparedStatements = true;
        /**
         * 每个连接最大预处理语句数
         * <p>默认为50</p>
         */
        private Integer maxPreparedStatementsPerConnectionSize = 50;
        /**
         * 用于测试数据库连接状态
         * <p>Oracle: "select 1 from dual".</p>
         * <p>Mysql: "SELECT 1"</p>
         * <p>SQLSERVER: "SELECT 1"</p>
         * <p>ORACLE: "SELECT 'x' FROM DUAL"</p>
         * <p>Postgre: "SELECT 'x'"</p>
         */
        private String validationQuery = "select 1 from dual";
        /**
         * 测试语句超时时间
         * <p>默认为6s</p>
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
        /**
         * 数据库别名
         */
        private String nickName;
        /**
         * 用户名
         */
        private String username;
        /**
         * 密码
         */
        private String password;
        /**
         * 连接地址
         */
        private String url;
        /**
         * 驱动名
         */
        private String driverName;
        /**
         * druid设置（覆盖全局）
         */
        private DynamicDatasourceSettings.DruidSettings customDruidSettings;
    }
}
