package java14;

import java.time.LocalDate;

/**
 * Records are final. Also, this class is effectively Immutable.
 * So, this could be highly efficient in Lambdas.
 */
enum Gender {
    MALE, FEMALE;
}

public record Person (
        String name,
        int age, Gender gender,
        LocalDate dateOfBirth,
        int salary ) {
}
