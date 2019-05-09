package PresentationLayer;

import FunctionLayer.LoginSampleException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CalculateJ extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        System.out.println("Er i CalculateJ");

        int carportLen = 5400;
        int carportWid = 3000;

        int numberRafterDistance = ((carportLen - 45) / 601) + 1;

        System.out.println("antalSpaerAfstande = " + numberRafterDistance);
        int rafterDistance = (((carportLen - 45) / (numberRafterDistance)) / 5) * 5;
        System.out.println("spaerAfstand = " + rafterDistance);
        int lastRafterDistance = (carportLen - 45) - (numberRafterDistance - 1) * rafterDistance;
        System.out.println("lastSpaerAfstand = " + lastRafterDistance);


        String xSpaer = "";
        String xDim = "";
        String rafterFlatSvg = "";
        String dim4FlatSvg = "";
        double xRafter = 0;

        //Tegning af spær
        for (int i = 0; i < numberRafterDistance; i++) {
            xRafter = i * rafterDistance;
            xSpaer = "<rect x=\"_xS_\" y=\"0\" width=\"4.5\" height =\"600\"  style=\"stroke: black; fill: white;\"/>\n";
            xSpaer = xSpaer.replace("_xS_", Double.toString(xRafter / 10));
            rafterFlatSvg = rafterFlatSvg + xSpaer;
            System.out.println("xRafter = " + xRafter);
        }

        double last_xRafter = xRafter + lastRafterDistance;
        xSpaer = "<rect x=\"_xSLast_\" y=\"0\" width=\"4.5\" height =\"600\"  style=\"stroke: black; fill: white;\"/>\n";
        xSpaer = xSpaer.replace("_xSLast_", Double.toString(last_xRafter / 10));
        rafterFlatSvg = rafterFlatSvg + xSpaer + "</svg>\n";

        System.out.println("last_xRafter = " + last_xRafter);


        //Målsætning af spær
        for (int i = 0; i < numberRafterDistance - 1; i++) {
            xRafter = i * rafterDistance;
            xDim = "<line x1=\"_x1_\"  y1=\"20\" x2=\"_x2_\"   y2=\"20\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"_xDimPlac_\" y=\"20\">_yDimText_</text>\n";
            xDim = xDim.replace("_x1_", Double.toString(50 + (xRafter / 10)));
            xDim = xDim.replace("_x2_", Double.toString(50 + (xRafter / 10 + rafterDistance / 10)));
            xDim = xDim.replace("_xDimPlac_", Double.toString(65 + (xRafter / 10)));
            xDim = xDim.replace("_yDimText_", Integer.toString(rafterDistance));
            dim4FlatSvg = dim4FlatSvg + xDim;
        }


        xDim = "<line x1=\"_x1_\"  y1=\"20\" x2=\"_x2_\"   y2=\"20\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text  x=\"_xDimPlac_\" y=\"20\">_yDimText_</text>\n";
        xDim = xDim.replace("_x1_", Double.toString(50 + (xRafter / 10 + rafterDistance / 10)));
        System.out.println("xRafter = " + xRafter / 10);
        System.out.println("lastRafterDistance = " + lastRafterDistance / 10);
        xDim = xDim.replace("_x2_", Double.toString(50 + (xRafter / 10 + rafterDistance / 10 + lastRafterDistance / 10)));
        xDim = xDim.replace("_xDimPlac_", Double.toString(65 + (xRafter / 10 + rafterDistance / 10)));
        xDim = xDim.replace("_yDimText_", Integer.toString(lastRafterDistance));
        dim4FlatSvg = dim4FlatSvg + xDim;


        //TopDel af svg
        String topFlatSvg = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "height=\"200%\" viewBox=\"0 0 830 700\"\n" +
                "preserveAspectRatio=\"xMinYMin\">\n" +
                "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "x = \"50\"\n" +
                "y = \"50\"\n";

        //RammeDel med indv. viewbox
        String frameFlatSvg = "width=\"_len_\" height=\"_wid_\" viewBox=\"0 0 _len_ _wid_\"\n" +
                "preserveAspectRatio=\"xMinYMin\">\n" +
                "<!--> ramme <-->\n" +
                "<rect x=\"0\" y=\"0\" width=\"_len_\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";

        frameFlatSvg = frameFlatSvg.replace("_len_", Integer.toString(carportLen / 10));
        frameFlatSvg = frameFlatSvg.replace("_wid_", Integer.toString(carportWid / 10));

        //Langsgående remme
        String remFlatSvg = "<!--> remme <-->\n" +
                "<rect x=\"0\" y=\"35\" width=\"780\" height =\"4.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                "<rect x=\"0\" y=\"_yRem2_\" width=\"780\" height =\"4.5\"  style=\"stroke: black; fill: white;\"/>\n";
        remFlatSvg = remFlatSvg.replace("_yRem2_",Double.toString(carportWid / 10-39.5));

        //Vindkryds
        String crossFlatSvg = "<!--> vindkryds <-->\n" +
                "<line x1=\"55\" y1=\"35\" x2=\"_x2Cross1_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"58\" y1=\"35\" x2=\"_x2Cross2_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x2Cross1_\" y1=\"35\" x2=\"55\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x2Cross2_\" y1=\"35\" x2=\"58\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "\n";
        crossFlatSvg = crossFlatSvg.replace("_x2Cross1_",Double.toString(carportWid/10+55-70));
        crossFlatSvg = crossFlatSvg.replace("_y2Cross1_",Double.toString(carportWid/10-70+35));
        crossFlatSvg = crossFlatSvg.replace("_x2Cross2_",Double.toString(carportWid/10+55-70+3));


        /*String rafterFlatSvg = "<!--> spær <-->\n"+
                "<rect x=\"0\" y=\"0\" width=\"4.5\" height =\"600\"  style=\"stroke: black; fill: white;\"/>\n"+
                "<rect x=\"55\" y=\"0\" width=\"4.5\" height =\"600\"  style=\"stroke: black; fill: white;\"/>\n"+
                "</svg>\n";
*/

        //Pile for mållinier
        String arrowFlatSvg = "<defs>\n" +
                "<marker id=\"beginArrow\"\n" +
                "markerWidth=\"9\" markerHeight=\"9\" \n" +
                "refX=\"0\" refY=\"4\" \n" +
                "orient=\"auto\"> \n" +
                "<path d=\"M0,4 L8,0 L8,8 L0,4\" style=\"fill: #000000s;\" />\n" +
                "</marker>\n" +
                "<marker id=\"endArrow\" \n" +
                "markerWidth=\"9\" markerHeight=\"9\" \n" +
                "refX=\"8\" refY=\"4\" \n" +
                "orient=\"auto\"> \n" +
                "<path d=\"M0,0 L8,4 L0,8 L0,0\" style=\"fill: #000000;\" /> \n" +
                "</marker> \n" +
                "</defs> ";

        //String dim1FlatSvg = " ";

        //Breddemål
        String dim2FlatSvg = "<line x1=\"20\"  y1=\"50\" x2=\"20\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 15,_yText_)\" x=\"15\" y=\"_yText_\">_wid_</text>\n";
        dim2FlatSvg = dim2FlatSvg.replace("_y2_",Integer.toString(50 + carportWid / 10));
        dim2FlatSvg = dim2FlatSvg.replace("_yText_",Integer.toString(50 + (carportWid / 10)/2));
        dim2FlatSvg = dim2FlatSvg.replace("_wid_",Integer.toString(carportWid ));

        //Længdemål
        String dim3FlatSvg = "<line x1=\"50\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text  x=\"_xText_\" y=\"_y_\">_len_</text>\n";
        dim3FlatSvg = dim3FlatSvg.replace("_x2_", Integer.toString(50 + carportLen / 10));
        dim3FlatSvg = dim3FlatSvg.replace("_xText_", Integer.toString((50 + carportLen / 10) / 2));
        dim3FlatSvg = dim3FlatSvg.replace("_len_", Integer.toString(carportLen));
        dim3FlatSvg = dim3FlatSvg.replace("_y_", Integer.toString(carportWid/10+80));



       /* String dim4FlatSvg = "<line x1=\"50\"  y1=\"20\" x2=\"105\"   y2=\"20\" \n"+
                "style=\"stroke:#006600;\n"+
                "marker-start: url(#beginArrow);\n"+
                "marker-end: url(#endArrow);\"/>\n"+
                "<text  x=\"65\" y=\"20\">550</text>\n";
*/

       //Bunden af svg
        String endFlatSvg = "</svg>";

        String sumFlatSvg = topFlatSvg + frameFlatSvg + remFlatSvg + crossFlatSvg + rafterFlatSvg + arrowFlatSvg +
                dim2FlatSvg + dim3FlatSvg + dim4FlatSvg + endFlatSvg;

        System.out.println(sumFlatSvg);

        session.setAttribute("svg_drawing", sumFlatSvg);


        return "drawflatroof" + "page";
    }
}
