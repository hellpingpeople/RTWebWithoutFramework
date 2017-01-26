package models;

import controllers.DBUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Alexander Vashurin on 1/26/17.
 */
public class DataDao {
    private Connection connection;

    public DataDao() throws Exception {
        connection = DBUtility.getConnection();
    }

    public ArrayList<String> getPersonas(String re) {
        ArrayList<String> list = new ArrayList<String>();
        PreparedStatement ps = null;
        String data;
        try {

            ps = connection.prepareStatement("SELECT * FROM persona where sur_name like ? or first_name like ? ");
            ps.setString(1, re + "%");
            ps.setString(2,re+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data = rs.getString("sur_name") + " "
                        + rs.getString("first_name") + " "+
                            rs.getString("patronymic") + " "+
                            rs.getString("date_of_birth");
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}