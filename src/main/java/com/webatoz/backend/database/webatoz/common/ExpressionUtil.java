package com.webatoz.backend.database.webatoz.common;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringPath;

import java.util.List;

public class ExpressionUtil {

    public static <T> BooleanExpression eq(SimpleExpression<T> path, T value) {
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            if ("".equals(value)) {
                return null;
            }
        }

        return path.eq(value);
    }

    public static BooleanExpression like(StringPath stringPath, String value) {
        if (value == null) {
            return null;
        }

        if (!value.contains("%")) {
            return stringPath.contains(value);
        }

        return stringPath.like(value);
    }


    public static <T> BooleanExpression in(SimpleExpression<T> path, List<T> value) {
        if (value.isEmpty()) {
            return null;
        }
        if (value.size()==1 && value.iterator().next() == null){
            return null;
        }

        return path.in(value);
    }
}
