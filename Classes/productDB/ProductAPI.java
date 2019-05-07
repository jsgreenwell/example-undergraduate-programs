package productDB;
// Add logging & change try/catches to throws
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductAPI {
	private Connection con = null;
	
	public ProductAPI() {
		try {
			con = DriverManager.getConnection("jdbc:sqlite:Database/ProductDB.db");
		} catch (SQLException e) {
			sqlExceptionHandler(e);
		}
	}

	public void create(String table) {
		String createQuery;
		
		try {
			switch (table.toLowerCase()) {
				case "employee":
					createQuery = "CREATE TABLE IF NOT EXISTS employee ( " +
							"employee_id      INTEGER PRIMARY KEY, " +
							"employee_name    VARCHAR, " +
							"supervisor_name  VARCHAR, " +
							"supervisor_title VARCHAR);";
					break;
				default:
					createQuery = "CREATE TABLE IF NOT EXISTS product (" +
						"oid VARCHAR PRIMARY KEY UNIQUE NOT NULL," +
						"product_name VARCHAR(50) NOT NULL," +
						"supplier VARCHAR(50) NOT NULL," +
						"quantity INTEGER DEFAULT 1," +
						"unit_cost NUMERIC(8,2) NOT NULL);";
					break;
			}
				
			Statement stmt = con.createStatement();
			stmt.execute(createQuery);
		} catch (SQLException e) {
			sqlExceptionHandler(e);
		}
	}
	
	public void insertProd(String iQuery, JsonTemplate[] jValues) {
		try {
			for (var element : jValues) {
				PreparedStatement pstmt = con.prepareStatement(iQuery);
			
				pstmt.setString(1, element.get_id());
				pstmt.setString(2, element.getProduct_name());
				pstmt.setString(3, element.getSupplier());
				pstmt.setInt(4, element.getQuantity());
				pstmt.setDouble(5, element.getUnit_cost());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			sqlExceptionHandler(e);
		}
	}

	public ArrayList<HashMap<String, Object>> selectAll(String sTable) {
		String selectall = sTable.toLowerCase() == "employee" ? "SELECT * FROM employee;" 
				: "SELECT * FROM product;";
		ResultSet rs = null;
		ArrayList<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();
		
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(selectall);
			
			while(rs.next()) {
				HashMap<String, Object> row = new HashMap<String, Object>();
				
				row.put("oid", rs.getString("oid"));
				row.put("prodName", rs.getString("product_name"));
				row.put("supplier", rs.getString("supplier"));
				row.put("quantity", rs.getInt("quantity"));
				row.put("unitCost", rs.getDouble("unit_cost"));
				rows.add(row);
			}
			
		} catch (SQLException e) {
			sqlExceptionHandler(e);
		}
		return rows;
	}
	
	public ResultSet selectProd(String sQuery) {
		ResultSet rs = null;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(sQuery);
		} catch (SQLException e) {
			sqlExceptionHandler(e);
		}
		return rs;
	}

	public void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			sqlExceptionHandler(e);
		}
	}
	
	public void sqlExceptionHandler(SQLException error) {
		// add logging, could make into a wrapper function
		System.out.println("Standard Failure: " + error.getMessage());
	}
}
