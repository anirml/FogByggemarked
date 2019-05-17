package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;
import FunctionLayer.Order;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SendRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        HttpSession session = request.getSession();
        System.out.println("Er i SendRequest");



        List<String> list = new ArrayList<>();
        list= (List<String>) session.getAttribute("list");
        LogicFacade.createRequest(list);
        System.out.println("test i sendrequest");

        return "customerpage";
    }
}
