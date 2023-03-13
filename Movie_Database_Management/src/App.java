import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import DAO_files.MovieDAO;
import DAO_files.UserDAO;
import profile_files.*;
import java.util.*;

public class App {
    public static void checkIfEmpty(List<Movies> mveList) {
        Boolean check = mveList.isEmpty();
        if (check == true) {
            System.out.println("OOPS! SORRY, Your requirement is unavailable in the given Movie Database!");
        } else {
            mveList.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {

        // Creation of Movies from csv
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                "C:\\Users\\Admin\\Downloads\\Oop miniproject\\Oop miniproject\\dbpracticejdbc\\src\\csv_files\\Movies.csv"));
              //  System.out.println("hell");
            String movieLine;
            int alreadyinsertedvalue = 0;
            int counter = 0;
            while ((movieLine = reader.readLine()) != null) {
                if (counter == 0){
                    counter++;
                    continue;
                }
                //System.out.println(movieLine);
                Movies m = new Movies(movieLine);
                MovieDAO mov = new MovieDAO();
                // Listing all Movie objects
                List<Movies> mlist = mov.getAllObjects();
                for (Movies movies : mlist) {
                    if (m.getId() == movies.getId()) {
                        alreadyinsertedvalue = m.getId();
                        break;
                    }
                }
            
                mov.createObjects(m, alreadyinsertedvalue);
            }
            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }

