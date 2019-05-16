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

    public static void calcToolshedChoice(HttpServletRequest request){

        HttpSession session = request.getSession();

        System.out.println("Er i toolshedchoice");

        List<String> dimlist = new ArrayList<>();
        dimlist = (List<String>) session.getAttribute("list");

        // carportLength dimlist.get(0)
        // carportWidth dimlist.get(1)
        System.out.println(dimlist.get(0) + " " + dimlist.get(1));
    int carportLength= Integer.valueOf(dimlist.get(1));
    int carportWidth= Integer.valueOf(dimlist.get(0));
    System.out.println(dimlist.get(0) + " " + dimlist.get(1));

        List<String> shedWidthList = new ArrayList<>();


        final int SHEDSTARTWIDTH = 120;

    for (int i = SHEDSTARTWIDTH; i <carportWidth -30 ; i = i+30) {
        //System.out.println(i);
        shedWidthList.add(Integer.toString(i));
    }

        session.setAttribute("toolshedWidthList",shedWidthList);


        //Længde


        List<String> shedLengthList = new ArrayList<>();

        final int SHEDSTARTLENGTH = 120;

    for (int i = SHEDSTARTLENGTH; i < carportLength-60 ; i = i+30) {
        //System.out.println(i);
        shedLengthList.add(Integer.toString(i));
    }
    //System.out.println(shedLengthList);

        session.setAttribute("toolshedLengthList",shedLengthList);

        return;
    }
}