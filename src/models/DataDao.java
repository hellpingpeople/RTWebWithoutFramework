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

            ps = connection.prepareStatement("SELECT * FROM persona where sur_name like ?");
            ps.setString(1, re + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data = rs.getString(2);
                list.add(data);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}