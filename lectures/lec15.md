# Collections that use Generics

- a collections represents a group of objects known as its elements
- all core collection interfaces are generic

## Collection interface

- root of collection heirarchy
- use for max generalizability

```java
Collection<String> = new ArrayList<>();
Collection<Car> = new ArrayList<RaceCar>(); // not possible. <Type> must be the same
```

If we insert HybridCar into Collection<Car> and get it out of ArrayList<RaceCar>, we have a problem

## Using a collection
Methods:
- size(), isEmpty(), contains(), add(), remove()

Methods that operate on entire collections
- containsAll(Collection<E>)
- others

## Each collection has an iterator

```java
for (Object i : collection) {
    System.out.println(i);
}
```

Here we **cannot** add() or remove() during iteration becuase that changes the size of the collection

### An irterator

```java
public interface Iterator<E> {
    boolean hasNext();
    E next();
    void remove(); // optional
}
```

Get an iterator for a given collection using iterator() method

```java
// remove element where some condition is true
public static <E> void filter(Collection<E> c) {
    for(Iterator<E> it = c.iterator(); it.hasNext(); ) {
        E str = it.next();
        if(someCondition(str))
            it.remove();
    }
}
```

## The core collection interfaces
- list
- set
- deque
- queue
- ** map

### Set
- cannot contain duplicate elements
- ex: HashSet, TreeSet, ...
- Used to quickly remove duplicates from another collection

```java
ArrayList<Integer> list - new ArrayList<>();
list.add(1);
list.add(2);
list.add(3);
list.add(1);
Collection<Integer> noDups = new HashSet<>(list);
```

**Set operation** (see testSet.java in lecture_code)

### List
List has ListIterator that allows going back and forth. next() and previous(), hasNext(), hasPrevious()

### Queue

For large incoming data queues. Often constatnly being checked for new data

Fifo

- Insert -> add(e) throws excep. -> offer(e) returns special value
- Remove -> remove() throws excep. -> poll() returns special value
- Examine -> element() -> peek()
- special value is Null returned when operation fails

### Deque

holds multiple elements prior to processing

- FIFO or LIFO (Stack and Queue at same time)

### Map

- object that maps keys to values
- cannot contain duplicate keys
- one key can map to one element

### SortedSet and SortedMap

- indicate sorted versions of Set and Map (TreeSet is sorted)
- all collections can easily be sorted

## Optional methods

- only important when creating your own colleciton
- optional ones are indicated in documentation

## Java.util.collections

Has some useful methods for sorting and such

One use is removing all occurrences of an element
```java
coll.add(1);
coll.add(null);
coll.add(null);
coll.removeAll(Collections.singleton(null));
// coll contains {1}
```