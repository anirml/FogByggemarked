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
                        destination = "pitchedroof";
                        break;
                    case "itemlist":
                        destination = "itemlist";
                        break;
                    case "register":
                        destination = "registerpage";
                        break;


                    default :
                        destination = "404page";
            }
        }

        return destination;
    }
}
