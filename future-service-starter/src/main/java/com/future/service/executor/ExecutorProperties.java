package com.future.service.executor;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author future
 * @date 2021/05/17 11:25
 */
@Data
@ConfigurationProperties(prefix = "future.async.executor.thread")
public class ExecutorProperties {

    /**
     * 配置核心线程数
     */
    private Integer corePoolSize;

    /**
     * 配置最大线程数
     */
    private Integer maxPoolSize;

    /**
     * 配置队列大小
     */
    private Integer queueCapacity;

    /**
     * 配置线程池中的线程的名称前缀
     */
    private String namePrefix;

}
