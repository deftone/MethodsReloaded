import java.util.ArrayList;
import java.util.List;

public class VarargsExample {


    public static void main(String[] args) {

//        System.out.println(getMinimum(3, 6, 1, 7));

        long vorher = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            getMinimum(2, 3);
        long nacher = System.currentTimeMillis();
        System.out.println(nacher - vorher);



        vorher = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            getMinimum2(2, 3);
        nacher = System.currentTimeMillis();
        System.out.println("vararg: " + (nacher - vorher));

        List<Integer> ints = new ArrayList<>();
        ints.add(2);
        ints.add(3);
        vorher = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
            getMinimum(ints);
        nacher = System.currentTimeMillis();
        System.out.println("lilsitst: " + (nacher - vorher));

//        System.out.println(getMinimum());

    }

    private static int getMinimum2(int... numbers) {
        //scheitert erst zur laufzeit wenn kein einziges int uebergeben wird -> nicht zur kompilierzeit :(
        if (numbers.length == 0) {
            throw new IllegalArgumentException("too few numbers");
        }

        //schleife geht nur mit vorinitialisierung -> haesslich :(
        int min = numbers[0];
        for (int number : numbers) {
            if (number < min)
                min = number;
        }
        return min;
    }


    //performance bessere Alternative: mehere Ueberlagerungen und eine var args
    private static int getMinimum() {
        return -1;
    }

    private static int getMinimum(int one) {
        return one;
    }

    private static int getMinimum(int one, int two) {
        if (one > two)
            return two;
        return one;
    }

    private static int getMinimum(int one, int two, int three) {
        int min = getMinimum(one, two);
        return getMinimum(min, three);
    }

    private static int getMinimum(List<Integer> ints) {
        return ints.stream().min(Integer::compareTo).get();
    }

//    private static int getMinimum(int one, int two, int three, int... rest) {
//        int min = getMinimum(one, two, three);
//        for (int number : rest) {
//            if (number < min)
//                min = number;
//        }
//        return min;
//    }
}
