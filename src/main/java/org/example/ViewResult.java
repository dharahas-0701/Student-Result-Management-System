package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ViewResult {

    public static void viewResult() {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            String query = "SELECT * FROM students s JOIN results r ON s.id = r.student_id WHERE s.id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){

                System.out.println("\n===== Student Result =====");

                System.out.println("Student ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Semester: " + rs.getInt("semester"));

                System.out.println("\nMarks:");
                System.out.println("Subject1: " + rs.getInt("subject1"));
                System.out.println("Subject2: " + rs.getInt("subject2"));
                System.out.println("Subject3: " + rs.getInt("subject3"));
                System.out.println("Subject4: " + rs.getInt("subject4"));
                System.out.println("Subject5: " + rs.getInt("subject5"));

                System.out.println("\nTotal: " + rs.getInt("total"));
                System.out.println("Percentage: " + rs.getDouble("percentage"));

            } else {

                System.out.println("Student result not found!");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}