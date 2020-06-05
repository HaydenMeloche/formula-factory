package com.hayden.meloche;

import com.hayden.meloche.sources.CustomFieldDataSource;
import com.hayden.meloche.sources.FinPicDataSource;

public class DataSourceFactory {
    public static DataSource getDataSource(String dataType) {
        if (dataType.equalsIgnoreCase("F")) {
            return new FinPicDataSource();
        } else if (dataType.equalsIgnoreCase("C")) {
            return new CustomFieldDataSource();
        }
        throw new UnsupportedOperationException("Unsupported data source");
    }
}
