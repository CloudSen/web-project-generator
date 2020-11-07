package com.clouds3n.generator.webprojectgenerator.service.impl;

import com.clouds3n.generator.webprojectgenerator.config.template.MybatisPlusTemplateConfig;
import com.clouds3n.generator.webprojectgenerator.config.template.module.CommonSettings;
import com.clouds3n.generator.webprojectgenerator.config.template.module.MavenSettings;
import com.clouds3n.generator.webprojectgenerator.service.ProjectGenerator;
import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * maven project generator
 * @author clouds3n
 * @time 2020-11-06 09:27
 */
public class MavenProjectGenerator implements ProjectGenerator {

    @Override
    public void generate(MybatisPlusTemplateConfig templateConfig, Configuration freemarker) throws IOException {
        createPath(templateConfig);
        createProjectFiles(templateConfig, freemarker);
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

    private void createProjectFiles(MybatisPlusTemplateConfig templateConfig, Configuration freemarker) throws IOException {
        CommonSettings commonSettings = templateConfig.getCommonSettings();
        MavenSettings mavenSettings = templateConfig.getMavenSettings();
        Path rootPath = Path.of(OUTPUT_PATH + com.baomidou.mybatisplus.core.toolkit.StringUtils.camelToHyphen(commonSettings.getProjectName()));
        Path editorConfigPath = Path.of(EDITOR_CONFIG_FILE);
        Path gitIgnorePath = Path.of(GIT_IGNORE_FILE);
        Files.copy(editorConfigPath, Path.of(rootPath + File.separator + EDITOR_CONFIG_FILE));
        Files.copy(gitIgnorePath, Path.of(rootPath + File.separator + GIT_IGNORE_FILE));

    }

    private void createJavaFiles(MybatisPlusTemplateConfig templateConfig, Configuration freemarker) {

    }
}
