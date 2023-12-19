package com.fabrick.checkfinancial.configuration;

import com.fabrick.checkfinancial.restclient.http.HeadersInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@Slf4j
public class RestConfiguration {

    @Value(value = "${fabrick.api.auth-schema}")
    private String authSchema;
    @Value(value = "${fabrick.api.api-key}")
    private String apiKey;
    @Value(value = "${fabrick.api.account-id}")
    private String accountId;
    @Value(value = "${fabrick.api.rootUri}")
    private String rootUri;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        log.info("Initialising Rest template using API rootUri {}",rootUri);

        return builder
                .rootUri(rootUri)
                .interceptors(HeadersInterceptor.of(authSchema,apiKey,accountId))
                .setConnectTimeout(Duration.ofMillis(3000))
                .setReadTimeout(Duration.ofMillis(3000))
                .build();
    }
}
