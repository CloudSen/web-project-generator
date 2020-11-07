package com.clouds3n.generator.webprojectgenerator.config.freemarker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Configuration For FreeMarker
 * @author clouds3n
 */
@Configuration
public class FreeMarkerConfig {

    private static final String TEMPLATE_PATH = "src/main/resources/templates";

    /**
     * Use the default configuration of freemarker
     */
    @Bean("freemarker")
    public freemarker.template.Configuration getFreeMarker() throws IOException {
        freemarker.template.Configuration cfg =
                new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_30);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.name());
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setBooleanFormat("c");
        return cfg;
    }
}
