package java11;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.partitioningBy;

public class VarKeyWord {

    public static void main(String[] args) {
        var number = 10;
        System.out.println(number);
        var word = "Hello";
        System.out.println(word);

        //Remember No-Polymorphism
        var list = new ArrayList<Integer>();
        list.add(1);

        var count = List.of(1, 2, 3, 4, 5, 6, 9).stream().collect(partitioningBy(x -> x % 2 == 0));
        count.forEach((key, value) -> System.out.println("key: " + key + " : value " + value));
    }
}
