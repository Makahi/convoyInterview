# convoyInterview
Code for Convoy assignment


<h4>Problem statement:</h4>
Write a java application that takes in a input file denoting trips, and bundles them together into as few different trips as possible. 
Print out these bundles.

<h4>Interface:</h4>
<i>./bundler.sh path_to_input_file</i>
<ul><li>path_to_input_file is mandatory</li></ul>

<h4>Input file</h4>
Each line in the file represents one shipment, and looks like:
```
<SHIPMENT_ID> <START_CITY> <END_CITY> <DAY_OF_WEEK>
```
Lines beginning with a '#' are considered comments and will not be processed



<h4>How to run:</h4>
<ol>
<li>Make sure that you have Java 8 or later installed on your computer (if not, download from https://java.com/en/download/)</li>
<li>Run the bundler with <b><i>./bundler.sh path_to_input_file</i></b></li>
</ol>
<h4>Ex:</h4>
<pre>
Eris:convoyInterview Sacha$ ./bundler.sh "tst/resources/OneBranchTest"
1 3 44 22 99
2
Eris:convoyInterview Sacha$ ./bundler.sh "tst/resources/MultipleBranchesTest"
1 3 5
4
2
</pre>


<h4>To build source code if jar not present:</h4>
<ol>
<li>Install gradle if not already installed (https://gradle.org/)</li>
<li>Pull down this git repository and navigate to its root directory</li>
<li>Run <b><i>gradle clean build</i></b> to build the code into a jar file</li>
</ol>