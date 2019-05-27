package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Roof;
import FunctionLayer.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class ItemMapperTest {

    private static Connection testConnection;
    private static String USER = "testinguser";
    private static String USERPW = "try1try2tryAgain";
    private static String DBNAME = "fog_byggemarked_test?serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false";
    private static String HOST = "157.230.110.206";

    @Before
    public void setUp() {
        try {
            // awoid making a new connection for each test
            if ( testConnection == null ) {
                String url = String.format( "jdbc:mysql://%s:3306/%s", HOST, DBNAME );
                Class.forName( "com.mysql.cj.jdbc.Driver" );

                testConnection = DriverManager.getConnection( url, USER, USERPW );
                // Make mappers use test
                Connector.setConnection( testConnection );
            }
            // reset test database
            try ( Statement stmt = testConnection.createStatement() ) {
                stmt.execute( "drop table if exists roof_material" );
                stmt.execute( "create table roof_material like roof_material_test" );
                stmt.execute( "insert into roof_material select * from roof_material_test" );
            }

        } catch ( ClassNotFoundException | SQLException ex ) {
            testConnection = null;
            System.out.println( "Could not open connection to database: " + ex.getMessage() );
        }
    }

    @Test
    public void testSetUpOK() {
        // Just check that we have a connection.
        assertNotNull( testConnection );
    }

    @Test
    public void testLogin01(){
        // Can we get certain materials?
        List<Roof> roofList = ItemMapper.readRoofList();
        assertTrue( roofList != null );
    }

    @Test( expected = LoginSampleException.class )
    public void testLogin02() throws LoginSampleException {
        // We should get an exception if we use the wrong password
        User user = UserMapper.login( "jens@somewhere.com", "larsen" );
    }

    @Test
    public void ConstructorTest()
    {
        // ConstructorTest på Roof
        Roof roof = new Roof();
        // Assert
        Assert.assertNotNull(roof);
    }

    @Test
    public void testLogin03() throws LoginSampleException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@somewhere.com", "jensen" );
        assertEquals( "customer", user.getType() );
    }

    @Test
    public void testCreateUser01() throws LoginSampleException {
        // Can we create a new user - Notice, if login fails, this will fail
        // but so would login01, so this is OK
        User original = new User( "king@kong.com", "uhahvorhemmeligt", "konge" );
        UserMapper.createUser( original );
        User retrieved = UserMapper.login( "king@kong.com", "uhahvorhemmeligt" );
        assertEquals( "konge", retrieved.getType() );
    }
}