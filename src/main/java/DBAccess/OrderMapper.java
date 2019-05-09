package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import java.sql.Timestamp;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

public class OrderMapper {

    public static void createRequest(Order order, User user) throws LoginSampleException {
        try {
            Connection con = Connector.connection();

         /*   BEGIN;
            INSERT INTO users (username, password)
            VALUES('test', 'test');
            INSERT INTO profiles (userid, bio, homepage)
            VALUES(LAST_INSERT_ID(),'Hello world!', 'http://www.stackoverflow.com');
            COMMIT;
            */

            //String SQL = "INSERT INTO orders (order_date,order_length) VALUES (?,?)";

            String SQL_User = "SELECT email FROM User "
                    + "WHERE email=?";

            PreparedStatement psUser = con.prepareStatement( SQL_User,Statement.RETURN_GENERATED_KEYS );

            psUser.setInt(1,1);
            psUser.executeUpdate();



            ResultSet uID = psUser.getGeneratedKeys();
            uID.next();
            String idE = uID.getString( 3 );
            while (idE!=null)
                if(idE.equalsIgnoreCase(user.getEmail())){

                }

          //  if(user.getEmail()){}








            String SQL = "BEGIN;\n" +
                    "INSERT INTO orders (order_date,order_status,order_comment,order_roof_angle,order_roof_material," +
                    "order_length,order_width,order_shed,order_shed_length,order_shed_width)\n" +
                    "  VALUES(?,?,?,?,?,?,?,?,?);\n" +
                    "INSERT INTO user (userid, bio, homepage) \n" +
                    "  VALUES(LAST_INSERT_ID(),'Hello world!', 'http://www.stackoverflow.com');\n" +
                    "COMMIT;";


            //String SQL = "INSERT INTO order(order_id,order_date,order_status,order_comment,order_roof_angle,order_roof_material," +
            //        "order_lenght,order_width,order_shed,order_shed_lenght,order_shed_width,order_ship_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement( SQL,Statement.RETURN_GENERATED_KEYS );

            //Converting orderTime toLocalDateTime();
            Timestamp orderTime = new Timestamp(System.currentTimeMillis());
            // returns a Timestamp value corresponding to the given LocalDateTime
            //ISO 8601 format
            LocalDateTime orderTimeConverted = orderTime.toLocalDateTime();



            ps.setString(1, String.valueOf(orderTimeConverted));

            if(user.getType().equalsIgnoreCase("customer")){
                ps.setString(2,order.isOrderStatus());
            }

            if(order.getOrderComment()!=null){
                ps.setString(3,order.getOrderComment());
            }
            ps.setString(4,order.getOrderRoofAngle());
            ps.setString(5,order.getRoofMaterial());
            ps.setString(6,order.getOrderLength());
            ps.setString(7,order.getOrderWidth());
            ps.setString(8,order.isOrderShed());
            ps.setString(9,order.getOrderShedLength());
            ps.setString(10,order.getOrderShedWidth());







            ps.executeUpdate();

            ResultSet idOrder = ps.getGeneratedKeys();
            idOrder.next();
            int idO = idOrder.getInt( 1 );
            order.setOrderId( idO );

            ResultSet idUser = ps.getGeneratedKeys();
            idUser.next();
            int idU = idUser.getInt( 1 );
            order.setOrderId( idU );

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }

}
