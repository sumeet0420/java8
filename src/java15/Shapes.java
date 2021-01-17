package java15;

/*
public abstract sealed class Shapes permits java15.Circle, java15.Rectangle{

    public void getShapesInfo(){
        System.out.println("Shapes.");
    }

    public abstract void print();
}
*/
public sealed interface  Shapes permits java15.Circle, java15.Rectangle, java15.Polygon{

    default void getShapesInfo(){
        System.out.println("Shapes.");
    }

    public abstract void print();
}
