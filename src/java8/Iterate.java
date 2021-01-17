package java8;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import static java.lang.System.out;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Stream.iterate;

public class Iterate {

    public static void main(String[] args) {
        //Stream.generate(()->generate()).limit(5).forEach(System.out::println);
        int num = 100;
        //boolean evalute = evalute();
        //Love this feature. Lazy Evaluation.
        Supplier<Boolean> evalute = Iterate::evalute;
        if(num > 100 && evalute.get()){
            out.println("Hello.");
        }

        iterate(0,input->input+1)
                .limit(5).forEach(out::println);

        List<Integer> list = List.of(1,2,4,90,87).stream()
                .collect(toCollection(() -> new LinkedList<>()));

    }

    private static boolean evalute() {
        out.println("Evaluate");
        return false;
    }
}
