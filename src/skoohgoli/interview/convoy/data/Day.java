package skoohgoli.interview.convoy.data;

/**
 * Created by Sacha on 5/25/17.
 */
public enum Day {
    M("Monday"),
    T("Tuesday"),
    W("Wednesday"),
    R("Thursday"),
    F("Friday");

    private String dayOfWeek;

    Day(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Day next() {
        switch (this) {
            case M:
                return T;
            case T:
                return W;
            case W:
                return R;
            case R:
                return F;
            case F:
            default:
                return null;
        }
    }



}
