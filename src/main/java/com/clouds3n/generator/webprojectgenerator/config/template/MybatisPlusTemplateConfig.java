package com.clouds3n.generator.webprojectgenerator.config.template;

import com.clouds3n.generator.webprojectgenerator.config.template.module.CommonSettings;
import com.clouds3n.generator.webprojectgenerator.config.template.module.MavenSettings;
import com.clouds3n.generator.webprojectgenerator.config.template.module.MybatisPlusAutoGeneratorSettings;
import com.clouds3n.generator.webprojectgenerator.config.template.module.MybatisPlusYmlSettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Template config for JAVA
 *
 * @author clouds3n
 * @time 11/3/20 5:27 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MybatisPlusTemplateConfig {

    @Valid
    @NotNull
    private CommonSettings commonSettings;
    @Valid
    @NotNull
    private MavenSettings mavenSettings;
    @Valid
    private MybatisPlusAutoGeneratorSettings mpSettings;
    @Valid
    private MybatisPlusYmlSettings mpYmlSettings;
}
