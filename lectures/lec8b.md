# Polymorphism

- means 'can take multiple forms'
- ex: a RaceCar is a RaceCar but also a Car

- Subclass is always seen as "bigger box"
- Thus, going from Subclass to parent class is a narrowing cast
- Cannot cast from subclass to super class

```java
RaceCar rc = new RaceCar();
Car rc2 = new RaceCar(); // this works, every RaceCar is a Car; RC is a subclass of Car

RaceCar rc3 = new Car(); // doesn't work cuz type RaceCar doesn't know about Car

// if we wanted it to compile (not good idea)
// This is a narrowing cast Car to RaceCar
RaceCar rc3 = (RaceCar) new Car();
```

In a RaceTrack with many types of Cars, we can have getFastestCar() method return a Car type, allowing any type of Car to be returned

Suppose we do:
```java
Car car1 = new RaceCar();

car1.race(); // doesn't work since it's of type car

// Must cast it first
((RaceCar)car1).race();
// or
RaceCar car2 = (RaceCar) car1;
```

In memory we have:

- Heap: RaceCar
- car1 (type Car): -> RaceCar
- car2 (type RaceCar): -> RaceCar (same one)

```java
Car car = new Car():

((RaceCar)car).race();
```

**This will compile** but will run into a **run-time error**
- Casting does not call the constructor, so we may be missing out on object initialization if the cast would have been allowed

```java
ArrayList<Car> cars = new ArrayList<Car>();
ArrayList<RaceCar> racecars = new ArrayList<RaceCar>();

Car car = new Car();
RaceCar rc1 = new RaceCar();
Car rc2 = new RaceCar(); // declare variable as Car and make a RaceCar object;
RaceCar rc3 = (RaceCar) new Car(); // compile but shouldn't do this; crashes run-time error

cars.add(car); // yes
cars.add(rc1); // yes, racecar treated as Car; gets casted as Car; narrow cast
cars.add(rc2); // yes
cars.add(rc3); // no

racecars.add(car); // no
racecars.add(rc1); // yes
racecars.add(rc2); // no, need to explicitly cast Car as RaceCar
racecars.add(rc3); // doesn't run
```