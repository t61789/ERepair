package com.zzu.erepair.utility;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

@Component
public class CommonProperties {

    private Properties properties;

    public void init() throws IOException {
        properties = new Properties();
        properties.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("common.properties"), StandardCharsets.UTF_8));
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
