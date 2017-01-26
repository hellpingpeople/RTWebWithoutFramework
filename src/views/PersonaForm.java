package views;

import models.Persona;

import javax.servlet.http.HttpServlet;
import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * Created by Alexander Vashurin on 1/26/17.
 */
public class PersonaForm extends HttpServlet {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    private int personaId;
    private String firstName;
    private String surName;
    private String patronymic;
    private String dateOfBirth;
    private int sex;
    private int autoId;
    private Collection autos;

    public void initFromPersona(Persona st) {
        this.personaId = st.getPersonaId();
        this.firstName = st.getFirstName();
        this.surName = st.getSurName();
        this.patronymic = st.getPatronymic();
        this.dateOfBirth = sdf.format(st.getDateOfBirth());
        if (st.getSex() == 'М') {
            this.sex = 0;
        } else {
            this.sex = 1;
        }
        this.autoId = st.getAutoId();

    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }





    public int getAutoId() {
        return autoId;
    }

    public void setAutoId(int autoId) {
        this.autoId = autoId;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setAutos(Collection autos) {
        this.autos = autos;
    }

    public Collection getAutos() {
        return autos;
    }
}

