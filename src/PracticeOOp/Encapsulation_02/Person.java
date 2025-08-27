/**
 * Person Class - Demonstrates Basic Encapsulation
 *
 * This class shows:
 * - Private instance variables (data hiding)
 * - Public getter and setter methods (controlled access)
 * - Data validation in setter methods
 * - Encapsulation benefits: security, data integrity, maintainability
 */
package PracticeOOp.Encapsulation_02;

public class Person {
    // Private instance variables - hidden from outside access
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private double height; // in centimeters
    private double weight; // in kilograms
    private String address;

    // Constructor
    public Person(String name, int age) {
        setName(name); // Using setter for validation
        setAge(age);   // Using setter for validation
        this.email = "";
        this.phoneNumber = "";
        this.height = 0.0;
        this.weight = 0.0;
        this.address = "";
    }

    // Parameterized constructor
    public Person(String name, int age, String email, String phoneNumber) {
        setName(name);
        setAge(age);
        setEmail(email);
        setPhoneNumber(phoneNumber);
        this.height = 0.0;
        this.weight = 0.0;
        this.address = "";
    }

    // Getter methods (Accessors) - Provide controlled READ access
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getAddress() {
        return address;
    }

    // Setter methods (Mutators) - Provide controlled WRITE access with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Error: Name cannot be empty");
            return;
        }

        if (name.trim().length() < 2) {
            System.out.println("❌ Error: Name must be at least 2 characters long");
            return;
        }

        // Remove extra spaces and capitalize properly
        this.name = capitalizeWords(name.trim());
        System.out.println("✅ Name set to: " + this.name);
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("❌ Error: Age cannot be negative");
            return;
        }

        if (age > 150) {
            System.out.println("❌ Error: Age seems unrealistic (>150 years)");
            return;
        }

        this.age = age;
        System.out.println("✅ Age set to: " + this.age);
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            this.email = "";
            return;
        }

        // Basic email validation
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        if (!email.matches(emailPattern)) {
            System.out.println("❌ Error: Invalid email format");
            return;
        }

        this.email = email.toLowerCase().trim();
        System.out.println("✅ Email set to: " + this.email);
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            this.phoneNumber = "";
            return;
        }

        // Remove all non-digits
        String cleanNumber = phoneNumber.replaceAll("[^0-9]", "");

        if (cleanNumber.length() < 10) {
            System.out.println("❌ Error: Phone number must have at least 10 digits");
            return;
        }

        // Format as (XXX) XXX-XXXX for 10 digits or +X (XXX) XXX-XXXX for 11+
        if (cleanNumber.length() == 10) {
            this.phoneNumber = String.format("(%s) %s-%s",
                cleanNumber.substring(0, 3),
                cleanNumber.substring(3, 6),
                cleanNumber.substring(6));
        } else if (cleanNumber.length() == 11) {
            this.phoneNumber = String.format("+%s (%s) %s-%s",
                cleanNumber.substring(0, 1),
                cleanNumber.substring(1, 4),
                cleanNumber.substring(4, 7),
                cleanNumber.substring(7));
        } else {
            this.phoneNumber = cleanNumber; // Keep as is for international numbers
        }

        System.out.println("✅ Phone number set to: " + this.phoneNumber);
    }

    public void setHeight(double height) {
        if (height <= 0) {
            System.out.println("❌ Error: Height must be positive");
            return;
        }

        if (height < 50 || height > 300) {
            System.out.println("❌ Error: Height seems unrealistic (should be 50-300 cm)");
            return;
        }

        this.height = height;
        System.out.println("✅ Height set to: " + this.height + " cm");
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            System.out.println("❌ Error: Weight must be positive");
            return;
        }

        if (weight < 10 || weight > 500) {
            System.out.println("❌ Error: Weight seems unrealistic (should be 10-500 kg)");
            return;
        }

        this.weight = weight;
        System.out.println("✅ Weight set to: " + this.weight + " kg");
    }

    public void setAddress(String address) {
        if (address == null) {
            this.address = "";
            return;
        }

        this.address = address.trim();
        if (!this.address.isEmpty()) {
            System.out.println("✅ Address set to: " + this.address);
        }
    }

    // Utility methods that use encapsulated data
    public double getBMI() {
        if (height <= 0 || weight <= 0) {
            System.out.println("❌ Cannot calculate BMI: Height and weight must be set");
            return 0.0;
        }

        // BMI = weight(kg) / (height(m))^2
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }

    public String getBMICategory() {
        double bmi = getBMI();
        if (bmi == 0.0) return "Unknown";

        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal weight";
        else if (bmi < 30.0) return "Overweight";
        else return "Obese";
    }

    public String getAgeCategory() {
        if (age < 13) return "Child";
        else if (age < 20) return "Teenager";
        else if (age < 60) return "Adult";
        else return "Senior";
    }

    public boolean isValidForDriversLicense() {
        return age >= 16; // Assuming 16 is minimum age
    }

    public boolean hasCompleteContactInfo() {
        return !email.isEmpty() && !phoneNumber.isEmpty() && !address.isEmpty();
    }

    // Private helper method - internal implementation detail
    private String capitalizeWords(String input) {
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                capitalizeNext = true;
                result.append(c);
            } else if (capitalizeNext) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }

    // Method to display person information
    public void displayPersonInfo() {
        System.out.println("\n👤 ===== Person Information =====");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age + " (" + getAgeCategory() + ")");
        System.out.println("Email: " + (email.isEmpty() ? "Not provided" : email));
        System.out.println("Phone: " + (phoneNumber.isEmpty() ? "Not provided" : phoneNumber));
        System.out.println("Height: " + (height > 0 ? height + " cm" : "Not provided"));
        System.out.println("Weight: " + (weight > 0 ? weight + " kg" : "Not provided"));
        System.out.println("Address: " + (address.isEmpty() ? "Not provided" : address));

        if (height > 0 && weight > 0) {
            System.out.printf("BMI: %.2f (%s)\n", getBMI(), getBMICategory());
        }

        System.out.println("Driver's License Eligible: " + (isValidForDriversLicense() ? "Yes" : "No"));
        System.out.println("Complete Contact Info: " + (hasCompleteContactInfo() ? "Yes" : "No"));
        System.out.println("===============================\n");
    }

    @Override
    public String toString() {
        return String.format("Person{name='%s', age=%d, email='%s'}", name, age, email);
    }
}
