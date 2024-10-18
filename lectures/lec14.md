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