package com.hayden.meloche.sources;

import com.hayden.meloche.DataSource;
import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.List;


public class CustomFieldDataSource implements DataSource {
    public CustomFieldDataSource(List<String> arguments) {
    }

    @Override
    public Expression.LazyNumber getValue(String key) {
        return new Expression.LazyNumber() {
            public BigDecimal eval() {
                return BigDecimal.ONE;
            }
            public String getString() {
                return "1";
            }
        };
    }

    @Override
    public boolean supportsHistoric() {
        return false;
    }
}
