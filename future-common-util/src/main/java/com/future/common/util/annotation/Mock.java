package com.future.common.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * 标识这是一个mock的数据接口
 *
 * @author future
 * @date 2021/05/06 15:26
 */
@Target(ElementType.METHOD)
@Retention(SOURCE)
public @interface Mock {

    String value() default "";

}
