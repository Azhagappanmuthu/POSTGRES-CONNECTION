package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class postgreSQLJDBC {

	public static void main(String args[]) {
		Connection connection = null;
		Statement statement = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentProfile", "postgres",
					"postgres");
			System.out.println("opened database succesfully");
			statement = connection.createStatement();
			String sql = "CREATE TABLE STUDENTSDETAILS " +
			"(ID INT PRIMARY KEY   NOT NULL," +
		    "NAME          TEXT  NOT NULL," +
			"AGE           INT   NOT NULL," +
		    "ADDRESS       CHAR(50))";

					statement.executeUpdate(sql);
			statement.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("TABLE CREATED SUCCESSFULLY");

	}

}
