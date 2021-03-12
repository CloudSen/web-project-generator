package com.clouds3n.generator.webprojectgenerator.module.threadpool;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 通用scheduler设置
 *
 * @author clouds3n
 * @time 2020-12-02 09:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class SchedulerSettings {
    /**
     * 线程名前缀
     */
    private String threadNamePrefix = "common-scheduler-";
    /**
     * 线程池大小
     */
    private Integer poolSize = 20;
}
