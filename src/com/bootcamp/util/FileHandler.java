package com.bootcamp.util;

import com.bootcamp.model.Student;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "students.txt";

    // DAY 8 TARGET: Weak exception handling and missing resource management (no try-with-resources)
    public static void saveStudents(List<Student> students) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (Student s : students) {
                writer.write(s.toCsv());
                writer.newLine();
            }
            writer.close(); // DAY 7 TARGET: Risky resource closing outside finally block
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // TODO: Day 8 - AI Practice: Refactor loadStudents() using modern Java NIO and safe try-with-resources
    public static List<Student> loadStudents() {
        List<Student> loaded = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return loaded;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    loaded.add(new Student(parts[0], parts[1], parts[2], Double.parseDouble(parts[3])));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error loading data.");
        }
        return loaded;
    }
}