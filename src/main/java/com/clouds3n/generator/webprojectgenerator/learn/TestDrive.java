package com.clouds3n.generator.webprojectgenerator.learn;

import com.clouds3n.generator.webprojectgenerator.config.template.MybatisPlusTemplateConfig;
import com.clouds3n.generator.webprojectgenerator.config.template.module.*;
import com.clouds3n.generator.webprojectgenerator.service.GenerateService;
import freemarker.template.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author clouds3n
 * @time 11/3/20 4:52 PM
 */
@Validated
@RestController
@RequestMapping(("/test"))
public class TestDrive {

    private final Configuration freemarker;
    private final GenerateService generateService;

    public TestDrive(Configuration freemarker, GenerateService generateService) {
        this.freemarker = freemarker;
        this.generateService = generateService;
    }

    @GetMapping("")
    public Object test() throws IOException, TemplateException {
        Template template = freemarker.getTemplate("test.ftlh");
        try (OutputStreamWriter os = new OutputStreamWriter(System.out)) {
            template.process(new Test().setName("freemarker"), os);
        }
        return "ok";
    }

    @GetMapping("/java")
    public Object testJava() throws IOException, TemplateException {
        Template template = freemarker.getTemplate("java-app.ftlh");
        Map<String, Object> data = new HashMap<>(16);
        try (OutputStreamWriter os = new OutputStreamWriter(System.out)) {
            CommonSettings commonSettings = new CommonSettings()
                .setAuthor("CloudS3n")
                .setProjectName("test");
            MavenSettings mavenSettings = new MavenSettings()
                .setVersion("1.0.0")
                .setGroupId("com.clouds3n.test")
                .setArtifactId("java");
            mavenSettings.setPackageName(mavenSettings.getGroupId() + "." + mavenSettings.getArtifactId());
            MybatisPlusTemplateConfig defaultTemplateConfig = new MybatisPlusTemplateConfig(commonSettings, mavenSettings, null, null);
            DefaultObjectWrapper objectWrapper = new DefaultObjectWrapper(Configuration.VERSION_2_3_30);
            TemplateHashModel statics = objectWrapper.getStaticModels();
            data.put("statics", statics);
            data.put("common", defaultTemplateConfig.getCommonSettings());
            data.put("maven", defaultTemplateConfig.getMavenSettings());
            template.process(data, os);
        }
        return "ok";
    }

    @GetMapping("/yml")
    public Object testYml() throws IOException, TemplateException {
        Template template = freemarker.getTemplate("java-cfg-yml.ftlh");
        DynamicDatasourceSettings.DruidSettings commonDruidSettings =
            new DynamicDatasourceSettings.DruidSettings();
        DynamicDatasourceSettings.DatasourceSettings paraDataSourceSettings =
            new DynamicDatasourceSettings.DatasourceSettings()
            .setNickName("maria")
            .setUsername("clouds3n")
            .setPassword("cloudsen")
            .setUrl("jdbc:mysql://localhost:3306/test");
        DynamicDatasourceSettings.DatasourceSettings baseDataSourceSettings =
            new DynamicDatasourceSettings.DatasourceSettings()
                .setNickName("base")
                .setUsername("hw02user")
                .setPassword("hw02password")
                .setUrl("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=129.9.2.20)(PORT=1522)))(CONNECT_DATA=(SERVICE_NAME=hwbase02)))")
                .setDriverName("oracle.jdbc.OracleDriver");
        DynamicDatasourceSettings dynamicDatasourceSettings =
            new DynamicDatasourceSettings()
            .setPrimary("para")
            .setCommonDruidSettings(commonDruidSettings)
            .setDatasourceSettings(Arrays.asList(paraDataSourceSettings, baseDataSourceSettings));
        MybatisPlusYmlSettings.YmlEnvironment devEnvironment =
            new MybatisPlusYmlSettings.YmlEnvironment()
            .setProfileName("dev")
            .setDynamicDatasourceSettings(dynamicDatasourceSettings)
            .setMyStarterSettings(new MyStarterSettings());
        MybatisPlusYmlSettings.YmlEnvironment prodEnvironment =
            new MybatisPlusYmlSettings.YmlEnvironment()
                .setProfileName("prod")
                .setDynamicDatasourceSettings(dynamicDatasourceSettings)
                .setMyStarterSettings(new MyStarterSettings());
        MybatisPlusYmlSettings mybatisPlusYmlSettings = new MybatisPlusYmlSettings()
            .setPort("8080")
            .setAppName("test")
            .setActiveProfile("dev")
            .setEnvironments(Arrays.asList(devEnvironment, prodEnvironment));
        Map<String, Object> data = new HashMap<>(16) {{
            put("yml", mybatisPlusYmlSettings);
        }};
        try (OutputStreamWriter os = new OutputStreamWriter(System.out)) {
            template.process(data, os);
        }
        return "ok";
    }

    @GetMapping("/path")
    public Object testPath() throws IOException {
        CommonSettings commonSettings = new CommonSettings()
            .setAuthor("CloudS3n")
            .setProjectName("myProject");
        MavenSettings mavenSettings = new MavenSettings()
            .setVersion("1.0.0")
            .setGroupId("com.clouds3n.demo")
            .setArtifactId(commonSettings.getProjectName());
        mavenSettings.setPackageName(mavenSettings.getGroupId() + "." + mavenSettings.getArtifactId());
        new MybatisPlusAutoGeneratorSettings()
            .setAuthor(commonSettings.getAuthor());
        MybatisPlusTemplateConfig templateConfig = new MybatisPlusTemplateConfig(commonSettings, mavenSettings, null, null);
        generateService.generateProject(templateConfig);
        return "ok";
    }
}
