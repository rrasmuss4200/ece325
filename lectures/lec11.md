# Exception Handling

Have discussed three so far:

- Compile-time errors
  - IDE or compiler will tell you

- Run-time errors
  - system will tell you at runtime

- Logical
  - May not notice right away, unintended code output or interpretation

- Design error
  - Design bahaves in unintended way

- User error
  - Unintended user input to the program

- Environmental errors
  - network, third-party program usage

## Defensive Coding

- try to deal with errors as soon as they can occur
- fields of a class can only be controlled by the intended entities

Some exmaples:
- Encapsulation
- Getters/setters
- Setting default values

Ex:

```java
public class Car {
    private int maxSpeed; // make private

    public void setMaxSpeed(int i) {
        if (i >= 0) { // check for valid speed
            maxSpeed = i;
        } else {
            System.out.println("Invalid value for maxSpeed"); // Let the user know what they did wrong
        }
    }
}
```

## What is an Exception

When the program behaves in an unexpected behaviour, the program throws an exception.

```java
public class ExceptEx {
    ArrayList<String> myList;

    public void problemCode(String item) {
        myList.add(item); // will cause NullPointerException
                          // since myList has not been initialized

    }
}
```

We can provide alternative code to execute in the event of an exception using try ... catch statement

```java
public void problemCode(String item) {
    try {
        myList.add(item);
    }
    // only executes if except was thrown
    catch (NullPointerException e) {
        myList = new ArrayList<String>;
    }
    // always execute next part
    finally {
        // ...
    }
}
```

All exceptions are object that extend the Exception class

**Error**: should not try..catch since we cannot usually do anything about Errors
**Exception**: *Checked* and *unchecked* exceptions can both be dealt with

- *Checked*: Gets checked at compile time
- *Unchecked*: Does not get checked at compile time

```java
public void forwardException() throws IOExcpetion {
    // means you need to try...catch this expection somewhere in the method that calls it
}
```

```java
public void handleMany() {
    try {
        // ...
    }
    catch (Err1 e) {

    }
    catch (Err2 e) {

    }
}
```

NullPointerException is unchecked so generally we do not catch it. It can always occur for anything you do.

We can treat all exceptions in one block

```java
try {

}
catch (Excpetion e) {
    // good or bad idea
}
```

Makes for bad debugging if we just print "Here, an exception happened".

Also, different errors require different ways of dealing with them, this makes for bad implementation in this block

## Defining our own Exception

```java
public class BlankNoteException extends Exception {
    public BlankNoteException(String message) {
        super(message);
    }
}

public void addNote (String s) throws BlankNoteException {
    if (S.trim().equals(")){
        throw new BlankNoteException("Note can't be empty");
    } else {
        myList.add(s);
    }
}
```
