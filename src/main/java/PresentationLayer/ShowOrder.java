package PresentationLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.CalculateFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i ShowOrder");

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        String userType= (String) session.getAttribute( "type");

        List<Order> orderList = null;


        /*if (userType.equals("customer")) {

            orderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
            //session.setAttribute("orderList",orderList);

        } else {
            orderList =OrderMapper.readOrders0();
            //session.setAttribute("orderList",orderList);

        }
*/
        //(request.getParameter("command"))

        switch (request.getParameter("action")){
            case "customer":

                orderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));

                break;
            case "empOrder0":
                orderList =OrderMapper.readOrders0();

                break;
            case "empOrder1":
                orderList =OrderMapper.readOrders1();

                break;
            default :
                System.out.println("Er i ShowOrder i bund i switch");
        }


        int listNo = Integer.valueOf(request.getParameter("listNo"));
        Order tempOrder = null;

        for (int i = 0; i <orderList.size() ; i++) {
            if (listNo==i) {
                tempOrder=orderList.get(i);
            }
        }
        //System.out.println(tempOrder.toString());
        int cl = 10*tempOrder.getOrderLength();
        int cW = 10*tempOrder.getOrderWidth();
        int shedLen = 10*tempOrder.getOrderShedLength();
        int shedWid = 10*tempOrder.getOrderShedWidth();

        String makeOrder = "0";

        session.setAttribute("lenght",Integer.toString(cl/10));
        session.setAttribute("width",Integer.toString(cW/10));

        CalculateFacade.drawing(request, cl, cW, shedLen, shedWid);

        if (userType.equals("employee")) {
            CalculateFacade.stykList(request, cl, cW, shedLen, shedWid, userType);
        } else {
            if (tempOrder.getOrderStatus()==1) {
                CalculateFacade.stykList(request, cl, cW, shedLen, shedWid, userType);
            } else {
                //makeOrder = "1";
            }
        }

        session.setAttribute("makeOrder",makeOrder);

        return "draw" + "page";
    }
}
