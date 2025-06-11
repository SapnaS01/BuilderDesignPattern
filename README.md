#  Java Builder Design Pattern Example

This repository demonstrates how the **Builder Design Pattern** works in Java by manually implementing a `User` class and its builder, mimicking the behavior of Lombok’s `@Builder` annotation.

---

## What is the Builder Design Pattern?

The **Builder Design Pattern** is a **creational pattern** that allows the construction of complex objects **step-by-step**. It provides a clean solution for creating objects when:
- A class has many parameters (especially optional ones).
- You want to avoid the constructor overload problem.
- You aim for **immutability**, **readability**, and **flexibility** in your object creation.

---

##  Telescoping Constructors Problem

Telescoping constructors require you to create many overloaded constructors to handle different combinations of parameters:

```java
User u1 = new User();                        // Constructor 1
User u2 = new User("abc");                   // Constructor 2
User u3 = new User("abc", 25);               // Constructor 3
User u4 = new User("abc", 25, "India");      // Constructor 4
```

## Drawbacks

- Hard to read and understand.
- Too many constructors needed.
- Difficult to manage optional fields.
- Cannot skip optional parameters easily.

## Builder Pattern

```java
User user = new User.UserBuilder()
                .setName("abc")
                .setAge(25)
                .setCountry("India")
                .build();
```
###  What's Happening in Memory?

- **In Telescoping Constructors**:
  - Each constructor call (e.g., `new User(...)`) creates a separate object in the heap.
  - Every overloaded constructor results in a new memory allocation with a unique address.
  - Even if only one field is different, a new object is created.

- **In Builder Pattern**:
  - A temporary `UserBuilder` object is created in the heap.
  - Fields are set one by one through method chaining.
  - When `.build()` is invoked:
    - A single, final `User` object is created using the builder’s data.
    - The `UserBuilder` object becomes **eligible for garbage collection** once it's no longer referenced.

---

### Steps to Implement Builder Design Pattern

- Create a class in which you want to use this design pattern
- Define the fields as private
- Create a static inner builder class
- - In the builder class, create setter-style methods that return the builder object (for method chaining).
- Create a build method in builder class and return the outer class object.
- Use the builder to create the object 

---
## 📌 Real-World Use Case

Imagine a registration form where a user can fill name, age, country, address, phone number, etc. Some fields are optional.

Instead of writing multiple constructors to handle all combinations, the Builder Pattern allows constructing the object only with the fields provided.

## ✨ Lombok: `@Builder` Annotation

If you're using Lombok, you can skip writing the entire builder manually:

```java
@Builder
public class User {
    private String name;
    private int age;
    private String country;
}

```
> Note: Make sure Lombok is installed and your IDE supports annotation processing.

Lombok automatically generates the inner static builder class, setter-style methods, and the build() method behind the scenes.


