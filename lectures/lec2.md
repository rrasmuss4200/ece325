# Lecture 2: Java Basics
HelloWorld.java
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

## What happens when a .java file is compiled:
.java files are compiled into .class file

- Every java program needs *at least* one class.
- The class **must** be the same name as the file name.
- 'main' method is required

**NB**: 3 Types of errors:
- Compile-time errors:
  - syntax...

- Run-time errors
  - caught by system with executed
  - Div by 0, empty array operation

- Logical errors
  - Caught by developer
  - Program not executed as intended

WorldHello.java
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.err.println(Go away World!");
        System.out.println(5/0);
    }
}
```

Errs:
- div by 0
- missing quotation
- printing to err
- wrong file name


## Code structure in Java
- One class per Java file
- class body goes within curly braces
- Classes contain methods with statements
- Stand-alone functions cannot be defined in Java

## Syntax rules
- Semicolons (;)
- Most white space doesn't matter
- Comments -> // or /** */

## 8 Primitive Types
- byte - 8 bit
- float - 32 bit float
- int - 32 bit
- long - 64 bit
- double - 64 bit float
- short - 16
- char - 8 bit
- bool - 1 bit
- *NB* these types have default values, but we should initialize them as 0

## Tyep Casting
```java
int i = (int) 100L;
```

*Widening*: going to larger type
- byte -> short -> char -> int -> long -> float -> double
- done by JVM

*Narrowing*: larger to smaller type
- opposite direction
- done manually

## Java Literals
it's a source code representation of a fixed value

ex: 3 is a literal and never changes. String values are literals too

Boolean values are also literlas.

## Methods in Java
*visibility*: whoe can access the method (public or private)

*static*: how to execute the method, what is inside it

*return type*: can be a primitive type, object or void (nothing)

*name and parameters*


