# fileprocessor_gt
File processor to aggregate the data using JAVA, SpringBoot

1. CSV file data is read line by line (for memory optimization - see note 1 below).
2. Each line is converted to PERSON object using converter class.
3. Each PERSON object is sent to chain of processors that will process the person and update the state accordingly.
4. End result is stored as a state object.

Note 1 : If memory is not a constraint, then we can load all the data from the file into an array / list. And then we can use streams operations to get the result.


