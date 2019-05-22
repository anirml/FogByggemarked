package DBAccess;

import FunctionLayer.FogException;
import FunctionLayer.Order;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static void createRequest(Order order) throws FogException {
        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO orders_oh (order_date,user_id,order_status,order_comment,order_roof_angle,order_roof_material," +
                    "order_length,order_width,order_shed,order_shed_length,order_shed_width,order_ship_date)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, order.getOrderDate());
            ps.setInt(2, order.getUserId());
            ps.setInt(3, order.getOrderStatus());
            ps.setString(4, order.getOrderComment());
            ps.setInt(5, order.getOrderRoofAngle());
            ps.setInt(6, order.getOrderRoofMaterial());
            ps.setInt(7, order.getOrderLength());
            ps.setInt(8, order.getOrderWidth());
            ps.setInt(9, order.getOrderShed());
            ps.setInt(10, order.getOrderShedLength());
            ps.setInt(11, order.getOrderShedWidth());
            ps.setString(12, order.getOrderShipDate());

            ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), "Fejl i createRequest");
        }
    }

    public static List<Order> readOrders0() throws FogException {

        List<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM fog_byggemarked.orders_oh WHERE (order_status = 0)";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {

                int orderId = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                int userId = resultSet.getInt("user_id");
                int orderStatus = resultSet.getInt("order_status");
                String orderComment = resultSet.getString("order_comment");
                int orderRoofAngle = resultSet.getInt("order_roof_angle");
                int orderRoofMaterial = resultSet.getInt("order_roof_material");
                int orderLength = resultSet.getInt("order_length");
                int orderWidth = resultSet.getInt("order_width");
                int orderShed = resultSet.getInt("order_shed");
                int orderShedLength = resultSet.getInt("order_shed_length");
                int orderShedWidth = resultSet.getInt("order_shed_width");
                String orderShipDate = resultSet.getString("order_ship_date");


                Order tempOrder = new Order(orderId, orderDate, userId, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth, orderShipDate);
                orderList.add(tempOrder);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new FogException(ex.getMessage(), "Fejl i readOrders");
        }
        return orderList;
    }

    public static List<Order> readOrders1() {

        List<Order> orderList = new ArrayList<>();

        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM fog_byggemarked.orders_oh WHERE (order_status = 1)";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {

                int orderId = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                int userId = resultSet.getInt("user_id");
                int orderStatus = resultSet.getInt("order_status");
                String orderComment = resultSet.getString("order_comment");
                int orderRoofAngle = resultSet.getInt("order_roof_angle");
                int orderRoofMaterial = resultSet.getInt("order_roof_material");
                int orderLength = resultSet.getInt("order_length");
                int orderWidth = resultSet.getInt("order_width");
                int orderShed = resultSet.getInt("order_shed");
                int orderShedLength = resultSet.getInt("order_shed_length");
                int orderShedWidth = resultSet.getInt("order_shed_width");
                String orderShipDate = resultSet.getString("order_ship_date");


                Order tempOrder = new Order(orderId, orderDate, userId, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth, orderShipDate);
                orderList.add(tempOrder);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }


    public static List<Order> readUserOrders(int userId) {
        List<Order> userOrderList = new ArrayList<>();
        try {
            Connection con = Connector.connection();

            String sql = "SELECT * FROM fog_byggemarked.orders_oh WHERE (user_id = ?) AND (order_status = 1)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                int orderId = resultSet.getInt("order_id");
                String orderDate = resultSet.getString("order_date");
                int orderStatus = resultSet.getInt("order_status");
                String orderComment = resultSet.getString("order_comment");
                int orderRoofAngle = resultSet.getInt("order_roof_angle");
                int orderRoofMaterial = resultSet.getInt("order_roof_material");
                int orderLength = resultSet.getInt("order_length");
                int orderWidth = resultSet.getInt("order_width");
                int orderShed = resultSet.getInt("order_shed");
                int orderShedLength = resultSet.getInt("order_shed_length");
                int orderShedWidth = resultSet.getInt("order_shed_width");
                String orderShipDate = resultSet.getString("order_ship_date");

                Order tempUserOrder = new Order(orderId, orderDate, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth, orderShipDate);
                userOrderList.add(tempUserOrder);
                //System.out.println(orderStatus);
                //System.out.println(orderComment);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userOrderList;
    }


    public static void markSendOrder(String date, int orderID) throws FogException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE fog_byggemarked.orders_oh" +
                         " SET order_ship_date = ?, order_status = 1 WHERE (`order_id` = ?);";
            ps = con.prepareStatement(SQL);
            //ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, date);
            ps.setInt(2, orderID);
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            throw new FogException(ex.toString(), "CNF fejl i markSendOrder");
        } catch (SQLException ex) {
            throw new FogException(ex.toString(), "SQL fejl i markSendOrder");
        }


    }


}

