package PresentationLayer;

import FunctionLayer.*;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MakeRequest extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        try {

            String userId;
            String width = "";
            String lenght = "";
            String roof = "";
            String angleS = "";
            String toolShedWidth = "";
            String toolShedLength = "";

            String destination = "../index";


            HttpSession session = request.getSession();

            switch (request.getParameter("command")){
                case "makeRequest":
                    switch (request.getParameter("action")){
                        case "step1":
                            destination = "roofstep1page";
                            break;
                        case "step2":
                            System.out.println("Er i MakeRequest - step2");
                            width = request.getParameter("width");
                            lenght = request.getParameter("lenght");
                            if (width == null || lenght == null){
                                request.setAttribute("message","Du mangler at vælge Bredde eller Længde!");
                                destination = "roofstep1page";
                                break;
                            }
                            session.setAttribute("lenght",lenght);
                            session.setAttribute("width",width);
                            destination = "roofstep2page";
                            break;
                        case "step3":
                            System.out.println("Er i MakeRequest - step3");
                            roof = request.getParameter("roof");
                            angleS = request.getParameter("angle");
                            if (roof == null || angleS == null){
                                request.setAttribute("message","Du mangler at vælge Tagtype eller Taghældning");
                                destination = "roofstep2page";
                                break;
                            }
                            ToolshedChoice.calcToolshedChoice(request);
                            session.setAttribute("roof",roof);
                            session.setAttribute("angle",angleS);

                            destination = "roofstep3page";
                            break;
                        case "step4":
                            System.out.println("Er i MakeRequest - step4");
                            toolShedWidth = request.getParameter("toolShedWidth");
                            toolShedLength = request.getParameter("toolShedLength");
                            if (toolShedWidth == null || toolShedLength == null){
                                request.setAttribute("message","Du mangler at vælge SkurBredde eller SkurLængde");
                                destination = "roofstep2page";
                                break;
                            }
                            session.setAttribute("toolShedLength",toolShedLength);
                            session.setAttribute("toolShedWidth",toolShedWidth);
                            destination = "roofstep4page";
                            break;
                        case "step5":

                            System.out.println("Er i MakeRequest - step5");

                            session.setAttribute("comment",request.getParameter("comment"));

                            int cl = 10 * Integer.valueOf((String) session.getAttribute("lenght"));
                            int cW = 10 * Integer.valueOf((String) session.getAttribute("width"));
                            int shedLen = 10 * Integer.valueOf((String) session.getAttribute("toolShedLength"));
                            int shedWid = 10 * Integer.valueOf((String) session.getAttribute("toolShedWidth"));

                            int angle = Integer.valueOf((String) session.getAttribute("angle"));

                            String userType = (String) session.getAttribute("type");

                            String showStykList = "0";
                            session.setAttribute("showStykList",showStykList);

                            Boolean roofPitch = Boolean.valueOf((Boolean) session.getAttribute("roofPitch"));

                            CalculateFacade.drawing(request, cl, cW, shedLen, shedWid);
                            if (roofPitch) {
                                CalculateFacade.drawPitch(request, cW, shedWid, angle);
                            } else {
                                CalculateFacade.drawFlat(request, cW, shedWid, angle);
                            }

                            CalculateFacade.stykList(request, cl, cW, shedLen, shedWid,userType);

                            destination = "draw" + "page";
                            break;

                        default :
                            destination = "404page";
                    }
                case "makeRequestBack":
                    switch (request.getParameter("action")){
                        case "bstep1":
                            destination = "roofstep1page";
                            break;
                        case "bstep2":
                            System.out.println("step2");
                            destination = "roofstep2page";
                            break;
                        case "bstep3":
                            System.out.println("step3");
                            destination = "roofstep3page";
                            break;
                        case "bstep4":
                            System.out.println("step4");
                            destination = "roofstep4page";
                            break;
                    }
            }

            return destination;

        } catch (Exception e){
            System.out.println("der var en fejl i MakeRequest");
        }
        return "404page";
    }
}