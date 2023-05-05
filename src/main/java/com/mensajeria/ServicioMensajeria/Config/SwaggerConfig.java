package com.mensajeria.ServicioMensajeria.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {



    @Bean
        Docket api() {
            return new Docket(DocumentationType.SWAGGER_2).select()
                    .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                    .paths(PathSelectors.any())
                    .build()
                    .securitySchemes(Arrays.asList(apiKey()))
                    .securityContexts(Arrays.asList(securityContext()))
                     .apiInfo(apiInfo());
        }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }


    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(defaultAuth()))
                .build();
    }

//TODO/AJUSTAR LAS FILAS 59 6 68 TIENE COSAS QUE NO SE ESTAN USANDO
    private SecurityReference  defaultAuth () {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        SecurityReference reference = new SecurityReference("Bearer", authorizationScopes);


     //   List<SecurityReference> references = new ArrayList<>();
     // references.add(reference);


         return reference;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API REST  -- SERVICIO MENSAJERIA ULTRA FAST -- ")
                .description("\uD83D\uDCE6\uD83D\uDE9A With our REST API you will be able to register, query, update, and delete one of these entities:" +
                "\n"+ " " +
                "\n"+ " " +
                "\n"+ "----- CUSTOMER" +
                "\n"+"----- EMPLOYEE " +
                "\n"+"----- PACKAGE " +
                "\n" +"----- COURIER SERVICE "+
                "\n"+ " " +
                "\n"+ " "

                     +   "\n" + "It also allows making requests based on the user role (admin, user)\uD83D\uDD11.")


                .version("1.0.0")
                .build();
    }
    }



