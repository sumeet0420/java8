package puzzles;

public class Elvis {

//Class Initilization is from top to bottom..
    //Recursive class Initilization (Java ignores it.)

    public static final Elvis ELVIS = new Elvis();

//    private static final String LIVING;// = true;
    private static final String LIVING = "living";



    private Elvis() {
        System.out.println("Constructing..");

    }

//    public static final Elvis ELVIS = new Elvis();

    //private static final boolean LIVING = true;
//    private final Boolean alive = LIVING;
    private final String alive = LIVING;

    public final String lives() {
        return alive;
    }


    public static void main(String[] args) {
        System.out.println(ELVIS.lives().equals("living") ? "Wow" : "Heart broken");
//        System.out.println(new Elvis().lives() ? "Wow" : "Heart broken");
    }
}
