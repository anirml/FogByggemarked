package DBAccess;

import FunctionLayer.FogException;
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

public class Tests {

    private static Connection testConnection;
    private static String USER = "testuser";
    private static String USERPW = "password123";
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
                stmt.execute( "drop table if exists user" );
                stmt.execute( "create table user like user_test" );
                stmt.execute( "insert into user select * from user_test" );
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
    public void testRooflist() throws FogException {
        // Can we get certain materials?
        List<Roof> roofList = ItemMapper.readRoofList();
        assertNotNull(roofList);
    }

    @Test
    public void testConstructor()
    {
        // ConstructorTest på Roof
        Roof roof = new Roof();
        // Assert
        Assert.assertNotNull(roof);
    }

    @Test
    public void testLoginType() throws FogException {
        // Jens is supposed to be a customer
        User user = UserMapper.login( "jens@dr.dk", "1234" );
        assertEquals( "customer", user.getType() );
    }
}