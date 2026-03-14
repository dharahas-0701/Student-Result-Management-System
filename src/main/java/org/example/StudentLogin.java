package org.example;

import java.sql.*;
import java.util.Scanner;

public class StudentLogin {

    public static int login(){

        Scanner sc = new Scanner(System.in);

        try{

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            String query = "SELECT * FROM students WHERE id=? AND password=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("Student Login Successful!");
                return id;
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Invalid Student ID or Password!");
        return -1;
    }
}