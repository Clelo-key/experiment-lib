package cn.example.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Fly
 * @CreateTime: 2025-03-17
 * @Version: 1.0
 */
@AutoConfiguration
@EnableConfigurationProperties(ApiProperties.class)
@ConditionalOnProperty(prefix = "api.custom", name = "enable", havingValue = "true", matchIfMissing = false)
public class ApiPropertiesAutoConfiguration {
    @Bean
    public OpenAPI CustomOpenAPIInfo(ApiProperties apiProperties) {
        System.out.println(apiProperties.getTitle());
        return new OpenAPI()
                .info(new Info().title(apiProperties.getTitle())
                        .description(apiProperties.getDescription())
                        .version(apiProperties.getVersion())
                        .contact(new Contact().name(apiProperties.getAuthor()))
                );
    }
}
