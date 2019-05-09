package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculateJ extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        System.out.println("Er i CalculateJ");

        List<String> orderInput = new ArrayList<>();
        orderInput = (List<String>) session.getAttribute("list");

        String carportWidS = orderInput.get(0);
        String carportLenS = orderInput.get(1);


        int carportLen = 10 * Integer.parseInt(carportLenS);
        int carportWid = 10 * Integer.parseInt(carportWidS);

        //int carportLen = 7800;
        //int carportWid = 6000;


        int[] arrayRafter = LogicFacade.rafter(carportLen, carportWid);

        int[] arrayPost = LogicFacade.post(carportLen);

        int[] arrayStern = LogicFacade.stern(carportLen, carportWid);


        List<Wood> woodList = DBAccess.ItemMapper.readWoodList();

        HashMap<Integer, ItemForList> rafterMap = new HashMap<>();
        HashMap<Integer, ItemForList> postMap = new HashMap<>();
        HashMap<Integer, ItemForList> uSternMap = new HashMap<>();
        HashMap<Integer, ItemForList> oSternMap = new HashMap<>();

        HashMap<String, Description> descMap = DBAccess.ItemMapper.readDescMap();

        ItemForList tempWood = new ItemForList();
        String tempDesc = "";

        for (int i = 0; i <woodList.size() ; i++) {
            //remme og spær
            if ((woodList.get(i).getWoodDim1() == 45) && (woodList.get(i).getWoodDim2() == 195)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempWood = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit());
                rafterMap.put(woodList.get(i).getWoodLength(), tempWood);
            }
            //stolper
            if ((woodList.get(i).getWoodDim1() == 97) && (woodList.get(i).getWoodDim2() == 97)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempWood = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit());
                postMap.put(woodList.get(i).getWoodLength(), tempWood);
            }
            //understernbrædder
            if ((woodList.get(i).getWoodDim1() == 25) && (woodList.get(i).getWoodDim2() == 200)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempWood = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit());
                uSternMap.put(woodList.get(i).getWoodLength(), tempWood);
            }
            //oversternbrædder
            if ((woodList.get(i).getWoodDim1() == 25) && (woodList.get(i).getWoodDim2() == 125)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempWood = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit());
                oSternMap.put(woodList.get(i).getWoodLength(), tempWood);
            }

        }


       /* for (Integer i:rafterWood.keySet()) {
             System.out.println("key: " + i + " value. " +rafterWood.get(i).toString());
        }
*/

        //Stykliste Genering ******************

        ArrayList<OrderLine> tempStykList = new ArrayList();

        //Stolper
        tempStykList.add(new OrderLine(postMap.get(3000),Integer.toString(arrayPost[0]*2),descMap.get("stolp").getUseDesc()));

        //Remme
        System.out.println("Antal stolper arrayPost[0] = "+arrayPost[0]);
        System.out.println("arrayPost[2] =" + arrayPost[2]);
        System.out.println("arrayPost[3] =" + arrayPost[3]);

        tempStykList.add(new OrderLine(rafterMap.get(arrayPost[2]),Integer.toString(2),descMap.get("rem01").getUseDesc()));
        if (arrayPost[0]==4){
           tempStykList.add(new OrderLine(rafterMap.get(arrayPost[3]),Integer.toString(2),descMap.get("rem01").getUseDesc()));
        }

        //Spær
        tempStykList.add(new OrderLine(rafterMap.get(arrayRafter[3]),Integer.toString(arrayRafter[0]),descMap.get("spaer").getUseDesc()));


        //Stern (under)
        System.out.println("antal stern gavl del1 arrayStern[0] =" + arrayStern[0]);
        System.out.println("antal stern gavl del2 arrayStern[1] =" + arrayStern[1]);
        System.out.println("antal stern side del1 arrayStern[2] =" + arrayStern[2]);
        System.out.println("antal stern side del2 arrayStern[3] =" + arrayStern[3]);
        System.out.println("længde stern gavl del1 arrayStern[4] =" + arrayStern[4]);
        System.out.println("længde stern gavl del2 arrayStern[5] =" + arrayStern[5]);
        System.out.println("længde stern side del1 arrayStern[6] =" + arrayStern[6]);
        System.out.println("længde stern side del2 arrayStern[7] =" + arrayStern[7]);

        tempStykList.add(new OrderLine(uSternMap.get(arrayStern[4]),Integer.toString(arrayStern[0]),descMap.get("usb_g").getUseDesc()));
        if (carportWid>5700) {
            tempStykList.add(new OrderLine(uSternMap.get(arrayStern[5]), Integer.toString(arrayStern[1]), descMap.get("usb_g").getUseDesc()));
        }
        tempStykList.add(new OrderLine(uSternMap.get(arrayStern[6]),Integer.toString(arrayStern[2]),descMap.get("usb_s").getUseDesc()));

        if (carportLen>5700) {
            tempStykList.add(new OrderLine(uSternMap.get(arrayStern[7]), Integer.toString(arrayStern[3]), descMap.get("usb_s").getUseDesc()));
        }

        //Stern (under)

        tempStykList.add(new OrderLine(oSternMap.get(arrayStern[4]),Integer.toString(arrayStern[0]),descMap.get("osb_g").getUseDesc()));
        if (carportWid>5700) {
            tempStykList.add(new OrderLine(oSternMap.get(arrayStern[5]), Integer.toString(arrayStern[1]), descMap.get("osb_g").getUseDesc()));
        }
        tempStykList.add(new OrderLine(oSternMap.get(arrayStern[6]),Integer.toString(arrayStern[2]),descMap.get("osb_s").getUseDesc()));

        if (carportLen>5700) {
            tempStykList.add(new OrderLine(oSternMap.get(arrayStern[7]), Integer.toString(arrayStern[3]), descMap.get("osb_s").getUseDesc()));
        }

        for (int i = 0; i <tempStykList.size() ; i++) {
            System.out.println(tempStykList.get(i).getItem().getDesc()+" "+tempStykList.get(i).getItem().getLength()+" "+
                    tempStykList.get(i).getNumber()+" "+tempStykList.get(i).getItem().getUnit()+
                    " "+tempStykList.get(i).getComments());
        }

        session.setAttribute("styklist",tempStykList);



