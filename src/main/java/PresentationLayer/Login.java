package PresentationLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.FogException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;


import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws FogException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login(email, password );
        HttpSession session = request.getSession();
        System.out.println("Er i Login");
        session.setAttribute("id",user.getId());
        session.setAttribute( "email", email);
        session.setAttribute( "user", user );
        session.setAttribute( "type", user.getType() );

        if (user.getType().equals("customer")) {

            List<Order> userOrderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
            session.setAttribute("userOrderList",userOrderList);

        } else {
            List<Order> order0List =OrderMapper.readOrders0();
            session.setAttribute("order0List",order0List);
            List<Order> order1List =OrderMapper.readOrders1();
            session.setAttribute("order1List",order1List);
            session.setAttribute("userList", UserMapper.readUsers());

        }


        return user.getType() + "page";
    }
}