package com.clouds3n.generator.webprojectgenerator.module.threadpool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * common thread pool settings data-module
 *
 * @author clouds3n
 * @time 2020-11-05 11:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ThreadPoolSettings {
    /**
     * 通用executor设置
     */
    private ExecutorSettings executorSettings;
    /**
     * 通用scheduler设置
     */
    private SchedulerSettings schedulerSettings;
}
