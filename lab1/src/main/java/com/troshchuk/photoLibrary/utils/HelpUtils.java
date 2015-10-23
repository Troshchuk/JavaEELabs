package com.troshchuk.photoLibrary.utils;

import com.troshchuk.photoLibrary.annotation.Column;
import com.troshchuk.photoLibrary.annotation.Id;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HelpUtils {
    public static List<Method> getColumnsMethods(Class clazz) {
        List<Method> methods = new ArrayList<Method>();
        for (Method m : clazz.getMethods()) {
            if (m.getDeclaredAnnotation(Column.class) != null && m.getParameterTypes().length == 0) {
                methods.add(m);
            }
        }
        return methods;
    }

    public static Method getIdMethod(Class clazz) {
        for (Method m : clazz.getMethods()) {
            if (m.getDeclaredAnnotation(Id.class) != null && m.getParameterTypes().length == 0) {
                return m;
            }
        }
        return null;
    }

    public static List<String> toColumns(List<Method> methods) {
        List<String> columns = new ArrayList<String>();
        for (Method method : methods) {
            columns.add(method.getDeclaredAnnotation(Column.class).name());
        }
        return columns;
    }

    public static List<Method> getSetsMethods(List<Method> getMethods, Class<?> type) {
        List<Method> methods = new ArrayList<Method>();
        try {
            for (Method method : getMethods) {
                methods.add(type.getMethod(method.getName().replaceFirst("g", "s"), method.getReturnType()));
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return methods;
    }
}
