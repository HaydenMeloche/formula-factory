package com.hayden.meloche;

import com.hayden.meloche.sources.CustomFieldDataSource;
import com.hayden.meloche.sources.FinPicDataSource;

import java.util.List;

public class DataSourceFactory {
    public static DataSource getDataSource(String dataType, List<String> arguments) {
        if (dataType.equalsIgnoreCase("FP")) {
            return new FinPicDataSource(arguments);
        } else if (dataType.equalsIgnoreCase("C")) {
            return new CustomFieldDataSource(arguments);
        }
        throw new UnsupportedOperationException("Unsupported data source");
    }
}
