package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect2 {
	


	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("작성자 id: ");
		int writerId = scanner.nextInt();
		
		
		Connection connection = DBConnection.getInstance().getConnection();

		String sql = "select * from board_mst where writer_id =?";
				
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, writerId); // 1은 쿼리에서 -> 방향으로 가다가 만난 첫 번째 물음표를 뜻한다.
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("id\ttitle\t\tcontent\t\t\tread_count\twriter_id");
			
			while(rs.next() ) {
				System.out.println("id: " + rs.getInt(1)
				+ "\t title: " + rs.getString(2)
				+ "\t content: " + rs.getString(3)
				+ "\t read_count" + rs.getInt(4)
				+ "\t writer_id" + rs.getInt(5));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
