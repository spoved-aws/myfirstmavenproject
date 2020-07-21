package com.practiceTestClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class databaseConnectivity {

	public static void connectToDatabase() {

		try {
			Connection connection = DriverManager.getConnection("jdbc:Mysql://localhost:3306/testdatabase", "root",
					"Anusha22@");

			Statement statement = connection.createStatement();

			String s = "insert into empdetails values ('Prasad', 'Venkat', '99999')";
			String s2 = "delete from empdetails where FName='Kanu'";
			String s3 = "select * from empdetails";
//			statement.executeUpdate(s2);
			ResultSet rs = statement.executeQuery(s3);
			
			int size = rs.getFetchSize(); 
			while(rs.next()) {
				
				System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3));

			}

		
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		databaseConnectivity.connectToDatabase();

	}

	

}
