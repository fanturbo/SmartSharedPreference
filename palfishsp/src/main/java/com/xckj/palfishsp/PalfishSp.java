package com.xckj.palfishsp;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.CLASS;

@Target(FIELD)
@Retention(CLASS)
public @interface PalfishSp {
    /**
     * 存储的key
     */
    String key();

    /**
     * 存储的字段的作用
     */
    String name();
}
