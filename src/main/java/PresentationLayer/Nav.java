package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Nav extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

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
                        destination = "requestspage";
                        break;
                    case "register":
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