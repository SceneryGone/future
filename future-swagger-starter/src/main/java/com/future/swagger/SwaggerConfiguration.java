package com.future.swagger;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.List;

/**
 * 公共配置
 *
 * @author future
 * @date 2021/05/01 22:26
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfiguration implements WebMvcConfigurer {

    @Resource
    private SwaggerProperties swaggerProperties;

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public Docket buildDocker() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(MessageFormat.format(swaggerProperties.getTitle(), applicationName))
                .description(swaggerProperties.getDescription())
                .version(swaggerProperties.getVersion())
                .contact(getContact())
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerProperties.getStatus())
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    public Contact getContact() {
        return new Contact("future", "http://yaoguang.info", "378899470@qq.com");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:META-INF/resources/webjars/");
    }

    private List<Parameter> operationParameters() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        Parameter token = parameterBuilder
                .name("token")
                .description("令牌")
                .parameterType("header")
                .modelRef(new ModelRef("string"))
                .required(false)
                .build();
        return Lists.newArrayList(token);
    }
}
