/**
 * Student Class - Basic Example of Classes and Objects
 *
 * This class demonstrates:
 * - Instance variables (attributes)
 * - Constructors (default and parameterized)
 * - Methods (getters, setters, utility methods)
 * - Object creation and usage
 */

package PracticeOOp.Classes_And_Objects_01;
public class Student {
    // Instance variables (attributes) - private for encapsulation
    private String name;
    private int age;
    private String studentId;
    private double gpa;
    private String major;

    // Default Constructor
    public Student() {
        this.name = "Unknown";
        this.age = 0;
        this.studentId = "000000";
        this.gpa = 0.0;
        this.major = "Undeclared";
    }

    // Parameterized Constructor
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = 0.0; // Default GPA for new students
        this.major = "Undeclared";
    }

    // Fully Parameterized Constructor
    public Student(String name, int age, String studentId, double gpa, String major) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.gpa = gpa;
        this.major = major;
    }

    // Getter Methods (Accessors)
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    // Setter Methods (Mutators)
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid name provided");
        }
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Age must be between 0 and 120");
        }
    }

    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA. GPA must be between 0.0 and 4.0");
        }
    }

    public void setMajor(String major) {
        if (major != null && !major.trim().isEmpty()) {
            this.major = major;
        } else {
            System.out.println("Invalid major provided");
        }
    }

    // Utility Methods
    public void study(String subject) {
        System.out.println(name + " is studying " + subject);
    }

    public void attendClass(String className) {
        System.out.println(name + " is attending " + className + " class");
    }

    public String getGradeLevel() {
        if (gpa >= 3.7) {
            return "Excellent";
        } else if (gpa >= 3.0) {
            return "Good";
        } else if (gpa >= 2.0) {
            return "Average";
        } else {
            return "Needs Improvement";
        }
    }

    public boolean isEligibleForHonors() {
        return gpa >= 3.5;
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("=== Student Information ===");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student ID: " + studentId);
        System.out.println("GPA: " + gpa);
        System.out.println("Major: " + major);
        System.out.println("Grade Level: " + getGradeLevel());
        System.out.println("Honors Eligible: " + (isEligibleForHonors() ? "Yes" : "No"));
        System.out.println("========================");
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d, studentId='%s', gpa=%.2f, major='%s'}",
                           name, age, studentId, gpa, major);
    }
}
