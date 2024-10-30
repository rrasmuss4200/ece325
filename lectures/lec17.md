# Improving Readability of Code

**Tips**:
- comments/docs
- style
- code grouping
- consistent naming
- DRY (Don't repeat yourself)

## Comments vs Documentation

- comments are meant for when you have access to source code. Help maintain code for later
- Documentation is for how to use the code and access the API

### Writing better comments
- code should be self explanatory
- Is there a way I can improve the code so that this comment is not necessary?
- avoid useless comments
- write for code that cannot be clarified further
- write for code that is inherently complex (algorithm)

## Doc comments in javadoc
- converted to HTML using javadoc
- must precede class implementation
- section headers starting with @ produce HTML documentation

*Important block tags:*
- @author (classes and interfaces)
- @version (classes and interfaces)
- @param (methods and constructors, required)
- @return (methods only, for every method that returns seomthing other than void)
- @throws
- @deprecated

## Consistent and self-explanatory naming

- actually very difficult
- it's personal preference but just be consistent

## DRY

- applies to source code but also documentation and comments

## Good examples

- popular open source projects
- Java API source code

## Exam

- questions might include *why is this a bad comment*, or *what can this variable name be changed to*