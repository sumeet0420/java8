package java12;

enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

public class SwitchCaseExpression {

    public static void main(String[] args) {
            //Before
            /*Day day = Day.THURSDAY;
            int numLetters = 0;
            switch (day){
                case MONDAY:
                case FRIDAY:
                case SUNDAY:
                    numLetters = 6;
                    break;
                case TUESDAY:
                    numLetters = 7;
                    break;
                case SATURDAY:
                case THURSDAY:
                    numLetters = 5;
                    break;
                case WEDNESDAY:
                    numLetters = 3;
                    break;
                default:
                    numLetters=99;
            }
        System.out.println(numLetters);*/
        //After
        Day day = Day.THURSDAY;
        int numLetters =  switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> {
                System.out.println(6);
                yield 6;
            }
            case TUESDAY -> {
                System.out.println(7);
                yield 7;
            }
            case SATURDAY, THURSDAY -> {
                System.out.println(5);
                yield 5;
            }
            case WEDNESDAY -> {
                System.out.println(3);
                yield 3;
            }
            default -> {
                System.out.println("Error - Set to 99");
                yield 99;
            }
        };

        System.out.println(numLetters);
    }
}
