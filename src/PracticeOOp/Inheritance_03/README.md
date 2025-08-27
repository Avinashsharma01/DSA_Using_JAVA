# Inheritance in Java

## What is Inheritance?

Inheritance is one of the four fundamental principles of Object-Oriented Programming that allows a class to inherit properties (fields) and behaviors (methods) from another class.

## Key Concepts

- **Parent Class (Superclass)**: The class being inherited from
- **Child Class (Subclass)**: The class that inherits from the parent
- **IS-A Relationship**: Child class "is a" type of parent class
- **Code Reusability**: Avoid duplicating code by inheriting common functionality
- **Method Overriding**: Child class can provide specific implementation of parent's method

## Inheritance Syntax

```java
// Parent class
public class ParentClass {
    // parent members
}

// Child class inheriting from parent
public class ChildClass extends ParentClass {
    // child-specific members
    // inherited members from parent are automatically available
}
```

## Types of Inheritance in Java

1. **Single Inheritance**: One class extends one parent class
2. **Multilevel Inheritance**: Child class becomes parent for another class
3. **Hierarchical Inheritance**: Multiple classes inherit from one parent

Note: Java doesn't support multiple inheritance of classes (but supports it through interfaces)

## Key Keywords

- `extends`: Used to inherit from a class
- `super`: Reference to parent class
- `super()`: Call parent class constructor
- `@Override`: Annotation for method overriding

## Examples in this Section

1. **Vehicle.java** - Base class demonstrating common properties
2. **Car.java** - Inherits from Vehicle with specific features
3. **Motorcycle.java** - Another Vehicle subclass
4. **ElectricCar.java** - Multilevel inheritance example
5. **Animal.java** - Hierarchical inheritance demonstration
6. **Dog.java, Cat.java, Bird.java** - Animal subclasses
7. **TestInheritance.java** - Comprehensive testing

## Benefits of Inheritance

- **Code Reusability**: Write once, use many times
- **Method Overriding**: Customize behavior in subclasses
- **Polymorphism**: Treat objects of different types uniformly
- **Maintainability**: Changes to parent affect all children
- **Extensibility**: Easy to add new subclasses
