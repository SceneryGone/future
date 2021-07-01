package com.future.service.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.function.BooleanSupplier;

/**
 * @author future
 * @date 2021/05/07 15:10
 */
@Slf4j
public class TransactionUtil {

    /**
     * 事务提交之后异步执行-带有重试机制
     */
    public static void processAfterCommitAsynchronously(BooleanSupplier supplier) {
        try {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    RetryUtil.retryAsynchronously(supplier);
                }
            });
        } catch (Exception e) {
            log.error("job execute error:{}", e.getMessage(), e);
        }
    }

    /**
     * 事务提交之后执行-不重试
     */
    private static Boolean process(BooleanSupplier supplier) {
        try {
            TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
                @Override
                public void afterCommit() {
                    supplier.getAsBoolean();
                }
            });
            return true;
        } catch (Exception e) {
            log.error("job execute error:{}", e.getMessage(), e);
            return false;
        }
    }

}
