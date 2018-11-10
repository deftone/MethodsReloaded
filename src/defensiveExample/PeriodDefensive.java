package defensiveExample;

import java.util.Date;

//alternativ: die Klasse LocalDateTime, ZonedDateTime oder Instant nutzen!
//Date sollte man sowieso nicht mehr nutzen, da veraltet!

public class PeriodDefensive {

    private final Date start;
    private final Date end;

    //Korrigierter Konstruktor, der defensive Kopien erstellt
    PeriodDefensive(Date start, Date end) {

        //nicht clone benutzen! da Date nicht final ist, koennte eine boesartige Subklasse von Date erzeugt werden.
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        //Gueltigkeitspruefung auf Kopien -> TOCTOU-Angriff minimieren
        //anderer Thread, der in dem Zeitfenster der Verletzbarkeit die Parameter aendern koennte
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException("start muss vor ende sein!");
        }
    }

    //Korrigierte Getter, erstellt defensive Kopien der internen Felder
    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }


    public static void main(String[] args) {

        Date start = new Date();
        Date end = new Date();

        PeriodDefensive periodUndefensive = new PeriodDefensive(start, end);
        System.out.println(periodUndefensive.getStart().compareTo(periodUndefensive.getEnd()));
        System.out.println(periodUndefensive.getEnd().getTime());

        end.setTime(System.currentTimeMillis() - 100);
        System.out.println(periodUndefensive.getEnd().getTime());
        System.out.println(periodUndefensive.getStart().compareTo(periodUndefensive.getEnd()));
    }
}
