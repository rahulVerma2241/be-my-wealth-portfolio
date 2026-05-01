package org.arrow.bemywealth.portfolio.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().
                info(new Info().title("Wealth Manager API")
                        .version("v1")
                .description("Wealth Manager API"));
    }
}
