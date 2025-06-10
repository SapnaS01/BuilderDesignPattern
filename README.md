#  Java Builder Design Pattern Example

This repository demonstrates the internal working of @Builder annotation in Java using a `User` class as an example.

---

## What is Builder Design Pattern?
The **Builder Design Pattern** is a creational design pattern used to construct complex objects **step-by-step**. It provides a flexible solution to object creation problems when the class has **many optional parameters**, improving **readability, maintainability**, and **immutability**.
---
### Telescoping constructors

Telescoping constructors is a design pattern in Java (and other object-oriented languages) where a class has multiple constructors, each one adding more parameters than the previous one. 
Each constructor calls another constructor in the same class using this(...), leading to a "telescoping" effect.

## 📌 Telescoping Constructor Pattern
User u1 = new User();                       // Constructor 1
User u2 = new User("abc");                  // Constructor 2
User u3 = new User("abc", 25);              // Constructor 3
User u4 = new User("abc", 25, "India");     // Constructor 4

## Each line here creates a new object in the heap with a different set of parameters.

-✔️ Each User object (u1, u2, u3, u4) has its own memory address in the heap.

-✔️ The JVM doesn’t care which constructor you used — as long as you say new User(...), it allocates a new object in heap.

## In Builder pattern 
User user = new UserBuilder()
                .setName("abc")
                .setAge(25)
                .setCountry("India")
                .build();
#👉 Here, there are two objects involved:

- UserBuilder object (temporary) — created in the heap
- User object — created during .build() (final object in the heap)



### Why Do We Need It?

##❌ Problem without Builder:

Imagine a class with many fields:
User user = new User("abc", 25, "India", "123 Street", "Engineer", "F", "Vegetarian", "Medium", true);
You can’t tell what each value means, and if you want to leave some fields out, you need to create overloaded constructors → messy and hard to manage.


###✅ When to Use Builder Pattern?

-A class has many parameters (especially optional ones)
-You want to avoid many constructors
-You want to make object creation more readable and maintainable
-You’re aiming for immutability

### You can achieve this by using an annotation present in Lombok Framework  **@Builder**








