package com.wu;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: 吴磊
 * @program: testspring
 * @create: 2021-04-24 10:34
 */
@ConfigurationProperties(prefix = "wu")
public class ConfiguretionProperties {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
