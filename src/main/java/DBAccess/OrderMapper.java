package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Timestamp;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static void createRequest(Order order) throws LoginSampleException {
        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO orders (order_date,user_id,order_status,order_comment,order_roof_angle,order_roof_material," +
                    "order_length,order_width,order_shed,order_shed_length,order_shed_width) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            //Converting orderTime toLocalDateTime();
            Timestamp orderTime = new Timestamp(System.currentTimeMillis());
            // returns a Timestamp value corresponding to the given LocalDateTime
            //ISO 8601 format
            LocalDateTime orderTimeConverted = orderTime.toLocalDateTime();

            ps.setString(1,String.valueOf(orderTimeConverted));
            ps.setString(2,order.getUserId());
            ps.setString(3,order.getOrderStatus());
            ps.setString(4,order.getOrderComment());
            ps.setString(5,order.getOrderRoofAngle());
            ps.setString(6,order.getRoofMaterial());
            ps.setString(7,order.getOrderLength());
            ps.setString(8,order.getOrderWidth());
            ps.setString(9,order.getOrderShed());
            ps.setString(10,order.getOrderShedLength());
            ps.setString(11,order.getOrderShedWidth());

            ps.executeUpdate();

            ResultSet idOrder = ps.getGeneratedKeys();
            idOrder.next();
            int idO = idOrder.getInt(1);
            order.setOrderId(idO);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public  static List<String> readOrders() {

        List<String> orderList = new ArrayList<>();


        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM orders\n" +
                    "INNER JOIN user\n" +
                    "ON orders.user_id = user.user_id;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                int userId = resultSet.getInt("user_id");
                String orderDate = resultSet.getString("order_date");
                int orderStatus = resultSet.getInt("order_status");
                String orderComment = resultSet.getString("order_comment");
                int orderRoofAngle = resultSet.getInt("order_roof_angle");
                String orderRoofMaterial = resultSet.getString("order_roof_material");
                int orderLength = resultSet.getInt("order_length");
                int orderWidth = resultSet.getInt("order_width");
                int orderShed = resultSet.getInt("order_shed");
                int orderShedLength = resultSet.getInt("order_shed_length");
                int orderShedWidth = resultSet.getInt("order_shed_width");
                int orderShipDate = resultSet.getInt("order_ship_date");

                String userName = resultSet.getString("user_name");
                String userEmail = resultSet.getString("user_email");
                //userPassword
                String userAddress = resultSet.getString("user_address");
                String userZipcode = resultSet.getString("user_zipcode");
                String userCity = resultSet.getString("user_city");
                String userPhone = resultSet.getString("user_phone");
                String userType = "0";
                //userType so far its hidden

                Order tempOrder = new Order(String.valueOf(userId),String.valueOf(orderStatus),orderComment,
                        String.valueOf(orderRoofAngle),orderRoofMaterial,String.valueOf(orderLength),
                        String.valueOf(orderWidth),String.valueOf(orderShed),
                        String.valueOf(orderShedLength),String.valueOf(orderShedWidth));
                orderList.add(String.valueOf(orderId));
                orderList.add(String.valueOf(tempOrder));
                orderList.add(String.valueOf(orderDate));
                orderList.add(String.valueOf(orderShipDate));

                User tempUser = new User(userName,userEmail,"0",userAddress,
                        userZipcode, userCity,userPhone,userType);
                orderList.add(String.valueOf(tempUser));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}