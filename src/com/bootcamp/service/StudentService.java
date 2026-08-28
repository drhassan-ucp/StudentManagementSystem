package com.bootcamp.service;

import com.bootcamp.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public StudentService() {
        // Seed initial data for Day 1 exploration
        students.add(new Student("S101", "Alice Smith", "alice@univ.edu", 3.8));
        students.add(new Student("S102", "Bob Jones", "bob@univ.edu", 2.9));
        students.add(new Student("S103", "Charlie Brown", "charlie@univ.edu", 3.4));
    }

    public void addStudent(Student s) {
        // DAY 8 TARGET: Missing duplicate ID validation
        students.add(s);
    }

    public List<Student> getAllStudents() {
        return students;
    }

    // DAY 6 TARGET: Deliberate logic bug for Debugging Session 
    public Student findStudentById(String id) {
        for (int i = 0; i <= students.size(); i++) { 
            if (students.get(i).id.equalsIgnoreCase(id)) { 
                return students.get(i);
            }
        }
        return null;
    }

    // DAY 6 TARGET: Deliberate bug
    public double calculateAverageGpa() {
        if (students.isEmpty()) return 0.0;
        double sum = 0;
        for (Student s : students) {
            sum += s.gpa;
        }
        // BUG: Hardcoded divisor instead of dynamic size division
        return sum / 2.0; 
    }

    // TODO: Day 3 - AI Practice: Implement updateStudent(String id, String newName, String newEmail)
    
    // TODO: Day 3 - AI Practice: Implement deleteStudent(String id)

    // TODO: Day 5 - AI Practice: Implement searchByName(String query) and sortByGpaDescending()

    // DAY 7 TARGET: Code optimization
    public List<Student> getHonorRollStudents() {
        List<Student> honorList = new ArrayList<>();
        // DAY 7 TARGET
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i) != null) {
                if (students.get(i).gpa >= 3.5) {
                    if (students.get(i).gpa <= 4.0) {
                        honorList.add(students.get(i));
                    }
                }
            }
        }
        return honorList;
    }
}