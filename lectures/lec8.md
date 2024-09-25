# Inheritance: Super and Sub classes

**is-a** relationship indeicates that one class is a special class of the other
- cat is-a feline, which is-a animal
- race car is-a car

This allows cleaner code reuse

## Cars example
- For example a race car could have a race() method, which would not make sense for a SafetyCar
- SafetyCar could ahve driveSafetyLap() method
- Both of these are examples of Car class

If we want to implement getFasterCar() for a class of RaceTrack:
- Inheritance allows us to return another object
- We would only need to call getMaxSpeed() on whatever type of Car we have

## Subclasses
- can access all methods and fields that are available in parent class
- can also have it's own special fields and methods

```java
public class Car {
    int maxSpeed;

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
// in separte .java file
public class RaceCar extends Car {
    public RaceCar() {
        maxSpeed = 370;
    }

    public void race() {
        // vroom
    }
}

// in program (main or other file)
RaceCar rc = new RaceCar();
Car car = new Car();

int x = car.getMaxSpeed(); // 0 cuz 0 is default for ints
car.race(); // won't run cuz car doesn't know about race() method

int y = rc.getMaxSpeed(); // 370
rc.race();
```
- if maxSpeed was private, we would need a setter method in Car for maxSpeed
- would need to be in Car class since that is where maxSpeed is declared private

