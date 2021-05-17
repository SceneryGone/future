#### 使用方式

properties 中配置

```properties
future.async.executor.thread.core-pool-size=10
future.async.executor.thread.max-pool-size=10
future.async.executor.thread.queue-capacity=9999
future.async.executor.thread.name-prefix=future-test
```

方法上加上注解就可以

```java
import org.springframework.stereotype.Component;

@Service
class UserClass {
    @Async("asyncServiceExecutor")
    public void show() {
    }
}
```