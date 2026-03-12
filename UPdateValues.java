package com.prince;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UPdateValues {
	public static void main(String agr[]) {
		System.out.println("User to Data Update in table");
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Email");
		String email1 = s.next();
		System.out.println("Enter your password(To be Updated)");
		String pass1 = s.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sp_demo?useSSL=false", "root", "root");
			PreparedStatement ps = con.prepareStatement("update sp_demo set password=? where email=? ");
			ps.setString(1, email1);
			ps.setString(2, pass1);
			int x = ps.executeUpdate();
			if (x == 1) {
				System.out.println("Data has been Update");
			} else {
				System.out.println("Data has been not update");
			}

			con.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
