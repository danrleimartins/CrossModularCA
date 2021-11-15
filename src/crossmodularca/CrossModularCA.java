package crossmodularca;

import Utilities.InputUtilities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Danrlei & Guilherme
 */
public class CrossModularCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        displayMenu();
    }

    private static void displayMenu() {

        System.out.println("Welcome to the Calculator of Linear Equations.");
        System.out.println("\n1) LOGIN");
        System.out.println("\n2) REGISTER");
        System.out.println("\n3) EXIT");
        int options = InputUtilities.getUserInt("Please select one of the options.", 1, 3);

        switch (options) {

            case 1:
                String username = InputUtilities.getUserText("Please enter your username.");
                String password = InputUtilities.getUserText("Please enter your password.");
                //TO DO - COMPARE TO DATABASE
                break;

            case 2:
                System.out.println("Welcome to the self registration process.");
                String newUsername = InputUtilities.getUserText("Enter a username.");
                String newPassword = InputUtilities.getUserText("Enter a password.");
                //TO DO - GENERATE NEW USER OBJECT & INSERT TO DATABASE
                break;

            default:
        }

    }

    private static void connectDatabase() {
        
            try {
            // Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbServer = "jdbc:mysql://localhost:3306/equations";
            String user = "CCT";
            String password = "Dublin";
            String query = "SELECT * FROM user";

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
                System.out.println(rs.getString("id") + "\t" + rs.getString("first_name")
                        + "\t\t\t" + rs.getString("last_name"));
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
