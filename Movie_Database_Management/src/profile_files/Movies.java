package profile_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.*;
import DAO_files.MovieDAO;

public class Movies {
    private int id = -1;
    private String Movie_name;
    private String Language;
    private String Genere;
    private double rating = 0;

    List<Users> alluser = new ArrayList<>();

    public Movies(int id, String Movie_name, String Language) {
        this.id = id;
        this.Movie_name = Movie_name;
        this.Language = Language;
    }

    public Movies(int id, String Movie_name, String Language, String Genere) {
        this.id = id;
        this.Movie_name = Movie_name;
        this.Language = Language;
        this.Genere = Genere;
    }

    public Movies(int id, String Movie_name, String Language, double rating) {
        this.id = id;
        this.Movie_name = Movie_name;
        this.Language = Language;
        this.rating = rating;
    }

    public Movies(int id, String Movie_name, String Language, String Genere, double rating) {
        this.id = id;
        this.Movie_name = Movie_name;
        this.Language = Language;
        this.Genere = Genere;
        this.rating = rating;
    }

    public Movies() {

    }

    public Movies(int id, String Movie_name, String Language, List<Users> alluser) {
        this.id = id;
        this.Movie_name = Movie_name;
        this.Language = Language;
        this.alluser = alluser;
    }

    public Movies(String name, String Language) {
        this.Movie_name = name;
        this.Language = Language;
    }

    public Movies(String studLine) {
        String values[] = studLine.split(",");
        this.id = Integer.parseInt(values[0]);
        this.Movie_name = values[1];
        this.Language = values[2];
        this.Genere = values[3];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_name() {
        return Movie_name;
    }
    


    public void setMovie_name(String movie_name) {
        Movie_name = movie_name;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<Users> getAlluser() {
        return alluser;
    }

    public void setAlluser(List<Users> alluser) {
        this.alluser = alluser;
    }

    public void setAlluser(int index, Users user) {
        alluser.add(index, user);
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String genere) {
        Genere = genere;
    }

    // @Override
    // public String toString() {
    // return "Movies [Genere=" + Genere + ", Language=" + Language + ",
    // Movie_name=" + Movie_name + ", alluser="
    // + alluser + ", id=" + id + ", rating=" + rating + "]";

    // }

    // @Override
    void printObjects(String moviename) {
        MovieDAO movieDAO = new MovieDAO();
        List<Movies> movies = movieDAO.getAllObjects();
        for (Movies movie : movies) {
            if (movie.Movie_name.equalsIgnoreCase(moviename)) {
                System.out.println("language is:" + movie.getLanguage());
                System.out.println("Moviename is:" + movie.getMovie_name());
                System.out.print("users are: ");
                movie.getAlluser().forEach(System.out::println);
                System.out.println("ID is: " + movie.getId());
                System.out.println("rating is " + movie.getRating());

            }
        }
    }

    @Override
    public String toString() {
        return "Movie id=" + id + ", Movie_name=" + Movie_name + ", rating=" + Math.round(rating * 100.0) / 100.0
                + " Genere=" + Genere
                + ", Language= " + Language + "\n";
    }

    // @Override
    public int count() {
        ResultSet rs;
        int count = 0;
        String SQL = "SELECT COUNT(*) AS rowcount FROM movies";
        Connection con = ConnectionFactory.getConnection();
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {

            rs = stmt.executeQuery();
            rs.next();
            count = rs.getInt("rowcount");

            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((Genere == null) ? 0 : Genere.hashCode());
        // result = ((Language == null) ? 0 : Language.hashCode());
        // result = ((Movie_name == null) ? 0 : Movie_name.hashCode());
        // result = ((alluser == null) ? 0 : alluser.hashCode());
        // result = id;
        long temp;
        temp = Double.doubleToLongBits(rating);
        result = (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movies other = (Movies) obj;
        if (Genere == null) {
            if (other.Genere != null)
                return false;
        } else if (!Genere.equals(other.Genere))
            return false;
        if (Language == null) {
            if (other.Language != null)
                return false;
        } else if (!Language.equals(other.Language))
            return false;
        if (Movie_name == null) {
            if (other.Movie_name != null)
                return false;
        } else if (!Movie_name.equals(other.Movie_name))
            return false;
        if (alluser == null) {
            if (other.alluser != null)
                return false;
        } else if (!alluser.equals(other.alluser))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(rating) != Double.doubleToLongBits(other.rating))
            return false;
        return true;
    }

}
