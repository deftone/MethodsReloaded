import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NullExample {

    public static void main(String[] args) {

        List<Integer> bad = badExample();
        System.out.println("bad, makes nullpointer");
        //additional code necessary! or nullpointer
        if (bad != null)
        for (Integer i : bad) {
            System.out.printf(String.valueOf(i));
        }

        Set<Integer> good = goodExample();
        System.out.println("good");
        for (Integer i : good) {
            System.out.printf(String.valueOf(i));
        }

        Set<Integer> goodOptimized = goodExampleOptimized();
        System.out.println("good optimized");
        for (Integer i : goodOptimized) {
            System.out.printf(String.valueOf(i));
        }

    }


    private static List<Integer> badExample() {
        //some code
        //if nothing is found:
        return null;

    }

    public static Set<Integer> goodExample() {
        Set<Integer> set = new HashSet<>();
        //some code which might add values to set
        //if nothing is found:
        return set;
    }

    public static Set<Integer> goodExampleOptimized() {
        //some code
        //if nothing is found:
        return Collections.emptySet();
    }
}
