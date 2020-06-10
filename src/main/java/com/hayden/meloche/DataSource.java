package com.hayden.meloche;


import com.udojava.evalex.Expression;

public interface DataSource {
    Expression.LazyNumber getValue(String key);
    boolean supportsHistoric();
}
