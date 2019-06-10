package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.FogException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditOrder0 extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {

            System.out.println("Er i EditOrder0");

            String destination = "../index";

            String width = "";
            String lenght = "";
            String roof = "";
            String angleS = "";
            String toolShedWidth = "";
            String toolShedLength = "";
            boolean roofPitch = false;
            boolean roofChange = false;


            HttpSession session = request.getSession();

            switch (request.getParameter("action")) {
                case "step1":
                    width = request.getParameter("width");
                    lenght = request.getParameter("lenght");
                    angleS = request.getParameter("angle");

                    Order tempOrder = (Order) session.getAttribute("order");
                    if ((tempOrder.getOrderRoofAngle() != Integer.valueOf(angleS)) &&
                            (tempOrder.getOrderRoofAngle() == 0 || Integer.valueOf(angleS) == 0)) {
                        roofChange = true;
                    }
                    session.setAttribute("roofChange", roofChange);

                    session.setAttribute("lenght", lenght);
                    session.setAttribute("width", width);
                    session.setAttribute("angle", angleS);

                    ToolshedChoice.calcToolshedChoice(request);

                    if (!angleS.equals("0")) {
                        roofPitch = true;
                    }
                    session.setAttribute("roofPitch", roofPitch);

                    destination = "orderedit2page";
                    break;

                case "step2":
                    System.out.println("Er i EditOrder0 - step2");

                    roof = request.getParameter("roof");
                    if (roof == null) {
                        request.setAttribute("message", "Du mangler at vælge Tagtype");
                        destination = "orderedit2page";
                        break;
                    }

                    toolShedWidth = request.getParameter("toolShedWidth");
                    toolShedLength = request.getParameter("toolShedLength");
                    if (!((toolShedWidth.equals("0") && toolShedLength.equals("0")) ||
                            (!toolShedWidth.equals("0") && !toolShedLength.equals("0")))) {
                        request.setAttribute("message", "Enten SkurBredde og SkurLængde eller begge \"ingen\"");
                        destination = "orderedit2page";
                        break;
                    }

                    int orderRoofAngle = Integer.valueOf((String) session.getAttribute("angle"));
                    System.out.println(orderRoofAngle);
                    int orderRoofMaterial = Integer.valueOf(roof);
                    System.out.println(orderRoofMaterial);
                    int orderLength = Integer.valueOf((String) session.getAttribute("lenght"));
                    System.out.println(orderLength);
                    int orderWidth = Integer.valueOf((String) session.getAttribute("width"));
                    System.out.println(orderWidth);
                    int orderShed = 0;
                    System.out.println(orderShed);
                    int orderShedLength = Integer.valueOf(toolShedLength);
                    System.out.println(orderShedLength);
                    int orderShedWidth = Integer.valueOf(toolShedWidth);
                    System.out.println(orderShedWidth);

                    if ((orderShedLength != 0) && (orderShedWidth != 0)) orderShed = 1;


                    Order order = new Order(orderRoofAngle, orderRoofMaterial, orderLength, orderWidth,
                            orderShed, orderShedLength, orderShedWidth);

                    int orderId = Integer.valueOf((Integer) session.getAttribute("orderId"));

                    OrderMapper.editOrder(order, orderId);

                    session.setAttribute("order0List", OrderMapper.readOrders0());

                    destination = "employeepage";
                    break;

                case "back":
                    destination = "orderedit1page";
                    break;

                default:
                    destination = "404page";
            }

            return destination;

        } catch (Exception e){
            throw new FogException("Fejl i EditOrder0");
        }

    }
}
