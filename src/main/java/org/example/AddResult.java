package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddResult {

    public static void addResult() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Subject1 Marks: ");
            int s1 = sc.nextInt();

            System.out.print("Enter Subject2 Marks: ");
            int s2 = sc.nextInt();

            System.out.print("Enter Subject3 Marks: ");
            int s3 = sc.nextInt();

            System.out.print("Enter Subject4 Marks: ");
            int s4 = sc.nextInt();

            System.out.print("Enter Subject5 Marks: ");
            int s5 = sc.nextInt();

            int total = s1 + s2 + s3 + s4 + s5;

            double percentage = total / 5.0;

            String query = "INSERT INTO results VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setInt(2, s1);
            ps.setInt(3, s2);
            ps.setInt(4, s3);
            ps.setInt(5, s4);
            ps.setInt(6, s5);
            ps.setInt(7, total);
            ps.setDouble(8, percentage);

            ps.executeUpdate();

            System.out.println("Result Added Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}