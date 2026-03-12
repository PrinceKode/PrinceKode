package com.prince;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteValue {
	public static void main(String agr[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Your Email");
		String email1 = s.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sp_demo?useSSL=false", "root", "root");
			PreparedStatement ps = con.prepareStatement("DELETE FROM sp_demo WHERE email=?");
			ps.setString(1, email1);
			int x = ps.executeUpdate();
			if (x == 1) {
				System.out.println(x);
				System.out.println("Ok");
			} else {
				System.out.println("Not ok");

			}
			con.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
