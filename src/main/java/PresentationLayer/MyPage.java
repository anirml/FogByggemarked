package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.FogException;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MyPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String email = user.getEmail();
        request.setAttribute("email", email);
        String userRole = request.getParameter("type");
        if (userRole.equals("employee")) {
            List<String> orderList = DBAccess.OrderMapper.readOrders();
            session.setAttribute("orderList",orderList);
            return "employeepage";
        } else {
            List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
            session.setAttribute("orderList",userOrderList);
            return "customerpage";
        }
    }
}