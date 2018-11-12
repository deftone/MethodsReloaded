package defensiveExample;

import java.util.Date;

public class PeriodUndefensive {

    private final Date start;
    private final Date end;

    private PeriodUndefensive(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException("start muss vor ende sein!");
        this.start = start;
        this.end = end;
    }


    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }


    public static void main(String[] args) {

        Date start = new Date();
        Date end = new Date();

        PeriodUndefensive periodUndefensive = new PeriodUndefensive(start, end);
        System.out.println(periodUndefensive.getStart().compareTo(periodUndefensive.getEnd()));
        System.out.println(periodUndefensive.getEnd().getTime());

        //Problem: Date ist mutable!
        end.setTime(System.currentTimeMillis() - 100);
        System.out.println(periodUndefensive.getEnd().getTime());
        System.out.println(periodUndefensive.getStart().compareTo(periodUndefensive.getEnd()));
    }
}
