package puzzles;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShortSet {

    public static void main(String[] args) {
        /*Set<Short> hashSet = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            hashSet.add(i);
            hashSet.remove(i - 1);
        }*/
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            hashSet.add(i);
            hashSet.remove(i - 1);
        }
        System.out.println(hashSet.size());
        //1;100;Exception;None of the above

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        list.remove(1);
        list.remove(Integer.valueOf(1));
        System.out.println(list);
    }
}
