
import java.sql.*;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String[] args) {
        // Show the splash screen
        final Splash splash = new Splash();
        splash.dispose();
        splash.setUndecorated(true);
        splash.setLocationRelativeTo(null);
        splash.show();
        // Create the data file in case it doesn't already exist
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "password");
            Statement smt = con.createStatement();
            String sql = "CREATE SCHEMA `data`";
            smt.executeUpdate(sql);
            sql = "CREATE TABLE `data`.`customer` (" +
                    "  `id` VARCHAR(45) NOT NULL," +
                    "  `password` VARCHAR(45) NULL," +
                    "  `first_name` VARCHAR(45) NULL," +
                    "  `last_name` VARCHAR(45) NULL," +
                    "  `address` TEXT NULL," +
                    "  `state` VARCHAR(45) NULL," +
                    "  `zip` VARCHAR(45) NULL," +
                    "  `ssn` VARCHAR(45) NULL," +
                    "  `question` TEXT NULL," +
                    "  `answer` TEXT NULL," +
                    "  `admin` BOOLEAN NULL," +
                    "  PRIMARY KEY (`id`));";
            smt.executeUpdate(sql);
            sql = "CREATE TABLE `data`.`flight` (" +
                    "  `id` VARCHAR(45) NOT NULL," +
                    "  `from` VARCHAR(45) NULL," +
                    "  `to` VARCHAR(45) NULL," +
                    "  `date` VARCHAR(45) NULL," +
                    "  `time` VARCHAR(45) NULL," +
                    "  `adate` VARCHAR(45) NULL," +
                    "  `atime` VARCHAR(45) NULL," +
                    "  `limit` VARCHAR(45) NULL," +
                    "  PRIMARY KEY (`id`));";
            smt.executeUpdate(sql);
            sql = "CREATE TABLE `data`.`booking_list` (" +
                    "  `customer_id` VARCHAR(45) NULL," +
                    "  `flight_id` VARCHAR(45) NULL);";
            smt.executeUpdate(sql);
        } catch(Exception exc){
            System.out.println(exc);
        }
    }
}
