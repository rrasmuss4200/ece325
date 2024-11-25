# Design Principles

Clean code:
- good for maintenance

**LeBlanc's Law**
- Later equals never in the context of 'fixing something later'
- don't be afraid to tell manager of unrealistic timelines


## Symptoms of bad code
- difficult to change (rigid)
- breaks in many places every time you change something
- Inability to reuse code

## SOLID principles
- principles to improve software designs
- not rules or laws

### Single Responsibility
- a class should only have one reason to change
- i.e only one job or responsibility
- ideally, we have many small classes and not few, large ones

**Good because**

- improves cohesion
- makes them more readable
- makes classes smaller

### Open-closed Principle
- module should be open for extension but closed for modification
- i.e change what a module does without changing its code
- This is Polymorphism

ex:

If we had classes for Rectangle and Cricle and had AreaCalculator class, we would need a new method for every area we want to calculate

Instead, we should have ```interface Shape``` and AreaCalculator takes a Shape

```java
public interface Shape {
public abstract double calculateArea();
}
public class Rectangle implements Shape {
    private double length;
    private double width;
    @Override
    public double calculateArea() {
        return length*width;
    }
}

public class AreaCalculator {
    public static double calculateArea(Shape s) {
        return s.calculateArea(); // if any new bugs come, then they're in the new class
    }
}
```

### Liskov Substitution Principle
- “Subclasses should be substitutable for their base classes.”
- A user of a base class should continue to function properly if a subclass of that class is passed to it

ex: class RaceTrack should have Cars on it. Some subclasses of Car could be FormulaOneCar, but could also be Minivan and we don't want Minivans on the RaceTrack.

To fix this, add interface RaceCar to distinguish cars that can and cannot race. FormulaOneCar implements RaceCar and extends Car but Minivan only extends Car

OR

Make RaceCar and subclass of Car

### Interface segregation Principle

- no client should be forced to depend on methods it doesn't use

Ex: if we have a single interface that contains methods intended for many different classes, Class A can call methods for Class B and vvc. Also forces A to implement methods it doesn't need

Should extract interface Service to class specific methods. **Segregate** functionality into smaller interfaces by extracting only relevant methods

### Dependency Inversion Principle
- Depend upon abstractions, don't depend on concretions

ex: if you had a lamp, just plug it into the wall, don't solder the wires directly to the outlet

In OOP, DIP-proof

Lanmp -> <<interface>>(Power Source) <- Outlet

Lamp depends on abstraction of power source

- reduces coupling between classes
- High coupling means a change in one class would likely require a change in another

DIP in practice: Declare as most general/abstract type

``` RaceCar rc = new FormulaOneCar()``` , gives us a lot of flexibility.