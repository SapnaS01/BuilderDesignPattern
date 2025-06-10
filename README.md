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
