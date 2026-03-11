package com.nemchann.cache;

public @interface Cache {
    String[] value() default {};
}
