package Models;

/**
 * Created by kuldeep on 31/01/18.
 */

public class PojoClass {

    private String  text_airline,text_timeschedule,text_time;
    private int logo;

    public String getText_airline() {
        return text_airline;
    }

    public void setText_airline(String text_airline) {
        this.text_airline = text_airline;
    }

    public String getText_timeschedule() {
        return text_timeschedule;
    }

    public void setText_timeschedule(String text_timeschedule) {
        this.text_timeschedule = text_timeschedule;
    }

    public String getText_time() {
        return text_time;
    }

    public void setText_time(String text_time) {
        this.text_time = text_time;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
