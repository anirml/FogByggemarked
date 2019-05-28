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
                    "order_length,order_width,order_shed,order_shed_length,order_shed_width,order_ship_date,order_price)" +
                    " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            ps.setDouble(13, order.getOrderPrice());

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
                double orderPrice = resultSet.getDouble("order_price");


                Order tempOrder = new Order(orderId, orderDate, userId, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth, orderShipDate, orderPrice);
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
                double orderPrice = resultSet.getDouble("order_price");


                Order tempOrder = new Order(orderId, orderDate, userId, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth, orderShipDate, orderPrice);
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
                double orderPrice = resultSet.getDouble("order_price");

                Order tempUserOrder = new Order(orderId, orderDate, orderStatus, orderComment,
                        orderRoofAngle, orderRoofMaterial, orderLength,
                        orderWidth, orderShed, orderShedLength, orderShedWidth, orderShipDate, orderPrice);
                userOrderList.add(tempUserOrder);
                //System.out.println(orderStatus);
                //System.out.println(orderComment);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return userOrderList;
    }


    public static void markSendOrder(String date, int orderID, double orderPrice) throws FogException {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Connection con = Connector.connection();
            String SQL = "UPDATE fog_byggemarked.orders_oh" +
                    " SET order_ship_date = ?, order_status = 1, order_price = ? WHERE (`order_id` = ?);";
            ps = con.prepareStatement(SQL);
            //ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, date);
            ps.setDouble(2, orderPrice);
            ps.setInt(3, orderID);
            ps.executeUpdate();

        } catch (ClassNotFoundException ex) {
            throw new FogException(ex.toString(), "CNF fejl i markSendOrder");
        } catch (SQLException ex) {
            throw new FogException(ex.toString(), "SQL fejl i markSendOrder");
        }
    }

    public static void deleteOrder(int orderId) throws FogException {
        try {
            Connection con = Connector.connection();

            String SQL = "DELETE FROM fog_byggemarked.orders_oh WHERE order_id = ?;";

            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, orderId);

            ps.executeUpdate();


        } catch (SQLException | ClassNotFoundException ex) {
            throw new FogException(ex.getMessage(), "Fejl i createRequest");
        }
    }
}