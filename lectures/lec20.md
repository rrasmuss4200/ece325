# Nested Classes

We *can* define a class within another but one should only do this when you need

```java
public class OuterClass {
    private int count;

    class NestedClass {

    }
}
```

Can access fields of outer class in nested class as long as nested is not static and fields are not private

## Why use them

- Use to logically group a class that is only used in one place
- increase encapsulation

ex: extend our car class by storing details about tires
- idealPressure and actualPressure

Should we make tires inside Car class or not?

Do we ever need to use a tire outside of Car?

If yes, it should be upper class, if not then we can make it nested

```java
public class Car {
    private Tire[] tires;

    public Car() {
        tires = new Tire[4];
        for (int i = 0; i < tires.length; i++) {
            tires[i] = new Tire();
        }
    }

    public void inflate(int pos, int pressure) {
        Tires[pos].inflate(pressure);
    }

    class Tires {
        int idealPressure;
        int actualPressure;

        void inflate(int pressure) {
            this.actualPressure += pressure;
        }
    }
}
```

## 3 types of inner classes:

### Inner member
  - ex: if we are creating a custome list class, we need to provide our own functionality for iterating. This would only be used inside our own list.
  - ** When we create an outer class object, we **do not** automatically create an inner class object.

### Local classes
- inside method body, loop or if clause
- useful when you know the class won't be used outside the block
- not that often in practice
- ex:

```java
public class AddressUtils {
    public static boolean arePhoneNumbersValid(String ph1, String ph2) {
        class PhoneNumber {
            boolean isValid;
            String regex = "[^0-9]";

            PhoneNumber(String s) {
                String nr = s.replaceAll(regex, "");
                if (nr.length() != 10) isValid = false;
                else isValid = true;
            }
        }
        PhoneNumber p1 = new PhoneNumber(ph1);
        PhoneNumber p2 = new PhoneNumber(ph2);
        return p1.isValid && p2.isValid;
    }
}
```

### Anonymous classes
- declare and make a class at the same time
- no name
- can be used if you use a local class only once.
- used a lot in GUI's

ex: (code is incomplete. API defines that it needs an event handler)

```java
Button btn = new Button();
btn.setText("Say 'Hello World'");
btn.setOnAction(new EventHandler<ActionEvent>()) { // only used in this method
    @Override
    public void handle(ActionEvent event) {
    System.out.println("Hello World!");
    }
};
```

This is very useful for GUI's because there are tons of EventHandler classes that you need to make do slightly different things. This would become awkward if you create a local class for each one. Naming would also become an issue.

To specify an anonymous class, there needs to be a pre-existing type that characterizes the class, otherwise we need a local class

Accessing local variables for inner and outer classes

```java
public class OuterClass {
    private int x = 0;
        class InnerClass {
        private int x = 1;
        public void printX() {
            System.out.println(this.x); // inner class x
            System.out.println(OuterClass.this.x); // outer class x
        }
    }
}
```

### Static nested classes

Enums are these. They're static by default

When to use what:

- when a class needs to be visible outside a single method -> inner member class
- when each instance of member class needs to access outer class -> make it nonstatic, otherwise make it static
- if you need to create instances in only one location AND there's a pre-existing type -> make anonymous