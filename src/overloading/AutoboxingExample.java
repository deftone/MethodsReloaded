package overloading;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AutoboxingExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = -3; i < 3; i++) {
            list.add(i);
            set.add(i);
        }

        for (int i = 0; i < 3; i++) {
            //remove item at index
            list.remove(i);
            //remove object
//            list.remove((Integer)i);
            set.remove(i);
        }

        System.out.println("list: " + list);
        System.out.println("set: " + set);
    }
}

























// list.remove(i);
//list.remove(Integer.valueOf(i));