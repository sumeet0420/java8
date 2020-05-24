package java8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static java8.Main.printMap;

public class CollectorsLearning {

    //Short-Circuits Operation
    //allMAtch, anyMatch
    //findAny, findFirst

    public static void main(String[] args) {

        //groupingBy(Function, Collector)
        //collectingAndThen(Collector, Function)
        //teeing (Collector, Collector, operation)

        String json = "";
        String regex = "";
        printMap(Arrays.stream("helloworldh".split("")).collect(
                groupingBy(identity(), () -> new LinkedHashMap<>(),
                        collectingAndThen(counting(), Long::intValue))));

        System.out.println("***************");

        printMap(Arrays.stream("helloworldh".split(""))
                .collect(groupingBy(identity(), counting())));

        System.out.println(Arrays.stream("helloworldh".split(""))
                .collect(collectingAndThen(counting(), Long::intValue)));

        System.out.println(Arrays.stream("helloworldh".split(""))
                .collect(groupingBy(identity(), collectingAndThen(counting(), Long::intValue))));

        System.out.println(Arrays.stream("helloworldh".split(""))
                .collect(groupingBy(identity(), counting())));

        int[] vals = new int[100];
        Arrays.setAll(vals, i -> 2);
        listOfIntegers().stream().parallel().reduce(0, (a, b) -> a + b);
        System.out.println(factorial(1127));

        System.out.println(getPersonList().stream().collect(toList()));
        System.out.println("**************PERSON BY GENDER******************");

        System.out.println(getPersonList().stream().collect(groupingBy(Person::getGender)));
        Stream.of("hello", "popdof", "dsjafl", "odsa").sorted().limit(3);

        List<List<Integer>> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(Arrays.asList(1,2,3));
        listOfIntegers.add(Arrays.asList(4,5,6));
        listOfIntegers.add(Arrays.asList(7,8,9));
        listOfIntegers.add(Arrays.asList(10,12,13));

        //Flatten a list
        System.out.println(listOfIntegers.stream().flatMap(list->list.stream()).collect(toSet()));

        System.out.println(getPersonList().stream()
                .collect(groupingBy(Person::getName, mapping(Person::getName, counting()))));

        System.out.println(getPersonList().stream()
                .collect(groupingBy(Person::getAge, mapping(Person::getName, toSet()))));

        //Collecting By maxBy return the object itselg
        System.out.println(getPersonList().stream()
                .collect(maxBy(comparing(Person::getAge))));
        //Getting the person from the maximum age. map because maxBy returns a Optional
        var name = getPersonList().stream()
                .collect(collectingAndThen(maxBy(comparing(Person::getAge)), person -> person.map(Person::getName)));

        System.out.println(name);

                System.out.println(getPersonList().stream()
        .collect(groupingBy(Person::getName,mapping(Person::getAge,toSet()))));

        System.out.println(listOfIntegers().stream()
                .reduce(new ArrayList<Integer>(), (list, element) -> {
                    list.add(element);
                    return list;
                }, (list1, list2) -> {
                    list1.addAll(list2);
                    return list1;
                }));

        Stream.generate(() -> getPersonList()).limit(1).forEach(System.out::println);

    }
    //Types of Stream -> IntStream, LongStream, DoubleStream, Reference
    //Reduction is not for MUTTABLE OBJECTS...

    public static void helloFunctions(HelloFunctional hello) {
        hello.hello("hello function");
    }

    public static List<Integer> listOfIntegers() {
        return IntStream.rangeClosed(1, 200).boxed().collect(toList());
    }

    public static BigInteger factorial(long number) {
        return LongStream.rangeClosed(1, number).mapToObj(x -> BigInteger.valueOf(x))
                .parallel()
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static List<Person> getPersonList() {
        return List.of(new Person("Sumeet", 28, Gender.MALE),
                new Person("Loksh", 21, Gender.FEMALE),
                new Person("Polly", 27, Gender.FEMALE),
                new Person("Shailash", 22, Gender.FEMALE),
                new Person("Josh", 22, Gender.MALE),
                new Person("Joshila", 22, Gender.FEMALE)
        );
    }

    public static void doSomething(String x) {
        System.out.println("Hello");
        System.out.println(x);
        System.out.println("********************");
    }

}

