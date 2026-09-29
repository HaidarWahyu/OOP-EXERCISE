# PBO Exercise: Shape, Square, Circle, and Cylinder

A Java OOP exercise applying **Abstraction**, **Encapsulation**, **Inheritance**, and **Polymorphism**, based on the course material *PBO 5-6* (exploration on pages 63-66).

## Project Structure

```
PBOExercise/
├── Shape.java       # abstract parent class
├── Square.java      # child of Shape
├── Circle.java       # child of Shape
├── Cylinder.java     # child of Circle
├── Main.java         # main program
└── README.md
```

Hierarchy: `Shape` → `Square`, `Shape` → `Circle` → `Cylinder`

## Sample Output

```
--- Object Info ---
1. Square colored red, area = 25.00
2. Circle blue, area = 28.27
3. Cylinder green, volume = 282.74
```

## OOP Concepts

### 1. Abstraction
`Shape` is declared `abstract` and cannot be instantiated directly. Its method `printInfo()` is also `abstract` — only a signature, no body — forcing every child class to provide its own version.

```java
public abstract class Shape {
    public abstract void printInfo();
}
```

### 2. Encapsulation
Attributes (`color`, `side`, `radius`, `height`) are `private`/`protected`, not accessed directly from outside. They're read and changed only through getters/setters.

```java
protected String color;

public String getColor() { return color; }
public void setColor(String color) { this.color = color; }
```

Used in `Main.java`:
```java
square.setColor("yellow");
System.out.println(square.getColor());
```

### 3. Inheritance
`Square` and `Circle` extend `Shape`; `Cylinder` extends `Circle` (multilevel). Each child calls the parent constructor with `super(...)` instead of repeating the same fields.

```java
public class Cylinder extends Circle {
    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }
}
```

Because of this, `Cylinder` reuses `Circle`'s `area()` to compute its own volume:

```java
public double volume() {
    return area() * height;
}
```

### 4. Polymorphism
`printInfo()` is overridden differently in each child class using `@Override`. Same method name, different behavior depending on the object.

```java
// Square
System.out.printf("Square colored %s, area = %.2f%n", color, area());

// Circle
System.out.printf("Circle %s, area = %.2f%n", color, area());

// Cylinder
System.out.printf("Cylinder %s, volume = %.2f%n", color, volume());
```

Calling the same method on different objects produces different output:

```java
square.printInfo();   // Square colored red, area = 25.00
circle.printInfo();   // Circle blue, area = 28.27
cylinder.printInfo(); // Cylinder green, volume = 282.74
```
#Result

<img width="426" height="349" alt="image" src="https://github.com/user-attachments/assets/10e69de3-0c7c-4897-952f-c37de59c65cd" />

## Summary

| Concept | Keyword(s) | Where |
|---|---|---|
| Abstraction | `abstract class`, `abstract void printInfo()` | `Shape.java` |
| Encapsulation | `private`/`protected` fields + getters/setters | All classes |
| Inheritance | `extends`, `super(...)` | `Square`, `Circle`, `Cylinder` |
| Polymorphism | `@Override printInfo()` | `Square`, `Circle`, `Cylinder` |
