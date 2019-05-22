package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO user (user_name, user_email, user_password, user_address, " +
                            "user_zipcode, user_city, user_phone, user_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getName() );
            ps.setString( 2, user.getEmail() );
            ps.setString( 3, user.getPassword() );
            ps.setString( 4, user.getAddress() );
            ps.setString( 5, user.getZipcode() );
            ps.setString( 6, user.getCity() );
            ps.setString( 7, user.getPhone() );
            ps.setString( 8, user.getType() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }


    public static List<User> readUsers() {

        List<User> userList = new ArrayList<>();

        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM fog_byggemarked.user ";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("user_name");
                String email = resultSet.getString("user_email");
                String password = resultSet.getString("user_password");
                String address = resultSet.getString("user_address");
                String zipcode = resultSet.getString("user_zipcode");
                String city = resultSet.getString("user_city");
                String phone = resultSet.getString("user_phone");
                String type = resultSet.getString("user_type");


                User tempUser = new User(id,name,email,password,address,zipcode,city,phone,type);

                userList.add(tempUser);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }



    public static User login( String email, String password ) throws LoginSampleException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT user_id, user_type FROM user "
                    + "WHERE user_email=? AND user_password=?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String type = rs.getString( "user_type" );
                int id = rs.getInt( "user_id" );
                User user = new User( email, password, type );
                user.setId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
