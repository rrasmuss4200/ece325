# More about Scanner

- has methods for reading integers as well
  - hasNextInt() and nextInt()

```java
String str = "100 200";

int a = 0, b = 0;
try {
    s = new Scanner(str);
    if(s.hasNextInt())
        a = s.nextInt();
    if(s.hasNextInt())
        b = s.nextInt();
    Syste.out.println(a*b);
}
finally {
    if(s != null)
        s.close();
}
```

If str = "Numbers: 100 200", it would print 0 since it only scans Numbers: then 100.

Does a * b = 100 * 0 = 0 since it only checks for an int twice.

## Set locale

useLocale(Localse.US) sets reading ints to US standards since we don't always know where program will be used

## Objects can be read/written too
● Object streams are implemented by ObjectInputStream and ObjectOutputStream

– NB here we want this lower-level I/O... so object streams are byte streams, not character streams

● Use the readObject() and writeObject()
methods

### Why read/write object

- save/load program state
- only works if we read it back into application that uses the same classes
- read/written by (de)serializing
  - Just implement Serializable marker interface
  - deserializing objects can lead to security issues

# In summary

For user input:
- System.in or Console

For files:
- Byte stream: use InputStream/OutputStream
- Character stream: use Reader/Writer
- Buffered stream: use Buffered class
- Object stream 

**Generally** wrap all classes in a buffered stream