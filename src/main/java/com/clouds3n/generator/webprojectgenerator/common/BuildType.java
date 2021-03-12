package com.clouds3n.generator.webprojectgenerator.common;

import lombok.Getter;

/**
 * 构建类型
 * @author clouds3n
 * @time 2020-11 18:40
 */
@Getter
public enum BuildType {
    /**
     * maven project
     */
    MAVEN,
    /**
     * gradle project
     */
    GRADLE,
}
