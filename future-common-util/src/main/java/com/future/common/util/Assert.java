package com.future.common.util;

import java.util.Collection;
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

    public static <T extends RuntimeException, R> void isTrue(Predicate<R> predicate, R r, T e) {
        if (!predicate.test(r)) {
            throw e;
        }
    }

    public static <T extends RuntimeException> void isNotNull(Object object, T e) {
        if (object == null) {
            throw e;
        }
    }

    public static <T extends RuntimeException> void isNotEmpty(Collection<?> collection, T e) {
        if (collection == null || collection.isEmpty()) {
            throw e;
        }
    }

}
