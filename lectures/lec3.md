# Lec 3: Classes and Objects

Class: blueprint for creating objects

Object: a certain instance of a certain class

## Instance variables and methods

In OOP, state.characteristics = instance variables

Behaviour = methods

Car:

maxSpeed,
colour

getMaxSpeed(),
getColour()

Check for relationships between classes:
- 'has-a' and 'is-a'

When defining a new class, make sure there is no existing class that does the same

### Class or obj?

- Chair: class
- Address: class
- Rectangle: class
- Baycon (profs dog): object
- Canada: Object

Sometimes if depends on the problem you're mdoeling

If building a pet store: Baycon could be object of class dog

If building a video game, Baycon could be a class with special abilities

## Creation of class and object:

```java
public class Car {
    int maxSpeed; // instance variable

    public Car() {
        maxSpeed = 200; // local variable
    }
    // Can have multiple constructors
    public Car(int m) {
        maxSpeed = m;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

// in program
Car c1 = new Car();
int x = c1.getMaxSpeed(); // x = 200
```

### Calling a method in Java:

A method is almost always called on an object

This means the method will reflect the objects state

### Instance vs local

Instance - can be accessed anywhere in the class, also called a field

Local - can be found inside a specific method

## Some Java conventions

- class name starts with uppercase
- variables, methods start with lowercase
  - one expception

## Where is Object stored

- objects are created on the heap
  - heap sized can be manually increased if need be
  - Should try to avoid
- monitored by Java's Garbage Collector

ex:

```java
Car c1 = new Car();
c1.maxSpeed = 300;

Car c2 = new Car();
c2.maxSpeed = 250;

c1 = c2;
c1.getMaxSpeed(); // => 300
```

**Heap Space**
Car object:

maxSpeed changed to 300

Car object:

maxSpeed = 250;


**Variables**
c1 points to car object
c2 points to another Car object

After c1 = c2, c1 points to same object as c2

## Java is pass-by-value

- The value of a variable is copied
- For primitive types, this is the actual value/literal
- For refernce types (obj types), **this is the refernce (pointer) to that object**
  - Reference variables contain reference values, not objects

```java
public class Race {
    public void race(Car c1, Car c2) { // return type should be Car
        if(c1.getMaxSpeed() > c2.getMaxSpeed()) // if speeds are the same, c2 wins
            return c1;
        else return c2;
    }
}
```

```java
public void switchSpeeds(Car c1, Car c2) {
    int speed = c1.getMaxSpeed(); // this has an issue...
    c1.setMaxSpeed(c2.getMaxSpeed());
    c2.setMaxSpeed(speed);
}
```