//************************** disp kode*************************************************************
/*

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
            ps.setString(6,order.getOrderRoofMaterial());
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

<<<<<<< HEAD
    public  static List<Order> readUserOrders(String userId) {
        List<Order> userOrderList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.orders WHERE (user_id = ?);";
            PreparedStatement ps = con.prepareStatement( sql );
            ps.setString( 1, userId );
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {

                String orderStatus = resultSet.getString("order_status");
                String orderComment = resultSet.getString("order_comment");
                String orderRoofAngle = resultSet.getString("order_roof_angle");
                String orderRoofMaterial = resultSet.getString("order_roof_material");
                String orderLength = resultSet.getString("order_length");
                String orderWidth = resultSet.getString("order_width");
                String orderShed = resultSet.getString("order_shed");
                String orderShedLength = resultSet.getString("order_shed_length");
                String orderShedWidth = resultSet.getString("order_shed_width");

                Order tempUserOrder = new Order(userId, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth);
                userOrderList.add(tempUserOrder);
                //System.out.println(orderStatus);
                //System.out.println(orderComment);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userOrderList;
    }

    public  static List<String> readOrders() {
=======
    public  static List<Order> readOrders() {
>>>>>>> cfab578d5b3e15a47f439d37aebfa5c62e8abc5e

        List<Order> orderList = new ArrayList<>();


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
                String userAddress = resultSet.getString("user_address");
                String userZipcode = resultSet.getString("user_zipcode");
                String userCity = resultSet.getString("user_city");
                String userPhone = resultSet.getString("user_phone");
                String userType = "0";
                //userType so far its hidden


<<<<<<< HEAD
                orderList.add(String.valueOf(orderId));
                        //orderList.add(String.valueOf(tempOrder));
                        orderList.add(String.valueOf(orderDate));
                        orderList.add(String.valueOf(orderShipDate));

                        User tempUser = new User(userName,userEmail,"0",userAddress,
                        userZipcode, userCity,userPhone,userType);
                        orderList.add(String.valueOf(tempUser));
                        }
=======
                Order tempOrder = new Order(orderId,String.valueOf(userId),orderDate,String.valueOf(orderStatus),orderComment,String.valueOf(orderRoofAngle),orderRoofMaterial,String.valueOf(orderLength),String.valueOf(orderWidth),String.valueOf(orderShed),String.valueOf(orderShedLength),String.valueOf(orderShedWidth),String.valueOf(orderShipDate),userName,userEmail,userAddress,userZipcode,userCity,userPhone,userType);
               // Order tempOrder = new Order(String.valueOf(userId),String.valueOf(orderStatus),orderComment,
               //         String.valueOf(orderRoofAngle),orderRoofMaterial,String.valueOf(orderLength),
               //         String.valueOf(orderWidth),String.valueOf(orderShed),
               //         String.valueOf(orderShedLength),String.valueOf(orderShedWidth));
               // orderList.add(String.valueOf(orderId));
               // orderList.add(String.valueOf(tempOrder));
               // orderList.add(String.valueOf(orderDate));
               // orderList.add(String.valueOf(orderShipDate));

               // User tempUser = new User(userName,userEmail,"0",userAddress,
               //         userZipcode, userCity,userPhone,userType);
                orderList.add(tempOrder);
            }
>>>>>>> cfab578d5b3e15a47f439d37aebfa5c62e8abc5e

                        } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                        }
                        return orderList;
                        }


*/
