package crossmodularca;

import Utilities.InputUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Danrlei
 */
public class Login {

    public static void Login() {

        try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbServer = "jdbc:mysql://localhost:3306/equations";
            String user = "root";
            String password = "root";
            String query = "SELECT * FROM user_data";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Outcome is: Successfull");

            // Loop through the result set
            System.out.println("ID" + "\t" + "First Name" + "\t\t" + "Last Name");
            System.out.println("===============================================");
            while (rs.next()) {
                System.out.println(rs.getString("id") + "\t" + rs.getString("username")
                        + "\t\t\t" + rs.getString("password"));
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Welcome to the Calculator of Linear Equations.");
        System.out.println("\n1) LOGIN");
        System.out.println("\n2) REGISTER");
        System.out.println("\n3) EXIT");
        int options = InputUtilities.getUserInt("Please select one of the options.", 1, 3);

        switch (options) {

            case 1:
                String inputUsername = InputUtilities.getUserText("Please enter your username.");
                String inputPassword = InputUtilities.getUserText("Please enter your password.");
                //TO DO - COMPARE TO DATABASE
                break;

            case 2:
                System.out.println("Welcome to the self registration process.");
                String newUsername = InputUtilities.getUserText("Enter a username.");
                String newPassword = InputUtilities.getUserText("Enter  password.");
                //TO DO - GENERATE NEW USER OBJECT & INSERT TO DATABASE
                User newUser = new User(newUsername, newPassword);
                break;

            default:
        }

    }

}
