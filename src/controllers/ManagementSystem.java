package controllers;

import models.Auto;
import models.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Vashurin Alexander on 25.01.2017.
 */
public class ManagementSystem
{
    private static Connection con;
    private static ManagementSystem instance;

    private ManagementSystem() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/rtdb";
            con = DriverManager.getConnection(url, "postgres", "postgres");
        } catch (ClassNotFoundException e) {
            throw new Exception(e);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static synchronized ManagementSystem getInstance() throws Exception {
        if (instance == null) {
            instance = new ManagementSystem();
        }
        return instance;
    }
//    private ManagementSystem() {
//    }
//
//    public static synchronized ManagementSystem getInstance() {
//        if (instance == null) {
//            Class.forName("org.postgresql.Driver");
//            try {
//                instance = new ManagementSystem();
//                Context ctx = new InitialContext();
//                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/RtDB");
//
//                try {
//
//                    con = dataSource.getConnection();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            } catch (NamingException e) {
//                e.printStackTrace();
//
//            }
//            return instance;
//        }
//        return null;
//    }



    public List getAutos() throws SQLException {
        List autos = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT auto_id, model_name, color, reg_number FROM auto");
        while (rs.next()) {
            Auto gr = new Auto();
            gr.setAutoId(rs.getInt(1));
            gr.setModelName(rs.getString(2));
            gr.setColor(rs.getString(3));
            gr.setRegNumber(rs.getString(4));
            autos.add(gr);
        }
        rs.close();
        stmt.close();
        return autos;
    }

    public Collection getAllPersonas() throws SQLException {
        Collection persons = new ArrayList();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT persona_id, first_name, patronymic, sur_name, "
                + "sex, date_of_birth FROM persona ORDER BY sur_name, first_name, patronymic");
        while (rs.next()) {
            Persona st = new Persona(rs);
            persons.add(st);
        }
        rs.close();
        stmt.close();
        return persons;
    }

    public Collection getPersonFromAuto(Auto auto, int year) throws SQLException {
        Collection persons = new ArrayList();
        PreparedStatement stmt = con.prepareStatement("SELECT persona_id, first_name, patronymic, sur_name, "
                + "sex, date_of_birth FROM persona "
                + "ORDER BY sur_name, first_name, patronymic");
        stmt.setInt(1, auto.getAutoId());
        stmt.setInt(2, year);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Persona st = new Persona(rs);
            persons.add(st);
        }
        rs.close();
        stmt.close();
        return persons;
    }

    public Persona getPersonById(int personaId) throws SQLException {
        Persona persona = null;
        PreparedStatement stmt = con.prepareStatement("ELECT persona_id, first_name, patronymic, sur_name, "
                + "sex, date_of_birth FROM persona WHERE persona_id = ?");
        stmt.setInt(1, personaId);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            persona = new Persona(rs);
        }
        rs.close();
        stmt.close();
        return persona;
    }

    public void movePersonsToAuto(Auto oldGroup, int oldYear, Auto newauto, int newYear) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE persona SET auto_id =  ?"
                + "WHERE auto_id =  ?");
        stmt.setInt(1, newauto.getAutoId());
        stmt.setInt(2, newYear);
        stmt.setInt(3, oldGroup.getAutoId());
        stmt.setInt(4, oldYear);
        stmt.execute();
    }

    public void removeStudentsFromGroup(Auto auto, int year) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM persona WHERE auto_id = ? ");
        stmt.setInt(1, auto.getAutoId());
        stmt.setInt(2, year);
        stmt.execute();
    }

    public void insertPersona(Persona persona) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO persona "
                + "(first_name, patronymic, sur_name, sex, date_of_birth, auto_id)"
                + "VALUES( ?,  ?,  ?,  ?,  ?,  ?)");
        stmt.setString(1, persona.getFirstName());
        stmt.setString(2, persona.getPatronymic());
        stmt.setString(3, persona.getSurName());
        stmt.setString(4, new String(new char[]{persona.getSex()}));
        stmt.setDate(5, new Date(persona.getDateOfBirth().getTime()));
        stmt.setInt(6, persona.getAutoId());
        stmt.execute();
    }

    public void updatePersona(Persona persona) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("UPDATE persona "
                + "SET first_name=?, patronymic=?, sur_name=?, sex=?, date_of_birth=?, auto_id=?,"
                + " WHERE persona_id=?");
        stmt.setString(1, persona.getFirstName());
        stmt.setString(2, persona.getPatronymic());
        stmt.setString(3, persona.getSurName());
        stmt.setString(4, new String(new char[]{persona.getSex()}));
        stmt.setDate(5, new Date(persona.getDateOfBirth().getTime()));
        stmt.setInt(6, persona.getAutoId());
        stmt.setInt(8, persona.getPersonaId());
        stmt.execute();
    }

    public void deletePersona(Persona persona) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM persona WHERE persona_id =  ?");
        stmt.setInt(1, persona.getPersonaId());
        stmt.execute();
    }
}