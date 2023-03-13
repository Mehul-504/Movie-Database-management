package DAO_files;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionFactory;
import profile_files.*;

public class UserDAO extends AbstractMethordsUsers {

    @Override
    public void createObjects(Object entity, int a) {
        Users user = new Users();
        user = (Users) entity;
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into users values(NULL,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            MovieDAO movieDAO = new MovieDAO();
            List<Movies> allMovies = movieDAO.getAllObjects();

            int check = 0;
            for (Movies movies : allMovies) {
                if (movies.getId() == (user.getMovie_Id())) {
                    check++;
                } else {
                }

            }

            if (check != 0) {
                stmt.setString(1, user.getUser_name());
                stmt.setInt(2, user.getMovie_Id());
                stmt.setDouble(3, user.getRating());
                stmt.executeUpdate();

            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // inserting user using cmd line
  public static void insertUsers(Users user) {
    boolean b;
    Connection con = ConnectionFactory.getConnection();
    final String SQL = "insert into users values(?,?,?,?)";
    PreparedStatement stmt;
    try {
      stmt = con.prepareStatement(SQL);
     stmt.setInt(1, user.getId());
      stmt.setString(2, user.getUser_name());
      stmt.setInt(3, user.getMovie_Id());
      stmt.setDouble(4, user.getRating());
      //stmt.setDouble(5, user.getRating());
      stmt.execute();
      b=true;
      if(b==true)
                System.out.println("User inserted successfully!!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
    @Override
    List<Users> getAllObjects() {
        List<Users> users = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from users";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Users user = new Users(rs.getInt("id"), rs.getString("user_name"), rs.getInt("movie_id"),
                        rs.getDouble("rating"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void truncateuser() {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "truncate users";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
