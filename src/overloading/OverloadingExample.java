package overloading;

import java.util.*;

//todo copy in notepad++

public class OverloadingExample {

    static String classify(List<?> list) {
        return "List";
    }

    static String classify(Set<?> set) {
        return "Set";
    }

    static String classify(Collection<?> collection) {
        return "unknown collection";
    }


    public static void main(String[] args) {

        Collection<?>[] example = {
                new ArrayList<Integer>(),
                new HashSet<String>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> collection : example) {
            System.out.println(classify(collection));
        }
    }
}
