package edu.cis232.SemesterProjectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemDB {
	public static void main(String[] args) throws Exception{
		// Create a named constant for the URL.
		// NOTE: This value is specific for Java DB.
		final String DB_URL = "jdbc:hsqldb:file:ItemDB/Item";

		try {
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// If the DB already exists, drop the tables.
			dropTables(conn);

			// Build the Item table.
			buildItemTable(conn);

			// Close the connection.
			conn.close();
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

	/**
	 * The dropTables method drops any existing in case the database already
	 * exists.
	 */
	public static void dropTables(Connection conn) {
		System.out.println("Checking for existing tables.");

		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();
			

			try {
				// Drop the Customer table.
				stmt.execute("DROP TABLE Customer");
				System.out.println("Customer table dropped.");
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}

			try {
				// Drop the Item table.
				stmt.execute("DROP TABLE Item");
				System.out.println("Item table dropped.");
			} catch (SQLException ex) {
				// No need to report an error.
				// The table simply did not exist.
			}
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/**
	 * The buildItemTable method creates the Item table and adds some rows
	 * to it.
	 */
	public static void buildItemTable(Connection conn) {
		try {
			// Get a Statement object.
			Statement stmt = conn.createStatement();

			// Create the table.
			stmt.execute("CREATE TABLE Item (" 
					+ "Description CHAR(25), " 
					+ "ProdNum CHAR(10) NOT NULL PRIMARY KEY, "
					+ "Type CHAR(10) "
					+ "Price DOUBLE " + ")");

			// Insert row #1.
			stmt.execute("INSERT INTO Item VALUES ( " 
					+ "'Cereal', " 
					+ "'14-002', "
					+ "Food "
					+ "1.95 )");

			// Insert row #2.
			stmt.execute("INSERT INTO Item VALUES ( " 
					+ "'Ground Beef', " 
					+ "'15-001', "
					+ "Food "
					+ "7.95 )");

			// Insert row #3.
			stmt.execute("INSERT INTO Item VALUES ( " 
					+ "'Steak', " 
					+ "'15-002', "
					+ "Food "
					+ "7.95 )");

			// Insert row #4.
			stmt.execute("INSERT INTO Item VALUES ( " 
					+ "'Green Pants', " 
					+ "'15-001', "
					+ "Clothes "
					+ "8.55 )");

			// Insert row #5.
			stmt.execute("INSERT INTO Item VALUES ( " 
					+ "'Black T-Shirt', " 
					+ "'16-001', "
					+ "Clothes "
					+ "9.95 )");

			// Insert row #6.
			stmt.execute("INSERT INTO Item VALUES ( " 
					+ "'Red T-Shirt', " 
					+ "'16-002', "
					+ "Clothes "
					+ "9.95 )");

			System.out.println("Item table created.");
		} catch (SQLException ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}
	}

}
