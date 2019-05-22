package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Nav extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        System.out.println("Er i Nav");

        HttpSession session = request.getSession();
        List<User> userList = null;

        String destination = "index";

        switch (request.getParameter("command")){
            case "nav":
                switch (request.getParameter("action")){
                    case "quickbyg":
                        destination = "quickbygpage";
                    break;
                    case "pitchedroof":
                        destination = "roofstep1page";
                        break;
                    case "requests":
                        userList = UserMapper.readUsers();
                        session.setAttribute("userList",userList);
                        destination = "requestspage";
                        break;
                    case "register":
                        System.out.println("Er i Nav register");
                        destination = "registerpage";
                        break;
                    case "woodmaterial":
                        destination = "woodmaterialpage";
                        break;
                    case "roofmaterial":
                        destination = "roofmaterialpage";
                        break;
                    case "customer":
                        destination = "customerpage";
                        break;
                    case "employee":
                        destination = "employeepage";
                        break;
                    case "editwood":
                        destination = "editwoodpage";
                        break;
                    case "makewood":
                        destination = "makewoodpage";
                        break;

                    default :
                        destination = "404page";
            }
        }
        return destination;
    }
}