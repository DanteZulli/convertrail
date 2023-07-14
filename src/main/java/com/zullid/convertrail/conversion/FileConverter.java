package com.zullid.convertrail.conversion;

import java.io.File;

public interface FileConverter<T> {
    T convert(File file);
}
