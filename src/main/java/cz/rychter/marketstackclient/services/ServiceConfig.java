package cz.rychter.marketstackclient.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfig {

    @Value("${apiToken}")
    private String apiToken;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public MarketStackService marketService(RestTemplate restTemplate) {
        return new MarketStackService(restTemplate, apiToken);
    }

    @Bean
    public String apiToken() {
        return apiToken;
    }

}
