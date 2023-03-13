
package profile_files;

public class Users {
    private int id = -1;
    private String User_name;
    private int Movie_Id;
    private double rating;

    public Users(int id, String user_name, int movie_Id, double rating) {
        this.id = id;
        User_name = user_name;
        Movie_Id = movie_Id;
        this.rating = rating;
    }

    public Users(String userLine) {
        String[] values = userLine.split(",");
        this.User_name = values[0];
        this.Movie_Id = Integer.valueOf(values[1]);
        this.rating = Double.valueOf(values[2]);
    }

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public int getMovie_Id() {
        return Movie_Id;
    }

    public void setMovie_Id(int movie_Id) {
        Movie_Id = movie_Id;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Users [Movie_id=" + Movie_Id + ", User_name=" + User_name + ", rating=" + rating + "]";
    }
}