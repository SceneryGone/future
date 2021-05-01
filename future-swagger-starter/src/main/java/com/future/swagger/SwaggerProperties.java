package com.future.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * swagger 公共配置
 *
 * @author future
 * @date 2021/05/01 22:24
 */
@Data
@ConfigurationProperties(prefix = "future.swagger")
public class SwaggerProperties {

    private String title = "{0} 服务端接口文档";

    private String description = "restful api规范说明";

    private String version = "1.0.0";

}
