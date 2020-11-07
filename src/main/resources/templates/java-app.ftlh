<#assign StringUtils=statics['org.apache.commons.lang3.StringUtils']>
package ${maven.packageName};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ${common.author}
 * @time ${common.createTime}
 */
@SpringBootApplication
public class ${StringUtils.capitalize(common.projectName)}Application {

    public static void main(String[] args) {
        SpringApplication.run(${StringUtils.capitalize(common.projectName)}Application.class);
    }

}