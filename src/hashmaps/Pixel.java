package hashmaps;

public class Pixel implements Comparable<Pixel> {

    private int x;
    private int y;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pixel pixel = (Pixel) o;

        if (getX() != pixel.getX()) return false;
        return getY() == pixel.getY();
    }

    @Override
    public int hashCode() {
        int result = getX();
        //result = 31 * result + getY();
        return 31;
    }

    @Override
    public int compareTo(Pixel o) {
        return Integer.compare(o.x, x);
    }
}
