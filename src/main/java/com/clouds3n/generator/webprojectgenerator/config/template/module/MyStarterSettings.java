package com.clouds3n.generator.webprojectgenerator.config.template.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * CloudS3n starters settings data-module
 * @author clouds3n
 * @time 2020-11-05 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MyStarterSettings {

    private boolean enableDruidMonitor = true;
    private boolean enableGlobalExceptionHandler = true;
    private boolean enableThreadPool = true;
    private boolean enableMybatisPlus = true;
    private boolean enableSecurity = true;
    private boolean enableEs = true;
    private boolean enableMonitor = true;
    private ThreadPoolSettings threadPoolSettings;

}
