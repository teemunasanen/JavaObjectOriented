package Team_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class JDBCteam {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://sql7.freemysqlhosting.net:3306/sql7373042";

	// Database credentials
	static final String USER = "sql7373042";
	static final String PASS = "uufBLeDEbH";

	public static void addPlayer(Player jari) {

		String frontName = jari.getFname();
		String lastName = jari.getLname();
		String classification = jari.getClassification();

		Connection conn = null;
		Statement stmt = null;
		try {
			// Connect
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Statement
			String sql = "INSERT INTO TEAM (FName, LName, Classification) values (?,?,?)";

			PreparedStatement preparedStmt = conn.prepareStatement(sql);

			preparedStmt.setString(1, frontName);
			preparedStmt.setString(2, lastName);
			preparedStmt.setString(3, classification);

			preparedStmt.execute();

			System.out.println("Saving data...");

			conn.close();

			// Catch errors

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public static void loadPlayers() {

		Connection conn = null;
		Statement stmt = null;
		try {
			// Connect
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Downloading data...");

			// Statement
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM TEAM");

			DefaultTableModel model = new DefaultTableModel(
					new String[] { "Front Name", "Last name", "Classification" }, 0);

			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) });

				GUI_Team.table.setModel(model);
			}
			System.out.println("");
			conn.close();

			// Catch errors
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	public static void removePlayer() {

		DefaultTableModel model = (DefaultTableModel) GUI_Team.table.getModel();
		int row = GUI_Team.table.getSelectedRow();
		String front = model.getValueAt(row, 0).toString();
		String last = model.getValueAt(row, 1).toString();

		Connection conn = null;
		Statement stmt = null;
		try {
			// Connect
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Loading data...");
			// Statement
			String sql = "DELETE FROM TEAM WHERE FName = ? AND LName = ?";

			PreparedStatement preparedStmt = conn.prepareStatement(sql);

			preparedStmt.setString(1, front);
			preparedStmt.setString(2, last);

			preparedStmt.execute();

			System.out.println("Removing data...");
			System.out.println("Player " + front + " " + last + " removed from the Team");
			System.out.println("");
			conn.close();

			// Catch errors
		} catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}