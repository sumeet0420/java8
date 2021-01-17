package java8;

import java.util.Iterator;

public class PersonalIterable implements Iterable<PersonalIterable>{

    @Override
    public Iterator<PersonalIterable> iterator() {
        return new PersonalIterator();
    }

    private class PersonalIterator implements Iterator {

        @Override
        public boolean hasNext() {
            System.out.println("Called HAs Next");
            return false;
        }

        @Override
        public Object next() {
            System.out.println("Called Next");
            return null;
        }
    }

    public static void main(String[] args) {
        for (var person:new PersonalIterable()) {
            System.out.println(person);
        }
    }
}
