package com.future.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.MessageFormat;

/**
 * 公共配置
 *
 * @author future
 * @date 2021/05/01 22:26
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration {

    @Autowired
    private SwaggerProperties swaggerProperties;

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket getUserDocket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(MessageFormat.format(swaggerProperties.getTitle(), applicationName))
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .contact(getContact())
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    public Contact getContact() {
        return new Contact("future", "http://yaoguang.info", "182xxxx2301@163.com");
    }

}
