# Encapsulation in Java

## What is Encapsulation?

Encapsulation is one of the four fundamental principles of Object-Oriented Programming. It refers to:

1. **Data Hiding**: Bundling data (attributes) and methods that operate on that data within a single unit (class)
2. **Access Control**: Restricting direct access to some of an object's components
3. **Interface Definition**: Providing controlled access through public methods (getters/setters)

## Why Encapsulation?

- **Security**: Prevents unauthorized access to sensitive data
- **Data Integrity**: Ensures data is modified only through controlled methods
- **Maintainability**: Changes to internal implementation don't affect external code
- **Flexibility**: Can change internal implementation without breaking existing code

## Access Modifiers in Java

| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| public   | ✓     | ✓       | ✓        | ✓     |
| protected| ✓     | ✓       | ✓        | ✗     |
| default  | ✓     | ✓       | ✗        | ✗     |
| private  | ✓     | ✗       | ✗        | ✗     |

## Encapsulation Best Practices

1. **Make instance variables private**
2. **Provide public getter and setter methods**
3. **Validate data in setter methods**
4. **Use meaningful method names**
5. **Hide implementation details**

## Examples in this Section

1. **Person.java** - Basic encapsulation with validation
2. **EncapsulatedBankAccount.java** - Advanced encapsulation with security
3. **Employee.java** - Real-world example with business rules
4. **EncapsulationDemo.java** - Demonstration of access modifiers
5. **TestEncapsulation.java** - Testing all examples

## Key Concepts Covered

- Private instance variables
- Public getter/setter methods
- Data validation in setters
- Access modifiers (private, protected, public, default)
- Information hiding
- Controlled access to data
