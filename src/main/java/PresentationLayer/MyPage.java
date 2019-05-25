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
        System.out.println("Er i MyPage");
        User user = (User)session.getAttribute("user");
        String email = user.getEmail();
        request.setAttribute("email", email);
        String userType = (String) session.getAttribute("type");
        if (userType.equals("employee")) {
            List<Order> order0List = DBAccess.OrderMapper.readOrders0();
            session.setAttribute("order0List",order0List);
            return "employeepage";
        } else {

            List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
            session.setAttribute("userOrderList",userOrderList);
            return "customerpage";
        }
    }
}