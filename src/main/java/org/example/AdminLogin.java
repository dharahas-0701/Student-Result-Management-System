package org.example;

import java.sql.*;
import java.util.Scanner;

public class AdminLogin {

    public static boolean login(){

        Scanner sc = new Scanner(System.in);

        try{

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Admin Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Admin Password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM admins WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("Admin Login Successful!");
                return true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Invalid Admin Credentials!");
        return false;
    }
}