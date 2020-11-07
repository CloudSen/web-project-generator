package com.clouds3n.generator.webprojectgenerator.service;

import com.clouds3n.generator.webprojectgenerator.config.template.MybatisPlusTemplateConfig;

/**
 * @author clouds3n
 * @time 2020-11-06 15:10
 */
public interface GenerateService {
    /**
     * start generate project
     * @param templateConfig template config for freemarker
     */
    void generateProject(MybatisPlusTemplateConfig templateConfig);
}
