server:
  port: ${yml.port}
spring:
  application:
    name: ${yml.appName}
  profiles:
    active: ${yml.activeProfile}
<#list yml.environments as env>
---
spring:
  profiles: ${env.profileName}
  datasource:
    dynamic:
      primary: ${env.dynamicDatasourceSettings.primary}
      strict: ${env.dynamicDatasourceSettings.strict}
      p6spy: ${env.dynamicDatasourceSettings.p6spy}
      druid:
        filters: ${env.dynamicDatasourceSettings.commonDruidSettings.filters}
        initial-size: ${env.dynamicDatasourceSettings.commonDruidSettings.initialSize}
        min-idle: ${env.dynamicDatasourceSettings.commonDruidSettings.minIdle}
        max-wait: ${env.dynamicDatasourceSettings.commonDruidSettings.maxWait}
        max-active: ${env.dynamicDatasourceSettings.commonDruidSettings.maxActive}
        test-while-idle: ${env.dynamicDatasourceSettings.commonDruidSettings.testWhileIdle}
        test-on-borrow: ${env.dynamicDatasourceSettings.commonDruidSettings.testOnBorrow}
        test-on-return: ${env.dynamicDatasourceSettings.commonDruidSettings.testOnReturn}
        poolPreparedStatements: ${env.dynamicDatasourceSettings.commonDruidSettings.poolPreparedStatements}
        max-pool-prepared-statement-per-connection-size: ${env.dynamicDatasourceSettings.commonDruidSettings.maxPreparedStatementsPerConnectionSize}
        validation-query: ${env.dynamicDatasourceSettings.commonDruidSettings.validationQuery}
        validation-query-timeout: ${env.dynamicDatasourceSettings.commonDruidSettings.validationQueryTimeout}
      datasource:
    <#list env.dynamicDatasourceSettings.datasourceSettings as datasource>
        ${datasource.nickName}:
          username: ${datasource.username}
          password: ${datasource.password}
          url: ${datasource.url}
        <#if datasource.driverName??>
          driver-class-name: ${datasource.driverName}
        </#if>
      <#if datasource.customDruidSettings??>
          druid:
            min-idle: ${datasource.customDruidSettings.minIdle}
            max-wait: ${datasource.customDruidSettings.maxWait}
            max-active: ${datasource.customDruidSettings.maxActive}
      </#if>
    </#list>
<#if env.myStarterSettings??>
config:
  starter:
    enable-druid-monitor: ${env.myStarterSettings.enableDruidMonitor}
    enable-global-exception-handler: ${env.myStarterSettings.enableGlobalExceptionHandler}
    enable-thread-pool: ${env.myStarterSettings.enableThreadPool}
    enable-mybatis-plus: ${env.myStarterSettings.enableMybatisPlus}
    enable-security: ${env.myStarterSettings.enableSecurity}
    enable-es: ${env.myStarterSettings.enableEs}
    enable-monitor: ${env.myStarterSettings.enableMonitor}
  <#if env.myStarterSettings.threadPoolSettings??>
  thread-pool:
    <#if env.myStarterSettings.threadPoolSettings.executorSettings??>
    executor:
      thread-name-prefix: ${env.myStarterSettings.threadPoolSettings.threadNamePrefix}
      core-pool-size: ${env.myStarterSettings.threadPoolSettings.corePoolSize}
      max-pool-size: ${env.myStarterSettings.threadPoolSettings.maxPoolSize}
      queue-capacity: ${env.myStarterSettings.threadPoolSettings.queueSize}
      keep-alive-seconds: ${env.myStarterSettings.threadPoolSettings.keepAliveSeconds}
      allow-core-thread-timeout: ${env.myStarterSettings.threadPoolSettings.allowCoreTimeout}
    </#if>
    <#if env.myStarterSettings.threadPoolSettings.schedulerSettings??>
    scheduler:
      thread-name-prefix: ${env.myStarterSettings.schedulerSettings.threadNamePrefix}
      pool-size: ${env.myStarterSettings.schedulerSettings.poolSize}
    </#if>
  </#if>
</#if>
</#list>