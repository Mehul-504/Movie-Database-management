package DAO_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import profile_files.Movies;
import profile_files.Users;

public class MovieDAO extends AbstractMethordsUsers {

  // read all movies along with users.
  public static List<Movies> getAllMoviesUsersMovies() {
    MovieDAO movieDAO = new MovieDAO();
    List<Movies> movies = movieDAO.getAllObjects();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from movies";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Movies movie = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));

        movies.add(movie);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  // update movies.
  // users is objects composition
  public static List<Movies> setAllMovieUsers() {

    List<Movies> movies = new ArrayList<>();
    List<Movies> movies1 = new ArrayList<>();

    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from movies";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies movie = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(movie);
      }
      UserDAO userDAO = new UserDAO();
      List<Users> allUsers = userDAO.getAllObjects();
      List<Users> doneusers = new ArrayList<>();

      for (Movies movie : movies) {

        Movies mov = new Movies();
        mov = movie;
        for (Users users : allUsers) {
          Users user = new Users();
          user = users;
          if (mov.getId() == (user.getMovie_Id())) {
            doneusers.add(user);
          }
        }

        mov.setAlluser(doneusers);

        movies1.add(mov);

        doneusers = new ArrayList<>();

      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;

  }

  //ref 1: setting movie ratings
  // update ratings
  public static void setAllMovieRatings() {
    Connection con = ConnectionFactory.getConnection();//getting con
    final String SQL = "update movies set Rating=? where Id=?";//query
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {//prep stmt
      List<Movies> allMovies = MovieDAO.setAllMovieUsers();//returns all movies
      double rat = 0;
      int noofratings = 0;
      for (Movies movies : allMovies) {
        rat = 0;
        noofratings = 0;
        UserDAO userDAO = new UserDAO();
        List<Users> Users = userDAO.getAllObjects();

     List<Users> user= movies.getAlluser();
     for (Users use : user) {
      rat=rat+ use.getRating();
      noofratings++;
     }
        if (noofratings != 0) {
          rat = rat / noofratings;
          movies.setRating(rat);
          movies.getId();
          stmt.setDouble(1, movies.getRating());
          stmt.setInt(2, movies.getId());
          stmt.executeUpdate();
        }

      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // checking movies when language and genere is given.
  public static List<Movies> Suggestion(String string1, String string2) {
    List<Movies> movies = new ArrayList<Movies>();
    Connection con = ConnectionFactory.getConnection();
    String SQL = "";
    if (string1.equalsIgnoreCase("Language")) {
      SQL = "select * from movies where Language=?";
    }

    if (string1.equalsIgnoreCase("Genere")) {
      SQL = "select * from movies where Genere=?";
    }

    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setString(1, string2);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies mov = new Movies(rs.getInt("Id"), rs.getString("Movie_Name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(mov);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return movies;

  }

  // checking movies where rating>? or rating<?
  public static List<Movies> Checkforrating(String string1, String string2) {
    List<Movies> movies = new ArrayList<Movies>();
    Connection con = ConnectionFactory.getConnection();
    String SQL = "";
    if (string1.equalsIgnoreCase("-gt")) {
      SQL = "select * from movies where Rating > ?";
    }
    if (string1.equalsIgnoreCase("-lt")) {
      SQL = "select * from movies where Rating < ?";
    }
    if (string1.equalsIgnoreCase("-equal")) {
      SQL = "select * from movies where Rating = ?";
    }
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setDouble(1, Double.parseDouble(string2));

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies mov = new Movies(rs.getInt("Id"), rs.getString("Movie_Name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(mov);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  // checking for a particular langugage/Genere movies having rating>? or rating<?
  // or rating=?
  public static List<Movies> Checkforrating(String string1, String string2, String string3, String string4) {
    List<Movies> movies = new ArrayList<Movies>();
    Connection con = ConnectionFactory.getConnection();
    String SQL = "";
    if (string2.equalsIgnoreCase("Language")) {
      if (string1.equalsIgnoreCase("-gt")) {
        SQL = "select * from movies where Rating > ? and Language=?";
      }
      if (string1.equalsIgnoreCase("-lt")) {
        SQL = "select * from movies where Rating < ? and Language=?";
      }
      if (string1.equalsIgnoreCase("-equal")) {
        SQL = "select * from movies where Rating = ? and Language=?";
      }
    }
    if (string2.equalsIgnoreCase("Genere")) {
      if (string1.equalsIgnoreCase("-gt")) {
        SQL = "select * from movies where Rating > ? and Genere=?";
      }
      if (string1.equalsIgnoreCase("-lt")) {
        SQL = "select * from movies where Rating < ? and Genere=?";
      }
      if (string1.equalsIgnoreCase("-equal")) {
        SQL = "select * from movies where Rating = ? and Genere=?";
      }
    }
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setDouble(1, Double.parseDouble(string4));
      stmt.setString(2, string3);

      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies mov = new Movies(rs.getInt("Id"), rs.getString("Movie_Name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(mov);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  // Delete
  public static void deletemovie(String string1,String string2) {
    try {
      Connection con = ConnectionFactory.getConnection();
      if(string1.equalsIgnoreCase("Id")){
      String sql = "DELETE FROM movies WHERE Id = ? ";
      PreparedStatement stmt = con.prepareStatement(sql);
      stmt.setInt(1, Integer.parseInt(string2));
      stmt.executeUpdate();
      }
      else if(string1.equalsIgnoreCase("Movietitle")){
          String sql = "DELETE FROM movies WHERE Movie_Name = ? ";
          System.out.println(string2);
          PreparedStatement stmt = con.prepareStatement(sql);
          stmt.setString(1, string2);
          stmt.executeUpdate();
      }
    
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<Movies> getMovieByTitle(String MovieTitle) {
    List<Movies> movies = new ArrayList<>();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from movies where Movie_Name = ? ";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setString(1, MovieTitle);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies mve = new Movies(rs.getInt("Id"), rs.getString("Movie_Name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(mve);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  // inserting movie using cmd line
  public static void insertMovies(Movies movie) {
    boolean b;
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "insert into movies values(?,?,?,?,?)";
    PreparedStatement stmt;
    try {
      stmt = con.prepareStatement(SQL);
     stmt.setInt(1, movie.getId());
      stmt.setString(2, movie.getMovie_name());
      stmt.setString(3, movie.getLanguage());
      stmt.setString(4, movie.getGenere());
      stmt.setDouble(5, movie.getRating());
      stmt.execute();
      b=true;
      if(b==true)
                System.out.println("Movie inserted successfully!!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }

  // Read - ALL
  @Override
  public List<Movies> getAllObjects() {
    List<Movies> movies = new ArrayList<>();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "select * from movies";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Movies movie = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));

        movies.add(movie);
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return movies;
  }

  public static List<Movies> sortRating() {
    List<Movies> movies = new ArrayList<>();
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "SELECT * FROM movies ORDER BY Rating DESC";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies mve = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(mve);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  // search using partial strings
  public static List<Movies> PartialStringSearch(String s2) {

    List<Movies> movies = new ArrayList<>();
    String s3 = "%" + s2.toLowerCase() + "%";
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "SELECT * from movies where Movie_Name LIKE ?";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setString(1, s3);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies mve = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));
        movies.add(mve);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;
  }

  public static List<Movies> Checkforrating(String string) {
    List<Movies> movies = new ArrayList<Movies>();
    Connection con = ConnectionFactory.getConnection();
    int str = Integer.parseInt(string);
    String SQL = "select * from movies where Id = ?";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setInt(1, str);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Movies movie = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));

        movies.add(movie);
      }
    } catch (SQLException e) {

      e.printStackTrace();
    }
    return movies;
  }

  @Override
  public void createObjects(Object entity, int alreadyinsertedvalue) {
    Movies movie = new Movies();
    movie = (Movies) entity;
    Connection con = ConnectionFactory.getConnection();

    if (movie.getId() == alreadyinsertedvalue) {
      final String SQL = "update movies set Rating=?,Movie_Name=?,Language=?,Genere=? where Id=?";
      try (PreparedStatement stmt = con.prepareStatement(SQL)) {
        stmt.setDouble(1, movie.getRating());
        stmt.setString(2, movie.getMovie_name());
        stmt.setString(3, movie.getLanguage());
        stmt.setString(4, movie.getGenere());
        stmt.setInt(5, movie.getId());
        stmt.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }

    else {
      final String SQL1 = "insert into movies values(?,?,?,?,NULL)";
      try (PreparedStatement stmt = con.prepareStatement(SQL1)) {

        stmt.setInt(1, movie.getId());
        stmt.setString(2, movie.getMovie_name());
        stmt.setString(3, movie.getLanguage());
        stmt.setString(4, movie.getGenere());
       // stmt.setDouble(5, movie.getRating());
        stmt.executeUpdate();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void truncatemov() {
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "truncate movies";
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.executeUpdate();
    } catch (Exception e) {
      e.getMessage();
    }
  }

  public static List<Movies> filtermovies(String string1, String string2) {
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "Select * from movies where Rating Between ? and ?";
    List<Movies> movies = new ArrayList<>();
    try (PreparedStatement stmt = con.prepareStatement(SQL)) {
      stmt.setDouble(1, Double.parseDouble(string1));
      stmt.setDouble(2, Double.parseDouble(string2));
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Movies movie = new Movies(rs.getInt("id"), rs.getString("Movie_name"), rs.getString("Language"),
            rs.getString("Genere"), rs.getDouble("Rating"));

        movies.add(movie);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return movies;

  }

}
