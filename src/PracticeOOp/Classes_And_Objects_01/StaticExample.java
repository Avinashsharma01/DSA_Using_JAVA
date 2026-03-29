/**
 * StaticExample - Demonstrates Static vs Instance Members
 *
 * This class shows:
 * - Static variables (class-level data)
 * - Static methods (class-level behavior)
 * - Instance variables (object-level data)
 * - Instance methods (object-level behavior)
 * - When to use static vs instance
 */

package PracticeOOp.Classes_And_Objects_01;
public class StaticExample {
    // Static variables (shared by all instances)
    private static int totalObjects = 0;
    private static String companyName = "TechCorp";
    private static final double PI = 3.14159; // Static constant

    // Instance variables (unique to each object)
    private String name;
    private int id;
    private double salary;

    // Constructor
    public StaticExample(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = ++totalObjects; // Increment and assign unique ID
        System.out.println("✅ Employee created: " + name + " (ID: " + id + ")");
    }

    // Static methods (can be called without creating an object)
    public static int getTotalObjects() {
        return totalObjects;
    }

    public static String getCompanyName() {
        return companyName;
    }

    public static void setCompanyName(String newName) {
        companyName = newName;
        System.out.println("🏢 Company name changed to: " + companyName);
    }

    public static double calculateCircleArea(double radius) {
        return PI * radius * radius; // Using static constant
    }

    public static void displayCompanyInfo() {
        System.out.println("\n🏢 ===== Company Information =====");
        System.out.println("Company Name: " + companyName);
        System.out.println("Total Employees: " + totalObjects);
        System.out.println("================================\n");
    }

    // Static method that demonstrates you cannot access instance variables
    public static void staticMethodExample() {
        System.out.println("📌 This is a static method");
        System.out.println("📌 Static methods can access static variables: " + companyName);
        System.out.println("📌 Total objects created: " + totalObjects);

        // ❌ This would cause an error - cannot access instance variables from static context
        // System.out.println("Name: " + name); // ERROR!
        // System.out.println("Salary: " + salary); // ERROR!

        System.out.println("📌 To access instance variables, you need an object instance");
    }

    // Instance methods (require an object to be called)
    public void displayEmployeeInfo() {
        System.out.println("\n👤 ===== Employee Information =====");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: $" + String.format("%.2f", salary));
        System.out.println("Company: " + companyName); // Instance method can access static variables
        System.out.println("==================================\n");
    }

    public void giveRaise(double percentage) {
        double oldSalary = salary;
        salary += salary * (percentage / 100);
        System.out.println("💰 " + name + " received a " + percentage + "% raise!");
        System.out.println("💰 Old salary: $" + String.format("%.2f", oldSalary));
        System.out.println("💰 New salary: $" + String.format("%.2f", salary));
    }

    public void instanceMethodExample() {
        System.out.println("📌 This is an instance method");
        System.out.println("📌 Instance methods can access both static and instance variables");
        System.out.println("📌 Static variable (company): " + companyName);
        System.out.println("📌 Instance variable (name): " + name);
        System.out.println("📌 Instance variable (salary): " + salary);
        System.out.println("📌 Static variable (total objects): " + totalObjects);
    }

    // Getters and setters
    public String getName() { return name; }
    public int getId() { return id; }
    public double getSalary() { return salary; }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', salary=%.2f, company='%s'}",
                           id, name, salary, companyName);
    }

    // Demonstration method
    public static void demonstrateStaticVsInstance() {
        System.out.println("🔍 DEMONSTRATING STATIC VS INSTANCE MEMBERS");
        System.out.println("============================================\n");

        // Call static methods without creating objects
        System.out.println("📋 Calling static methods without objects:");
        System.out.println("Company name: " + StaticExample.getCompanyName());
        System.out.println("Total employees: " + StaticExample.getTotalObjects());
        System.out.println("Circle area (radius=5): " + StaticExample.calculateCircleArea(5.0));

        StaticExample.staticMethodExample();
        StaticExample.displayCompanyInfo();

        // Create objects and call instance methods
        System.out.println("👥 Creating employees and calling instance methods:");
        StaticExample emp1 = new StaticExample("Alice Johnson", 75000);
        StaticExample emp2 = new StaticExample("Bob Smith", 65000);
        StaticExample emp3 = new StaticExample("Carol Davis", 80000);

        // Display information using instance methods
        emp1.displayEmployeeInfo();
        emp2.displayEmployeeInfo();
        emp3.displayEmployeeInfo();

        // Show how static variables are shared
        System.out.println("📊 Notice how static variables are shared:");
        StaticExample.displayCompanyInfo(); // Shows total count updated

        // Change company name (affects all employees)
        StaticExample.setCompanyName("InnovateInc");

        System.out.println("📋 After company name change:");
        emp1.displayEmployeeInfo(); // Shows new company name
        emp2.displayEmployeeInfo(); // Shows new company name

        // Demonstrate instance method capabilities
        emp1.instanceMethodExample();
        emp1.giveRaise(10);

        System.out.println("\n📈 Final company statistics:");
        StaticExample.displayCompanyInfo();

        System.out.println("✅ Static vs Instance demonstration completed!\n");
    }
}
