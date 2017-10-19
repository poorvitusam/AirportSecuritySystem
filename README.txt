Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile airportSecurityState/src/build.xml run -Darg0=firstarg -Darg1=SECOND -Darg2=THIRD

-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.

[Date: ] -- 10/19/2017

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)
To store results: arraylist- O(n)

-----------------------------------------------------------------------
The Implementation and flow is as follows:

1.Driver class: I call a new class from here( Let's call 
it AirportSecurityProcess)

2.AirportSecurityProcess: : This acts like a base class. This class 
reads one line at a time. It process this line, and breaks it into 
parameters. The 2 metrics are computed in this class and passes it 
to tightenOrLoosenSecurity() which is in the context class. 

3.Context : This calls the tightenOrLoosenSecurity() of the current 
state's class (by default I have assigned it to LOW_RISK). 
The state class has the conditional check to determine the 
currentState, which is returned to the context class. The context 
class then returns the currentState object to AirportSecurityProcess.


4.AirportSecurityProcess: It matches the string (e.g LOW_RISK = 1 3 5 7 9)
 with the currentState received and sends the string to Result class to 
 store in a list.
 
5.Driver : Finally the result is written to the output file.
 
Provide list of citations (urls, etc.) from where you have taken code
(if any).