        // Creation of Users from csv
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    "\"C:\\Users\\Admin\\Downloads\\Oop miniproject\\Oop miniproject\\dbpracticejdbc\\src\\csv_files\\Users.csv\""));
            String userLine;
            int a = 0;
            while ((userLine = reader.readLine()) != null) {
                UserDAO user = new UserDAO();
                user.createObjects(new Users(userLine), a);
            }
            reader.close();
        } catch (IOException e) {
            e.getMessage();
        }

        // setting Movie ratings
        MovieDAO.setAllMovieRatings();
        

        // switch cases for arg[i]/arguments given in query
        switch (args[0]) {
            case "-print":
                List<Movies> allMovies1 = MovieDAO.setAllMovieUsers();
                System.out.println("--------------");
                allMovies1.forEach(System.out::println);
                System.out.println("--------------");
                break;

            case "-search":
                if (args[2].equalsIgnoreCase("Rating")) {
                    List<Movies> Movies = MovieDAO.Checkforrating(args[1], args[3]);
                    checkIfEmpty(Movies);
                } else if (args[1].equalsIgnoreCase("Id")) {
                    List<Movies> Movies = MovieDAO.Checkforrating(args[2]);
                    checkIfEmpty(Movies);
                } else if (args[4].equalsIgnoreCase("Rating")) {
                    List<Movies> Movies = MovieDAO.Checkforrating(args[1], args[2], args[3], args[5]);
                    checkIfEmpty(Movies);

                }
                break;

            case "-searchMovie_title":
                if (args[1].equalsIgnoreCase("MovieTitle")) {
                    {
                        List S1= MovieDAO.PartialStringSearch(args[2]);
                        //List<Movies> MovieTitle_search = MovieDAO.getMovieByTitle(S1);
                        checkIfEmpty(S1);
                    }
                }
                break;

            case "-count":
                Movies m = new Movies();
                int count = m.count();
                System.out.println("there are " + count + "rows");
                break;
            case "-delete":
                MovieDAO.deletemovie(args[1], args[2]);
                List<Movies> allMovies = MovieDAO.setAllMovieUsers();
                System.out.println("Now the elements left in the database are: ");
                allMovies.forEach(System.out::println);
                break;
            case "-insert":
                
                Movies movie = new Movies();
                int id = Integer.parseInt(args[1]);
                movie.setId(id);
                movie.setMovie_name(args[2]);
                movie.setLanguage(args[3]);
                movie.setGenere(args[4]);
                double rating = Double.parseDouble(args[5]);
                movie.setRating(rating);
                MovieDAO.insertMovies(movie);
                
                
                break;
            
                case "-insertuser":
                
                Users user = new Users();
                int id1 = Integer.parseInt(args[1]);
                int movieid = Integer.parseInt(args[3]);
                user.setUser_name(args[2]);
                user.setMovie_Id(movieid);

                        
                user.setId(id1);
                double rating1 = Double.parseDouble(args[4]);
                user.setRating(rating1);
                UserDAO.insertUsers(user);
                
                
                break;

            case "-searchmovie":
                List<Movies> movies = MovieDAO.Suggestion(args[1], args[2]);
                checkIfEmpty(movies);
                break;

            case "-sort":
                List<Movies> mve = MovieDAO.sortRating();
                checkIfEmpty(mve);
                break;

            case "-partialString":
                List<Movies> mov = MovieDAO.PartialStringSearch(args[1]);
                checkIfEmpty(mov);
                break;

            case "-deleteAllMovies":
                MovieDAO.truncatemov();
                break;

            case "-deleteAllUsers":
                UserDAO.truncateuser();
                break;

            case "-printusers":
                List<Movies> allMovieslist = MovieDAO.setAllMovieUsers();
                // MovieDAO.setAllMovieRatings();
                for (Movies mov1 : allMovieslist) {
                    System.out.println(mov1);
                    System.out.println("Individual ratings given by Users to this movie are: ");
                    List<Users> uList = mov1.getAlluser();
                   // uList.get(8);
                  // System.out.print("list size is "+(uList.size()));
                  // uList.forEach(System.out::println);
                  int n=uList.size()/46;
                  int count2 =0;
                  for (Users usq : uList) {
                    System.out.println(usq);
                    count2++;
                    if(count2==n)
                        break;
                    

                  }
                    System.out.println("\n");
                }
                break;
            case "-individual_ratings":
                List<Movies> allMovieslist1 = MovieDAO.setAllMovieUsers();
                if (args[1].equalsIgnoreCase("id")) {
                    int a = Integer.parseInt(args[2]);
                    for (Movies mov1 : allMovieslist1) {
                        if (a == mov1.getId()) {
                            System.out.println(mov1);
                    System.out.println("Individual ratings given by Users to this movie are: ");
                    List<Users> uList = mov1.getAlluser();
                  int n=uList.size()/46;
                  int count2 =0;
                  for (Users usq : uList) {
                    System.out.println(usq);
                    count2++;
                    if(count2==n)
                        break;
                    
                  }
                    System.out.println("\n");
                        }
                    }
                }
                if (args[1].equalsIgnoreCase("movietitle")) {
                   
                    for (Movies mov1 : allMovieslist1) {
                      
                        if (args[2].contains(mov1.getMovie_name())) {
                            System.out.println(mov1);
                            System.out.println("Individual ratings given by Users to this movie are: ");
                            List<Users> uList = mov1.getAlluser();
                          int n=uList.size()/46;
                          int count2 =0;
                          for (Users usq : uList) {
                            System.out.println(usq);
                            count2++;
                            if(count2==n)
                                break; 
                          }
                            System.out.println("\n");
                        }
                    }
                }
                break;
            case "-filter":
                List<Movies> mList1 = MovieDAO.filtermovies(args[1], args[2]);
                checkIfEmpty(mList1);
                break;
            default:
                printHelp();
                break;
        }
    }

    private static void printHelp() {
        System.out.println("Help Menu for commands:\n\n\n");
        System.out.println("Print all movies: \nSyntax: -print \n\n");
        System.out.println(
                "Insert a movie into the database: \nSyntax: -insert <Movie_Id> <Movie_Name> <Language> <Genere> <Rating>\nEg:-insert 50 dune english comedy 10.0\n\n");
        System.out.println(
                "Insert a user into the database: \nSyntax: -insertuser <User_Id> <User_Name> <Movie_id>  <Rating>\nEg:-insert 50 Name 40 10.0\n\n");
        System.out.println(
                "Individual_ratings gives all the individual ratings for a particular movieid: \nSyntax: -individual_ratings id <movie_id>\nEg:-individual_ratings id 1\n\n");
        System.out.println(
                "Individual_ratings gives all the individual ratings for a particular moviename: \nSyntax: -individual_ratings movietitle <movietitle>\nEg:-individual_ratings movietitle Mahanati\n\n");
        System.out.println("Search movies using id: \nSyntax: -search Id <Id>\nEg:-search Id 1\n\n");
        System.out.println(
                "Search movie by title: \nSyntax: -searchMovie_title MovieTitle <movie_title>\nEg:-searchMovie_title MovieTitle movie1\n\n");
        System.out.println(
                "Search using Partial movie name: \nSyntax: -partialString movietitle\nEg:-partialString movietitle\n\n");
        System.out.println(
                "Search for movies which have rating less than a particular value: \nSyntax: -search -lt Rating <rating>\nEg:-search -lt Rating 9.0\n\n");
        System.out.println(
                "Search for movies which have rating above a particular value: \nSyntax: -search -gt Rating <rating>\nEg:-search -gt Rating 7.0\n\n");
        System.out.println(
                "Search for movies which have rating less than a particular value: \nSyntax: -search -equal Rating <rating>\nEg:-search -equal Rating 9.0\n\n");
        System.out.println(
                "Search for movies in a particular language: \nSyntax: -searchmovie Language <language>\nEg: -searchmovie Language english\n\n");
        System.out.println(
                "Search for movies of a particular genre: \nSyntax: -searchmovie Genere <genre>\nEg:-searchmovie Genere comedy\n\n");
        System.out.println(
                "Search for a movie of a particular language/Genere and having rating above/below/equal a particular value: \nSyntax: -search -gt/-lt/-equal Language/Genere <language/genre> Rating <rating>\nEg:-search -gt/-lt/-equal Language/Genere english Rating 8.0\n\n");
        System.out.println(
                "Delete movies using id: \nSyntax: -delete Id <Id> (or) Syntax: -delete MovieTitle <movie_title>\nEg1: -delete Id 1\nEg2: -delete MovieTitle Dune\n\n");
        System.out.println("Count number of movies: \nSyntax: -count\n\n");
        System.out.println("Print movies algong with individual user ratings: \nSyntax:-printusers\n\n");
        System.out.println(
                "Filter returns the movies with rating between rating1 and rating2: \nSyntax: -filter <rating1> <rating2>\n\n");
        System.out.println("Sort movies in descending order of ratings:\nSyntax: -sort\n\n");
        System.out.println("Help menu: \nSyntax: -h(or any key will work)\n\n");
    }
}