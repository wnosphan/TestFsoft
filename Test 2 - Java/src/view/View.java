/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import model.Gender;
import model.StudentDAO;

/**
 *
 * @author ADMIN
 */
public class View {

    private static Scanner sc = new Scanner(System.in);

    public static String getName() {
        System.out.print("Enter Name: ");
        return sc.nextLine();

    }

    public static String getAge() {
        String age;

        do {
            System.out.print("Enter Age: ");
            age = sc.nextLine();

            if (!view.CheckValid.ageValid(age)) {
                System.out.println("Invalid input! Please re-enter Age.");
            }
        } while (!view.CheckValid.ageValid(age));

        return age;
    }

    public static Gender getGender() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Gender (Male or Female): ");
        String gender = sc.nextLine();

        while (!view.CheckValid.genderValid(gender)) {
            System.out.print("Invalid input! Please re-enter Gender (Male or Female): ");
            gender = sc.nextLine();
        }

        return gender.equals("Male") ? Gender.MALE : Gender.FEMALE;
    }

    public static String getPhone() {
        String phone;

        do {
            System.out.print("Enter Phone Number : ");
            phone = sc.nextLine();

            if (!view.CheckValid.phoneValid(phone)) {
                System.out.println("Invalid input! Please re-enter PHoneNumber (10 digit).");
            }
        } while (!view.CheckValid.phoneValid(phone));

        return phone;
    }

    public static String getEmail() {
        String email;

        do {
            System.out.print("Enter email: ");
            email = sc.nextLine();

            if (!view.CheckValid.emailValid(email)) {
                System.out.println("Invalid input! Please re-enter email.");
            }
        } while (!view.CheckValid.emailValid(email));

        return email;
    }

    public static String getKey() {

        String key;

        do {
            System.out.print("Enter key: ");
            key = sc.nextLine();

            if (!view.CheckValid.keyValid(StudentDAO.listOfStudent, key)) {
                System.out.println("Invalid input! Please re-enter key.");
            }
        } while (!view.CheckValid.keyValid(StudentDAO.listOfStudent, key));

        return key;

    }
}
