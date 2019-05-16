package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws FogException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login(email, password );
        HttpSession session = request.getSession();
        session.setAttribute("id",user.getId());
        session.setAttribute( "email", email);
        session.setAttribute( "user", user );
        session.setAttribute( "type", user.getType() );
        return user.getType() + "page";
    }
}