package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Choice extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        HttpSession session = request.getSession();
        System.out.println("Er i Choice");
        List<Roof> roofList = DBAccess.ItemMapper.readRoofList();

        /*for (int i = 0; i <roofList.size() ; i++) {
            System.out.println(roofList.get(i).toString());
        }
*/

        String destination="";

        switch (request.getParameter("action")){
            case "pitch":
                // code block
                boolean roofPitch =true;
                List<Roof> menuPitchList = DBAccess.ItemMapper.makePitchRoofMenu(roofList);

                //for (int i = 0; i <menuPitchList.size() ; i++) {
                  //  System.out.print(menuPitchList.get(i).getRoofId()+"  "+menuPitchList.get(i).getRoofDesc());
                  //  System.out.println();
                //}
                session.setAttribute("roofPitchMenu",menuPitchList);
                session.setAttribute("roofPitch",roofPitch);
                destination = "roofstep1";
                break;
            case  "flat":
                // code block
                roofPitch =false;
                List<Roof> menuFlatList = DBAccess.ItemMapper.makeFlatRoofMenu(roofList);

                System.out.println();
                //for (int i = 0; i <menuFlatList.size() ; i++) {
                  //  System.out.print(menuFlatList.get(i).getRoofId()+"  "+menuFlatList.get(i).getRoofDesc());
                  //  System.out.println();
                //}
                session.setAttribute("roofFlatMenu",menuFlatList);
                session.setAttribute("roofPitch",roofPitch);
                destination = "roofstep1";
                break;
            default:
                // code block
                destination = "404";
        }


        return destination + "page";
    }
}
