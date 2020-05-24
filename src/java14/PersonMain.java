package java14;

import java.time.LocalDate;
import java.time.Month;

public class PersonMain {
    public static void main(String[] args) {
        var person = new Person("Sumeet", 28,
                Gender.MALE, LocalDate.of(1992, Month.JULY,16),16_00_000);
        System.out.println(person);
        System.out.println(person.salary());
    }

}
