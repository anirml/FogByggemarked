package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
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
