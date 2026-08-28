package com.bootcamp.model;

import java.util.ArrayList;
import java.util.List;

// TODO: Day 1 - AI Practice (Code Explanation & Documentation):
// Prompt your AI Agent: "Generate standard JavaDoc comments for this class explaining its fields, 
// state representation, and responsibility in the system."
public class Student {
    public String id; 
    public String n;
    public String email;
    public double gpa;
    
    private List<String> courses; 

    public Student(String id, String n, String email) {
        this.id = id;
        this.n = n;
        this.email = email;
        this.gpa = 0.0;
        this.courses = new ArrayList<>();
    }

    public Student(String id, String n, String email, double gpa) {
        this.id = id;
        this.n = n;
        this.email = email;
        this.gpa = gpa;
        this.courses = new ArrayList<>();
    }

    public void printInfo() {
        System.out.println("ID: " + id + " | Name: " + n + " | Email: " + email + " | GPA: " + gpa);
    }

    public String toCsv() {
        return id + "," + n + "," + email + "," + gpa;
    }
}