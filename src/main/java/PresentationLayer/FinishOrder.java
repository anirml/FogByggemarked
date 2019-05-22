package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FinishOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i FinishOrder");

        HttpSession session = request.getSession();

        List<Order> order0List = OrderMapper.readOrders0();
        List<Order> order1List = null;

        LocalDateTime tidspunkt = LocalDateTime.now();
        String timeNow = tidspunkt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        int listNo = Integer.valueOf(request.getParameter("listNo"));
        int orderId = -1;

        for (int i = 0; i <order0List.size() ; i++) {
            if (listNo==i) {
                orderId = order0List.get(i).getOrderId();
            }
        }

        System.out.println("orderId = "+orderId);
        if (orderId>=0) OrderMapper.markSendOrder(timeNow, orderId);

        order0List = DBAccess.OrderMapper.readOrders0();
        session.setAttribute("order0List",order0List);
        order1List = DBAccess.OrderMapper.readOrders1();
        session.setAttribute("order1List",order1List);

        return "employeepage";
    }
}
