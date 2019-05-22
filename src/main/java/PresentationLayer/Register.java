package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String address = request.getParameter("address");
        String zipcode = request.getParameter("zipcode");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        if(password1.equalsIgnoreCase("")){
            System.out.println("fuck yaa");
        }
        if (name.equalsIgnoreCase("") || email.equalsIgnoreCase("") || password1.equalsIgnoreCase("")
                || password2.equalsIgnoreCase("") || address.equalsIgnoreCase("") || zipcode.equalsIgnoreCase("")
                || city.equalsIgnoreCase("") || phone.equalsIgnoreCase("")) {
            throw new FogException("Alle fælter skal udfyldes.");
        }
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(name, email, password1, address, zipcode, city, phone);
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "type", user.getType() );
            List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
            session.setAttribute("userOrderList",userOrderList);
            return user.getType() + "page";
        } else {
            throw new FogException( "Alle fælter skal udfyldes." );
        }
    }
}