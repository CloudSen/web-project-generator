package com.clouds3n.generator.webprojectgenerator.config.template.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * common thread pool settings data-module
 * @author clouds3n
 * @time 2020-11-05 11:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ThreadPoolSettings {

    private ExecutorSettings executorSettings = new ExecutorSettings();
    private SchedulerSettings schedulerSettings = new SchedulerSettings();


    /**
     * common executor settings data-module
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class ExecutorSettings {
        private String threadNamePrefix = "common-executor-";
        private Integer corePoolSize = 50;
        private Integer maxPoolSize = 300;
        private Integer queueSize = 40;
        private Integer keepAliveSeconds = 60;
        private boolean allowCoreTimeout = false;
    }

    /**
     * common scheduler settings data-module
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Accessors(chain = true)
    public static class SchedulerSettings {
        private String threadNamePrefix = "common-scheduler-";
        private Integer poolSize = 20;
    }
}
