package com.nemchann.entity;

import static com.nemchann.entity.Option.NO;
import static com.nemchann.entity.Option.YES;

@ToString(NO)
public class A extends Entity{
    int x = 52;

    @ToString(YES)
    String str = "hello";
}
