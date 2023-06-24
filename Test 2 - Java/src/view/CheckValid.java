/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import model.Gender;
import model.Student;

/**
 *
 * @author ADMIN
 */
public class CheckValid {

    public List<Student> listOfStudent = new ArrayList<>();

    public static boolean emailValid(String email) {
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(regex);
    }

    public static boolean ageValid(String age) {
        String regex = "\\d+";
        return age.matches(regex);
    }

    public static boolean phoneValid(String phone) {
        String regex = "\\d{10}";
        return phone.matches(regex);
    }

    public static boolean genderValid(String value) {
        try {
            Gender gender = Gender.valueOf(value.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean keyValid(List<Student> list, String key) {

        for (Student s : list) {
            if (s.getKey().equalsIgnoreCase(key)) {
                return false;
            }
        }

        return true;

    }
}
