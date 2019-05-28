package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SendRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        HttpSession session = request.getSession();
        System.out.println("Er i SendRequest");
/*

        System.out.println(session.getAttribute("lenght"));
        System.out.println(session.getAttribute("width"));
        System.out.println(session.getAttribute("roof"));
        System.out.println(session.getAttribute("angle"));

        System.out.println(session.getAttribute("toolShedLength"));
        System.out.println(session.getAttribute("toolShedWidth"));

        System.out.println(session.getAttribute("comment"));
        System.out.println(session.getAttribute("userId"));

*/
        LocalDateTime tidspunkt = LocalDateTime.now();
        String timeNow = tidspunkt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        int userId= Integer.valueOf((String) session.getAttribute("id"));
        String orderComment = (String) session.getAttribute("comment");
        int orderRoofAngle = Integer.valueOf((String) session.getAttribute("angle"));
        int orderRoofMaterial = Integer.valueOf((String) session.getAttribute("roof"));
        int orderLength = Integer.valueOf((String) session.getAttribute("lenght"));
        int orderWidth = Integer.valueOf((String) session.getAttribute("width"));
        int orderShed = 0;
        int orderShedLength = Integer.valueOf((String) session.getAttribute("toolShedLength"));
        int orderShedWidth = Integer.valueOf((String) session.getAttribute("toolShedWidth"));
        String orderShipDate = "";

        if ((orderShedLength!=0)&&(orderShedWidth!=0)) orderShed = 1;


        Order order = new Order(timeNow, userId, 0, orderComment, orderRoofAngle, orderRoofMaterial,
                                      orderLength, orderWidth, orderShed, orderShedLength, orderShedWidth, "");


        OrderMapper.createRequest(order);

        User user = (User) session.getAttribute("user");
        //List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
        //session.setAttribute("orderList",userOrderList);
        String userType = user.getType();

        if (userType.equalsIgnoreCase("employee")){
            return "employeepage";
        } else {

            return "customerpage";
        }
    }
}
