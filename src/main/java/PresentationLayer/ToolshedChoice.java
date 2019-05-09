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

    public static void calcToolshedChoice(HttpServletRequest request){
        HttpSession session = request.getSession();

    System.out.println("Er i toolshedchoice");

    List<String> dimlist = new ArrayList<>();
    dimlist = (List<String>) session.getAttribute("list");

    System.out.println(dimlist.get(0) + " " + dimlist.get(1));

    List<String> shedwidthlist = new ArrayList<>();


    final int WIDTHSTARTDIM = 210;

    for (int i = WIDTHSTARTDIM; i < Integer.parseInt(dimlist.get(0)) ; i = i+30) {
        //System.out.println(i);
        shedwidthlist.add(Integer.toString(i));
    }

    session.setAttribute("toolshedWidthList",shedwidthlist);


    //Længde


    List<String> shedlengthlist = new ArrayList<>();

    final int LENGTHSTARTDIM = 150;

    for (int i = LENGTHSTARTDIM; i < Integer.parseInt(dimlist.get(1)) ; i = i+30) {
        //System.out.println(i);
        shedlengthlist.add(Integer.toString(i));
    }
    //System.out.println(shedlengthlist);

    session.setAttribute("toolshedLengthList",shedlengthlist);

    //System.out.println(shedlist);

        return;
}

}
