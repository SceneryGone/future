package com.future.framework.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/**
 * 需要在spring环境下使用
 *
 * @author future
 * @date 2021/05/07 14:17
 */
@Slf4j
public class RetryUtil {

    private static final RetryTemplate TEMPLATE = new RetryTemplate();

    static {
        RetryPolicy retryPolicy = new SimpleRetryPolicy(3, Collections.singletonMap(Exception.class, true));
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(500L);
        backOffPolicy.setMultiplier(2);
        backOffPolicy.setMaxInterval(5000L);

        TEMPLATE.setRetryPolicy(retryPolicy);
        TEMPLATE.setBackOffPolicy(backOffPolicy);
    }

    /**
     * 异步重试
     */
    public static void retryAsynchronously(Supplier<Boolean> supplier) {
        CompletableFuture.runAsync(() -> {
            try {
                TEMPLATE.execute(context -> supplier.get());
            } catch (Exception e) {
                log.error("async do failed: {}", e.getMessage(), e);
            }
        });
    }

}