//******GENERERING AF TEGNING*******************************************************************************
        String postFlatSvg = "";
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
        topFlatSvg = topFlatSvg.replace("_wid_", Integer.toString(130 + carportWid / 10));

        //RammeDel med indv. viewbox
        String vBox1FlatSvg = "<svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" " +
                "xmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                "x = \"70\"\n" +
                "y = \"50\"\n" +
                "width=\"_len_\" height=\"_wid_\" viewBox=\"0 0 _len_ _wid_\"\n" +
                "preserveAspectRatio=\"xMinYMin\">\n";
        vBox1FlatSvg = vBox1FlatSvg.replace("_len_", Integer.toString(carportLen / 10));
        vBox1FlatSvg = vBox1FlatSvg.replace("_wid_", Integer.toString(carportWid / 10));

        //Def. af ramme i indv. viewBox
        String frameFlatSvg = "<!--> ramme <-->\n" +
                "<rect x=\"0\" y=\"0\" width=\"_len_\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";

        frameFlatSvg = frameFlatSvg.replace("_len_", Integer.toString(carportLen / 10));
        frameFlatSvg = frameFlatSvg.replace("_wid_", Integer.toString(carportWid / 10));


        //STOLPER
        //2 stolper
        if (arrayPost[0]==2) {
            //Placering af stolper
            postFlatSvg = "<!--> stolper <-->\n" +
                    "<rect x=\"85\" y=\"29.5\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                    "<rect x=\"_xPost_\" y=\"29.5\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                    "<rect x=\"85\" y=\"_yPost_\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                    "<rect x=\"_xPost_\" y=\"_yPost_\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n";
            postFlatSvg = postFlatSvg.replace("_xPost_", Double.toString(85 + arrayPost[1]/10));
            postFlatSvg = postFlatSvg.replace("_yPost_", Double.toString(carportWid/10 - 35));

            //Målsætning af stolper
            xDim = "<line x1=\"70\"  y1=\"_y_\" x2=\"160\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"105\" y=\"_y_\">900</text>\n";
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;

            xDim = "<line x1=\"160\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"_xText_\" y=\"_y_\">_dim_</text>\n";
            xDim = xDim.replace("_x2_", Integer.toString(70 + 90 + arrayPost[1]/10));
            xDim = xDim.replace("_xText_", Integer.toString((70 + 90 + (arrayPost[1]/10)/2)));
            xDim = xDim.replace("_dim_", Integer.toString(arrayPost[1]));
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;

            xDim = "<line x1=\"_x1_\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"_xText_\" y=\"_y_\">300</text>\n";
            xDim = xDim.replace("_x1_", Integer.toString(70 + carportLen/10 - 30));
            xDim = xDim.replace("_x2_", Integer.toString(70 + carportLen / 10));
            xDim = xDim.replace("_xText_", Integer.toString((70 + carportLen / 10 - 25)));
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;
        }

        //3 stolper
        if (arrayPost[0]==3){

            //Målsætning af 1. stolpe
            xDim = "<line x1=\"70\"  y1=\"_y_\" x2=\"160\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"105\" y=\"_y_\">900</text>\n";
            xDim = xDim.replace("_x2_", Integer.toString(70 + carportLen / 10));
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;

            for (int i = 0; i <2 ; i++) {
                //Placering af 1. og mellemstolper
                xPost = "<!--> stolper <-->\n" +
                        "<rect x=\"_xPost_\" y=\"29.5\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                        "<rect x=\"_xPost_\" y=\"_yPost_\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n";
                xPost = xPost.replace("_xPost_",Integer.toString(90 - 5 + i*arrayPost[1]/10));
                xPost = xPost.replace("_yPost_", Double.toString(carportWid/10 - 35));
                postFlatSvg = postFlatSvg + xPost;

                //Målsætning af mellemstolper
                xDim = "<line x1=\"_x1_\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                        "style=\"stroke:#006600;\n" +
                        "marker-start: url(#beginArrow);\n" +
                        "marker-end: url(#endArrow);\"/>\n" +
                        "<text  x=\"_xText_\" y=\"_y_\">_dim_</text>\n";
                xDim = xDim.replace("_x1_", Integer.toString(70 + 90 + i*arrayPost[1]/10));
                xDim = xDim.replace("_x2_", Integer.toString(70 + 90 + (i+1)*arrayPost[1]/10 ));
                xDim = xDim.replace("_xText_", Integer.toString(70 + 90 + i*arrayPost[1]/10 + (arrayPost[1]/10)/2));
                xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
                xDim = xDim.replace("_dim_", Integer.toString(arrayPost[1]));
                dim5FlatSvg = dim5FlatSvg + xDim;
            }

            //Placering af sidste stolper
            xPost = "<!--> stolper <-->\n" +
                    "<rect x=\"_xPost_\" y=\"29.5\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                    "<rect x=\"_xPost_\" y=\"_yPost_\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n";
            xPost = xPost.replace("_xPost_", Double.toString(85 + 2*arrayPost[1]/10));
            xPost = xPost.replace("_yPost_", Double.toString(carportWid/10 - 35));
            postFlatSvg = postFlatSvg + xPost;

            //Målsætning af sidste stolper
            xDim = "<line x1=\"_x1_\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"_xText_\" y=\"_y_\">300</text>\n";
            xDim = xDim.replace("_x1_", Integer.toString(70 + carportLen/10 - 30));
            xDim = xDim.replace("_x2_", Integer.toString(70 + carportLen / 10));
            xDim = xDim.replace("_xText_", Integer.toString((70 + carportLen / 10 - 25)));
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;
        }

        //4 stolper
        if (arrayPost[0]==4){
            //Målsætning af 1. stolpe
            xDim = "<line x1=\"70\"  y1=\"_y_\" x2=\"160\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"105\" y=\"_y_\">900</text>\n";
            xDim = xDim.replace("_x2_", Integer.toString(70 + carportLen / 10));
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;

            for (int i = 0; i <3 ; i++) {
                //Placering af 1. og mellemstolper
                xPost = "<!--> stolper <-->\n" +
                        "<rect x=\"_xPost_\" y=\"29.5\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                        "<rect x=\"_xPost_\" y=\"_yPost_\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n";
                xPost = xPost.replace("_xPost_",Integer.toString(90 - 5 + i*arrayPost[1]/10));
                xPost = xPost.replace("_yPost_", Double.toString(carportWid/10 - 35));
                postFlatSvg = postFlatSvg + xPost;


                //Målsætning af mellemstolper
                xDim = "<line x1=\"_x1_\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                        "style=\"stroke:#006600;\n" +
                        "marker-start: url(#beginArrow);\n" +
                        "marker-end: url(#endArrow);\"/>\n" +
                        "<text  x=\"_xText_\" y=\"_y_\">_dim_</text>\n";
                xDim = xDim.replace("_x1_", Integer.toString(70 + 90 + i*arrayPost[1]/10));
                xDim = xDim.replace("_x2_", Integer.toString(70 + 90 + (i+1)*arrayPost[1]/10 ));
                xDim = xDim.replace("_xText_", Integer.toString(70 + 90 + i*arrayPost[1]/10 + (arrayPost[1]/10)/2));
                xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
                xDim = xDim.replace("_dim_", Integer.toString(arrayPost[1]));

                dim5FlatSvg = dim5FlatSvg + xDim;

            }

            //Placering af sidste stolper
            xPost = "<!--> stolper <-->\n" +
                    "<rect x=\"_xPost_\" y=\"29.5\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                    "<rect x=\"_xPost_\" y=\"_yPost_\" width=\"10\" height =\"5.5\"  style=\"stroke: black; fill: white;\"/>\n";
            xPost = xPost.replace("_xPost_", Double.toString(85 + 3*arrayPost[1]/10));
            xPost = xPost.replace("_yPost_", Double.toString(carportWid/10 - 35));
            postFlatSvg = postFlatSvg + xPost;

            //Målsætning af sidste stolper
            xDim = "<line x1=\"_x1_\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                    "style=\"stroke:#006600;\n" +
                    "marker-start: url(#beginArrow);\n" +
                    "marker-end: url(#endArrow);\"/>\n" +
                    "<text  x=\"_xText_\" y=\"_y_\">300</text>\n";
            xDim = xDim.replace("_x1_", Integer.toString(70 + carportLen/10 - 30));
            xDim = xDim.replace("_x2_", Integer.toString(70 + carportLen / 10));
            xDim = xDim.replace("_xText_", Integer.toString((70 + carportLen / 10 - 25)));
            xDim = xDim.replace("_y_", Integer.toString(carportWid / 10 + 80));
            dim5FlatSvg = dim5FlatSvg + xDim;

        }

        //Langsgående remme
        String remFlatSvg = "<!--> remme <-->\n" +
                "<rect x=\"0\" y=\"35\" width=\"_len_\" height =\"4.5\"  style=\"stroke: black; fill: white;\"/>\n" +
                "<rect x=\"0\" y=\"_yRem2_\" width=\"_len_\" height =\"4.5\"  style=\"stroke: black; fill: white;\"/>\n";
        remFlatSvg = remFlatSvg.replace("_len_", Double.toString(carportLen / 10));
        remFlatSvg = remFlatSvg.replace("_yRem2_", Double.toString(carportWid / 10 - 39.5));

        // Remsamling
        if (arrayPost[0]==4) {
            remShare = "<!--> remdeling <-->\n" +
                       "<line x1=\"_x1_\"  y1=\"35\" x2=\"_x1_\"   y2=\"39.5\" style=\"stroke: black; fill: white; \"/>\n" +
                       "<line x1=\"_x1_\"  y1=\"_y1_\" x2=\"_x1_\"   y2=\"_y2_\" style=\"stroke: black; fill: white; \"/>\n";
            remShare = remShare.replace("_x1_",Double.toString(90 + arrayPost[1]/10));
            remShare = remShare.replace("_y1_",Double.toString(-35 + carportWid/10));
            remShare = remShare.replace("_y2_",Double.toString(-39.5 + carportWid/10));
            remFlatSvg = remFlatSvg + remShare;
            remText =  "<!--> remtekst <-->\n" +
                       "<text transform=\"rotate(-90 _x_,120)\" x=\"_x_\" y=\"120\">remsamling</text>\n" +
                       "<text transform=\"rotate(-90 _x_,_y1_)\" x=\"_x_\" y=\"_y1_\">remsamling</text>\n";
            remText = remText.replace("_x_",Double.toString(90 + arrayPost[1]/10));
            remText = remText.replace("_y1_",Double.toString(-45 + carportWid/10));
            remFlatSvg = remFlatSvg + remText;
        }

        //Vindkryds
        String crossFlatSvg = "<!--> vindkryds <-->\n" +
                "<line x1=\"_x1Cross1_\" y1=\"35\" x2=\"_x2Cross1_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x1Cross2_\" y1=\"35\" x2=\"_x2Cross2_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x2Cross1_\" y1=\"35\" x2=\"_x1Cross1_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "<line x1=\"_x2Cross2_\" y1=\"35\" x2=\"_x1Cross2_\" y2=\"_y2Cross1_\" style=\"stroke: black; stroke-dasharray: 10 10; \"/>\n" +
                "\n";
        String x1Cross1 = "";
        String x1Cross2 = "";
        String x2Cross1 = "";
        String x2Cross2 = "";
        if (carportLen < (carportWid - 700 + arrayRafter[1])) {
            x1Cross1 = "0";
            x1Cross2 = "3";
            x2Cross1 = Double.toString(carportLen / 10 - 3);
            x2Cross2 = Double.toString(carportLen / 10);
        } else {
            x1Cross1 = Double.toString(arrayRafter[1] / 10);
            x1Cross2 = Double.toString(arrayRafter[1] / 10 + 3);
            x2Cross1 = Double.toString(carportWid / 10 + 55 - 70);
            x2Cross2 = Double.toString(carportWid / 10 + 55 - 70 + 3);
        }
        crossFlatSvg = crossFlatSvg.replace("_x2Cross1_", x2Cross1);
        crossFlatSvg = crossFlatSvg.replace("_y2Cross1_", Double.toString(carportWid / 10 - 70 + 35));
        crossFlatSvg = crossFlatSvg.replace("_x2Cross2_", x2Cross2);
        crossFlatSvg = crossFlatSvg.replace("_x1Cross1_", x1Cross1);
        crossFlatSvg = crossFlatSvg.replace("_x1Cross2_", x1Cross2);

        //Tegning af spær
        rafterFlatSvg = "<!--> spaer <-->\n";
        for (int i = 0; i < arrayRafter[0]-1; i++) {
            xSpaer = "<rect x=\"_xS_\" y=\"0\" width=\"4.5\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";
            xSpaer = xSpaer.replace("_xS_", Double.toString(i * arrayRafter[1] / 10));
            xSpaer = xSpaer.replace("_wid_", Double.toString(carportWid / 10));

            rafterFlatSvg = rafterFlatSvg + xSpaer;
        }

        xSpaer = "<rect x=\"_xSLast_\" y=\"0\" width=\"4.5\" height =\"_wid_\"  style=\"stroke: black; fill: white;\"/>\n";
        xSpaer = xSpaer.replace("_xSLast_", Double.toString((carportLen-45)/10));
        xSpaer = xSpaer.replace("_wid_", Double.toString(carportWid / 10));
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
        xDim = xDim.replace("_x1_", Double.toString(70+(carportLen-arrayRafter[2]-45)/10));
        xDim = xDim.replace("_x2_", Double.toString(70+(carportLen-45)/10));
        xDim = xDim.replace("_xDimPlac_", Double.toString(70-40 +(carportLen-45)/10));
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
        yDim = yDim.replace("_y2_", Integer.toString(50 + 35));
        yDim = yDim.replace("_yText_", Integer.toString(50 + 28));
        yDim = yDim.replace("_wid_", Integer.toString(350));

        dim1FlatSvg = dim1FlatSvg + yDim;

        yDim = "<line x1=\"45\"  y1=\"_y1_\" x2=\"45\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 40,_yText_)\" x=\"40\" y=\"_yText_\">_wid_</text>\n";
        yDim = yDim.replace("_y1_", Integer.toString(50 + carportWid/10 - 35));
        yDim = yDim.replace("_y2_", Integer.toString(50 + carportWid/10));
        yDim = yDim.replace("_yText_", Integer.toString(50 + carportWid/10 - 35 + 28));
        yDim = yDim.replace("_wid_", Integer.toString(350));

        dim1FlatSvg = dim1FlatSvg + yDim;

        //Breddemål
        String dim2FlatSvg = "<line x1=\"20\"  y1=\"50\" x2=\"20\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 15,_yText_)\" x=\"15\" y=\"_yText_\">_wid_</text>\n";
        dim2FlatSvg = dim2FlatSvg.replace("_y2_", Integer.toString(50 + carportWid / 10));
        dim2FlatSvg = dim2FlatSvg.replace("_yText_", Integer.toString(50 + 10 + (carportWid / 10) / 2));
        dim2FlatSvg = dim2FlatSvg.replace("_wid_", Integer.toString(carportWid));

        //Længdemål
        String dim3FlatSvg = "<line x1=\"70\"  y1=\"_y_\" x2=\"_x2_\"   y2=\"_y_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text  x=\"_xText_\" y=\"_y_\">_len_</text>\n";
        dim3FlatSvg = dim3FlatSvg.replace("_x2_", Integer.toString(70 + carportLen / 10));
        dim3FlatSvg = dim3FlatSvg.replace("_xText_", Integer.toString((70 + carportLen / 10) / 2));
        dim3FlatSvg = dim3FlatSvg.replace("_len_", Integer.toString(carportLen));
        dim3FlatSvg = dim3FlatSvg.replace("_y_", Integer.toString(carportWid / 10 + 110));


        //Bunden af svg - End udv. viewport
        String end0FlatSvg = "</svg>";

        //Opbygnng af hele svg billed med de enkelte delstrenge
        String sumFlatSvg = topFlatSvg + vBox1FlatSvg +  frameFlatSvg + remFlatSvg + crossFlatSvg + rafterFlatSvg +
                postFlatSvg + vBox2FlatSvg + end1FlatSvg + arrowFlatSvg + dim1FlatSvg + dim2FlatSvg + dim3FlatSvg +
                dim4FlatSvg + dim5FlatSvg + end0FlatSvg;

        //System.out.println(sumFlatSvg);

        session.setAttribute("svg_drawing", sumFlatSvg);

//******GENERING AF TEGNING **** SLUT ***********************************************************************

        return "draw" + "page";
    }

}
