package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {

    public static void addStudent() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter Semester: ");
            int sem = sc.nextInt();
            sc.nextLine();
            System.out.print("Set password: ");
            String pass = sc.nextLine();

            String query = "INSERT INTO students VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.setInt(4, sem);
            ps.setString(5, pass);

            ps.executeUpdate();

            System.out.println("Student Added Successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}