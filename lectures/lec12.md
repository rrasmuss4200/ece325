# Basic I/O

- reading user input
- read/write to file
- saving/loading objects

## Which ways for input?

- files
- command line args
- the console (System.in)
- GUI

Libraries exist to make parsing CLA's easier

## I/O streams

- disk files, devices, other programs, etc.
- Streams support primitive types and objects

## Byte Streams

- perform input and output of bytes
- extends InputStream and OutputStream
- System.in is an InputStream

```java
public static void main(String args[]) throws IOException{
        InputStream in = System.in;

        int input = in.read(); // only reads single byte

        System.out.println("Just read: " + (char)input);
    }
```

Fix by as long as there's input, it prints it to sys.out
```java
public static void main(String args[]) throws IOException{
    InputStream in = System.in;

    int input;
    while((input = in.read()) != -1) { // -1 indicates EOF
        System.out.print((char)input);
    }
}
```

Can use these streams to read/write from a file

```java
public static void main(String[] args) throws IOException {
    FileInputStream in = null;
    FileOutputStream out = null;

    try {
        in = new FileInputStream("filename.txt");
        out = new FileOutputStream("output.txt");
        int c;
        while((c = in.read()) != -1) { // -1 indicates EOF
        out.write(c);
    } finally { // try finally will propogate errors up to method caller
        if (in != null) { in.close(); }
        if (out != null) { out.close(); }
    }
    }
}
```

*Make sure to always close streams*

Any stream in Java uses a byte stream internally, even for the more high-level i/o streams

## Character Streams

Reads Unicode througha a character stream

```java
// ...
    FileReader in = null;
    FileWriter out = null;

    try {
        // ...
    }
```

Reading character by character is expensive with OS calls.

*Also* these streams are non-buffered.

## Buffered Streams

- these read/write data until its full, then does the read/write

```java
    BufferedReader in = null;
    BufferedWriter out = null;
    try {
        in = new BufferedReader(new FileReader("input.txt"));
        out = new BufferedWriter(new FileWriter("output.txt"));
        String line;
    while ((line = in.readLine()) != null) {
        out.write(line + System.lineSeparator());
    }
    } finally {
        if (in != null) { in.close(); }
        if (out != null) { out.close(); }
    }
```

### Flushing a Buffered Stream

- buffer can be written (flushed) using the flush() method
- sometimes necessary before buffer is full

## Scanning Input

- break down input into tokens you can do something with it
  - ex: reading a CSV file

- Scanner allows one to split a String, InputStream or Readable based on a delimiter

```java
Scanner s = null;
String str = "Hello,1,World!,2";

try {
    s = new Scanner(str);
    s.useDelimiter(",);
    while(s.hasNext()) {
        System.out.print("Token: " + s.next());
    }

finally {
    if (s != null)
    s.close();
}
}
```