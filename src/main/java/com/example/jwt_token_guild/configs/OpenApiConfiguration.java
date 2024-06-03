package com.example.jwt_token_guild.configs;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        final String securitySchemeName = "Bearer Authorization";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes(securitySchemeName,
                                        new SecurityScheme()
                                                .name(securitySchemeName)
                                                .type(SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                                .description("Please insert JWT token")
                                )
                )
                .addServersItem(new Server().url("/"))
                .info(apiInfo());
    }

    /**
     * Creates an {@link Info} object for BoostApp Step-Api.
     *
     * @return {@link Info} object with title, description, and version set for BoostApp Step-Api.
     */
    private Info apiInfo() {
        return new Info()
                .title("JWT Token Guild API Documentation")
                .description("JWT Token Guild API")
                .version("1.0");
    }

}
