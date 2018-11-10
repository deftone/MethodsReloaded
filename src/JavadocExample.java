import com.sun.istack.internal.NotNull;

public class JavadocExample {


    /**
     * Kurzbeschreibung (in 3. Person): liefert die Quersumme einer Zahl (endet nach Punkt mit Leerzeichen).
     * <br>
     * jetzt konnen noch mehr details folgen, achtung: HTML foramt!
     * <br>
     * {@literal hiermit kann man z.B. > ausgeben}
     * <br>
     * <pre>{@code index < 0 || index>this.size()}</pre>
     * <br> oder so
     * {@code index < 0 || index>this.size()}
     * <br>
     * //param und return sollen Nominalphrasen sein, aber OHNE Punkt am ende
     * @param number die Zahl, von der man die Quersumme wissen moechte, darf nicht kleiner als 0 sein
     * @return die berechnete Quersumme
     *
     * //throws soll mit "wenn" anfangen ("if" in englisch?), auch hier kein Punkt
     * @throws NullPointerException wenn null uebergeben wird
     * @throws ArithmeticException  wenn eine negative zahl uebergeben wird
     */
    public static Integer checkSum(@NotNull Integer number) {
        if (number == null)
            throw new NullPointerException("number can not be null!");
        if (number <= 0)
            throw new ArithmeticException("number must be positive!");

        //code zum berechnen er quersumme
        //fake ergebnis:
        return number;
    }



    /**
     * liefert die Quersumme einer Zahl.
     * <br>
     * Details: {@literal sollte eine zahl > 0 sein}
     * <br>
     * Codebeispiel: <pre>{@code index < 0 || index>this.size()}</pre>
     *
     * @param number die Zahl, von der man die Quersumme wissen moechte, darf nicht kleiner als 0 sein
     * @return die berechnete Quersumme
     * @throws NullPointerException wenn null uebergeben wird
     * @throws ArithmeticException  wenn eine negative zahl uebergeben wird
     */
    public static Integer checkSumAgain(@NotNull Integer number) {
        if (number == null)
            throw new NullPointerException("number can not be null!");
        if (number <= 0)
            throw new ArithmeticException("number must be positive!");

        //code zum berechnen er quersumme
        //fake ergebnis:
        return number;
    }



    private enum Orchestra{
        /** Holzblaeser wie Floeten, Klarinetten*/
        WOODWIND,
        /** Blechblaeser wie Hoerner, Trompeten*/
        BRASS,
        /** Streicher wie Violine, Celle */
        STRINGS
    }
}
