package com.studyservlet.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	// 1. IP:PORT
	// 2. ID, PW
	
	public void getConnector() {
		String user = "moveone";
		String password = "user01";
		String url = "jdbc:oracle:thin:@52.78.169.47:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		try {
		// 1. 드라이버를 메모리에 로딩(객체를 생성)
			Class.forName(driver);
		// 2. DB연결
			Connection con = DriverManager.getConnection(url, user, password);
		// 3. Sql문 생성
			String sql = "SELECT * FROM REGIONS";
			
		// 4. Sql문을 미리 전송
			PreparedStatement st = con.prepareStatement(sql);
		// 5. 
			
		// 6. 최종 전송 및 경과 처리
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				// rs = 1 , Europe
				int n = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(n + " : " + name);
				System.out.println("---------");
			}
			
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
