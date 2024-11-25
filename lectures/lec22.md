# Application Performance

- how fast/efficient our software executes some task
- lots of tradeoffs

Performance is often a system engineers responsibility. But DevOps has brought SWE's and sys. engineers closer together. SWE can impact more on performance.

## Aspects of Performace

- CPU use
- Memory use
- Throughput / I/O efficiency
- Execution time

---

We usually focus on optimizing performace after the main functionality of the application is finished.

**Don't start optimizing too soon**

## Measuring
- Profiling: while the SW is running
- Performance tests: tests specially designed to test performance

### Levels of testing
- system level: load or stress tests
- unit level: microbenchmarks

```java
private static long sum() {
        Long sum = 0L; // change to long
        for(long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }
```

This function is pretty slow because we're adding a Long object and a *long* primitive type. Everytime we add, we autobox the long to Long

Changing Long to long gets rid of need to autobox.

## Concerned?

Be worried if it's an operation that is executed many, many times.
- large tasks that take long to execute
- small tasks that are executed very often

## Working with a profiler

It hooks into your program while its executing and meausres memory, CPU, hot-spots etc.

Convenient since you don’t have to specify a test case (but not as easy to repeat/automate)

## Microbenchmarks

JMH test harness

Low level code components that take very short time to execute (us, ns)

Very hard to write

## Measuring with log files
- most logs contain timestamps
- use them to identify hot-spots and execution time
- No need to run profiler which can slow down the execution

## Keep in Mind

- performance test are hard to set up correctly
- things running on the computer can influence performance
  - ex: updates running in background
- performance tests tend to be noisy
  - repeat test and get median result

## Cool tests

String concatentation vs. StringBuilder:

StringBuilder is faster because it is mutable while String's are not! Concating needs to make a new String each time

LinkedList is faster for inserting but ArrayList is faster for looking up.