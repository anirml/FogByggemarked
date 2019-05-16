package PresentationLayer;

import FunctionLayer.CalculateFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i ShowOrder");

        HttpSession session = request.getSession();

        List<Order> userOrderList = (List<Order>) session.getAttribute("orderList");

        int orderId = Integer.valueOf(request.getParameter("orderId"));
        Order tempOrder = null;

        for (int i = 0; i <userOrderList.size() ; i++) {
            if (orderId==i) {
                tempOrder=userOrderList.get(i);
            }
        }
        System.out.println(tempOrder.toString());
        int cl = 10*tempOrder.getOrderLength();
        int cW = 10*tempOrder.getOrderWidth();
        int shedLen = 10*tempOrder.getOrderShedLength();
        int shedWid = 10*tempOrder.getOrderShedWidth();

        String userType = (String) session.getAttribute("userType");

        String makeOrder = "0";
        session.setAttribute("makeOrder",makeOrder);

        session.setAttribute("lenght",Integer.toString(cl/10));
        session.setAttribute("width",Integer.toString(cW/10));

        CalculateFacade.drawing(request, cl, cW, shedLen, shedWid);
        CalculateFacade.stykList(request, cl, cW, shedLen, shedWid,userType);


        return "draw" + "page";
    }
}
