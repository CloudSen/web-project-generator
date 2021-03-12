package com.clouds3n.generator.webprojectgenerator.module.mp;

import com.clouds3n.generator.webprojectgenerator.module.CommonSettings;
import com.clouds3n.generator.webprojectgenerator.module.mvn.MavenSettings;
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
    @NotNull
    private MybatisPlusAutoGeneratorSettings mpSettings;
    @Valid
    @NotNull
    private MybatisPlusYmlSettings mpYmlSettings;
}
