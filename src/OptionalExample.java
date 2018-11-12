import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) throws Exception {

        TnsSomeObject tnsSomeObject = getTnsSomeObject(1);
        System.out.println(tnsSomeObject.getSomeName());

//        TnsSomeObject tnsSomeObjectNull = getTnsSomeObject(2);
//        System.out.println(tnsSomeObjectNull.getSomeName());


        Optional<TnsSomeObject> tnsSomeObjectOptional = getTnsSomeObjectBetter(2);
        //erste moeglichkeit: pruefen -> isPresent kann aber oft ersetzt werden! s.u.
        if (tnsSomeObjectOptional.isPresent())
            System.out.println(tnsSomeObjectOptional.get().getSomeName());


        //zweite moeglichkeit: was default (koennte man aber auch zurueckgeben - falls immer gueltig)
        TnsSomeObject tnsSomeObjectBetter = tnsSomeObjectOptional.get();
//                orElse(TnsSomeObject.getInstance(0, "default"));
        System.out.println(tnsSomeObjectBetter.getSomeName());

        //dritte moeglichkeit: exception wenn empty
        tnsSomeObjectBetter = tnsSomeObjectOptional.orElseThrow(() -> new Exception("nothing found"));
        System.out.println(tnsSomeObjectBetter.getSomeName());


    }


    // mit null -> so was gibt es oft im API code
    private static TnsSomeObject getTnsSomeObject(int id) {
        //irgendwelche Bedingungen mit der id
        if (id == 1)
            return TnsSomeObject.getInstance(1, "heinz");

        return null;
    }


    // mit Optional
    private static Optional<TnsSomeObject> getTnsSomeObjectBetter(int id) {
        //irgendwelche Bedingungen mit der id
        if (id == 1)
            return Optional.of(TnsSomeObject.getInstance(1, "heinz"));

        return Optional.empty();
    }


}


class TnsSomeObject {
    private int someId;
    private String someName;

    private TnsSomeObject(int id, String name) {
        this.someId = id;
        this.someName = name;
    }

    static TnsSomeObject getInstance(int id, String name) {
        return new TnsSomeObject(id, name);
    }

    String getSomeName() {
        return someName;
    }
}