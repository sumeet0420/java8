package java14;

import java.time.Month;

import static java.time.LocalDate.of;

public class PatternMatching {

    public static void main(String[] args) {
        String str = "hello pattern matching from  java 14";
        outputValueInUpperCase(str);
        Person person = new Person("Sumeet",26,
                Gender.MALE, of(1992, Month.JULY,16),132000);
        System.out.println(person.salary());
    }

    private static void outputValueInUpperCase(Object obj) {
        if(obj instanceof String str) {
            System.out.println(str.toUpperCase());
        } /*else {
            System.out.println(str.toString());
        }*/
    }

    public static void helloWorld(){
        return;
    }
}
