package com.exam.service.flipt;

import com.flipt.api.FliptApiClient;
import com.flipt.api.core.BearerAuth;
import com.flipt.api.core.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;

@Configuration
public class FliptConfiguration {

    private FliptApiClient fliptApiClient;

    //    BearerAuth auth = BearerAuth.of(getToken());
    BearerAuth auth = BearerAuth.of("");
    private String token;
    private String url = "";

    @Bean
    public FliptApiClient fliptApiClient() {
       this.fliptApiClient = new FliptApiClient(Environment.custom(url), auth);
       return this.fliptApiClient;
    }
}
