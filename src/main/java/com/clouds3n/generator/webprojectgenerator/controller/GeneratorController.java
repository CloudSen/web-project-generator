package com.clouds3n.generator.webprojectgenerator.controller;

import com.clouds3n.generator.webprojectgenerator.common.Res;
import com.clouds3n.generator.webprojectgenerator.module.mp.MybatisPlusTemplateConfig;
import com.clouds3n.generator.webprojectgenerator.service.ProjectGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;

/**
 * @author clouds3n
 * @time 2020-11 17:19
 */
@RestController
@RequestMapping("/generate")
public class GeneratorController {

    private final ProjectGenerator mavenProjectGenerator;

    public GeneratorController(ProjectGenerator mavenProjectGenerator) {
        this.mavenProjectGenerator = mavenProjectGenerator;
    }

    @PostMapping("/maven")
    public Res generateMavenProject(@RequestBody @Valid @NotNull MybatisPlusTemplateConfig templateConfig) throws IOException {
        mavenProjectGenerator.generate(templateConfig);
        return Res.ok();
    }
}
