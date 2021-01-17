package java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ExceptionMain {

    public static <A, R> Function<A, Optional<R>> wrap(FunctionException<A, R> operation) {
        return func-> {
            try {
                return Optional.of(operation.apply(func));
            } catch (Throwable throwable) {
                return Optional.empty();
            }
        };
    }
    public static void main(String[] args) {
//        List.of("a.txt","b.txt").stream().map(wrap(file ->Files.lines(Path.of(file)))).forEach(System.out::println);
        Collections.addAll(new HashSet<>(), "1", "2", "3", "4", "5");
    }
}
