# Testing Code

Biggest thing is testing for unexpected input and usage

## Unit Testing
- single method/class

## System level
- how many binaries operate together

```java
public class Car {
    public Integer Drive(Integer h, Integer kmh) {
        return h*kmh;
        // h and kmh can be positive. Take ones that make sense
        // h can't be negative
    }
}
```

Can also test very big value for h and kmh. Also any kmh > maxSpeed

Tests can be written based on method's signature and documentation.

This is called **TDD** (Test Driven Development)

## Unit testing with JUnit

First JUnit test: All look like this initially

```java
package ece325.labs.lab4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class First_test {

	@Test
    // call this method the name of what it is testing
	void test() {
		fail("Not yet implemented");
	}

}
```

The libraries allow for using assertions and Test annotation.

Using our naive implementation of drive() from up above...

**Assert Equals**
```java
@Test
void testDrive() {
    Car car = new Car();
    assertEquals(100, car.drive(10, 10));
    assertEquals(0, car.drive(0,10));
}
```

**AssertThrows** (Like should_panic in Rust. Making sure that the method throws and error expectedly)

```java
@Test
void testDrive() {
    Car car = new Car();
    assertEquals(100, car.drive(10, 10));
    assertEquals(0, car.drive(0,10));

    assertThrows(IllegalArgumentException.class, () -> {
        car.drive(-10,10);
    });
    // Probably want to split all these up into different test cases
    assertThrows(IllegalArgumentException.class, () -> {
        car.drive(null,10);
    });
}
```

This test will fail, we need to make drive() more robust

```java
public Integer drive(Integer h, Integer kmh) {
    if(h == null || kmh == null) // make sure we check null first to avoid NullPointerException when checking negative
        throw new IllegalArgumentException("h or kmh is null");
    if(h < 0 || kmh < 0)
        throw new IllegalArgumentException("h or kmh is negative");

    return h*kmh;
}
```

Other useful assertions:
- assertTrue() / assertFalse()
- assertArrayEquals()
- assertIterableEquals()
- assertSame()

Useful annotations
- @Test
- @BeforeEach / @AfterEach -> used to setup and cleanup test case

General Tips:
- Name classes Test*.java or *Test.java
- Usually in separate folder

## What should you test

- Common usage cases (Regression testing)
  - prioritize test cases that are most often used are at least working

- edge cases (boundaries of conditions)
- after finding a bug
- complex algorithms
- test paths (coverage, going through all possible paths of your code)

## Advantages of unit testing

- find issues early
- detect changes that may break a contract between methods
- simplifies debugging process
- helps reduce the cost of bug fixes

## Disadvantages of unit testing

- can't detect all types of bugs (like system-level bugs)