package com.app.bootstrap;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app.security")
public class SecurityConfigs {

    private String jwtSecret;

    private Integer jwtExpirationMs;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public Integer getJwtExpirationMs() {
        return jwtExpirationMs;
    }

    public void setJwtExpirationMs(Integer jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
    }
}