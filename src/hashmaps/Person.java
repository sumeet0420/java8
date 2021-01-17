package hashmaps;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private final int age;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        if (!name.equals(person.name)) return false;
        return dateOfBirth.equals(person.dateOfBirth);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + dateOfBirth.hashCode();
        result = 31 * result + age;
        return result;
    }
}
