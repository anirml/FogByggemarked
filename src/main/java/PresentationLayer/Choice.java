package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Choice extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {

            HttpSession session = request.getSession();
            System.out.println("Er i Choice");
            List<Roof> roofList = DBAccess.ItemMapper.readRoofList();

            String destination = "";

            switch (request.getParameter("action")) {
                case "pitch":
                    // code block
                    boolean roofPitch = true;
                    List<Roof> menuPitchList = DBAccess.ItemMapper.makePitchRoofMenu(roofList);

                    session.setAttribute("roofPitchMenu", menuPitchList);
                    session.setAttribute("roofPitch", roofPitch);
                    destination = "roofstep1";
                    break;
                case "flat":
                    // code block
                    roofPitch = false;
                    List<Roof> menuFlatList = DBAccess.ItemMapper.makeFlatRoofMenu(roofList);

                    session.setAttribute("roofFlatMenu", menuFlatList);
                    session.setAttribute("roofPitch", roofPitch);
                    destination = "roofstep1";
                    break;
                default:
                    // code block
                    destination = "404";
            }

            return destination + "page";

        } catch (Exception e) {
            throw new FogException("Fejl i Choice");
        }
    }
}
