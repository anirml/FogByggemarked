package PresentationLayer;

import FunctionLayer.LoginSampleException;
import com.sun.deploy.net.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ToolshedChoice extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        return "somepage";
    }

    public static void calcToolshedChoice(HttpServletRequest request) {

        HttpSession session = request.getSession();

        System.out.println("Er i ToolshedChoice");

        String len = (String) session.getAttribute("lenght");
        String wid = (String) session.getAttribute("width");

        int carportLength = Integer.valueOf(len);
        int carportWidth = Integer.valueOf(wid);

        System.out.println("Er i toolshedchoice efter indlæsning af len/wid");

        List<String> shedWidthList = new ArrayList<>();


        final int SHEDSTARTWIDTH = 120;

        for (int i = SHEDSTARTWIDTH; i < carportWidth - 30; i = i + 30) {
            //System.out.println(i);
            shedWidthList.add(Integer.toString(i));
        }

        session.setAttribute("toolshedWidthList", shedWidthList);

        //Længde

        List<String> shedLengthList = new ArrayList<>();

        final int SHEDSTARTLENGTH = 120;

        for (int i = SHEDSTARTLENGTH; i < carportLength - 60; i = i + 30) {
            //System.out.println(i);
            shedLengthList.add(Integer.toString(i));
        }
        //System.out.println(shedLengthList);

        session.setAttribute("toolshedLengthList", shedLengthList);

        return;
    }
}