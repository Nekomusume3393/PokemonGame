package pokemon.pokedex.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class XJdbc {
	
	private static Connection connection;
	
	private static Connection openConnection() {
		var driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		var dburl = "jdbc:sqlserver://localhost:1433;databaseName=PokemonGame;encrypt=true;trustServerCertificate=true";
		var username = "sa";
		var password = "lineth0334158668";
		
		try {
			if (!XJdbc.isReady()) {
				Class.forName(driver);
				connection = DriverManager.getConnection(dburl, username, password);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
		return connection;
	}
	
	public static void closeConnection() {
		try {
			if (XJdbc.isReady()) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean isReady() {
		try {
			return (connection != null && !connection.isClosed());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static int executeUpdate(String sql, Object... values) {
		try {
			var stmt = XJdbc.getStmt(sql, values);
			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static ResultSet executeQuery(String sql, Object... values) {
		try {
			var stmt = XJdbc.getStmt(sql, values);
			return stmt.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static <T> T getValue(String sql, Object... values) {
		try {
			var rs = XJdbc.executeQuery(sql, values);
			if (rs.next()) {
				return (T) rs.getObject(1);
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static PreparedStatement getStmt(String sql, Object... values) throws SQLException {
		var conn = XJdbc.openConnection();
		var stmt = sql.trim().startsWith("{") ? conn.prepareCall(sql) : conn.prepareStatement(sql);
		for (int i = 0; i < values.length; i++) {
			stmt.setObject(i + 1, values[i]);
		}
		return stmt;
	}
	
	// Summary of the XJdbc class:
	// Provides utility methods for database operations.
	// - openConnection: Opens a connection to the database.
	// - closeConnection: Closes the database connection.
	// - isReady: Checks if the connection is ready (not null and not closed).
	// - executeUpdate: Executes an update SQL statement (INSERT, UPDATE, DELETE).
	// - executeQuery: Executes a query SQL statement and returns a ResultSet.
	// - getValue: Executes a query and returns the first value from the result set.
	// - getStmt: Prepares a SQL statement with the provided values.
	
}