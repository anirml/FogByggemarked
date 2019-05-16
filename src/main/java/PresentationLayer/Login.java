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
        System.out.println("Er i login trin 1");
        session.setAttribute("userId",user.getId());
        session.setAttribute( "email", email);
        session.setAttribute( "user", user );
        session.setAttribute( "userType", user.getType() );

        System.out.println("Er i login trin 2");
        List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
        session.setAttribute("orderList",userOrderList);
        return user.getType() + "page";
    }
}