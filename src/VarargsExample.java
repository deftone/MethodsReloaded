public class VarargsExample {


    public static void main(String[] args) {

        System.out.println(getMinimum(3, 6, 1, 7));
        System.out.println(getMinimum());

    }

    private static int getMinimum(int... numbers) {
        //scheitert erst zur laufzeit wenn kein einziges int uebergeben wird -> nicht zur komplizerit :(
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


//    //performance bessere Alternative: mehere Ueberlagerungen und eine var args
//    private static int getMinimum() {
//        return -1;
//    }
//
//    private static int getMinimum(int one) {
//        return one;
//    }
//
//    private static int getMinimum(int one, int two) {
//        if (one > two)
//            return two;
//        return one;
//    }
//
//    private static int getMinimum(int one, int two, int three) {
//        int min = getMinimum(one, two);
//        return getMinimum(min, three);
//    }
//
//    private static int getMinimum(int one, int two, int three, int... rest) {
//        int min = getMinimum(one, two, three);
//        for (int number : rest) {
//            if (number < min)
//                min = number;
//        }
//        return min;
//    }
}
