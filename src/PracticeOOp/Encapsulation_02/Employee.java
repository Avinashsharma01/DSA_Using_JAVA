/**
 * Employee Class - Real-world Encapsulation with Business Rules
 *
 * This class demonstrates:
 * - Encapsulation in business domain
 * - Complex validation rules
 * - Computed properties
 * - Business logic protection
 * - Different access levels
 */

package PracticeOOp.Encapsulation_02;

public class Employee {
    // Private constants
    private static final double MIN_SALARY = 30000.0;
    private static final double MAX_SALARY = 500000.0;
    private static final int MAX_VACATION_DAYS = 30;

    // Private instance variables
    private String employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String position;
    private double baseSalary;
    private double bonus;
    private int vacationDaysUsed;
    private int totalVacationDays;
    private boolean isActive;
    private String hireDate;
    private String email;

    // Package-private (for HR systems)
    String socialSecurityNumber;

    // Protected (for inheritance)
    protected double performanceRating;

    // Constructor
    public Employee(String firstName, String lastName, String department,
                   String position, double baseSalary) {
        this.employeeId = generateEmployeeId();
        setFirstName(firstName);
        setLastName(lastName);
        setDepartment(department);
        setPosition(position);
        setBaseSalary(baseSalary);
        this.bonus = 0.0;
        this.vacationDaysUsed = 0;
        this.totalVacationDays = calculateVacationDays(position);
        this.isActive = true;
        this.hireDate = getCurrentDate();
        this.email = generateEmail();
        this.performanceRating = 3.0; // Default rating

        System.out.println("✅ Employee created: " + getFullName() + " (ID: " + employeeId + ")");
    }

    // Public getters with business logic
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getHireDate() {
        return hireDate;
    }

    // Controlled access to salary information
    public double getBaseSalary() {
        if (!isActive) {
            System.out.println("❌ Cannot access salary - employee is inactive");
            return 0.0;
        }
        return baseSalary;
    }

    public double getBonus() {
        return isActive ? bonus : 0.0;
    }

    public double getTotalCompensation() {
        if (!isActive) return 0.0;
        return baseSalary + bonus;
    }

    // Vacation management with business rules
    public int getVacationDaysRemaining() {
        return Math.max(0, totalVacationDays - vacationDaysUsed);
    }

    public int getVacationDaysUsed() {
        return vacationDaysUsed;
    }

    public int getTotalVacationDays() {
        return totalVacationDays;
    }

