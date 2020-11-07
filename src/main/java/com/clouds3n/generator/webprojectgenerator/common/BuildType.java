package com.clouds3n.generator.webprojectgenerator.common;

import com.clouds3n.generator.webprojectgenerator.service.ProjectGenerator;
import com.clouds3n.generator.webprojectgenerator.service.impl.MavenProjectGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * project build type enum,only support maven or gradle
 * @author clouds3n
 * @time 2020-11-06 09:11
 */
@Getter
@AllArgsConstructor
public enum BuildType {
    /**
     * use maven to build project
     */
    MAVEN("maven", 0, new MavenProjectGenerator()),
    /**
     * use gradle to build project
     */
    GRADLE("gradle", 1, null);

    private final String name;
    private final Integer code;
    private final ProjectGenerator projectGenerator;

    public static BuildType parseType(Integer code) {
        return Arrays.stream(values())
            .filter(buildType -> buildType.getCode().equals(code))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("unknown build type: " + code));
    }
}
