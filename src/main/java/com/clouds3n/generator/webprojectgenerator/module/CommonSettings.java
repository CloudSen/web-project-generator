package com.clouds3n.generator.webprojectgenerator.module;

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
 * 项目通用设置
 *
 * @author clouds3n
 * @time 11/4/20 11:19 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CommonSettings {
    /**
     * 项目构建方式
     * <p>默认是 maven</p>
     */
    private BuildType buildType = BuildType.MAVEN;
    /**
     * 作者
     * <p>用于注释的@author标签</p>
     */
    @NotBlank(message = "Please specify the coder name")
    private String author;
    /**
     * 创建时间
     * <p>用于注释的@time标签</p>
     */
    private String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.TIME_PATTERN));
    /**
     * 项目名
     */
    @NotBlank(message = "Please specify the project name")
    private String projectName;
    /**
     * 是否使用CloudS3n的tron starter
     */
    @NotNull
    private Boolean useCloudS3nStarter;
}
