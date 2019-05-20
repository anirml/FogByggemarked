package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LogicFacade;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;


import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login(email, password );
        HttpSession session = request.getSession();
        System.out.println("Er i login");
        session.setAttribute("id",user.getId());
        session.setAttribute( "email", email);
        session.setAttribute( "user", user );
        session.setAttribute( "type", user.getType() );

        if (user.getType().equals("customer")) {

            List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
            session.setAttribute("userOrderList",userOrderList);

        } else {
            List<Order> orderList =OrderMapper.readOrders();
            session.setAttribute("orderList",orderList);

        }


        return user.getType() + "page";
    }
}