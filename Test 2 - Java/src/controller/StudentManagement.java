/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import model.StudentDAO;
import view.Menu;

/**
 *
 * @author ADMIN
 */
public class StudentManagement extends Menu<String> {

    static String[] mc = {"Add Student", "Student 20 Age ", "Female Student 22 Age", "Exit"};
    StudentDAO st;
    Scanner sc = new Scanner(System.in);

    public StudentManagement(StudentDAO st, String[] mc) {
        super("Student Management", mc);
        this.st = st;
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1 ->
                st.addStudent();
            case 2 ->
                st.student20Age();
            case 3 ->
                st.studentMale22Age();
            case 4 ->
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        StudentDAO st = new StudentDAO();
        new StudentManagement(st, mc).run();

    }
}
