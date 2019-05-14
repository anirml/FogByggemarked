package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyPage extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String email = user.getEmail();
        request.setAttribute("email", email);
        String userRole = request.getParameter("type");
        if (userRole.equals("employee")) {
            return "employee";
        } else {
            return "customer";
        }
    }
}