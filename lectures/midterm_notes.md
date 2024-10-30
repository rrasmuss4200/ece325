**Strings are immutable**
I.e ```s1 = new String("FUN");
    s1 = "String";```
s1 still equals FUN

```java
s1 = "String";
s2 = new String("String");
s1 == s2 // false cuz s2 is not interned (in special part of Heap where non-object strings go)
s2.intern();
s1 == s2 // now returns true
```

## IO

We use buffered streams since OS calls are expensive. When we are reading bytes on after another, we call OS each time. With buffers, we only call OS when the buffer is full.

## Subclass/parent class inits Polymorphism

Car car = new Car();
RaceCar rc1 = new RaceCar();
Car rc2 = new RaceCar(); // declare variable as Car and make a RaceCar object;
RaceCar rc3 = (RaceCar) new Car(); // compile but shouldn't do this; crashes at run-time
// makes car into racecar - narrowing cast

Read it as: (is new <Object> subcless of type on the left)

**SCANNER** reads tokens from single stream/string

## Abstract class vs. interface

Interface only contains method signatures while an abstract class may or may not contain implementation

Use interface when you have some sort of functionality all classes must have but there are various implementations

A class can extend **AT MOST ONE** abstract class but can implement multiple interfaces

An abstract class can implement an interface

Adding a new method affects classes using an interface but doesn't have to affect classes using an abstract class

**Interfaces are like a contract, what should be done, not how to do it**

**Abstract classes can contain implementation. Restrain the way API contracts should be implemented**

## Bugs from MT

1. Print after return
2. i <= in array
3. max = 0 won't account for negative arrays
4. check if arr is null since arrays are objects
5. Change return type to Integer so we can return null if array is empty

*Will be similar bugs for final*

