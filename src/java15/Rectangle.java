package java15;

/*public final class Rectangle extends Shapes{*/
public final class Rectangle implements Shapes{
    @Override
    public void print() {
        System.out.println("Print from Rectangle");
    }
}
