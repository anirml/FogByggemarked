package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MakeRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {


        try {
            String destination = "../index.jsp";

            String width = request.getParameter("width");
            String lenght = request.getParameter("lenght");
            String roof = request.getParameter("roof");
            String angle = request.getParameter("angle");
            String toolShed = request.getParameter("toolShed");
            String toolShedWidth = request.getParameter("toolShedWidth");
            String toolShedLenght = request.getParameter("toolShedLenght");
            String comment = request.getParameter("comment");

            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String zipcode = request.getParameter("zipcode");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");


            System.out.println(width + " " + lenght);

            LogicFacade.createRequest(width,lenght,roof,angle,toolShed,toolShedWidth,toolShedLenght,comment,name,address,zipcode,city,phone,email);

            HttpSession session = request.getSession();

            List<String> list;

            if (session.getAttribute("list") == null) {
                list = new ArrayList<>();

                list.add(width);
                list.add(lenght);
                list.add(roof);
                list.add(angle);
                list.add(toolShed);
                list.add(toolShedWidth);
                list.add(toolShedLenght);
                list.add(comment);

                list.add(name);
                list.add(address);
                list.add(zipcode);
                list.add(city);
                list.add(phone);
                list.add(email);
            }else {
                list = (List<String>) session.getAttribute("list");
            }



            switch (request.getParameter("command")){
                case "getRequest":
                    switch (request.getParameter("action")){
                        case "step1":
                            destination = "pitchedroofstep1page";
                            break;
                        case "step2":
                            width = request.getParameter("width");
                            lenght = request.getParameter("lenght");
                            if (width == null || lenght == null){
                                request.setAttribute("message","Du mangler at vælge Bredde eller Længde!");
                                destination = "pitchedroofstep1page";
                                break;
                            }
                            list.set(0,width);
                            list.set(1,lenght);
                            System.out.println("B&L :" + width + " " + lenght);
                            destination = "pitchedroofstep2page";
                            break;
                        case "step3":
                            roof = request.getParameter("roof");
                            angle = request.getParameter("angle");
                            System.out.println("TAG & GRAD :" + roof + " " + angle);
                            if (roof == null || angle == null){
                                request.setAttribute("message","Du mangler at vælge Tagtype eller Taghældning");
                                destination = "pitchedroofstep2page";
                                break;
                            }
                            list.set(2,roof);
                            list.set(3,angle);
                            destination = "pitchedroofstep3page";
                            break;
                        case "step4":
                            toolShedWidth = request.getParameter("toolShedWidth");
                            toolShedLenght = request.getParameter("toolShedLenght");
                            list.set(4,toolShedWidth);
                            list.set(5,toolShedLenght);
                            System.out.println("B&L Skur :" + toolShedWidth + " " + toolShedLenght);
                            destination = "pitchedroofstep4page";
                            break;
                        case "step5":
                            comment = request.getParameter("comment");
                            list.set(11,comment);
                            System.out.println("comment :" + comment);
                            destination = "calculatepage";
                            break;

                        default :
                            destination = "404page";
                    }
                case "getRequestBack":
                    switch (request.getParameter("action")){
                        case "bstep1":
                            destination = "pitchedroofstep1page";
                            break;
                        case "bstep2":
                            System.out.println("step2");
                            destination = "pitchedroofstep2page";
                            break;
                        case "bstep3":
                            System.out.println("step3");
                            destination = "pitchedroofstep3page";
                            break;
                        case "bstep4":
                            System.out.println("step4");
                            destination = "pitchedroofstep4page";
                            break;

                    }
            }


            session.setAttribute("list",list);


            return destination;

        } catch (Exception e){
            System.out.println("der var en fejl i GetRequest");
        }

        return "404page";
    }
}