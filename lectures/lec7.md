# Envapsulation, autoboxing, the static keyword and constants

If we have a class car, we can do
```java
c.Maxspeed = -250;
```

- a class should keep info necessary to its interfal operation private
- it should only expose info when necessary

## Access modifiers

- public:
  - everyone can access it; inside and outside class and program
- private:
  - only this class can access
- default/package-private
  - **the default if not specified**
  - only this class and package can access it
- protected
  - only this class and package and subclasses can access it

Generally, instance variables should be private, also methods if no need for public

Now to update private instance variables, we have a separate method

```java
Car c = new Car();
c.maxSpeed = 250; // can't since its private

c.setMaxSpeed(250);
```

## Get methods:
Return private fields of a class

## Mutator methods:
Set private fields of a class

This is advantageous so we can add checks and error checking to setter method

Can control what goes in and what goes out

```java
public void setMaxSpeed(int s) {
    if (s < 0)
        throw new IllegalArgumentException("max speed < 0 ");
    maxSpeed = s;
}
```

## Wrappers and autoboxing

### ArrayList vs array

how to crete arrayList
```java
import java.util.ArrayList;

ArrayList<Car> list = new ArrayList<Car>();
Car c1 = new Car();
list.add(c1);
list.remove(c1);
```

- can't mix types of the same list
- doesn't work with primitives; (int, String, boolean)
  - Instead use wrapper classes: Integer, Boolean, ...

**Autoboxing** auto converts the primitive value to an object

```java
Integer i = 100;
int i2 = i;

// above line really does this
i2 = Integer.valueOf(i).intValue();
```

### When to use wrapper instead of primitive?

- when creating an ArrayList
- whne you need nullability
  - prims can't be null but a class can

Null is a literal:

This is useful when initializing new variables. Make sure the they can be *null* and not some random

- Instance variables have default values
- Local variables do not

**Prim types** are much faster to work with, but wrapper classes are used for nullability

## Static keyword in Java

- used to indicate that the state of the object doesn't matter
- **can call method without creating an object**

- Variables can be *static* too
- Note: **final** is const keyword in Java

```java
public class Race {
    public static final Car SAFETY_CAR = new Car();

    public static void main(String[] args) {
        Race.SAFETY_CAR.setMaxSpeed(50);
    }
}
```

Yes we can do this, the value of the reference to **SSAFETY_CAR** is final but we can still change the thing its pointing to.

**static methods** cannot access instance variables, or other methods that access instance variables
- becuase they know nothing about the instance
- if you need to do the above, your method shouldn't be static