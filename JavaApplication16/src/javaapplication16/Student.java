/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication16;

/**
 *
 * @author Dell
 */
public class Student {
    private String name;
    private String email;
    private double score;
    private String address;
    private int age;

    public Student(String name, String email, double score, String address, int age) {
        this.name = name;
        this.email = email;
        this.score = score;
        this.address = address;
        this.age = age;
    }

    // Getters and setters for all fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", score=" + score +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}

