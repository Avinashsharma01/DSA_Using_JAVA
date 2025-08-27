/**
 * Design Patterns - Comprehensive examples of common OOP design patterns
 *
 * This file demonstrates:
 * - Singleton Pattern: Ensure only one instance exists
 * - Factory Pattern: Create objects without specifying exact class
 * - Observer Pattern: Define one-to-many dependency between objects
 * - Strategy Pattern: Encapsulate algorithms and make them interchangeable
 */

import java.util.*;

// ================== SINGLETON PATTERN ==================

/**
 * Database Connection - Singleton Pattern Example
 * Ensures only one database connection exists in the application
 */
class DatabaseConnection {
    // Private static instance - the single instance
    private static DatabaseConnection instance;
    private String connectionString;
    private boolean isConnected;

    // Private constructor prevents external instantiation
    private DatabaseConnection() {
        this.connectionString = "jdbc:mysql://localhost:3306/mydb";
        this.isConnected = false;
        System.out.println("🔗 Database connection object created");
    }

    // Public static method to get the single instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        if (!isConnected) {
            isConnected = true;
            System.out.println("✅ Connected to database: " + connectionString);
        } else {
            System.out.println("⚠️ Already connected to database");
        }
    }

    public void disconnect() {
        if (isConnected) {
            isConnected = false;
            System.out.println("❌ Disconnected from database");
        }
    }

    public boolean isConnected() { return isConnected; }

    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("🔍 Executing query: " + query);
        } else {
            System.out.println("❌ Cannot execute query - not connected");
        }
    }
}

// ================== FACTORY PATTERN ==================

/**
 * Abstract Vehicle class for Factory Pattern
 */
abstract class FactoryVehicle {
    protected String brand;
    protected String model;

    public FactoryVehicle(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public abstract void start();
    public abstract void stop();
    public abstract String getType();

    @Override
    public String toString() {
        return getType() + "{brand='" + brand + "', model='" + model + "'}";
    }
}

/**
 * Concrete Vehicle implementations
 */
class FactoryCar extends FactoryVehicle {
    public FactoryCar(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void start() {
        System.out.println("🚗 " + brand + " " + model + " car engine started");
    }

    @Override
    public void stop() {
        System.out.println("🛑 " + brand + " " + model + " car engine stopped");
    }

    @Override
    public String getType() {
        return "Car";
    }
}

class FactoryMotorcycle extends FactoryVehicle {
    public FactoryMotorcycle(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void start() {
        System.out.println("🏍️ " + brand + " " + model + " motorcycle engine started");
    }

    @Override
    public void stop() {
        System.out.println("🛑 " + brand + " " + model + " motorcycle engine stopped");
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}

class FactoryTruck extends FactoryVehicle {
    public FactoryTruck(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void start() {
        System.out.println("🚚 " + brand + " " + model + " truck engine started");
    }

    @Override
    public void stop() {
        System.out.println("🛑 " + brand + " " + model + " truck engine stopped");
    }

    @Override
    public String getType() {
        return "Truck";
    }
}

/**
 * Vehicle Factory - Creates vehicles without client knowing exact class
 */
class VehicleFactory {
    public static FactoryVehicle createVehicle(String type, String brand, String model) {
        switch (type.toLowerCase()) {
            case "car":
                System.out.println("🏭 Factory creating car: " + brand + " " + model);
                return new FactoryCar(brand, model);
            case "motorcycle":
                System.out.println("🏭 Factory creating motorcycle: " + brand + " " + model);
                return new FactoryMotorcycle(brand, model);
            case "truck":
                System.out.println("🏭 Factory creating truck: " + brand + " " + model);
                return new FactoryTruck(brand, model);
            default:
                throw new IllegalArgumentException("❌ Unknown vehicle type: " + type);
        }
    }
}

// ================== OBSERVER PATTERN ==================

/**
 * Observer interface for receiving notifications
 */
interface Observer {
    void update(String message);
}

/**
 * Subject interface for managing observers
 */
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}

/**
 * News Agency - Concrete Subject implementation
 */
class NewsAgency implements Subject {
    private List<Observer> observers;
    private String latestNews;

    public NewsAgency() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("📰 New subscriber added to news agency");
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("📰 Subscriber removed from news agency");
    }

    @Override
    public void notifyObservers(String message) {
        System.out.println("📢 Broadcasting news to " + observers.size() + " subscribers:");
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void publishNews(String news) {
        this.latestNews = news;
        System.out.println("📰 News Agency: Publishing news - " + news);
        notifyObservers(news);
    }
}

/**
 * News Channel - Concrete Observer implementation
 */
class NewsChannel implements Observer {
    private String channelName;

    public NewsChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void update(String message) {
        System.out.println("📺 " + channelName + " received news: " + message);
        broadcast(message);
    }

    private void broadcast(String news) {
        System.out.println("📡 " + channelName + " broadcasting: " + news);
    }
}

/**
 * Mobile App - Another Observer implementation
 */
class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String message) {
        System.out.println("📱 " + appName + " app received news: " + message);
        sendNotification(message);
    }

