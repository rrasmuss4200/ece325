# Generics

```java
ArrayList<String> list = new ArrayList<String>();
```

This is a generic collection:
- it works with any type of class wuthout having to change its code
- allows us to use types as parameters
- Uses same source code for many different types it is created with
- **Prevent bugs** by allowing compile-time type checking
- They also remove the need to cast variables when calling .get() from an ArrayList

```java
ArrayList list2 = new ArrayList();
list2.add(new Car());
String str2 = (String) list2.get(0); // explicit cast to String
```

This will compile but will crash once you run it.

We will implement some generic classes using a Box that can hold any type of object.
- Once created, it can only hold the type of object its created with

```java
public class Box<T> {
    private T contents;

    public void setContents(T contents) {
        this.contents = contents;
    }
}
```

Can have as many different types: ```public class Box<T1, T2, T3...>```.

The **T**ype name is always a single uppercase letter
- because we want to name the type as a generic type, not the name of another type that already exists
- ex: ```public class Box<Car>``` vs. ```public class Box<T>```. Second one is much better even though both would work

- E - Element
- N - Number
- T - Type
- V - Value
- K - Key
- These are just names, don't actually enforce type

```java
Box<String> box1 = new Box<String>(); // ok
Box<Car> box2 = new Box<Car>(); // ok
Box<int> box3 = new Box<int>; // not ok. Must be object not primitive type
```

Cannot change types with a specific box as as you go.

## Multiple generic type parameters

```java
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

public class OurPair<K, V> implements Pair<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return K;
    }

    public V getValue() {
        return K;
    }
}
```

## Raw types

When we create an object of a generic class without type arguments, we call this a raw type
- This is there to support old code

```Box box = new Box();``` will always hold something of type object, no longer generic

```java
Box box1 = new Box();
Box<String> box2 = new Box<>();
```

We can add a Car to Box1 but not box2

If set box1 = box2, box1 still declared as Box so it will work

If set box2 = box1, box2 still declared as Box<String> so won't work

This is dangerous because since the compiler makes sure we put a String in box2, but if we put a Car object in it via box1!!!

If getting from raw box, we have to cast it which can be dangerous

**Do not mix generics and raw types**

# Part 2

Methods can be generic too

*Reminder* use **static** methods when you don't need to access the fields of the class
```java
public class Util {
    public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
        p1.getValue().equals(p2.getValue());
    }
}
```

**If p1 and p2 are not the same type, it will throw an error and not compile**

Can call with ```Util.<String, Integer>compare(...)``` or ```Util.compare(...)``` (type inference)

## Inheritance with generics

- T could mean any object
- Sometimes, we want to allow only specific types
  - Like a Number(Integer, Double,...)

- Type params can be **bounded** when we want to accept only certain classes

```public class Box<N extends Number>``` ( N *is a* number, rest of the class stays the same)

Box<Number> boxNum = new Box<>();

Box<Integer> boxInt = new Box<>();

Cannot do this!:

boxNum = boxInt;

A Box<Integer> is not a special type of a Box<Number>

If Java allowed this, and if Box<Number> held a Double, and if we set boxNum = boxInt, if boxInt took the Double out of the box, it wouldn't know what to do with it since a Double is not treated the same as an Integer.

### Inheritance can work with generics

Only if all types are the same.

Box<T> <- SpecialBox<T> <- VerSpecialBox<T>

**If we want to implement less restrictive rules for generics:**

Let's say we have

```java
public static void printAll(List<Number> list) {
    for(Number n : list) {
        System.out.println(n);
    }
}

printAll(new ArrayList<Number>()); // yes
printAll(new ArrayList<Integer>()); // no
```

We can do ArrayList<Number> since it can hold Number, Integer, Double but not Integer cuz of the same Box<> example as above

What is a better, less restrictive implementation, specify List takes type that extends Number

```java
public static <N extends Number> void printAll(List<N> list) {
    for(N n : list) {
        System.out.println(n);
    }
}

printAll(new ArrayList<Number>()); // yes
printAll(new ArrayList<Integer>()); // yes!
```

### Wildcard

We don't care what type N is, as long as it extends number

```java
public static void printAll(List<? extends Number> list) {
    for(Number n : list) {
        System.out.println(n);
    }
}
```

If we had printAll take List<Object>, it would be more restrictive, as the list would need to be made of types that extend Object.

Here we don't don't care what the type is, we are just printing it.

```java
public static void printAll(List<?> list) {
    for(Object n : list) {
        System.out.println(n);
    }
}
```

But here, we want to make sure the type we are adding to the list is of the appropriate type

```java
public static <T> void addToList(List<T> list, T t) {
    list.add(t);
}
```

**Lower and Upper bounded**
<? extends T>

- means any type that is T or extends/implements T (Number or Integer, goes down)

<? super T>

- means any type that is T or a superclass of T (Number or Object, goes up)

## PECS: Producer Extends, Consumer Super

- use **extends** when you only get values out of a data structure
- use **super** when you only put values in a data structure

**Producing**

- objects are either subclass or of class Car (we just care that it has a MaxSpeed to get)

```java
public static void showMaxSpeeds(List<? extends Car> list) {
    for(Car c : list)
        System.out.println(c.getMaxSpeed()); // uses the deepest implementation of getMaxSpeed() :)
}
```

**Consuming**

- We can do this as long as the List can store objects of type Car or a superclass of Car

```java
public static void storeCar(List<? super Car> list, Car c) {
    list.add(c);
}
```

**Why not <T super Car>?**

Cuz we know T is superclass of Car, but not much else. T may not know the same methods as Car

so we can **only use upperbound for wildcards**.
