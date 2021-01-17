package java8;

import java.util.function.Function;

@java.lang.FunctionalInterface
public interface FunctionException<A,R> {

    R apply(A a) throws Throwable;
}
