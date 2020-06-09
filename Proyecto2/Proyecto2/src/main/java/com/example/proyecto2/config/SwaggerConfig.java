package com.example.proyecto2.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Miguel
 * @version 09/06/2020
 *
 */
//PARA PODER VER LA DOCUMENTACIÓN EN FORMATO GRÁFICO ENTRAR EN: http://localhost:8080/swagger-ui.html
//PARA PODER VER LA DOCUMENTACIÓN VISUALIZADO COMO DATOS DE LA MÁQUINA ENTRAR EN: http://localhost:8080/v2/api-docs
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}
