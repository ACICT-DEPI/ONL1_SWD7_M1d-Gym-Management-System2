package firsttry.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    static String url = "jdbc:mysql://localhost:3306/";
	static String user = "Amr";
	static String password = "Amr_12saber";
    
    // Database name to be created
	static String databaseName = "GymWithAPI";

    // SQL statement to create a new database
	static String createDatabaseSQL = "CREATE DATABASE " + databaseName;

    // Connection and Statement objects
	static Connection connection = null;
	static Statement statement = null;

    /////////////////////////////////////////////////////////////////////////////
	
	public static void deleteDB() 
    {
		try {
    		connection = DriverManager.getConnection(url, user, password);
    		// Create a Statement object
            statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE " + databaseName);
            
            //Close the connection
            if (statement != null) statement.close();
            if (connection != null) connection.close();
            System.out.println("Deleted Successfully");
    	}
    	catch (SQLException e) {
    		System.out.println("Can't connect to the Database" + e.getMessage());
    	}
    }
	
    public static void createDB() 
    {
    	try {
    		connection = DriverManager.getConnection(url, user, password);
    		// Create a Statement object
            statement = connection.createStatement();
            statement.executeUpdate(createDatabaseSQL);
            
            Statement statementGlobal = connection.createStatement();
            statementGlobal.executeUpdate("SET GLOBAL sql_mode = ''");
            
            //Close the connection
            if (statement != null) statement.close();
            if (statementGlobal != null) statementGlobal.close();
            if (connection != null) connection.close();
    	}
    	catch (SQLException e) {
    		System.out.println("Can't connect to the Database" + e.getMessage());
    	}
    }
    
////////////////////////////////////////////////////////////////////////////////
    
    public static void createTables() 
    {
        // SQL statements to create tables
        String createPersonTable = "CREATE TABLE Person ("
                + "SSR VARCHAR(14) PRIMARY KEY , "
                + "Name VARCHAR(255) NOT NULL, "
                + "Age INT, "
                + "Email VARCHAR(255), "
                + "PhoneNumber VARCHAR(20), "
                + "Password VARCHAR(255)"
                + ");";

        String createTrainerTable = "CREATE TABLE Trainer ("
        		+ "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "SSR VARCHAR(14) , "
                + "WorkingHours INT, "
                + "GymHallId INT, "
                + "Rating DECIMAL(3, 2), "
                + "Salary DECIMAL(10, 2), "
                + "FOREIGN KEY (SSR) REFERENCES Person(SSR) ON DELETE CASCADE , "
                + "FOREIGN KEY (GymHallId) REFERENCES GymHall(Id)"
                + ");";

        String createTraineeTable = "CREATE TABLE Trainee ("
        		+ "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "SSR VARCHAR(14),"
                + "SubscriptionID int, "
                + "ExercisePlanID int, "
                + "Points INT ,"
                + "FOREIGN KEY (SSR) REFERENCES Person(SSR) ON DELETE CASCADE , "
                + "FOREIGN KEY (ExercisePlanID) REFERENCES ExercisePlan(Id) ON DELETE CASCADE , "
                + "FOREIGN KEY (SubscriptionID) REFERENCES Subscription(Id) ON DELETE CASCADE"
                + ") AUTO_INCREMENT = 1000;";

        // String createAdminTable = "CREATE TABLE Admin ("
        // 		+ "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
        //         + "PersonId INT, "
        //         + "Role VARCHAR(255) NOT NULL, "
        //         + "FOREIGN KEY (PersonId) REFERENCES Person(Id) ON DELETE CASCADE"
        //         + ");";

        // String createManagerTable = "CREATE TABLE Manager ("
        // 		+ "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
        //         + "PersonId INT, "
        //         + "Role VARCHAR(255) NOT NULL, "
        //         + "FOREIGN KEY (PersonId) REFERENCES Person(Id) ON DELETE CASCADE"
        //         + ");";

        String createGymHallTable = "CREATE TABLE GymHall ("
                + "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "Name VARCHAR(255)"
                + ");";
        
        String createEquipmentTable = "CREATE TABLE Equipment ("
                + "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "GymHallId INT, "
                + "Name VARCHAR(255), "
                + "Type VARCHAR(255) , "
                + "FOREIGN KEY (GymHallId) REFERENCES GymHall(Id)"
                + ");";


        // String createGymHallEquipmentTable = "CREATE TABLE GymHall_Equipment ("
        //         + "GymHallId INT, "
        //         + "EquipmentId INT, "
        //         + "PRIMARY KEY (GymHallId, EquipmentId), "
        //         + "FOREIGN KEY (GymHallId) REFERENCES GymHall(Id) ON DELETE CASCADE, "
        //         + "FOREIGN KEY (EquipmentId) REFERENCES Equipment(Id) ON DELETE CASCADE"
        //         + ");";

        String createExercisePlanTable = "CREATE TABLE ExercisePlan ("
                + "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "Steps VARCHAR(255), "
                + "Duration INT"
                + ");";

        String createSubscriptionTable = "CREATE TABLE Subscription ("
                + "Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, "
                + "Type VARCHAR(255), "
                + "StartDate DATE, "
                + "EndDate DATE, "
                + "Price DECIMAL(10, 2), "
                + "Discount DECIMAL(5, 2)"
                + ") AUTO_INCREMENT = 5100;";

        try (Connection conn = DriverManager.getConnection(url+databaseName, user, password);
             Statement stmt = conn.createStatement()) {

            // Execute SQL statements
        	stmt.executeUpdate(createGymHallTable);
        	stmt.executeUpdate(createExercisePlanTable);
            stmt.executeUpdate(createSubscriptionTable);
            stmt.executeUpdate(createPersonTable);
            System.out.println("Person table created successfully!");
            stmt.executeUpdate(createTrainerTable);
            stmt.executeUpdate(createTraineeTable);
            System.out.println("Trainee table created successfully!");
            // stmt.executeUpdate(createAdminTable);
            // stmt.executeUpdate(createManagerTable);
            stmt.executeUpdate(createEquipmentTable);
            // stmt.executeUpdate(createGymHallEquipmentTable);
            

            System.out.println("Tables created successfully!");

        } catch (Exception e) {
            System.out.println("Connection Error : " + e.getMessage());
        }
    }
    
/////////////////////////////////////////////////////////////////////////////////////////
   
}
