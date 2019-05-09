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

public class makeRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        try{

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
            List<String> list = new ArrayList<>();

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

            session.setAttribute("list",list);

          //session.setAttribute( "order",order );

        } catch (Exception e){
            System.out.println("der var en fejl");
        }

        return "pitchedroof";
    }
}