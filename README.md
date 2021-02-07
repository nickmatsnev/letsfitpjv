# letsfitpjv

This is semestral project of BIE-PJV course at FIT CTU in Prague, Winter semester 20/21, and my name 
is Nikita Matsnev (matsnnik).

This project is created in Java, using JavaFX and JBDC MySQL. It is desktop application.

The idea is quiet simple: a system for students, dedicated to passing various tests, created by users. 
You can sign up and after authentification procedure
you will be able to create and play victorines, you will also see your rating, your games rating and 
other users games and ratings. During the game process, you can answer 6 questions with multiple choices
and see your result at the end.

The source code consists of three packages and multiple classes beyond mentioned packages. 

These are Main class, which runs an application,
and also certain classes to maintain JBDC connection, navigation between pages, current session 
and some other features.
In the package named 'controllers' you can find controller classes for FXML design sheets, which are held
in the package 'design'. Package 'css' contains basic css source.

To run the application, you need to create your database and to run script 'create.sql' and to run it on 
MySQL server. Also change connection URLs in JBDCConnection class in conformity with your setup of database.
Then you just need to run it.
