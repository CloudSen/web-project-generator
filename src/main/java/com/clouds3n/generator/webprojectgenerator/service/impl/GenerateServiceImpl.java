package com.clouds3n.generator.webprojectgenerator.service.impl;

import com.clouds3n.generator.webprojectgenerator.config.template.MybatisPlusTemplateConfig;
import com.clouds3n.generator.webprojectgenerator.config.template.module.CommonSettings;
import com.clouds3n.generator.webprojectgenerator.service.GenerateService;
import com.clouds3n.generator.webprojectgenerator.service.ProjectGenerator;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

/**
 * @author clouds3n
 * @time 2020-11-06 15:11
 */
@Slf4j
@Service
public class GenerateServiceImpl implements GenerateService {

    private final Configuration freemarker;

    public GenerateServiceImpl(Configuration freemarker) {
        this.freemarker = freemarker;
    }

    @Override
    public void generateProject(MybatisPlusTemplateConfig templateConfig) {
        CommonSettings commonSettings = templateConfig.getCommonSettings();
        ProjectGenerator projectGenerator = commonSettings.getBuildType().getProjectGenerator();
        try {
            projectGenerator.generate(templateConfig, freemarker);
        } catch (Exception e) {
            log.error("[ GENERATOR ] failed to generate project:\n{}", ExceptionUtils.getStackTrace(e));
            throw new RuntimeException(e.getMessage());
        }
    }
}
