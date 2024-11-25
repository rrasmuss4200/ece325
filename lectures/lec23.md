# Garbage Collection

uses the object graph

GC Roots are how the GC knows what to delete

GC Roots -> RaceTrack object -> ArrayList<Car> -> Car Object x3

Local variables always are GC roots

## Steps of garbage collection

- Any object that can be reached from a GC root is considered **live**

1. Marking live objects
   - GC traverses memory, all objects passed are marked as live
2. Deleting dead objects
   - GC removes dead objects
3. Compacting remaining objects
   - defragments the memory and compacts it

## JVM Generation

- Young Generation
  - where all new objects are allocated
  - when this fills it, it triggers a minor garbage collection
  - Only collects objects from Young generation
  - Unremoved objects are aged and move to old generation at some point
  - Young Generation all divided into 3:
    - Eden, S0, S1 space
    - Objects move from Eden to S0 to S1 and are aged by 1 each time
    - each fill up triggers a minor GC
- Old
  - stores long surviving objects
  - only collected during *major* garbage collection
- Permanent (Metaspace)
  - metadata required by JVM to describe classes and methods used in application
  - objects only done during *full* garbage collection (goes through all 3)

## Garbage collection cost

- garbage collection stops all execution until its completed
- minor is faster than major
- GC execution time depends on the size of the heap
  - too small will trigger more GC cycles than necessary
  - too big heap will make GC take more time to execute and defragment

There are different types of GC's and one can choose what to use

One can also disable or finetune the GC, not practical though