    private void sendNotification(String news) {
        System.out.println("🔔 " + appName + " sending push notification: " + news);
    }
}

// ================== STRATEGY PATTERN ==================

/**
 * Payment Strategy interface
 */
interface PaymentStrategy {
    void pay(double amount);
    String getPaymentType();
}

/**
 * Concrete Payment Strategies
 */
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String holderName;

    public CreditCardPayment(String cardNumber, String holderName) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.holderName = holderName;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("💳 Processing credit card payment of $%.2f\n", amount);
        System.out.println("   Card: " + cardNumber + " (" + holderName + ")");
        System.out.println("✅ Credit card payment successful");
    }

    @Override
    public String getPaymentType() {
        return "Credit Card";
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() >= 4) {
            return "**** **** **** " + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("🌐 Processing PayPal payment of $%.2f\n", amount);
        System.out.println("   Account: " + email);
        System.out.println("✅ PayPal payment successful");
    }

    @Override
    public String getPaymentType() {
        return "PayPal";
    }
}

class BankTransferPayment implements PaymentStrategy {
    private String accountNumber;
    private String bankName;

    public BankTransferPayment(String accountNumber, String bankName) {
        this.accountNumber = maskAccountNumber(accountNumber);
        this.bankName = bankName;
    }

    @Override
    public void pay(double amount) {
        System.out.printf("🏦 Processing bank transfer of $%.2f\n", amount);
        System.out.println("   Account: " + accountNumber + " (" + bankName + ")");
        System.out.println("✅ Bank transfer successful");
    }

    @Override
    public String getPaymentType() {
        return "Bank Transfer";
    }

    private String maskAccountNumber(String accountNumber) {
        if (accountNumber.length() >= 4) {
            return "****" + accountNumber.substring(accountNumber.length() - 4);
        }
        return accountNumber;
    }
}

/**
 * Shopping Cart - Context class using Strategy Pattern
 */
class ShoppingCart {
    private List<String> items;
    private double totalAmount;
    private PaymentStrategy paymentStrategy;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addItem(String item, double price) {
        items.add(item);
        totalAmount += price;
        System.out.println("🛒 Added to cart: " + item + " ($" + price + ")");
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
        System.out.println("💰 Payment method set to: " + paymentStrategy.getPaymentType());
    }

    public void checkout() {
        if (paymentStrategy == null) {
            System.out.println("❌ Please select a payment method first");
            return;
        }

        if (items.isEmpty()) {
            System.out.println("❌ Cart is empty");
            return;
        }

        System.out.println("\n🛒 ===== Checkout Summary =====");
        System.out.println("Items in cart:");
        for (String item : items) {
            System.out.println("  - " + item);
        }
        System.out.printf("Total: $%.2f\n", totalAmount);
        System.out.println("============================");

        paymentStrategy.pay(totalAmount);

        // Clear cart after successful payment
        items.clear();
        totalAmount = 0.0;
        System.out.println("🎉 Checkout completed successfully!\n");
    }
}
