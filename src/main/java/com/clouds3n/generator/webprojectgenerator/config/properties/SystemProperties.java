package com.clouds3n.generator.webprojectgenerator.config.properties;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author clouds3n
 * @time 2020-11 15:52
 */
@Data
@Accessors(chain = true)
@Component
@ConfigurationProperties(prefix = "system")
public class SystemProperties {

    /**
     * render banner site
     */
    private String bannerUrl = "https://devops.datenkollektiv.de/renderBannerTxt?font=ogre&text=";
}
