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

        try {

            HttpSession session = request.getSession();
            System.out.println("Er i SendRequest");

            LocalDateTime tidspunkt = LocalDateTime.now();
            String timeNow = tidspunkt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            int userId = Integer.valueOf((String) session.getAttribute("id"));
            String orderComment = (String) session.getAttribute("comment");
            int orderRoofAngle = Integer.valueOf((String) session.getAttribute("angle"));
            int orderRoofMaterial = Integer.valueOf((String) session.getAttribute("roof"));
            int orderLength = Integer.valueOf((String) session.getAttribute("lenght"));
            int orderWidth = Integer.valueOf((String) session.getAttribute("width"));
            int orderShed = 0;
            int orderShedLength = Integer.valueOf((String) session.getAttribute("toolShedLength"));
            int orderShedWidth = Integer.valueOf((String) session.getAttribute("toolShedWidth"));
            String orderShipDate = "";

            if ((orderShedLength != 0) && (orderShedWidth != 0)) orderShed = 1;


            Order order = new Order(timeNow, userId, 0, orderComment, orderRoofAngle, orderRoofMaterial,
                    orderLength, orderWidth, orderShed, orderShedLength, orderShedWidth, "");

            OrderMapper.createRequest(order);

            String sendKvit = timeNow + " Der er sendt en forespørgsel på carport med l=" + session.getAttribute("lenght") +
                    " og b=" + session.getAttribute("width") + ", skur-len=" + session.getAttribute("toolShedLength") +
                    " og skur-wid=" + session.getAttribute("toolShedWidth");
            session.setAttribute("sendKvit", sendKvit);

            User user = (User) session.getAttribute("user");
            String userType = user.getType();

            List<Order> order0List = DBAccess.OrderMapper.readOrders0();
            session.setAttribute("order0List", order0List);
            List<Order> order1List = DBAccess.OrderMapper.readOrders1();
            session.setAttribute("order1List", order1List);


            if (userType.equalsIgnoreCase("employee")) {
                return "employeepage";
            } else {
                return "customerpage";
            }
        } catch (Exception e) {
            throw new FogException("Fejl i SendRequest");
        }
    }
}