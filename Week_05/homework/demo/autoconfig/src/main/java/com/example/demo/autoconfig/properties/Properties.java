package com.example.demo.autoconfig.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = Properties.SETTING_PREFIX)
public class Properties {
    public static final String SETTING_PREFIX = "student";

    public int id;

    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
