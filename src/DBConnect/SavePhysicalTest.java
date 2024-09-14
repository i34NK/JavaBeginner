package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SavePhysicalTest {
    public static void savePhysical(boolean colorblindess, boolean farsight, boolean astigmatism, boolean bodyresponse) {
        String sql = "INSERT INTO physical (colorblindess_test, farsight_test, astigmatism_test, bodyresponse_test) VALUES (?,?,?,?)";

        try(Connection con = ConnectDB.getConnection()){
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setBoolean(1,colorblindess);
            preparedStatement.setBoolean(2,farsight);
            preparedStatement.setBoolean(3,astigmatism);
            preparedStatement.setBoolean(4,bodyresponse);

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving user to database: " + e.getMessage());
        }
    }
}
