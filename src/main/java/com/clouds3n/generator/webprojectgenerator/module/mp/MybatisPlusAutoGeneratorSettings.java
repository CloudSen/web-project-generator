package com.clouds3n.generator.webprojectgenerator.module.mp;

import com.baomidou.mybatisplus.annotation.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * mybatis-plus 生成器配置
 *
 * @author clouds3n
 * @time 11/4/20 11:17 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MybatisPlusAutoGeneratorSettings {
    /**
     * 是否启用lombok语法
     * <p>默认为true</p>
     */
    private boolean enableLombok = true;
    /**
     * 是否启用builder模式
     * <p>默认为true</p>
     */
    private boolean enableChain = true;
    /**
     * 是否启用Rest风格的controller
     * <p>默认为true</p>
     */
    private boolean enableRestController = true;
    /**
     * 指定生成代码的数据源
     */
    @Valid
    @NotNull(message = "Please specify datasource for mybatis plus generator")
    private DynamicDatasourceSettings.DatasourceSettings datasource;
    /**
     * 输出代码路径
     * <p>默认为"src/main/java/"</p>
     */
    private String outputPath = "src/main/java/";
    /**
     * 输出父包名
     * <p>默认为"maven设置中的PackageName"</p>
     */
    @NotBlank(message = "Please specify parent package")
    private String parentPackage;
    /**
     * 模块名
     */
    private String moduleName;
    /**
     * xml mapper生成路径
     * <p>默认为"src/main/resources/mapper/"</p>
     */
    private String sqlXmlLocation = "src/main/resources/mapper/";
    /**
     * 代码作者
     */
    @NotBlank(message = "Please specify coder name")
    private String author;
    /**
     * ID生成策略
     * <p>默认为32-UUID</p>
     */
    private IdType idType = IdType.ASSIGN_UUID;
    /**
     * 忽略的表名前缀，多个用逗号分割
     */
    private String[] tablePrefix = new String[]{"T_"};
    /**
     * 需要生成的表，多个用逗号分割
     */
    @NotBlank(message = "Please specify tables separated by comma")
    private String needGenerateTables;
}
