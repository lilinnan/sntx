package com.lln.api.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiLinnan
 * @version 1.0
 * @date 2020/9/24 11:19
 */

@Configuration
public class CommonConfig {

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
