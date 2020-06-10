package com.hayden.meloche.sources;

import com.hayden.meloche.DataSource;
import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.List;


public class FinPicDataSource implements DataSource {
    public FinPicDataSource(List<String> arguments) {
    }

    @Override
    public Expression.LazyNumber getValue(String key) {
        return new Expression.LazyNumber() {
            public BigDecimal eval() {
                return BigDecimal.TEN;
            }
            public String getString() {
                return "10";
            }
        };
    }

    @Override
    public boolean supportsHistoric() {
        return false;
    }
}
