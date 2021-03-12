package com.clouds3n.generator.webprojectgenerator.service.impl;

import com.clouds3n.generator.webprojectgenerator.config.properties.SystemProperties;
import com.clouds3n.generator.webprojectgenerator.module.mp.MybatisPlusTemplateConfig;
import com.clouds3n.generator.webprojectgenerator.module.CommonSettings;
import com.clouds3n.generator.webprojectgenerator.module.mvn.MavenSettings;
import com.clouds3n.generator.webprojectgenerator.service.ProjectGenerator;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * @author clouds3n
 * @time 2020-11-06 15:11
 */
@Slf4j
@Service
public class MavenProjectGenerator implements ProjectGenerator {

    private final Configuration freemarker;
    private final RestTemplate restTemplate;
    private final SystemProperties systemProperties;

    public MavenProjectGenerator(
        Configuration freemarker,
        RestTemplate restTemplate,
        SystemProperties systemProperties
    ) {
        this.freemarker = freemarker;
        this.restTemplate = restTemplate;
        this.systemProperties = systemProperties;
    }

    @Override
    public void generate(MybatisPlusTemplateConfig templateConfig) throws IOException {
        createPath(templateConfig);
        createProjectFiles(templateConfig);
    }

    private void createPath(MybatisPlusTemplateConfig templateConfig) throws IOException {
        CommonSettings commonSettings = templateConfig.getCommonSettings();
        MavenSettings mavenSettings = templateConfig.getMavenSettings();

        //region project path
        Path rootPath = Path.of(OUTPUT_PATH + com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToHyphen(commonSettings.getProjectName()));
        Path javaPath = Path.of(rootPath + File.separator + JAVA_PATH);
        Path resPath = Path.of(rootPath + File.separator + RES_PATH);
        Path testPath = Path.of(rootPath + File.separator + TEST_PATH);
        Path packagePath = Path.of(javaPath + File.separator + mavenSettings.getPackageName().replaceAll("\\.", "/"));
        //endregion

        //region .gitkeep files
        Path rootKeepPath = Path.of(rootPath + File.separator + GIT_KEEP_FILE);
        Path srcKeepPath = Path.of(rootPath + File.separator + SRC_KEEP_PATH);
        Path packageKeepPath = Path.of(packagePath + File.separator + GIT_KEEP_FILE);
        Path resKeepPath = Path.of(resPath + File.separator + GIT_KEEP_FILE);
        Path testKeepPath = Path.of(testPath + File.separator + GIT_KEEP_FILE);
        //endregion

        List<Path> paths = Arrays.asList(
            rootPath, javaPath, resPath, testPath, packagePath
        );
        List<Path> files = Arrays.asList(
            rootKeepPath, srcKeepPath, packageKeepPath, resKeepPath, testKeepPath
        );
        for (Path path : paths) {
            Files.createDirectories(path);
        }
        for (Path file : files) {
            Files.createFile(file);
        }
    }

    private void createProjectFiles(MybatisPlusTemplateConfig templateConfig) throws IOException {
        CommonSettings commonSettings = templateConfig.getCommonSettings();
        MavenSettings mavenSettings = templateConfig.getMavenSettings();
        Path rootPath = Path.of(OUTPUT_PATH + com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToHyphen(commonSettings.getProjectName()));
        Path editorConfigPath = Path.of(EDITOR_CONFIG_FILE);
        Path gitIgnorePath = Path.of(GIT_IGNORE_FILE);
        Files.copy(editorConfigPath, Path.of(rootPath + File.separator + EDITOR_CONFIG_FILE));
        Files.copy(gitIgnorePath, Path.of(rootPath + File.separator + GIT_IGNORE_FILE));

        String banner = restTemplate.getForObject(systemProperties.getBannerUrl() + commonSettings.getProjectName(), String.class);
        log.info("生成项目banner:\n{}", banner);
    }


}
