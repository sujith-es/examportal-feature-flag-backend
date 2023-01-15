package com.exam.service.flipt;

import com.flipt.api.FliptApiClient;
import com.flipt.api.core.BearerAuth;
import com.flipt.api.core.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class FliptConfiguration {

    private FliptApiClient fliptApiClient;

    @Value("${FLIPT_API_TOKEN}")
    private String token;

    @Value("${FLIPT_API_URL}")
    private String url;

    @Bean
    public FliptApiClient fliptApiClient() {
       this.fliptApiClient = new FliptApiClient(Environment.custom(url), BearerAuth.of(token));
       return this.fliptApiClient;
    }
}
