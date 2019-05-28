package PresentationLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        System.out.println("Er i ShowOrder");

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        String userType = (String) session.getAttribute("type");

        List<Order> orderList = null;
        String action = request.getParameter("action");

        String showStykList = "0";
        String procentS = "0";
        session.setAttribute("procent", procentS);
        double totalPriceKorr = 0;
        String finishOrder = "0";

        if (!action.equals("beregn")) {
            switch (action) {
                case "customer":
                    orderList = OrderMapper.readUserOrders(Integer.valueOf(user.getId()));
                    break;
                case "delete":
                    orderList = OrderMapper.readOrders0();
                    break;
                case "empOrder0":
                    orderList = OrderMapper.readOrders0();
                    break;
                case "empOrder1":
                    finishOrder = "1";
                    orderList = OrderMapper.readOrders1();
                    break;
                default: {
                }
            }
            session.setAttribute("finishOrder", finishOrder);

            int listNo = Integer.valueOf(request.getParameter("listNo"));
            Order tempOrder = null;

            for (int i = 0; i < orderList.size(); i++) {
                if (listNo == i) {
                    tempOrder = orderList.get(i);
                }
            }

            int orderId = tempOrder.getOrderId();

            if (!action.equals("delete")) {
                int customId = tempOrder.getUserId();

                int cl = 10 * tempOrder.getOrderLength();
                int cW = 10 * tempOrder.getOrderWidth();
                int shedLen = 10 * tempOrder.getOrderShedLength();
                int shedWid = 10 * tempOrder.getOrderShedWidth();

                if (action.equals("empOrder1")) {
                    double orderPrice = tempOrder.getOrderPrice();
                    session.setAttribute("orderPrice", Double.toString(orderPrice));
                }
                session.setAttribute("orderId", Integer.toString(orderId));

                session.setAttribute("lenght", Integer.toString(cl / 10));
                session.setAttribute("width", Integer.toString(cW / 10));
                session.setAttribute("shedLen", Integer.toString(shedLen / 10));
                session.setAttribute("shedWid", Integer.toString(shedWid / 10));

                CalculateFacade.drawing(request, cl, cW, shedLen, shedWid);

                Koordinat[][] postArray = new Koordinat[9][2];
                postArray = CalculateFacade.stolpXY(cl, cW, shedLen, shedWid);


                if (userType.equals("employee")) {
                    List<User> tempUserList = (List<User>) session.getAttribute("userList");
                    User tempUser = null;
                    for (int i = 0; i < tempUserList.size(); i++) {
                        if (customId == tempUserList.get(i).getIdInt()) {
                            tempUser = new User(tempUserList.get(i).getName(), tempUserList.get(i).getEmail(),
                                    tempUserList.get(i).getAddress(), tempUserList.get(i).getZipcode(),
                                    tempUserList.get(i).getCity(), tempUserList.get(i).getPhone());
                        }
                    }
                    session.setAttribute("customUser", tempUser);

                    CalculateFacade.stykList(request, cl, cW, shedLen, shedWid, userType);
                    showStykList = "1";

                    String totalPriceS = (String) session.getAttribute("totalPrice");
                    totalPriceKorr = Double.valueOf(totalPriceS);

                    session.setAttribute("totalPriceKorr", (Double.toString(totalPriceKorr)));
                } else { //customer
                    if (tempOrder.getOrderStatus() == 1) {
                        System.out.println("OrderStatus = 1");
                        CalculateFacade.stykList(request, cl, cW, shedLen, shedWid, userType);
                        showStykList = "1";

                    } else {
                        //showStykList = "0";
                    }
                }
            } else {
                //delete forespørgsel
                DBAccess.OrderMapper.deleteOrder(orderId);
                orderList = OrderMapper.readOrders0();
                session.setAttribute("order0List", orderList);
                return "employee" + "page";
            }

        } else { //beregn pris efter procent ændring
            System.out.println("Er i showOrder under beregn ");

            showStykList = "1";

            procentS = request.getParameter("procent");
            session.setAttribute("procent", procentS);

            double procent = Double.valueOf(procentS);
            String totalPriceS = (String) session.getAttribute("totalPrice");
            //System.out.println("procent = "+procent);
            totalPriceKorr = CalculateFacade.afrund(Double.valueOf(totalPriceS) * (1 + procent / 100), 2);
            session.setAttribute("totalPriceKorr", Double.toString(totalPriceKorr));
        }

        session.setAttribute("showStykList", showStykList);

        return "draw" + "page";
    }
}
