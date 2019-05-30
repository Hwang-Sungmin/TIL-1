package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		// 1. JDBC Driver Loading..
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Oracle DB�� ���� �� ���̴�! ����
		} catch (ClassNotFoundException e) {
			System.out.println("DRiver Loading err");
		}
		// 2. Connection 1521 ��Ʈ workspace = db, pwd = db
		String id = "db";
		String pwd = "db";
		String url = "jdbc:oracle:thin:@" + "70.12.50.222"+ ":" + "1521" + ":xe";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, id, pwd);
		} catch (SQLException e) {
			System.out.println("Connection err");
			System.out.println(e.getMessage());
		}
		// 3. SQL ����
		String sql = "INSERT INTO T_USER VALUES" + "(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id20");
			pstmt.setString(2, "pwd20");
			pstmt.setString(3, "������");
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			System.out.println(" err");
			e.printStackTrace();
		}
		// 4. Close all
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
