package java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SetInOneLine {

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4,5}));
        Set<Integer> set3 = new HashSet<>(List.of(1,2,3,4,5));
        Set<Integer> set4 = Set.of(1,2,3,4,5);
        Set<Integer> set5 = Stream.of(1,2,3,4,5).collect(Collectors.toSet());
        Set<Integer> set6 = IntStream.of(1,2,3,4,5).boxed().collect(Collectors.toSet());
        Set<Integer> set7 = IntStream.rangeClosed(1,5).boxed().collect(Collectors.toSet());
        //50% acceptable
        Set<Integer> set8 = new HashSet<>(){{add(1);add(2);add(3);}};
    }
}
