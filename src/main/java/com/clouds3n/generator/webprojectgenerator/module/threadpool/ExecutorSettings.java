package com.clouds3n.generator.webprojectgenerator.module.threadpool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 通用executor设置
 *
 * @author clouds3n
 * @time 2020-12-02 09:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ExecutorSettings {
    /**
     * 线程名前缀
     */
    private String threadNamePrefix = "common-executor-";
    /**
     * 核心线程数
     */
    private Integer corePoolSize = 20;
    /**
     * 最大线程数
     */
    private Integer maxPoolSize = 100;
    /**
     * 队列大小
     */
    private Integer queueSize = 40;
    /**
     * 生存时长
     */
    private Integer keepAliveSeconds = 60;
    /**
     * 是否允许核心线程超时回收
     */
    private boolean allowCoreTimeout = false;
}
