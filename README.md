# JavaBasicPractice

# examples package
Simple examples of using basic Java language constructs:
- SystemOutExample - output information on console
- DataTypesExample - primitive data types and arithmetic operations
- IfThenElseExample - basic conditional operator
- SwitchExample - conditional Multiple choice operator
- CycleExample - loops with precondition, postcondition and counter
- MethodsExample - creating and using methods
- ArraysExample - one-dimensional and multidimensional arrays

# oop package
Object-Oriented Programming example:
- ICreatable - interface with breeding contract
- Animal - parent class, with some name, genders, age and satiety
  - Cat - child class of Animal, that overrides parent methods and has custom behavior
- Food - parent class, with some calories
  - Bone, Milk, Mouse - child class of Food, which animals can eat

# errors package
Errors usage examples:
- ErrorsExample - create hamsters, if the input is correct, or show error message
- Hamster - object class with validation setters
- ArgumentException - parent Exceptions class for arguments validation
  - EmptyArgumentException - child class of ArgumentException, which throws on empty nickname of Hamster
  - InvalidArgumentException - child class of ArgumentException, which throws on invalid hamster breeds
  - NumberArgumentException - child class of ArgumentException for numbers validation
    - NegativeArgumentException  - child class of NumberArgumentException, which throws for negative numbers
    - OverflowArgumentException  - child class of NumberArgumentException, which throws for too big numbers

# collections package
Person is simple data class (with name & lastname) for collection examples: 
- ArraysExample - using arrays with class Arrays (imitates interface java.util.Collection)
- ListExamples - using a dynamic lists (implement interface java.util.Collection) with class instances of ArrayList and LinkedList
- SetExample - using a dynamic set of unique elements (implement interface java.util.Collection) with class instances of HashSet and TreeSet
- MapExample - using a dynamic maps of pairs key-value (Map use object of interface java.util.Collection) with class instances of HashMap and TreeMap
- IteratorExample - enumeration of all collection values

# files package
Read and write data in files
- FilesExample - show 4 examples: 
clone image (read one file and write data to another), 
write to text-file (add text and show result), 
save object (serialize java-object to file and deserialized it), 
save object in json-format (used Gson library)
- FileInputAndOutputStreams - write and read bytes from file in classic try/catch and new try-with-resources/catch notation
- ReaderAndWriter - write (rewrite or append) and read text from file
- ObjectInputAndOutputStreams - write and read java-object



