## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.


## Student Names:              ## Roll Nos.:

Student 1 > Amritansh Shukla         ->     S20210010016
Student 2 > Mehul Yeole              ->     S20210010248
Student 3 > Rushikesh Kadam          ->     S20210010195
Student 4 > Nirbhay Gupta            ->     S20210010160
Student 5 > Manthan Shinde           ->     S20200010130

## Contribution to the project: 

> Student 1 has gone through all searching functions in the MovieDAO file and integrated them into the App.java file and implemented check for rating methods of movies in MovieDAO file, along with filling in the README file, and started App.java file with checking if the movie list is empty function.
> Student 2 has done sorting methods, printed out help menu, helped achieve inheritance in the program, created movies and users csv files and packaged the files into different folders and to count the number of records in the database, and commented through the entire code to explain what each method does.
> Student 3 has gone through updating functions directly from the command line by the user, and filtering function to filter out movies, while also consistently checking for Object Composition between the objects, primarily Movies and Users, in such a way that the ratings assigned by each user to the movies is printed out in the output of command line interface.
> Student 4 has created a read function to get all objects from the database, and form a list to show the no. of movies in the database, and created a delete function to delete any movie from the database, and made other functions to retreive movies by a distinguishing character such as their id, and to truncate the tables at the command of the user, and improved the search function to make partial string search possible.
> Student 5 made it possible to connect to the database by creating a Connection file and further created the create function to create new records in the database, and coded the initial part of App.java file to load csv files into the database, and overrode the toString() method, and created the mysql dump files.

## About the project:

We have created a java project regarding the command line record maintainance by setting up the connection with the database by exporting required drivers and givng connection to the database in connection factory. Our project is about movie database management so we have created two csv files "Movies1" and "Users", imported them to the database and profile_files are Movies.java and Users.java. We have implemented all the CRUD operations using Switch case in App.java which is depending on the folder DAO_files containing MovieDAO and UserDAO classes. These files have the search,create, update, delete related methods and a few aggregate methods.However, the Users table needs to be truncated at each command that it receives due to overlap of usage of data. Finally, there exists a backup file for the database called projects.sql in the dump_files folder that contains the exact contents of the database intended to be used The App.java file puts all of these together to execute the code in the main method to create a complete command line interface supportive code.