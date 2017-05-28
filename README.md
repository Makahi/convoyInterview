# convoyInterview
Code for Convoy assignment


####Problem statement:
Write a java application that takes in a input file denoting trips, and bundles them together into as few different trips as possible. 
Print out these bundles.

####Interface:
##### <i>./bundler.sh path_to_input_file</i>
- path_to_input_file is mandatory

#### Input file
Each line in the file represents one shipment, and looks like:
```
<SHIPMENT_ID> <START_CITY> <END_CITY> <DAY_OF_WEEK>
```
Lines beginning with a '#' are considered comments and will not be processed



###How to run:
1) Make sure that you have Java 8 or later installed on your computer (if not, download from https://java.com/en/download/)
2) Run the bundler with <b><i>./bundler.sh path_to_input_file</i></b>

#####Ex:
```
Eris:convoyInterview Sacha$ ./bundler.sh "tst/resources/OneBranchTest"
1 3 44 22 99
2
Eris:convoyInterview Sacha$ ./bundler.sh "tst/resources/MultipleBranchesTest"
1 3 5
4
2
```


###To build source code if jar not present:
1) Install gradle if not already installed (https://gradle.org/)
2) Pull down this git repository and navigate to its root directory
3) Run <b><i>gradle clean build</i></b> to build the code into a jar file