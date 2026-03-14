package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true){

            System.out.println("\n===== Student Result Management System =====");
            System.out.println("1 Admin Login");
            System.out.println("2 Student Login");
            System.out.println("3 Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice){

                case 1:

                    if(AdminLogin.login()){

                        System.out.println("\nAdmin Menu");
                        System.out.println("1 Add Student");
                        System.out.println("2 Add Result");
                        System.out.println("3 View Result");

                        int adminChoice = sc.nextInt();

                        if(adminChoice == 1)
                            AddStudent.addStudent();

                        else if(adminChoice == 2)
                            AddResult.addResult();

                        else if(adminChoice == 3)
                            ViewResult.viewResult();
                    }

                    break;

                case 2:

                    int studentId = StudentLogin.login();

                    if(studentId != -1){
                        ViewResult.viewResult(studentId);
                    }

                    break;

                case 3:

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}