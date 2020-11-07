package com.clouds3n.generator.webprojectgenerator.config.template.module;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * mybatis-plus auto generator settings data-module
 * @author clouds3n
 * @time 11/4/20 11:17 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MybatisPlusAutoGeneratorSettings {
    /**
     * whether to use lombok plugin
     * <p>default is true</p>
     */
    private boolean enableLombok = true;
    /**
     * whether to use builder pattern
     * <p>default is true</p>
     */
    private boolean enableChain = true;
    /**
     * whether to use restful controller
     * <p>default is true</p>
     */
    private boolean enableRestController = true;
    /**
     * generate code from which db
     */
    private DynamicDatasourceSettings.DatasourceSettings datasource;
    /**
     * output to which path
     * <p>default is "src/main/java/"</p>
     */
    private String outputPath = "src/main/java/";
    /**
     * output to which package
     * <p>default is "mavenPackageName"</p>
     */
    private String parentPackage;
    /**
     * xml mapper location
     * <p>default is "src/main/resources/mapper/"</p>
     */
    private String sqlXmlLocation = "src/main/resources/mapper/";
    /**
     * code author
     */
    private String author;
    /**
     * ID generate strategy
     * <p>default is 32-UUID</p>
     */
    private IdType idType = IdType.ASSIGN_UUID;
    /**
     * specify table prefix to ignore
     */
    private String[] tablePrefix = new String[]{"T_"};
    /**
     * what tables u want to generate, separated by comma
     */
    private String needGenerateTables;
    /**
     * module name
     */
    private String moduleName;
}
