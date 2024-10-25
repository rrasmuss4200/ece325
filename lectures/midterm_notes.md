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