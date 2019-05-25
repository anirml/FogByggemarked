package PresentationLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.CalculateFacade;
import FunctionLayer.FogException;
import FunctionLayer.Order;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        System.out.println("Er i ShowOrder");

        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        String userType= (String) session.getAttribute( "type");

        List<Order> orderList = null;
        String action = request.getParameter("action");

        String showStykList = "0";
        String procentS = "0";
        session.setAttribute("procent",procentS);
        double totalPriceKorr = 0;


        if (!action.equals("beregn")) {

            switch (action) {
                case "customer":

                    orderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));

                    break;
                case "empOrder0":
                    orderList = OrderMapper.readOrders0();

                    break;
                case "empOrder1":
                    orderList = OrderMapper.readOrders1();

                    break;
                default:
                    System.out.println("Er i ShowOrder i bund i switch");
            }


            int listNo = Integer.valueOf(request.getParameter("listNo"));
            Order tempOrder = null;

            for (int i = 0; i < orderList.size(); i++) {
                if (listNo == i) {
                    tempOrder = orderList.get(i);
                }
            }
            //System.out.println(tempOrder.toString());
            int cl = 10 * tempOrder.getOrderLength();
            int cW = 10 * tempOrder.getOrderWidth();
            int shedLen = 10 * tempOrder.getOrderShedLength();
            int shedWid = 10 * tempOrder.getOrderShedWidth();

            session.setAttribute("lenght", Integer.toString(cl / 10));
            session.setAttribute("width", Integer.toString(cW / 10));
            session.setAttribute("shedLen", Integer.toString(shedLen / 10));
            session.setAttribute("shedWid", Integer.toString(shedWid / 10));

            CalculateFacade.drawing(request, cl, cW, shedLen, shedWid);

            if (userType.equals("employee")) {
                CalculateFacade.stykList(request, cl, cW, shedLen, shedWid, userType);
                showStykList = "1";

                String totalPriceS = (String) session.getAttribute("totalPrice");
                totalPriceKorr = Double.valueOf(totalPriceS);
                System.out.println("totalPriceKorr = "+totalPriceKorr);
                session.setAttribute("totalPriceKorr",(Double.toString(totalPriceKorr)));
            } else {
                if (tempOrder.getOrderStatus() == 1) {
                    CalculateFacade.stykList(request, cl, cW, shedLen, shedWid, userType);
                    showStykList = "1";

                } else {
                    //showStykList = "0";
                }
            }
        } else {
            System.out.println("Er i showOrder under beregn ");

            showStykList = "1";

            procentS = request.getParameter("procent");
            session.setAttribute("procent",procentS);

            double procent = Double.valueOf(procentS);
            String totalPriceS = (String) session.getAttribute("totalPrice");
            System.out.println("procent = "+procent);
            totalPriceKorr = CalculateFacade.afrund(Double.valueOf(totalPriceS)*(1+procent/100),2);
            session.setAttribute("totalPriceKorr",Double.toString(totalPriceKorr));


        }

        session.setAttribute("showStykList",showStykList);

        return "draw" + "page";
    }
}
