package java8;

import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toSet;
import static java.util.stream.IntStream.rangeClosed;

public class LazyEvaluation {

    public static void main(String[] args) {
        Supplier<Set<Integer>> numbers = () -> getNumbers();
        System.out.println(numbers);
        System.out.println("**********************");

    }

    private static Set<Integer> getNumbers() {
        System.out.println("Hello from getNumbers..");
        return rangeClosed(1, 10000).boxed().collect(toSet());
    }

    //Adapter from Iterable to Stream
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    //Adapter from Stream to Iterable
    public static <E> Iterable<E> iterator(Stream<E> stream) {
        return stream::iterator;
    }
}
