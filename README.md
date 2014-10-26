slogo
=====

Project Description: Provides a development environment that supports users to write SLogo programs.

** IMPORTANT NOTE **
For the project to run at all, an Ant Builder must be created. More details follow later on in the Readme.

**names of all people who worked on the project**

Allan Kiplagat, Steve Kuznetsov, Austin Kyker, Stanley Yuan

**date you started, date you finished, and an estimate of the number of hours worked on the project**

We began the project September 21st, and finished the project on October 26th. 
An estimate of the number of hours worked on the project is 236 man-hours for the team.

**each person's role in developing the project**

Steve and Stanley worked on the backend.

Austin and Allan worked on the frontend. 

**any books, papers, online, or human resources that you used in developing the project**

A very large amount of Googling, using resources like stackoverflow often.

**files used to start the project (the class(es) containing main)**

The Main class within the Control package.

**files used to test the project (the class(es) containing TestSuite)**

There are 161 tests within the tests package.

**any data or resource files required by the project (including format of non-standard files)**

All of the data and resources are stored within the resources package.

**any information about using the program (i.e., command-line/applet arguments, key inputs, interesting example data files, or easter eggs)**

In order to use this project, we require that you use an Ant build to make the Slogo.jar file that is used within the project.

* What has to be done is right click the project slogo_team10, and click Properties
* The Builder section should be selected
* There should be an option to build a new Builder - make it an Ant Builder
* It can be titled MakeJar
* The build file should be set to "${workspace_loc:/slogo_team10/projectBuilder.xml}"
* The base directory should be set to "${workspace_loc:/slogo_team10}"
* After creating it, make sure the box next to the builder is checked
* The jar file that is required should now be automatically re-built anytime the program is run.

**any known bugs, crashes, or problems with the project's functionality**
When using the arrow keys to move the selected turtles when multiple workspace tabs are open, the arrow keys
not only move the turtles, but switch the selected workspace.

**any extra features included in the project**
The ability to use the project in multiple languages, the ability to drag and drop image files
that can be used in place of the default turtle image. The ability to read and write a workspace to
xml.

**your impressions of the assignment to help improve it in the future**
THe assignment was a good introduction into a large-scale group project. It emphasized
the importance of team communication and project planning.



