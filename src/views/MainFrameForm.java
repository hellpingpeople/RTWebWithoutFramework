package views;

import java.util.Collection;

/**
 * Created by zaicys on 26.01.2017.
 */
public class MainFrameForm {
    private int year;
    private int autoId;
    private Collection autos;
    private Collection persons;

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getAutoId() {
        return autoId;
    }

    public void setAutos(Collection autos) {
        this.autos = autos;
    }

    public Collection getAutos() {
        return autos;
    }

    public void setPersons(Collection persons) {
        this.persons = persons;
    }

    public Collection getPersons() {
        return persons;
    }
}

