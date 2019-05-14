package PresentationLayer;

import FunctionLayer.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MakeRequest extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        try {

            String width = "";
            String lenght = "";
            String roof = "";
            String angle = "";
            String toolShedWidth = "";
            String toolShedLength = "";
            String comment = "";

            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String zipcode = request.getParameter("zipcode");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String userId = "";

            String destination = "../index";


            HttpSession session = request.getSession();

            List<String> list;

            if (session.getAttribute("list") == null) {
                list = new ArrayList<>();

                list.add(width);
                list.add(lenght);
                list.add(roof);
                list.add(angle);
                list.add(toolShedWidth);
                list.add(toolShedLength);
                list.add(comment);

                list.add(userId);
                list.add(name);
                list.add(address);
                list.add(zipcode);
                list.add(phone);
                list.add(email);
            } else {
                list = (List<String>) session.getAttribute("list");
            }

            //boolean roofPitch = (boolean) session.getAttribute("roofPitch");

            switch (request.getParameter("command")) {
                case "makeRequest":
                    switch (request.getParameter("action")) {
                        case "step1":
                            destination = "roofstep1page";
                            break;
                        case "step2":
                            width = request.getParameter("width");
                            lenght = request.getParameter("lenght");
                            if (width == null || lenght == null) {
                                request.setAttribute("message", "Du mangler at vælge Bredde eller Længde!");
                                destination = "roofstep1page";
                                break;
                            }
                            list.set(0, width);
                            list.set(1, lenght);
                            //System.out.println("B&L :" + width + " " + lenght);
                            destination = "roofstep2page";
                            break;
                        case "step3":
                            roof = request.getParameter("roof");
                            angle = request.getParameter("angle");
                            System.out.println("TAG & GRAD :" + roof + " " + angle);
                            if (roof == null || angle == null) {
                                request.setAttribute("message", "Du mangler at vælge Tagtype eller Taghældning");
                                destination = "roofstep2page";
                                break;
                            }
                            ToolshedChoice.calcToolshedChoice(request);
                            list.set(2, roof);
                            list.set(3, angle);
                            destination = "roofstep3page";
                            break;
                        case "step4":
                            toolShedWidth = request.getParameter("toolShedWidth");
                            toolShedLength = request.getParameter("toolShedLength");
                            if (toolShedWidth == null || toolShedLength == null) {
                                request.setAttribute("message", "Du mangler at vælge Bredde eller Længde");
                                destination = "roofstep2page";
                                break;
                            }
                            list.set(4, toolShedWidth);
                            list.set(5, toolShedLength);
                            System.out.println("B&L Skur :" + toolShedWidth + " " + toolShedLength);
                            destination = "roofstep4page";
                            break;
                        case "step5":
                            comment = request.getParameter("comment");
                            list.set(6, comment);
                            System.out.println("comment: " + comment);

                            User user = (User) session.getAttribute("user");
                            userId = String.valueOf(user.getId());

                            list.set(7, userId);
                            System.out.println("User ID: " + list.get(7));

                            int cl = 10 * Integer.parseInt(list.get(1));
                            int cW = 10 * Integer.parseInt(list.get(0));

                            int shedLen = 10 * Integer.parseInt(list.get(5));
                            int shedWid = 10 * Integer.parseInt(list.get(4));

                            CalculateFacade.drawing(request, cl, cW, shedLen, shedWid);
                            CalculateFacade.stykList(request, cl, cW, shedLen, shedWid);

                            session.setAttribute("list", list);

                            destination = "draw" + "page";
                            break;

                        default:
                            destination = "404page";
                    }
                case "makeRequestBack":
                    switch (request.getParameter("action")) {
                        case "bstep1":
                            destination = "roofstep1page";
                            break;
                        case "bstep2":
                            System.out.println("step2");
                            destination = "roofstep2page";
                            break;
                        case "bstep3":
                            System.out.println("step3");
                            destination = "roofstep3page";
                            break;
                        case "bstep4":
                            System.out.println("step4");
                            destination = "roofstep4page";
                            break;

                    }
            }

            session.setAttribute("list", list);

            return destination;

        } catch (Exception e) {
            System.out.println("der var en fejl i MakeRequest");
        }
        return "404page";
    }
}