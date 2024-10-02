# Inheritance - method overriding and overloading

- Generally, we should avoid code duplication
  - This leads to inconsistencies
  - Leads to bugs

But sometimes we *should* duplicate methods in subclasses

ex: maintain() method for Car
- may mean different things for a Car or a RaceCar

## Polymorphism Type 1: Overloading
- additional version sof a method with different signatures
- i.e one wihtout params, one with, etc.

### Constructor Overaload

```java
public class Car {
    int maxSpeed;
    int wheels;
    Color color;

    public Car(Color c) {
        maxSpeed = 100;
        wheels = 4;
        color = c;
    }

    public Car(Color c, int w) {
        this(c); // calls the first constructor
        wheels = w;
    }
}
```
Use this() to call a constructor from withing another constructor
**MUST** be first statement in that constructor

```java
public Car() {
    println("Car constr 1");
}

public Car(Color c) {
    this();
    println("Car constr 2")
}

public Car(Color c, int w) {
    this(c);
    println("Car constr 3")
}
```

## Polymorphism type 2:
- implement a new version of a method inside a subclass
- It is convention to annotate overridden methods
- Just add ```@Override``` before the method

Which method is called?

```java
Car car = new Car();
car.maintain(); // calls car maintain

RaceCar rc = new RaceCar();
rc.maintain(); // calls racecar maintain

Car car2 = new RaceCar();
car2.maintain(); // calls racecar maintain
```
Calls the type on the right
Takes the *deepest*, or most specific implementation available

**super.** keyword calls the method that it overrides
**super()** calls constr from superclass

```java
public Car(Color c) {
    maxSpeed = 100;
    wheels = 4;
    color = c;
}

// ...

public class Minivan extends Car {
    public Minivan() {

    }

    public Minivan(Color c, boolean b) {
    super(c); // calls constructor from superclass
    hashitch = b;
    }

    public Minivan(Color c) {
        super(c);
    }
    // vs.
    public Minivan() {

    } // DOESN'T work cuz there's no super constr without parameters
    // cannot call super()
}
```

For Minivan(), it calls super() for the Car part of the build, but since there's no constructor in Car without parameters, then it won't compile

## Abstract methods

- way to make sure that we completly override a method in all subclasses of a superclass
- so we shouldn't defind the method body inside the superclass
- instead
  - a method of which the signature is defined and nothing else

```java
public abstract class Car {
    public abstract String showDetails();
    // asserts that all subclasses have an implementation of showDetails();
}
```

## Abstract classes
A class that contains one or more abstract methods is an abstract class

We cannot create an object from an abstract class because we are missing the implementation

Allows for all benefits of inheritance

```java
Car c = new Car();
// can't do this
```

Car can be subclass and superclass at same time. If there is superclass *vehicle*:

Vehicle and Car both are abstract classes and contain abstract method showDetails();

```java
Vehicle v1 = new RaceCar();
Vehicle v2 = new Vehicle(); // can't do this
```
