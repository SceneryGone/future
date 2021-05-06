#### 使用方式
依赖pom
```pom
<dependency>
    <groupId>org.future</groupId>
    <artifactId>future-swagger-starter</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
因为SwaggerConfiguration需要注入applicationName,所以依赖的模块需要在properties中配置
```properties
spring.application.name=applicationName
```
### 注意
只扫描RestController注解的类，所以需要额外注意。