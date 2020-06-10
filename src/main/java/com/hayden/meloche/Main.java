package com.hayden.meloche;

import com.udojava.evalex.AbstractLazyFunction;
import com.udojava.evalex.Expression;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /*
        The below code is a sample POC that will evaluate a custom formula that lazily retrieves data from different data sources.

        In the below example the formula is: FP(17, "customArg") * C(12, "customArg", "customArg1")

        FP & C are both keys that are used in our DataSourceFactory to determine what data source the data should come from.
        The first value in the ( ) is the key. The key is used to grab that individual value element. For ex: 10
        Every value in the ( ) after that is custom arguments that are passed into the dataservice. These could alter
        how the source gets the data or from what time period for example.

        LazyFunctions are added to the expression for each datasource, although this could be improved by possibly changing
        the formula syntax so that all datasources start with D. This would mean only one lazyfunction would ever be needed
        for datasources but would also mean all datasources would need to be 100% the same in the way they interact with
        the formula.
    */
    public static void main(String[] args) {
        Expression expression = new Expression("FP(17, \"customArg\") * C(12, \"customArg\", \"customArg1\")");
        expression.addLazyFunction(new AbstractLazyFunction("FP", -1) {
            @Override
            public Expression.LazyNumber lazyEval(List<Expression.LazyNumber> lazyParams) {
                return DataSourceFactory.getDataSource("FP", parseArguments(lazyParams)).getValue(lazyParams.get(0).getString());
            }
        });
        expression.addLazyFunction(new AbstractLazyFunction("C", -1) {
            @Override
            public Expression.LazyNumber lazyEval(List<Expression.LazyNumber> lazyParams) {
                return DataSourceFactory.getDataSource("C", parseArguments(lazyParams)).getValue(lazyParams.get(0).getString());
            }
        });

        // evaluates to 10
        System.out.println(expression.eval().intValue());
    }

    private static List<String> parseArguments(List<Expression.LazyNumber> lazyParams) {
        // ignore the first value in list because that is our key.
        return lazyParams.subList(1, lazyParams.size() - 1).stream().map(Expression.LazyNumber::getString).collect(Collectors.toList());
    }
}
