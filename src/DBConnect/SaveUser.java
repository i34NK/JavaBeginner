package DBConnect;

import java.sql.*;

public class SaveUser {

    public static void saveUser(String firstname, String lastname) {
        String sql = "INSERT INTO user (firstname, lastname, timestamp) VALUES (?,?,?)";

        try (Connection con = ConnectDB.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);

            // บันทึกเวลาปัจจุบัน
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(3, timestamp);

            preparedStatement.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving user to database: " + e.getMessage());
        }
    }

}
