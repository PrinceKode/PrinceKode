package com.prince;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Lab2 {
	public static void main(String agr[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Email id:");
		String user_email = s.next();
		System.out.println("Enter Password :");
		String user_pass = s.next();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sp_demo", "root", "root");
			PreparedStatement ps = con.prepareStatement("select * from sp_demo where email=? and password=?");
			ps.setString(1, user_email);
			ps.setString(2, user_pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("Login Successfully");
				System.out.println("Welcome:" + rs.getString("name"));
			} else {
				System.out.println("Invlid email and Password");
			}
			con.close();
			ps.close();
			rs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
