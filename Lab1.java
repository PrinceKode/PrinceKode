package com.prince;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lab1 {
	public static void main(String agr[]) {
		Connection con = null;
		Statement st = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ sp_demo?useSSL=false", "root", "root");
			String sql = "insert into sp_demo  values('rama','rama@123','ram@123','male','up')";
			st = con.createStatement();
			int x = st.executeUpdate(sql);
			if (x == 1) {
				System.out.println("Data has been inserted");
			} else {
				System.out.println("not data inserted");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
