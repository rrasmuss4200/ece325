# Interfaces

Allos us to take on responsibilities from multiple classes.

An interface contains only method signatures and fields.
- so all methods in an interface are abstract

```java
public interface Hybrid { // a hybrid car
    public void charge(); // always abstract so no abstract keyword

}

public class MiniVan extends Car implements Hybrid {
    private boonlean hasHitch;

    public String showDeatils() {
        return hasHitch;
    }

    public void charging() {
        System.out.println("Charing");
    }
}
```

Interfaces can extend each other and classes can implement as many interfaces as we want

## Extending Interfaces

```java
public interface Hybrid { // a hybrid car
    public void charge(); // always abstract so no abstract keyword

}

public interface SuperHybrid extends Hybrid {
    public void supercharge();
}

public class NucCar extends Car implements SuperHybrid {
    public void charge() { // Hybrid interface
        // ...
    }

    public void supercharge() { // SuperHybrid interface
        // ...
    }
}

Hybrid h1 = new NucCar(); // Since SuperHybrid extends Hybrid, then we can do this
```

A default method implementation can be added to an interface

This allows you to add new functionality without breaking classes that use the old interface

## Flexibility of interfaces

- implement funcitonalility that might not be logical
- Like Renderable:
  - 3D rendering is not really part of a Car
  - But would make sense in some applications

- Also allow classes to play different roles
  - Like Driveable
  - Car, Bike, Snowmobile

- Gives more consistency, anything Driveable will have necessary methods

## Differences b/w class, subclass, abstract class, interface

- **Class**: not a special type of any other class in the program. Doesn't pass *is-a* test
- **Subclass**: when you need a more specific version of a class and need to override or add new behaviour
- **Abstract** class: a template for a group of subclasses, and you have at least some implementation code
- **Interface**: define one of multiple roles a class can play, or you need to group subclasses and have no implementation code
  - Abstract classes becomes interfaces a lot of the time

### Abstract vs. non-abstract

- **Abstract**: if we do not want to allow the creation of an object of that class
- **Non-abstract**: otherwise

Ex: accurate model of a classroom

- Assume we have following classes:
  - Chair, Desk, Laptop, Speaker, Microphone, Instructor, Student, AVTech, Professor, Researcher, Employee

- Abs classes
  - Equipment
  - Furniture
  - Person - may be usefule

- Interface
  - Employee (pay method)
  - Researcher
  - Maybe AVTech

- Properties:
  - Movable (as an interface)
