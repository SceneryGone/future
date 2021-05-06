#### 继承jar
1. mysql-connector-java sql连接
2. tk.mybatis 通用mapper
3. spring-boot-mybatis spring和mybatis集成
4. pagehelper 分页工具类

#### 使用方法
依赖jar包
```maven
<dependency>
    <artifactId>future-mybatis</artifactId>
    <groupId>org.future</groupId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```
在application.properties添加配置
```properties
# mysql
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://route.wanpeng123.cn:13306/future?useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=xxxxxx

# mybatis
logging.level.tk.mybatis=TRACE
mybatis.type-aliases-package=com.future.mybatis.CommonMapper
mybatis.mapper-locations=classpath:mapper/*.xml

#mappers 多个接口时逗号隔开
mapper.mappers=com.future.mybatis.CommonMapper
mapper.not-empty=false
mapper.identity=MYSQL

# pageHelper
pagehelper.helperDialect=mysql
pagehelper.reasonable=true
pagehelper.supportMethodsArguments=true
pagehelper.params=count=countSql
```
启动类添加扫描mapper
```
@MapperScan("mapper所在包")
```
mapper使用-以t_user表为例
```java
public interface UserMapper extends CommonMapper<User> {
}
```
最后，注入调用即可，可以实现CommonMapper继承接口的方法，不用在mapper和xml中写那么多实现。


> 遇到其他情况可以看些这篇博客：https://www.cnblogs.com/jpfss/p/9117671.html