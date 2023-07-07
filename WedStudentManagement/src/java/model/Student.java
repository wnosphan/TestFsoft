/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ADMIN
 */
public class Student implements Comparable<Student>  {
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String createdAt;


    public Student() {

    }
    public Student(String name, String id, String password, String email, String phone, String address, String gender, String createdAt) {
        
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.createdAt = createdAt;
       
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int compareTo(Student other) {
        return other.getCreatedAt().compareTo(this.getCreatedAt());
    }
  
}
