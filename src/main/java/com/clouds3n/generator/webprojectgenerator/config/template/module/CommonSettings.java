package com.clouds3n.generator.webprojectgenerator.config.template.module;

import com.clouds3n.generator.webprojectgenerator.common.BuildType;
import com.clouds3n.generator.webprojectgenerator.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * common settings data-module
 * @author clouds3n
 * @time 11/4/20 11:19 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommonSettings {
    /**
     * specify project build type
     * <p>default is maven</p>
     */
    private BuildType buildType = BuildType.MAVEN;
    /**
     * coder name
     * <p>used for @author tag</p>
     */
    @NotBlank(message = "Please specify the coder name")
    private String author;

    /**
     * file create time
     * <p>used for @time tag</p>
     */
    private String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.TIME_PATTERN));

    /**
     * project name
     */
    @NotBlank(message = "Please specify the project name")
    private String projectName;

    @NotNull
    private Boolean useCloudS3nStarter;
}
