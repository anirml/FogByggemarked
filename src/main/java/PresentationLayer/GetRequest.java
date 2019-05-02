package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        try {

            String width = request.getParameter("width");
            String lenght = request.getParameter("lenght");
            String roof = request.getParameter("roof");
            String angle = request.getParameter("angle");
            String toolShedWidth = request.getParameter("toolShedWidth");
            String toolShedLenght = request.getParameter("toolShedLenght");

            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String zipcode = request.getParameter("zipcode");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String comment = request.getParameter("comment");
            System.out.println(width + " " + lenght);

            HttpSession session = request.getSession();
            List<String> list = new ArrayList<>();

            list.add(width);
            list.add(lenght);
            list.add(roof);
            list.add(angle);
            list.add(toolShedWidth);
            list.add(toolShedLenght);
            list.add(name);
            list.add(address);
            list.add(zipcode);
            list.add(phone);
            list.add(email);
            list.add(comment);

            session.setAttribute("list",list);





        } catch (Exception e){
            System.out.println("der var en fejl");
        }

        return "pitchedroof";
    }
}
