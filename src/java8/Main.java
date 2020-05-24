package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public class Main {

    public static void main(String[] args) throws IOException {

        String[] stringArray = {"hello", "how", "are", "you doing"};
        System.out.println(joinString(stringArray));
        System.out.println(joinString("hello", "how", "are", "you"));
        IntStream.rangeClosed(1, 1000).filter(Main::isPrime).forEach(System.out::println);
        readFile();
        var list1 = getRandomListOfInteger();
        var list2 = new ArrayList<Integer>(list1);

        Collections.shuffle(list2);
        System.out.println("Removed: " + list2.remove(5));
        System.out.println("Found: " + findTheMissingNumber(list1, list2));

        System.out.println(reverseAnInteger_1(654321));
        System.out.println(reverseAnInteger_2(654321));
        System.out.println(reverseAnInteger_3(654321));

        printMap(wordFrequency("hellloworld"));

        System.out.println(findDuplicates(Arrays.asList(1, 1, 0, 4, 5, 7, 7, 1, 0, 8)));
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        reverseList(list);
        System.out.println(list);
        System.out.println("*******************************************************************");
        shuffle(list);
        System.out.println(list);
        System.out.println("**************break************************");
    }

    //Shuffle a list
    public static <T> void shuffle(List<T> list) {
        final int size = list.size();
        for (int i = size; i > 1; i--) {
            int randomIndex = new Random().nextInt(i);
            swap(list, i - 1, randomIndex);
        }
    }

    //List Of Limit 1000000 of random integer from 10000 to 999900
    public static List<Integer> getRandomListOfInteger() {
        return new Random().ints(10000, 99900)
                .parallel()
                .limit(1000000)
                .boxed().collect(toList());
    }

    //List with a limit of random integer from 10000 to 999900
    public static List<Integer> getRandomListOfInteger(final int limit) {
        return new Random().ints(10000, 99900)
                .parallel()
                .limit(limit)
                .boxed().collect(toList());
    }

    //Reverse a list
    public static <T> void reverseList(List<T> list) {
        final int size = list.size();
        for (int i = 0, mid = size >> 1, j = size - 1; i < mid; i++, j--) {
            swap(list, i, j);
        }
    }

    //Swap two index of a list
    public static <T> void swap(List<T> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    //Produces a word frequenct map. Insertion Order in maintained..
    public static Map<String, Integer> wordFrequency(String word) {
        Map<String, Integer> frequncyMap = new LinkedHashMap<>();
//        Map<String, Integer> frequncyMap = Collections.synchronizedMap(new HashMap<>());
        Stream.of(word.split(""))// .parallel()
                .forEach(character -> frequncyMap.compute(character, (k, v) -> v == null ? 1 : v + 1));
        return frequncyMap;
    }

    //Prints a map
    public static <T extends Number> void printMap(Map<String, T> frequncyMap) {
        frequncyMap.forEach((k, v) -> System.out.print(k + v));
        System.out.println();
    }

    //Joins a string and return a string in CSV format
    public static String joinString(String... values) {
        return Stream.of(values).map(Main::stringInDoubleQuotes).parallel().collect(Collectors.joining(",")).toString();
    }

    //If the string begins with
    private static String stringInDoubleQuotes(String s) {
        return s.contains(" ") ? "\"" + s + "\"" : s;
    }

    //Find Duplicates from a collection
    public static <T> Set<T> findDuplicates(Collection<T> collection) {
        Map<T, Integer> frequncyMap = Collections.synchronizedMap(new HashMap<>());
        collection.stream().parallel()
                .forEach(character -> frequncyMap.compute(character, (k, v) -> v == null ? 1 : v + 1));
        return frequncyMap.keySet().stream().filter(key -> frequncyMap.get(key) > 1).collect(toSet());
        // Set<T> set = new HashSet<>();
        // frequncyMap.forEach((k,v)->{if(v>1) {set.add(k);}});

    }

    // Reverse an Integer
    private static String reverseAnInteger_3(int i) {
        return Stream.of(i).map(num -> new StringBuilder(String.valueOf(num)).reverse()).findFirst().toString();
    }

    // Reverse an Integer
    private static int reverseAnInteger_2(int num) {
        final int length = (int) Math.log10(num) + 1;
        String result = "";
        String word = String.valueOf(num);
        for (int i = length - 1; i >= 0; i--) {
            result += word.charAt(i);
        }
        return Integer.parseInt(result);
    }

    // Reverse an Integer
    private static int reverseAnInteger_1(int i) {
        final String word = String.valueOf(i);
        return Integer.parseInt(new StringBuilder(word).reverse().toString());
    }

    // Find the Missing Number from the two list
    public static int findTheMissingNumber(List<Integer> list1, List<Integer> list2) {
        return findXor(list1) ^ findXor(list2);
    }

    private static int findXor(List<Integer> list) {
        return list.parallelStream().mapToInt(Integer::valueOf).reduce(0, (a, b) -> a ^ b);
    }

    // Using Lambdas to read a file.
    private static void readFile() throws IOException {
        Files.lines(Path.of("words.txt")).parallel().filter(Pattern.compile("(\\d)+").asPredicate())
                .forEach(System.out::println);
    }

    // Find the numbers of vowels in a word.
    public long noOfVowels(final String word) {
        return Pattern.compile("").splitAsStream(word).filter(x -> !"aeiou".contains(x)).count();
    }

    // Finding the sum of digits in a word
    public int sumOfDigits(final String word) {
        return Pattern.compile("\\d").splitAsStream(word).peek(System.out::println).mapToInt(Integer::parseInt).sum();
    }

    // Finding the sum of the consecutive numbers in a word
    public int sumOfConsecutiveNumbers(final String word) {
        return Pattern.compile("\\d+").matcher(word).results().parallel()
                .mapToInt(matched -> Integer.parseInt(matched.group())).sum();
    }

    public static boolean isPrime(final int number) {
        return number > 1 && !IntStream.rangeClosed(2, number >> 1).anyMatch(x -> number % x == 0);
    }
}
