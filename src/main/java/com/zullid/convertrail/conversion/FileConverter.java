package com.zullid.convertrail.conversion;

public interface FileConverter<T, R> {
    T convert(R data);
}