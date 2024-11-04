# Enums

- predefined constants
- *public* and *static*

```java
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```
use as Day.Monday, Day.Thursay, etc.

This is better to preserve type safety and calculations

## Definition

- can be defined in its own source file
  - if it's used in multiple places
- defined in same file as class
  - if it's only used in the class

## Power of Enums

- they can have fields and methods

```java
public enum Course {
    ECE325 ("Object-Oriented Design", 3),
    ECE321 ("Software Requirements Engineering", 2);

    private String descr;
    private int hoursPerWeek;

    private Course(String descr, int hours) {
        this.descr = descr;
        this.hoursPerWeek = hours;
    }
}
```

Course Enum with two values
- each value has two fields: descr, and hoursPerWeek
- **private** constructor to stop new ones from being created
  - we want to only pick from the enums provided

### Useful enum methods

- values()
  - returns array of enum values, can be iterrated over
- toString()
  - prints textual value
- valueOf()
  - returns enum instance of that value

**valueOf()**

```java
String[] courses = {"ECE321", "ECE325"};
for(String s : courses)
    load += Course.valueOf(s).getHoursPerWeek();
```

They also implement the comparable interface

For it's methods

```java
public enum Operation {
    public abstract double apply(double x, double y);
    PLUS {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        public double apply(double x, double y) {
            return x - y;
        }
    };
}
```

We call it as ```Operation.MINUS.apply(3, 1);```. This implementation is better cuz it makes us implement the method for every part of the enum since apply is abstract.

## EnumSet

If we have a variable that can take on multiple values of an enum: we use an EnumSet

**Word processor**

```java
public class Text {
    public enum Style{ BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    public void applyStyles(Set<Style> styles) { ... }

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
```

Here, ```text``` can be **BOLD** and *ITALIC*



## Switch statements

- work with enums, strings, primitive types(byte, short, char, int), some wrapper classes
- fall through happens if there are no breaks

```java
public static void printDay(Day day) {
    switch (day) {
    case MONDAY:
        System.out.println("ECE325 lecture woohoo!");
    case WEDNESDAY:
        System.out.println("ECE325 lecture woohoo!");
    case FRIDAY:
        System.out.println("ECE325 lecture woohoo!");
    default:
        System.out.println("No lecture boohoo");
    }
}
```

If ```printDay(Day.MONDAY)``` is run, it will print "ECE325 lecture woohoo!" 3 times.

We need a ```break``` after each case.

Can write them like this to allow for multiple cases to lead to a single outcome.

```java
public static void printDay(Day day) {
    switch (day) {
    case MONDAY:
    case WEDNESDAY:
    case FRIDAY: // or case MONDAY,WEDNESDAY,FRIDAY:
        System.out.println("ECE325 lecture woohoo!");
        break;
    default:
        System.out.println("No lecture boohoo");
    }
}
```

