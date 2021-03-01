# Project 1: Deterministic Finite Automata

* Author: Sam Jackson and Jeremy Bouchard 
* Class: CS361 Section 1
* Semester: Spring 2021

## Overview

Models a finite autonoma; allows user to build and modify a finite
autonoma and check if strings exist within it.

## Compiling and Using

Compile:
in the main directory:

javac fa/dfa/DFADriver.java

To run on our test cases:

java fa.dfa.DFADriver ./test/testname.txt

## Discussion

The most difficult aspect of this project was understanding
a good mental model of how each class should work. We began by
understanding how a deterministic finite autonama should work,
and implemented methods from that point.

Another difficulty was navigating the correct storage objects
to use in each scenario. We were unfamiliar with some of the ones
used before the project, but through this we both gained a greater
understanding of them and their methods.

## Testing

We tested our project by comparing our output to the sample output
provided on the project spec sheet. The only output that seemed to
differ was our delta readout, but only in the case of whitespace
formatting. Otherwise, all data is correct.

## Extra Credit

N/A

## Sources used

[Here is some help creating links](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet#links)
[Linked Hash Set](https://www.geeksforgeeks.org/linkedhashset-tostring-method-in-java-with-example/)
[Multi Dimensional Arrays](https://www.geeksforgeeks.org/multidimensional-arrays-in-java/)
[Hash Maps](https://www.geeksforgeeks.org/java-util-hashmap-in-java-with-examples/#:~:text=HashMap%20is%20a%20part%20of,util%20package.&text=HashMap%20doesn't%20allow%20duplicate,once%20and%20multiple%20null%20values.)
