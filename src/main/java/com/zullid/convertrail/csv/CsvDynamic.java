package com.zullid.convertrail.csv;

import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class CsvDynamic {
    public static Class<?> createClass(String[] headers) {
        // Creation of the NEW dynamic Class
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .name("DynamicClass")
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value(Arrays.toString(headers)))
                .make();

        try {
            Class<?> dynamicClass = dynamicType.load(CsvDynamic.class.getClassLoader(),
                    ClassLoadingStrategy.Default.WRAPPER)
                    .getLoaded();
            Object instance = dynamicClass.getDeclaredConstructor().newInstance();

            return dynamicClass;
        } catch (InstantiationException | IllegalAccessException |
                InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
