package com.zzu.erepair.utility;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Component
public class SecurityKeys {

    private Properties keys;

    public void init() throws IOException {
        keys = new Properties();
        keys.load(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("keys.properties"), StandardCharsets.UTF_8));
    }

    public String getKey(){
        return keys.getProperty("securityKey");
    }

    public String getSecurityMD5(String source){
        return DigestUtils.md5DigestAsHex((getKey()+source).getBytes()).toLowerCase();
    }
}
