import com.sun.istack.internal.NotNull;

import java.util.Objects;

public class ValidationExample {

    private int numberOfValidations;
    private String author;

    /**
     *
     *
     * @NotNull can be used to document that no null values are allowed, but that does not do a nullcheck!
     *
     * @param numberOfValidations number of validations, must be positive!
     * @param author who did this, can not be null!
     */
    public ValidationExample(int numberOfValidations, @NotNull String author) {
        if (numberOfValidations <= 0)
            throw new ArithmeticException("number must be positive!");
        this.numberOfValidations = numberOfValidations;
        this.author = Objects.requireNonNull(author, "author can not be null!");
    }

    public static void main(String[] args) {

//        goodValidation(null);

//        goodValidation(-3);

//        betterValidation(null);

        System.out.println(useAssertionsForPrivateMethods(new int[]{1, 2}, 2));
//        System.out.println(useAssertionsForPrivateMethods(null, 3));
//        System.out.println(useAssertionsForPrivateMethods(new int[]{1, 2}, 0));
//        System.out.println(useAssertionsForPrivateMethods(new int[]{1, 2}, 3));

        ValidationExample validation = new ValidationExample(2, null);
        System.out.println(validation.numberOfValidations);
    }

    /**
     * bla bla bla {@literal -> make good java doc for public/protected methods for validations!}
     *
     * @param number ...
     * @return ...
     * @throws NullPointerException for invalid input
     * @throws ArithmeticException  for negative input
     */
    public static Integer goodValidation(Integer number) {
        if (number == null)
            throw new NullPointerException("number can not be null!");
        if (number <= 0)
            throw new ArithmeticException("number must be positive!");

        //some calculation
        return number * 3;
    }


    public static Integer betterValidation(Integer number) {
        int useThisForTheCalculation = Objects.requireNonNull(number, "optional message: number can not be null");

        if (number <= 0)
            throw new ArithmeticException("number must be positive!");

        //some calculation
        return useThisForTheCalculation + 1;
    }

    /**
     * funktioniert nur wenn -ea (oder -enableassertions) aktiviert sind!!!
     * in intellij: Run > Edit Configurations... > Configuration > VM options: -ea
     */
    private static String useAssertionsForPrivateMethods(int[] values, int size) {
        assert values != null;
        assert size > 0;
        assert size == values.length;

        return "yeah! passed all assertions :)";
    }

}
