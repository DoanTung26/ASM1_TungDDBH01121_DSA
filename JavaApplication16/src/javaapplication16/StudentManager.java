package javaapplication16;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentManager {

    private static final ArrayList<Student> studentCollection = new ArrayList<>();
    private static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        preloadStudents();

        boolean isRunning = true;
        while (isRunning) {
            displayOptions();
            int selection = userInput.nextInt();
            userInput.nextLine(); // Clear the newline

            switch (selection) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    modifyStudentDetails();
                    break;
                case 3:
                    removeStudentRecord();
                    break;
                case 4:
                    searchStudentByEmail();
                    break;
                case 5:
                    listAllStudents();
                    break;
                case 6:
                    arrangeStudentsByScore();
                    break;
                case 7:
                    evaluateStudentScores();
                    break;
                case 8:
                    System.out.println("Shutting down...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection! Please select a valid option.");
            }
        }
    }

    private static void preloadStudents() {
        studentCollection.add(new Student("Doan Tung", "doantung@gmail.com", 9.2, " Gia Lam Ha Noi", 20));
        studentCollection.add(new Student("Junning", "jun@gmail.com", 8.1, "Bac Tu Liem", 22));
        studentCollection.add(new Student("Quinn", "quinn@gmail.com", 5.4, "Nam Tu Liem", 19));
        studentCollection.add(new Student("Mai Linh", "lynh@gmail.com", 3.6, "Long Bien", 21));
    }

    private static void displayOptions() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Register Student");
        System.out.println("2. Modify Student Details");
        System.out.println("3. Remove Student Record");
        System.out.println("4. Search Student by Email");
        System.out.println("5. List All Students");
        System.out.println("6. Arrange Students by Score");
        System.out.println("7. Evaluate Student Scores");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    private static void registerStudent() {
        System.out.print("Enter student name: ");
        String name = userInput.nextLine();
        System.out.print("Enter student email: ");
        String email = userInput.nextLine();
        System.out.print("Enter student score: ");
        double score = userInput.nextDouble();
        userInput.nextLine(); // Clear the newline
        System.out.print("Enter student address: ");
        String address = userInput.nextLine();
        System.out.print("Enter student age: ");
        int age = userInput.nextInt();
        userInput.nextLine(); // Clear the newline

        studentCollection.add(new Student(name, email, score, address, age));
        System.out.println("Student registered successfully.");
    }

    private static void modifyStudentDetails() {
        System.out.print("Enter the email of the student to modify: ");
        String email = userInput.nextLine();

        for (Student student : studentCollection) {
            if (student.getEmail().equals(email)) {
                System.out.print("Enter new name: ");
                student.setName(userInput.nextLine());
                System.out.print("Enter new score: ");
                student.setScore(userInput.nextDouble());
                userInput.nextLine(); // Clear the newline
                System.out.print("Enter new address: ");
                student.setAddress(userInput.nextLine());
                System.out.print("Enter new age: ");
                student.setAge(userInput.nextInt());
                userInput.nextLine(); // Clear the newline
                System.out.println("Student details updated successfully.");
                return;
            }
        }
        System.out.println("Student with the provided email not found.");
    }

    private static void removeStudentRecord() {
        System.out.print("Enter the email of the student to remove: ");
        String email = userInput.nextLine();

        for (Student student : studentCollection) {
            if (student.getEmail().equals(email)) {
                studentCollection.remove(student);
                System.out.println("Student record removed successfully.");
                return;
            }
        }
        System.out.println("Student with the provided email not found.");
    }

    private static void searchStudentByEmail() {
        System.out.print("Enter the email of the student to search: ");
        String email = userInput.nextLine();

        for (Student student : studentCollection) {
            if (student.getEmail().equals(email)) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with the provided email not found.");
    }

    private static void listAllStudents() {
        if (studentCollection.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : studentCollection) {
                System.out.println(student);
                System.out.println("Rank: " + assignStudentRank(student.getScore()));
            }
        }
    }

    private static void arrangeStudentsByScore() {
        Collections.sort(studentCollection, (s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));
        System.out.println("Students arranged by score.");
        listAllStudents();
    }

    private static void evaluateStudentScores() {
        System.out.print("Enter the name of the first student: ");
        String firstName = userInput.nextLine();
        System.out.print("Enter the name of the second student: ");
        String secondName = userInput.nextLine();

        Student firstStudent = null;
        Student secondStudent = null;

        for (Student student : studentCollection) {
            if (student.getName().equalsIgnoreCase(firstName)) {
                firstStudent = student;
            }
            if (student.getName().equalsIgnoreCase(secondName)) {
                secondStudent = student;
            }
        }

        if (firstStudent == null || secondStudent == null) {
            System.out.println("One or both students not found.");
        } else {
            compareScores(firstStudent, secondStudent);
        }
    }

    private static void compareScores(Student s1, Student s2) {
        if (s1.getScore() > s2.getScore()) {
            System.out.println(s1.getName() + " has a higher score than " + s2.getName() + ".");
        } else if (s1.getScore() < s2.getScore()) {
            System.out.println(s2.getName() + " has a higher score than " + s1.getName() + ".");
        } else {
            System.out.println(s1.getName() + " and " + s2.getName() + " have the same score.");
        }
        System.out.println(s2.getName() + "'s score: " + s2.getScore() + " (" + assignStudentRank(s2.getScore()) + ")");
        System.out.println(s1.getName() + "'s score: " + s1.getScore() + " (" + assignStudentRank(s1.getScore()) + ")");
    }

    private static String assignStudentRank(double score) {
        if (score < 5.0) {
            return "Fail";
        } else if (score < 6.5) {
            return "Medium";
        } else if (score < 7.5) {
            return "Good";
        } else if (score < 9.0) {
            return "Very Good";
        } else if (score <= 10.0) {
            return "Excellent";
        } else {
            return "Invalid score";
        }
    }
}
