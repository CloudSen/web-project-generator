package com.clouds3n.generator.webprojectgenerator.module.mvn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * maven settings data-module
 * @author clouds3n
 * @time 11/4/20 11:13 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MavenSettings {
    /**
     * maven group id
     * <p>Used to specify the imported package name.</p>
     */
    @NotBlank(message = "Please specify the maven group id")
    private String groupId;
    /**
     * maven artifact id
     * <p>Used to specify the imported package name.</p>
     */
    @NotBlank(message = "Please specify the maven artifact id")
    private String artifactId;
    /**
     * project version
     * <p>used to specify the version of jar</p>
     */
    @NotBlank(message = "Please specify the project version")
    private String version;
    /**
     * package name = groupId + "." + artifactId (all lowercase)
     */
    private String packageName;
}
