package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class CalculateJ extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        System.out.println("Er i CalculateJ");

        List<String> orderInput = new ArrayList<>();
        orderInput = (List<String>) session.getAttribute("list");

        String cWS = orderInput.get(0);
        String clS = orderInput.get(1);

        String shedWidS = orderInput.get(4);
        String shedLenS = orderInput.get(5);


        int cl = 10 * Integer.parseInt(clS);
        int cW = 10 * Integer.parseInt(cWS);

        int shedLen = 10 * Integer.parseInt(shedLenS);
        int shedWid = 10 * Integer.parseInt(shedWidS);





        return "draw" + "page";
    }


}

/*

//******GENERERING AF TEGNING*******************************************************************************
        String postFlatSvg = "";
        String shedFlatSvg = "";
        String rafterFlatSvg = "";

        String dim1FlatSvg = "";
        String dim4FlatSvg = "";
        String dim5FlatSvg = "";
        String xDim = "";
        String xPost = "";
        String xSpaer = "";
        String yDim = "";
        String remShare = "";
        String remText = "";


        //TopDel af svg
        String topFlatSvg = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "height=\"80%\" viewBox=\"0 0 1000 _wid_\"\n" +
                "preserveAspectRatio=\"xMinYMin\">\n";
        topFlatSvg = topFlatSvg.replace("_wid_", Integer.toString(130 + cW / 10));

        //RammeDel med indv. viewbox
        String vBox1FlatSvg = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" " +
                "xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "x = \"70\"\n" +
                "y = \"50\"\n" +
                "width=\"_len_\" height=\"_wid_\" viewBox=\"0 0 _len_ _wid_\"\n" +
                "preserveAspectRatio=\"xMinYMin\">\n";
        vBox1FlatSvg = vBox1FlatSvg.replace("_len_", Integer.toString(cl / 10));
        vBox1FlatSvg = vBox1FlatSvg.replace("_wid_", Integer.toString(cW / 10));

        //Def. af ramme i indv. viewBox
        String frameFlatSvg = "<!--> ramme <-->\n" +
                "<rect x=\"0\" y=\"0\" width=\"_len_\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";

        frameFlatSvg = frameFlatSvg.replace("_len_", Integer.toString(cl / 10));
        frameFlatSvg = frameFlatSvg.replace("_wid_", Integer.toString(cW / 10));


        //STOLPE TEGNING og MÅLSÆTNING
        int tempX=0;
        int n = 0;
        //Første og sidste mål
        dim5FlatSvg = dim5FlatSvg +dimHor(700,cW+800,700+600,cW+800,700+150,cW+800,600);
        dim5FlatSvg = dim5FlatSvg +dimHor(700+cl-300,cW+800,700+cl,cW+800,700+cl-300,cW+800,300);
        for (int p = 0; p <2 ; p++) {
            for (int i = 0; i <9; i++) {
                if (postArray[i][p].getY()!=0) {
                    postFlatSvg=postFlatSvg+rectDraw(postArray[i][p].getX()-50,postArray[i][p].getY(),100,100);
                    if (postArray[i][p].getY()==300) {
                        //MålSÆTNING
                        if (n>0) {
                            dim5FlatSvg = dim5FlatSvg +dimHor(tempX+700,cW+800,postArray[i][p].getX()+700,
                                    cW+800,700+(tempX+postArray[i][p].getX())/2,cW+800,
                                    postArray[i][p].getX()-tempX);
                            //System.out.println(tempX+" "+postArray[i][p].getX()+" målværdi = "+
                            //        (postArray[i][p].getX()-tempX));
                        }
                        n=n+1;
                        tempX=postArray[i][p].getX();
                    }
                }
            }
        }


        //Skur
        if (shed) {

            shedFlatSvg = "<!--> skur vægge <-->\n";
            //Tegning af Skur gavl vægge
            //bagerste gavl
            // 1. brædt
            String xShed = "<rect x=\"_xSh_\" y=\"_ySh_\" width=\"2\" height =\"10\"  style=\"stroke: black; fill: white;\"/>\n";
            xShed = xShed.replace("_xSh_", Double.toString((cl-300+50)/10));
            xShed = xShed.replace("_ySh_", Double.toString((yShedStart)/10));
            shedFlatSvg = shedFlatSvg + xShed;
            //Næste brædder
            for (int i = 0; i <arrayShedW[0]; i++) {
                xShed = "<rect x=\"_xSh1_\" y=\"_ySh1_\" width=\"2\" height =\"10\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh1_", Double.toString((cl-300+50+20)/10));
                xShed = xShed.replace("_ySh1_", Double.toString((yShedStart+arrayShedW[2]+i*(100+arrayShedW[1]))/10));
                shedFlatSvg = shedFlatSvg + xShed;
                xShed = "<rect x=\"_xSh2_\" y=\"_ySh2_\" width=\"2\" height =\"10\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh2_", Double.toString((cl-300+50)/10));
                xShed = xShed.replace("_ySh2_", Double.toString((yShedStart+100+arrayShedW[1]+i*(100+arrayShedW[1]))/10));
                shedFlatSvg = shedFlatSvg + xShed;

            }
            //forreste gavl
            // 1. brædt
            xShed = "<rect x=\"_xSh_\" y=\"_ySh_\" width=\"2\" height =\"10\"  style=\"stroke: black; fill: white;\"/>\n";
            xShed = xShed.replace("_xSh_", Double.toString((cl-300-shedLen-70)/10));
            xShed = xShed.replace("_ySh_", Double.toString((yShedStart)/10));
            shedFlatSvg = shedFlatSvg + xShed;
            //Næste brædder
            for (int i = 0; i <arrayShedW[0]; i++) {
                xShed = "<rect x=\"_xSh1_\" y=\"_ySh1_\" width=\"2\" height =\"10\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh1_", Double.toString((cl-300-shedLen-70-20)/10));
                xShed = xShed.replace("_ySh1_", Double.toString((yShedStart+arrayShedW[2]+i*(100+arrayShedW[1]))/10));
                shedFlatSvg = shedFlatSvg + xShed;
                xShed = "<rect x=\"_xSh2_\" y=\"_ySh2_\" width=\"2\" height =\"10\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh2_", Double.toString((cl-300-shedLen-70)/10));
                xShed = xShed.replace("_ySh2_", Double.toString((yShedStart+100+arrayShedW[1]+i*(100+arrayShedW[1]))/10));
                shedFlatSvg = shedFlatSvg + xShed;

            }

            //Tegning af Skur lang vægge
            //nederste lang væg
            // 1. brædt
            xShed = "<rect x=\"_xSh_\" y=\"_ySh_\" width=\"10\" height =\"2\"  style=\"stroke: black; fill: white;\"/>\n";
            xShed = xShed.replace("_xSh_", Double.toString((xShedStart-70)/10));
            xShed = xShed.replace("_ySh_", Double.toString((cW-300)/10));
            shedFlatSvg = shedFlatSvg + xShed;
            //Næste brædder
            for (int i = 0; i <arrayShedL[0]; i++) {
                xShed = "<rect x=\"_xSh1_\" y=\"_ySh1_\" width=\"10\" height =\"2\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh1_", Double.toString((xShedStart-70+arrayShedL[2]+i*(100+arrayShedL[1]))/10));
                xShed = xShed.replace("_ySh1_", Double.toString((cW-300+20)/10));
                shedFlatSvg = shedFlatSvg + xShed;
                xShed = "<rect x=\"_xSh2_\" y=\"_ySh2_\" width=\"10\" height =\"2\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh2_", Double.toString((xShedStart-70+100+arrayShedL[1]+i*(100+arrayShedL[1]))/10));
                xShed = xShed.replace("_ySh2_", Double.toString((cW-300)/10));
                shedFlatSvg = shedFlatSvg + xShed;

            }
            //øverste lang væg
            // 1. brædt
            xShed = "<rect x=\"_xSh_\" y=\"_ySh_\" width=\"10\" height =\"2\"  style=\"stroke: black; fill: white;\"/>\n";
            xShed = xShed.replace("_xSh_", Double.toString((xShedStart-70)/10));
            xShed = xShed.replace("_ySh_", Double.toString((cW-300-shedWid-20)/10));
            shedFlatSvg = shedFlatSvg + xShed;
            //Næste brædder
            for (int i = 0; i <arrayShedL[0]; i++) {
                xShed = "<rect x=\"_xSh1_\" y=\"_ySh1_\" width=\"10\" height =\"2\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh1_", Double.toString((xShedStart-70+arrayShedL[2]+i*(100+arrayShedL[1]))/10));
                xShed = xShed.replace("_ySh1_", Double.toString((cW-300-shedWid-40)/10));
                shedFlatSvg = shedFlatSvg + xShed;
                xShed = "<rect x=\"_xSh2_\" y=\"_ySh2_\" width=\"10\" height =\"2\"  style=\"stroke: black; fill: white;\"/>\n";
                xShed = xShed.replace("_xSh2_", Double.toString((xShedStart-70+100+arrayShedL[1]+i*(100+arrayShedL[1]))/10));
                xShed = xShed.replace("_ySh2_", Double.toString((cW-300-shedWid-20)/10));
                shedFlatSvg = shedFlatSvg + xShed;

            }

            //shedFlatSvg = shedFlatSvg + xShed;
        }


        //Langsgående remme
        String remFlatSvg = "<!--> remme <-->\n" +
                "<rect x=\"0\" y=\"30\" width=\"_len_\" height =\"4.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                "<rect x=\"0\" y=\"_yRem2_\" width=\"_len_\" height =\"4.5\"  style=\"stroke: black; fill: white;\"/>\n";
        remFlatSvg = remFlatSvg.replace("_len_", Double.toString(cl / 10));
        remFlatSvg = remFlatSvg.replace("_yRem2_", Double.toString(cW / 10 - 34.5));

        // Remsamling

        if (cl>=6901&&cl<=9000) {
            remShare = "<!--> remdeling <-->\n" +
                       "<line x1=\"_x1_\"  y1=\"30\" x2=\"_x1_\"   y2=\"34.5\" style=\"stroke: black; fill: white; \"/>\n" +
                       "<line x1=\"_x1_\"  y1=\"_y1_\" x2=\"_x1_\"   y2=\"_y2_\" style=\"stroke: black; fill: white; \"/>\n";
            remShare = remShare.replace("_x1_",Double.toString(remShareX/10));
            remShare = remShare.replace("_y1_",Double.toString(-30 + cW/10));
            remShare = remShare.replace("_y2_",Double.toString(-34.5 + cW/10));
            remFlatSvg = remFlatSvg + remShare;
            remText =  "<!--> remtekst <-->\n" +
                       "<text transform=\"rotate(-90 _x_,120)\" x=\"_x_\" y=\"115\">remsamling</text>\n" +
                       "<text transform=\"rotate(-90 _x_,_y1_)\" x=\"_x_\" y=\"_y1_\">remsamling</text>\n";
            remText = remText.replace("_x_",Double.toString(remShareX/10));
            remText = remText.replace("_y1_",Double.toString(-40 + cW/10));
            remFlatSvg = remFlatSvg + remText;
        }

        //Vindkryds
        String crossFlatSvg = "<!--> vindkryds <-->\n" +
                "<line x1=\"_x1Cross1_\" y1=\"30\" x2=\"_x2Cross1_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x1Cross2_\" y1=\"30\" x2=\"_x2Cross2_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x2Cross1_\" y1=\"30\" x2=\"_x1Cross1_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x2Cross2_\" y1=\"30\" x2=\"_x1Cross2_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "\n";
        String x1Cross1 = "";
        String x1Cross2 = "";
        String x2Cross1 = "";
        String x2Cross2 = "";
        if (cl < (cW - 700 + arrayRafter[1])) {
            x1Cross1 = "0";
            x1Cross2 = "3";
            x2Cross1 = Double.toString(cl / 10 - 3);
            x2Cross2 = Double.toString(cl / 10);
        } else {
            x1Cross1 = Double.toString(arrayRafter[1] / 10);
            x1Cross2 = Double.toString(arrayRafter[1] / 10 + 3);
            x2Cross1 = Double.toString(cW / 10 + 55 - 70);
            x2Cross2 = Double.toString(cW / 10 + 55 - 70 + 3);
        }
        crossFlatSvg = crossFlatSvg.replace("_x2Cross1_", x2Cross1);
        crossFlatSvg = crossFlatSvg.replace("_y2Cross1_", Double.toString(cW / 10 - 60 + 30));
        crossFlatSvg = crossFlatSvg.replace("_x2Cross2_", x2Cross2);
        crossFlatSvg = crossFlatSvg.replace("_x1Cross1_", x1Cross1);
        crossFlatSvg = crossFlatSvg.replace("_x1Cross2_", x1Cross2);

        //Tegning af spær
        rafterFlatSvg = "<!--> spaer <-->\n";
        for (int i = 0; i < arrayRafter[0]-1; i++) {
            xSpaer = "<rect x=\"_xS_\" y=\"0\" width=\"4.5\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";
            xSpaer = xSpaer.replace("_xS_", Double.toString(i * arrayRafter[1] / 10));
            xSpaer = xSpaer.replace("_wid_", Double.toString(cW / 10));

            rafterFlatSvg = rafterFlatSvg + xSpaer;
        }

        xSpaer = "<rect x=\"_xSLast_\" y=\"0\" width=\"4.5\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";
        xSpaer = xSpaer.replace("_xSLast_", Double.toString((cl-45)/10));
        xSpaer = xSpaer.replace("_wid_", Double.toString(cW / 10));
        rafterFlatSvg = rafterFlatSvg + xSpaer ;

        //Målsætning af spær
        for (int i = 0; i < arrayRafter[0] - 2; i++) {
            xDim = "<line x1=\"_x1_\"  y1=\"20\" x2=\"_x2_\"   y2=\"20\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"_xDimPlac_\" y=\"20\">_yDimText_</text>\n";
            xDim = xDim.replace("_x1_", Double.toString(70 + (i * arrayRafter[1] / 10)));
            xDim = xDim.replace("_x2_", Double.toString(70 + ((i+1) * arrayRafter[1] / 10)));
            xDim = xDim.replace("_xDimPlac_", Double.toString(85 + (i * arrayRafter[1] / 10)));
            xDim = xDim.replace("_yDimText_", Integer.toString(arrayRafter[1]));
            dim4FlatSvg = dim4FlatSvg + xDim;
        }


        xDim = "<line x1=\"_x1_\"  y1=\"20\" x2=\"_x2_\"   y2=\"20\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text  x=\"_xDimPlac_\" y=\"20\">_yDimText_</text>\n";
        xDim = xDim.replace("_x1_", Double.toString(70+(cl-arrayRafter[2]-45)/10));
        xDim = xDim.replace("_x2_", Double.toString(70+(cl-45)/10));
        xDim = xDim.replace("_xDimPlac_", Double.toString(70-40 +(cl-45)/10));
        xDim = xDim.replace("_yDimText_", Integer.toString(arrayRafter[2]));
        dim4FlatSvg = dim4FlatSvg + xDim;



        //ViewBox med kommentarer
        String vBox2FlatSvg ="<svg width=\"200\" height=\"150\"" +
                "x = \"20\"\n" +
                "y = \"30\"\n" +
                " viewBox=\"0 0 200 100\"  xmlns=\"http://www.w3.org/2000/svg\">\n" +
                "<rect x=\"0\" y=\"0\" width=\"120\" height =\"60\"  style=\"stroke: black; fill: white;\"/>\n" +
                "<text \" x=\"10\" y=\"30\">Alle mål i mm</text> \n" +
                "style=\"stroke: #000000; fill:white;\"/>\n" +
                "</svg> ";

        //End indv. viewport
        String end1FlatSvg = "</svg>\n";

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

        //Mål på remplacering
        yDim = "<line x1=\"45\"  y1=\"50\" x2=\"45\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 40,_yText_)\" x=\"40\" y=\"_yText_\">_wid_</text>\n";
        yDim = yDim.replace("_y2_", Integer.toString(50 + 30));
        yDim = yDim.replace("_yText_", Integer.toString(50 + 23));
        yDim = yDim.replace("_wid_", Integer.toString(300));

        dim1FlatSvg = dim1FlatSvg + yDim;

        yDim = "<line x1=\"45\"  y1=\"_y1_\" x2=\"45\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 40,_yText_)\" x=\"40\" y=\"_yText_\">_wid_</text>\n";
        yDim = yDim.replace("_y1_", Integer.toString(50 + cW/10 - 30));
        yDim = yDim.replace("_y2_", Integer.toString(50 + cW/10));
        yDim = yDim.replace("_yText_", Integer.toString(50 + cW/10 - 30 + 28));
        yDim = yDim.replace("_wid_", Integer.toString(300));

        dim1FlatSvg = dim1FlatSvg + yDim;

        //Breddemål
        String dim2FlatSvg = "<line x1=\"20\"  y1=\"50\" x2=\"20\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 15,_yText_)\" x=\"15\" y=\"_yText_\">_wid_</text>\n";
        dim2FlatSvg = dim2FlatSvg.replace("_y2_", Integer.toString(50 + cW / 10));
        dim2FlatSvg = dim2FlatSvg.replace("_yText_", Integer.toString(50 + 10 + (cW / 10) / 2));
        dim2FlatSvg = dim2FlatSvg.replace("_wid_", Integer.toString(cW));

        //Længdemål
        String dim3FlatSvg = "<line x1=\"70\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text  x=\"_xText_\" y=\"_y_\">_len_</text>\n";
        dim3FlatSvg = dim3FlatSvg.replace("_x2_", Integer.toString(70 + cl / 10));
        dim3FlatSvg = dim3FlatSvg.replace("_xText_", Integer.toString((70 + cl / 10) / 2));
        dim3FlatSvg = dim3FlatSvg.replace("_len_", Integer.toString(cl));
        dim3FlatSvg = dim3FlatSvg.replace("_y_", Integer.toString(cW / 10 + 110));


        //Bunden af svg - End udv. viewport
        String end0FlatSvg = "</svg>";

        //Opbygnng af hele svg billed med de enkelte delstrenge
        String sumFlatSvg = topFlatSvg + vBox1FlatSvg +  frameFlatSvg + shedFlatSvg + postFlatSvg +remFlatSvg +
                rafterFlatSvg + crossFlatSvg + vBox2FlatSvg + end1FlatSvg + arrowFlatSvg + dim1FlatSvg +
                dim2FlatSvg + dim3FlatSvg + dim4FlatSvg + dim5FlatSvg + end0FlatSvg;

        //System.out.println(sumFlatSvg);

        session.setAttribute("svg_drawing", sumFlatSvg);

//******GENERING AF TEGNING **** SLUT ***********************************************************************

*/
