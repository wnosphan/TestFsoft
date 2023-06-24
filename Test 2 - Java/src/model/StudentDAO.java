/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author ADMIN
 */
public class StudentDAO {

    public static List<Student> listOfStudent = new ArrayList<>();

    public StudentDAO() {
        addStudents();
    }

    public void addStudents() {
        listOfStudent.add(new Student("Son", "20", Gender.MALE, "091234512", "son@gmail.com", "qe170092"));
        listOfStudent.add(new Student("Phan", "22", Gender.FEMALE, "091224522", "phan@gmail.com", "qe171092"));
        listOfStudent.add(new Student("Mai", "22", Gender.FEMALE, "092234512", "mai@gmail.com", "qe170192"));
        listOfStudent.add(new Student("Trang", "21", Gender.FEMALE, "0291098512", "trang@gmail.com", "qe177892"));
        listOfStudent.add(new Student("Thu", "23", Gender.FEMALE, "0291214512", "thu@gmail.com", "qe170091"));
        listOfStudent.add(new Student("Thao", "22", Gender.FEMALE, "0002224522", "thao@gmail.com", "qe172092"));
        listOfStudent.add(new Student("Khoi", "22", Gender.MALE, "098754512", "khoi@gmail.com", "qe170562"));
        listOfStudent.add(new Student("Ha", "21", Gender.FEMALE, "091053272", "ha@gmail.com", "qe177122"));
        listOfStudent.add(new Student("Do", "20", Gender.MALE, "091234512", "do@gmail.com", "qe179992"));
        listOfStudent.add(new Student("Linh", "22", Gender.FEMALE, "096743522", "linh@gmail.com", "qe171882"));
        listOfStudent.add(new Student("Khoa", "22", Gender.FEMALE, "0996847512", "khoa@gmail.com", "qe176612"));
        listOfStudent.add(new Student("Thi", "21", Gender.FEMALE, "091011512", "thi@gmail.com", "qe109762"));
        listOfStudent.add(new Student("Ngan", "21", Gender.FEMALE, "091033512", "ngan@gmail.com", "qe17992"));

    }

    public void addStudent() {
        listOfStudent.add(new Student(view.View.getName(), view.View.getAge(), view.View.getGender(), view.View.getPhone(), view.View.getEmail(), view.View.getKey()));
    }

    public void printStudent() {
        Collections.sort(listOfStudent, (stu1, stu2) -> stu1.getName().compareTo(stu2.getName()));
        for (Student stu : listOfStudent) {
            System.out.println(stu);
        }
    }

    public void print(List<Student> st) {
        for (int i = 0; i < st.size(); i++) {
            System.out.println(st.get(i));
        }
    }

    public ArrayList<Student> searchStudents(Predicate<Student> p) {
        ArrayList<Student> st = new ArrayList<>();
        for (Student student : listOfStudent) {
            if (p.test(student)) {
                st.add(student);
            }
        }
        return st;
    }

    public void student20Age() {
        ArrayList<Student> st = searchStudents(p -> p.getAge().equals("20"));
        print(st);
    }

    public void studentMale22Age() {
        ArrayList<Student> st = searchStudents(p -> (p.getAge().equals("22") && p.getGender().equals(Gender.FEMALE)));
        print(st);
    }

}
