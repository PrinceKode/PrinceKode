package com.prince;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertValue {
	public static void main(String agr[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Your Name");
		String name1 = s.next();
		System.out.println("Enter Your Email");
		String email1 = s.next();
		System.out.println("Enter Your Pass");
		String pass1 = s.next();

		System.out.println("Enter Your Gender");
		String gender1 = s.next();
		System.out.println("Enter Your City");
		String city1 = s.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sp_demo?useSSL=false", "root", "root");
			PreparedStatement ps = con.prepareStatement("insert into sp_demo values(?,?,?,?,?)");
			ps.setString(1, name1);
			ps.setString(2, email1);
			ps.setString(3, pass1);
			ps.setString(4, gender1);
			ps.setString(5, city1);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Success");
			} else {
				System.out.println("Fail");
			}
			con.close();
			ps.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
