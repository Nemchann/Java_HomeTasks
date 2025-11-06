package com.nemchann.mathematic;

import java.math.BigInteger;

public class BigIntegerWrapper implements Numeric{
    private final BigInteger value;

    public BigIntegerWrapper(BigInteger value) {
        this.value = value;
    }

    @Override
    public double toDouble() {
        return value.doubleValue();
    }
}
