package com.hayden.meloche.sources;

import com.hayden.meloche.DataSource;


public class CustomFieldDataSource implements DataSource {
    @Override
    public String getValue(String key) {
        return "1";
    }

    @Override
    public boolean supportsHistoric() {
        return false;
    }
}
