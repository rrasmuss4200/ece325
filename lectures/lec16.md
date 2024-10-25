# Sorting

Some collections are sorted by default

Others have a .sort() method

```java
public static void main (String[] args) {
        ArrayList<Car> s = new ArrayList<>();
        s.add(new Car("Ferrari", 300));
        s.add(new Car("Lamborghini", 320));
        s.add(new Car("Alfa Romeo", 300));
        s.add(new Car("Jeep", 180));
        s.add(new Car("Jeep", 180));
        s.add(new Car("Alfa Romeo", 250));

        System.out.println(Collections.sort(s)); // compiler doesn't know how to sort this

    }
```

Car is not Comparable! (From Collections docs)

We must implement Comparable interface

compareTo(T o) returns:
- -ve if obj is less than o
- 0 if obj equals o
- +ve is obj is bigger than o

This is based on the sorting functionality that your program needs

Implement Comparable:

```java
public class Car implements Comparable<Car> {
    // ...
    @Override
    // this method will sort by maxSpeed first, then Make after that
    public int compareTo(Car o) {
        int i = Integer.compare(maxSpeed, o.getMaxSpeed());
        if(i != 0) return i;
        return make.compareTo(o.getMake());
        }
    }
```

## Soring in unnatural order

- class can have only one natural ordering
  - since it can only implement comapreTo() once

- but it can have alternative orderings

## == vs equals() vs compareTo()

- == to check if the object **references** are the same
- if compareTo(T o) returns 0, expected that equals(T o) returns true
- A TreeSet uses compreTo(T o) for ordering
- Others like HashSet use equals() to filter duplicates

## Hashcode

- Java uses hashcodes to compare objects by default
- when stored in a Hashset, objects are decided on where it should be placed based on hashCode and equals() method
- when using a class in a set, one must override hashCode() method

ex:

```java
@Override
public int hashCode() {
    return make.hashCode() + maxSpeed;
}
```

two Car objects with different make and maxSpeed can have the same hashcode

However: their equals() test would then fail, so they are not considered equal

