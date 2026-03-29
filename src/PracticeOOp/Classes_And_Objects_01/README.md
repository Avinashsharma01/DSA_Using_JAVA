# Classes and Objects in Java

## What is a Class?

A class is a blueprint or template that defines:
- **Attributes (Fields/Instance Variables)**: The data/properties an object will have
- **Methods**: The behavior/actions an object can perform
- **Constructors**: Special methods to create and initialize objects

## What is an Object?

An object is an instance of a class. It's a real entity created from the class blueprint with:
- Actual values for the attributes
- Ability to call the methods defined in the class

## Basic Syntax

```java
public class ClassName {
    // Attributes (instance variables)
    dataType attributeName;
    
    // Constructor
    public ClassName(parameters) {
        // Initialize attributes
    }
    
    // Methods
    public returnType methodName(parameters) {
        // Method body
    }
}
```

## Examples in this Section

1. **Student.java** - Basic class with attributes and methods
2. **Car.java** - Class with multiple constructors
3. **BankAccount.java** - Real-world example with validation
4. **Person.java** - Advanced example with relationships
5. **TestClasses.java** - Main class to test all examples
6. **StaticExample.java** - Understanding static vs instance members

## Key Concepts Covered

- Class definition
- Instance variables
- Constructors (default, parameterized, overloaded)
- Methods (getters, setters, utility methods)
- Object creation and usage
- `this` keyword
- Static vs Instance members
- Access modifiers (public, private, protected)
