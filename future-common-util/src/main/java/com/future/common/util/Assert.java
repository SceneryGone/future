package com.future.common.util;

import java.util.function.Predicate;

/**
 * 判断处理
 *
 * @author future
 * @date 2021/05/01 23:55
 */
public class Assert {

    public static <T extends RuntimeException> void isTrue(boolean expression, T e) {
        if (!expression) {
            throw e;
        }
    }

    public static <T extends RuntimeException> void isTrue(boolean expression, FailureAction action) {
        if (!expression) {
            action.run();
        }
    }

    public static <T extends RuntimeException, R> void isTrue(Predicate<R> predicate, R r, T e) {
        if (!predicate.test(r)) {
            throw e;
        }
    }

    @FunctionalInterface
    public interface FailureAction {
        void run();
    }


}
