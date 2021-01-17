package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class CustomerCollectors {

    public static void main(String[] args) {
        //Supplier
        //BiConsumer accumulator
        var toList = Collector.of(ArrayList::new, //Supplier
                (list, a) -> list.add(a), //BiConsumer accumulator
                (list1, list2) -> { //combiner BinaryOperator
                    list1.addAll(list2);
                    return list1;
                },
                Collector.Characteristics.IDENTITY_FINISH //characteristics
        );
//        List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(toList());
//        ArrayList<Object> list = numbers.stream().filter(x->x>95).collect(toList);
//        System.out.println(list);

        Collector<Integer, ArrayList<Integer>, ArrayList<Integer>> toSortedReverseListCollector = Collector.of(ArrayList::new, //Supplier
                (list, a) -> list.add(a), //BiConsumer accumulator
                (list1, list2) -> { //combiner BinaryOperator
                    list1.addAll(list2);
                    return list1;
                }, (list3) -> {
                    Collections.sort(list3,Comparator.reverseOrder());
                    return list3;
                }, Collector.Characteristics.UNORDERED);

        List<Integer> numbers = IntStream.rangeClosed(1,100).boxed().collect(toSortedReverseListCollector);
        numbers.forEach(System.out::println);
    }
}
