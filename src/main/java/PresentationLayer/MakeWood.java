package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.FogException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeWood extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {

        String action = request.getParameter("action");

        int woodId = 0;
        if (request.getParameter("woodId") != null){
            woodId = Integer.valueOf(request.getParameter("woodId"));
        }
        int woodDim1 = Integer.valueOf(request.getParameter("woodDim1"));
        int woodDim2 = Integer.valueOf(request.getParameter("woodDim2"));
        String woodDesc = request.getParameter("woodDesc");
        int woodLength = Integer.valueOf(request.getParameter("woodLength"));
        String woodUnit = request.getParameter("woodUnit");
        double woodPrice = Double.valueOf(request.getParameter("woodPrice"));

        System.out.println(woodId + " " + woodDim1 + " " + woodDim2 + " " + woodDesc + " " + woodLength + " " + woodUnit + " " + woodPrice);

        try {


            if (action.equals("editwood")) {

                FunctionLayer.Wood wood = LogicFacade.editWood(woodId, woodDim1, woodDim2, woodDesc, woodLength, woodUnit, woodPrice);
                return "woodmaterial" + "page";

            }

            if (action.equals("makewood")) {
                FunctionLayer.Wood wood = LogicFacade.createWood(woodId, woodDim1, woodDim2, woodDesc, woodLength, woodUnit, woodPrice);
                return "woodmaterial" + "page";
            }
        } catch (Exception e){
            throw new FogException("Du mangler at udfylde en af felterne.");
        }

        return null;
    }
}