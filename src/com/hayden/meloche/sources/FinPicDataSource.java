package com.hayden.meloche.sources;

import com.hayden.meloche.DataSource;


public class FinPicDataSource implements DataSource {
    @Override
    public String getValue(String key) {
        return "10";
    }

    @Override
    public boolean supportsHistoric() {
        return false;
    }
}
