package PresentationLayer;

import FunctionLayer.FogException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class ToolshedChoice extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        return "somepage";
    }

    public static void calcToolshedChoice(HttpServletRequest request) {

        HttpSession session = request.getSession();



        //List<String> dimlist = new ArrayList<>();
        //dimlist = (List<String>) session.getAttribute("list");


        //System.out.println(session.getAttribute("lenght"));
        //System.out.println(session.getAttribute("width"));

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