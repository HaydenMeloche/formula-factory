package com.hayden.meloche;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> formulaSplit = Arrays.asList("F17", "+", "C17");

        for (int i = 0; i < formulaSplit.size(); i++) {
            String item = formulaSplit.get(i);
            if (!item.equals("+")) {
                String dataSourceType = String.valueOf(item.charAt(0));
                formulaSplit.set(i, DataSourceFactory.getDataSource(dataSourceType).getValue(item.substring(1)));
            }
        }

        formulaSplit.forEach(System.out::print);
    }
}
