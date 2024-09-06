# ECE 325

This repo is for notes and excercises in the Object-Oriented software design course

## Lec 1

### Procedural vs OOP
Assume we want to get a funciton to getMaxSpeed() of a car

```
int getMaxSpeed() {
    if(car == "racecar")
        return 400;
    else if (car == "minivan") {
        return 150;
    }
}
```

Lots of if-else statements to come:
- Can introduce new bugs if we change code
- Code gets repetitive

Instead we use OOP solution:
- Compiler can check
- Can just add new class
- Easier to collaborate with others

```@Java
public class Car {
    int maxSpeed;

    public Car() {
        maxSpeed = 200;
    }
}

public class RaceCar extends Car {
    public RaceCar() {
        maxSpeed = 370;
    }
}

public class Minivan extends Car {
    public Minivan() {
        maxSpeed = 150;
    }
}
```

### Origin of Java
- Based on the Oak language (1990s)
- intended for use in interactive TV set top boxes
- "Write once, run anywhere"
  - Lower cost to development
  - Andriod apps all use Java
- Initially Sun Microsystems, now owned by Oracle

| JVM
| ---
| OS
| Hardware

Java is a compiled language, into *.class files. Not as fast as C/C++, but still very good performance.

### Java in 2024
Java 17 is still used the most, next is 11 and 8.