    // Setters with validation and business rules
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }

        if (firstName.trim().length() < 2) {
            throw new IllegalArgumentException("First name must be at least 2 characters");
        }

        this.firstName = capitalizeFirstLetter(firstName.trim());
        updateEmail(); // Email depends on name
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }

        if (lastName.trim().length() < 2) {
            throw new IllegalArgumentException("Last name must be at least 2 characters");
        }

        this.lastName = capitalizeFirstLetter(lastName.trim());
        updateEmail(); // Email depends on name
    }

    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be empty");
        }

        this.department = department.trim().toUpperCase();
        this.totalVacationDays = calculateVacationDays(this.position);
        System.out.println("✅ Department updated to: " + this.department);
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty");
        }

        this.position = position.trim();
        this.totalVacationDays = calculateVacationDays(this.position);
        System.out.println("✅ Position updated to: " + this.position);
    }

    public boolean setBaseSalary(double newSalary) {
        if (newSalary < MIN_SALARY) {
            System.out.printf("❌ Salary cannot be below minimum: $%.2f\n", MIN_SALARY);
            return false;
        }

        if (newSalary > MAX_SALARY) {
            System.out.printf("❌ Salary cannot exceed maximum: $%.2f\n", MAX_SALARY);
            return false;
        }

        // Salary can only be increased or decreased by max 20% at once
        if (baseSalary > 0) {
            double changePercent = Math.abs(newSalary - baseSalary) / baseSalary;
            if (changePercent > 0.20) {
                System.out.println("❌ Salary change cannot exceed 20% at once");
                return false;
            }
        }

        double oldSalary = this.baseSalary;
        this.baseSalary = newSalary;
        System.out.printf("✅ Salary updated from $%.2f to $%.2f\n", oldSalary, newSalary);
        return true;
    }

    public boolean setBonus(double bonus) {
        if (bonus < 0) {
            System.out.println("❌ Bonus cannot be negative");
            return false;
        }

        // Bonus cannot exceed 50% of base salary
        if (bonus > baseSalary * 0.5) {
            System.out.println("❌ Bonus cannot exceed 50% of base salary");
            return false;
        }

        this.bonus = bonus;
        System.out.printf("✅ Bonus set to $%.2f\n", bonus);
        return true;
    }

    // Vacation management methods
    public boolean requestVacation(int days) {
        if (!isActive) {
            System.out.println("❌ Inactive employees cannot request vacation");
            return false;
        }

        if (days <= 0) {
            System.out.println("❌ Vacation days must be positive");
            return false;
        }

        if (vacationDaysUsed + days > totalVacationDays) {
            System.out.printf("❌ Not enough vacation days. Available: %d, Requested: %d\n",
                            getVacationDaysRemaining(), days);
            return false;
        }

        vacationDaysUsed += days;
        System.out.printf("✅ Vacation approved: %d days. Remaining: %d days\n",
                         days, getVacationDaysRemaining());
        return true;
    }

    public void resetVacationDays() {
        vacationDaysUsed = 0;
        this.totalVacationDays = calculateVacationDays(position);
        System.out.println("✅ Vacation days reset for new year");
    }

    // Performance management
    public boolean setPerformanceRating(double rating) {
        if (rating < 1.0 || rating > 5.0) {
            System.out.println("❌ Performance rating must be between 1.0 and 5.0");
            return false;
        }

        this.performanceRating = rating;
        System.out.printf("✅ Performance rating set to: %.1f\n", rating);

        // Automatic bonus calculation based on performance
        calculatePerformanceBonus();
        return true;
    }

    public double getPerformanceRating() {
        return performanceRating;
    }

    public String getPerformanceCategory() {
        if (performanceRating >= 4.5) return "Outstanding";
        else if (performanceRating >= 3.5) return "Exceeds Expectations";
        else if (performanceRating >= 2.5) return "Meets Expectations";
        else if (performanceRating >= 1.5) return "Below Expectations";
        else return "Unsatisfactory";
    }

    // Employee lifecycle management
    public void promoteEmployee(String newPosition, double salaryIncrease) {
        if (!isActive) {
            System.out.println("❌ Cannot promote inactive employee");
            return;
        }

        String oldPosition = this.position;
        setPosition(newPosition);

        if (setBaseSalary(baseSalary + salaryIncrease)) {
            System.out.printf("🎉 %s promoted from %s to %s with $%.2f salary increase!\n",
                            getFullName(), oldPosition, newPosition, salaryIncrease);
        }
    }

    public void terminateEmployee() {
        this.isActive = false;
        this.bonus = 0.0;
        System.out.println("💼 Employee " + getFullName() + " has been terminated");
    }

    public void reactivateEmployee() {
        this.isActive = true;
        System.out.println("✅ Employee " + getFullName() + " has been reactivated");
    }

    // Private helper methods (encapsulated implementation)
    private String generateEmployeeId() {
        return "EMP" + System.currentTimeMillis() % 100000;
    }

    private String generateEmail() {
        if (firstName == null || lastName == null) return "";
        return (firstName + "." + lastName + "@company.com").toLowerCase();
    }

    private void updateEmail() {
        this.email = generateEmail();
    }

    private String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private String getCurrentDate() {
        // Simplified date - in real app, use proper date formatting
        return "2024-01-01";
    }

    private int calculateVacationDays(String position) {
        if (position == null) return 15;

        position = position.toLowerCase();
        if (position.contains("senior") || position.contains("manager")) {
            return 25;
        } else if (position.contains("director") || position.contains("vp")) {
            return 30;
        } else {
            return 15;
        }
    }

    private void calculatePerformanceBonus() {
        double bonusPercent = 0.0;

        if (performanceRating >= 4.5) {
            bonusPercent = 0.15; // 15% bonus
        } else if (performanceRating >= 3.5) {
            bonusPercent = 0.10; // 10% bonus
        } else if (performanceRating >= 2.5) {
            bonusPercent = 0.05; // 5% bonus
        }

        if (bonusPercent > 0) {
            double calculatedBonus = baseSalary * bonusPercent;
            setBonus(calculatedBonus);
        }
    }

    // Public method to display employee information
    public void displayEmployeeInfo() {
        System.out.println("\n👨‍💼 ===== Employee Information =====");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + getFullName());
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);
        System.out.println("Position: " + position);
        System.out.println("Hire Date: " + hireDate);
        System.out.printf("Base Salary: $%.2f\n", getBaseSalary());
        System.out.printf("Bonus: $%.2f\n", getBonus());
        System.out.printf("Total Compensation: $%.2f\n", getTotalCompensation());
        System.out.printf("Performance: %.1f (%s)\n", performanceRating, getPerformanceCategory());
        System.out.printf("Vacation: %d used / %d total (%d remaining)\n",
                         vacationDaysUsed, totalVacationDays, getVacationDaysRemaining());
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("=================================\n");
    }

    @Override
    public String toString() {
        return String.format("Employee{id='%s', name='%s', department='%s', position='%s', active=%s}",
                           employeeId, getFullName(), department, position, isActive);
    }
}
