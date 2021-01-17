package java8;

import java.io.IOException;

public abstract class Hello {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello");

        System.out.println("Hello".concat("wow"));
        System.out.println(10%2);
        System.out.println(10&2);
        System.out.println(10|2);
        System.out.println(10>>1);
    }

    //abstract final void hello();
}
