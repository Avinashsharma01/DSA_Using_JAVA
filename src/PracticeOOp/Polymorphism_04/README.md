# Polymorphism in Java

## What is Polymorphism?

Polymorphism comes from Greek words "poly" (many) and "morph" (forms), meaning "many forms". It's the ability of objects of different types to be treated as instances of the same type through a common interface.

## Types of Polymorphism in Java

### 1. **Compile-time Polymorphism (Static)**
- **Method Overloading**: Same method name, different parameters
- **Operator Overloading**: Not supported in Java (except + for strings)

### 2. **Runtime Polymorphism (Dynamic)**
- **Method Overriding**: Subclass provides specific implementation
- **Interface Implementation**: Multiple classes implement same interface
- **Abstract Class Implementation**: Concrete classes extend abstract classes

## Key Concepts

- **Dynamic Method Dispatch**: JVM decides which method to call at runtime
- **Late Binding**: Method binding happens during execution
- **Upcasting**: Child object referenced by parent type
- **Downcasting**: Parent reference cast back to child type
- **instanceof operator**: Check object type at runtime

## Real-world Benefits

- **Flexibility**: Write code that works with multiple types
- **Extensibility**: Add new types without changing existing code
- **Maintainability**: Single interface for multiple implementations
- **Code Reusability**: Same method works with different object types

## Examples in this Section

1. **Shape.java** - Abstract base class for geometric shapes
2. **Circle.java, Rectangle.java, Triangle.java** - Shape implementations
3. **Animal.java** - Interface demonstrating polymorphic behavior
4. **Dog.java, Cat.java, Bird.java** - Animal implementations
5. **Calculator.java** - Method overloading examples
6. **PaymentProcessor.java** - Real-world polymorphism example
7. **TestPolymorphism.java** - Comprehensive demonstrations

## Polymorphism Patterns

- **Strategy Pattern**: Different algorithms with same interface
- **Template Method**: Common structure, varying implementations
- **Factory Pattern**: Create objects polymorphically
- **Observer Pattern**: Multiple observers, same notification interface
