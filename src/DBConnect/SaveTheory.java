package DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaveTheory {
    public static void saveTheory(int trafficsign, int trafficline, int giveaway){
        String sql = "INSERT INTO theory (trafficsign_test, trafficline_test, giveaway_test) VALUES (?,?,?)";

        try(Connection con = ConnectDB.getConnection()){
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1,trafficsign);
            preparedStatement.setInt(2,trafficline);
            preparedStatement.setInt(3,giveaway);

            preparedStatement.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving user to database: " + e.getMessage());
        }
    }
}
