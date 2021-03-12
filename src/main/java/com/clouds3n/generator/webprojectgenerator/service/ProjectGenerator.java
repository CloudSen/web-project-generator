package com.clouds3n.generator.webprojectgenerator.service;

import com.clouds3n.generator.webprojectgenerator.module.mp.MybatisPlusTemplateConfig;

import java.io.IOException;

/**
 * indicate this is project generator
 * @author clouds3n
 * @time 2020-11-06 09:25
 */
@FunctionalInterface
public interface ProjectGenerator {

    String OUTPUT_PATH = "src/main/java/com/clouds3n/generator/webprojectgenerator/temp/";
    String GIT_KEEP_FILE = ".gitkeep";
    String SRC_KEEP_PATH = "src/" + GIT_KEEP_FILE;
    String JAVA_PATH = "src/main/java/";
    String RES_PATH = "src/main/resources/";
    String TEST_PATH = "src/test/";
    String EDITOR_CONFIG_FILE = ".editorconfig";
    String GIT_IGNORE_FILE = ".gitignore";

    /**
     * do generate
     * @param templateConfig freemarker template config
     * @throws IOException io exception
     */
    void generate(MybatisPlusTemplateConfig templateConfig) throws IOException;
}
