package com.hayden.meloche;


public interface DataSource {
    String getValue(String key);
    boolean supportsHistoric();
}
