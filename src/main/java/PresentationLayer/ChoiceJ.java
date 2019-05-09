package PresentationLayer;

import FunctionLayer.LoginSampleException;
import FunctionLayer.Roof;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ChoiceJ extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        System.out.println("Er i ChoiceJ");
        List<Roof> roofList = DBAccess.ItemMapper.readRoofList();

        for (int i = 0; i <roofList.size() ; i++) {
            System.out.println(roofList.get(i).toString());
        }


        List<Roof> menuList = DBAccess.ItemMapper.makeRoofMenu(roofList);

        for (int i = 0; i <menuList.size() ; i++) {
            System.out.print(menuList.get(i).getRoofId()+"  "+menuList.get(i).getRoofDesc());
            System.out.println();
        }

        session.setAttribute("roofMenu",menuList);

        return "gableroof" + "page";
    }
}
