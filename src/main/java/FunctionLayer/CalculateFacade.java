package FunctionLayer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CalculateFacade {


    public static int[] rafter (int len, int wid){
        //arrayRafter[0] = numberRafter
        //arrayRafter[1] = rafterDist
        //arrayRafter[2] = lastRafterDist
        //arrayRafter[3] = lenRafter
        int [] arrayRafter = new int [4];
        arrayRafter[0] = ((len - 45) / 601) + 3;
        arrayRafter[1] = (((len - 45) / (arrayRafter[0]-1)) / 5) * 5;
        arrayRafter[2] = (len - 45) - (arrayRafter[0] - 2) * arrayRafter[1];
        arrayRafter[3] = wid + 300;
        return arrayRafter;
    }

    public static int[] stern (int len, int wid){
        //arrayStern[0] = antal understern gavl del1
        //arrayStern[1] = antal understern gavl del2
        //arrayStern[2] = antal understern side del1
        //arrayStern[3] = antal understern side del2
        //arrayStern[4] = længde understern gavl del1
        //arrayStern[5] = længde understern gavl del2
        //arrayStern[6] = længde understern side del1
        //arrayStern[7] = længde understern side del2

        int [] arrayStern = new int [8];
        arrayStern[0] = 2;
        arrayStern[4] = wid+300;
        if (wid>5700){
            arrayStern[1] = 2;
            arrayStern[4] = (((wid-300)/2)/300+1)*300;
            arrayStern[5] = arrayStern[4]+300;
        }
        arrayStern[2] = 2;
        arrayStern[6] = len+300;
        if (len>5700) {
            arrayStern[3] = 2;
            arrayStern[6] = (((len - 300) / 2) / 300 + 1) * 300;
            arrayStern[7] = arrayStern[6] + 300;
        }
        return arrayStern;
    }

    public static int[] roofFlat(int len, int wid) {
        //Plastmo Ecolite tag
        int plastmoWid = 1090;
        int[] plastmoLen = {2400, 3000, 3600, 4200, 4800, 6000};
        // arrayRoofFlat[0] = pladelængden
        // arrayRoofFlat[1] = antal plader i længderetning
        // arrayRoofFlat[2] = antal plader i bredderetning
        int[] arrayRoofFlat = new int[3];
        int i = 5;
        while (plastmoLen[i] > len + 200) {
            arrayRoofFlat[0] = plastmoLen[i];
            i = i - 1;
        }
        arrayRoofFlat[1] = 1;
        arrayRoofFlat[2] = wid  / 890 + 1;

        if (len>5700){
            i = 5;
            while (plastmoLen[i] > len/2 + 200) {
                arrayRoofFlat[0] = plastmoLen[i];
                i = i - 1;
            }
            arrayRoofFlat[1] = 2;

        }

        return arrayRoofFlat;

    }

    public static double[] shedWall (int dim) {
        //arrayShed[0] = n antal gange 2 brædder
        //arrayShed[1] = x afstand mellemrum brædder
        //arrayShed[2] = start afstand
        double[] arrayShed = new double[3];
        arrayShed[0] = ((dim-300)-(dim-300)%150)/150+1;
        arrayShed[1] = (dim-100)/arrayShed[0]-100;
        arrayShed[2] = 50 + arrayShed[1]/2;

        return arrayShed;
    }

    public static String rectDraw (int x, int y, int wid, int height){

        String xPost="";
        xPost =  "<rect x=\"_x_\" y=\"_y_\" width=\"_wid_\" height =\"_h_\"  style=\"stroke: black; fill: white;\"/>\n";
        xPost = xPost.replace("_x_",Integer.toString(x/10));
        xPost = xPost.replace("_y_", Double.toString(y/10));
        xPost = xPost.replace("_wid_",Integer.toString(wid/10));
        xPost = xPost.replace("_h_",Integer.toString(height/10));
        return xPost;
    }


    public static String dimHor (int x1, int y1, int x2, int y2, int xText, int yText, int dim) {

        String xDim = "";
        xDim = "<line x1=\"_x1_\"  y1=\"_y1_\" x2=\"_x2_\"  y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text  x=\"_xText_\" y=\"_yText_\">_dim_</text>\n";
        xDim = xDim.replace("_x1_", Integer.toString(x1/10));
        xDim = xDim.replace("_x2_", Integer.toString(x2/10));
        xDim = xDim.replace("_y1_", Integer.toString(y1/10));
        xDim = xDim.replace("_y2_", Integer.toString(y2/10));
        xDim = xDim.replace("_xText_", Integer.toString(xText/10));
        xDim = xDim.replace("_yText_", Integer.toString(yText/10));
        xDim = xDim.replace("_dim_", Integer.toString(dim));
        return xDim;
    }

    public static String dimVer (int x1, int y1, int x2, int y2, int xText, int yText, int dim) {
        String yDim = "";
        yDim = "<line x1=\"_x1_\"  y1=\"_y1_\" x2=\"_x2_\"   y2=\"_y2_\" \n" +
                "style=\"stroke:#006600;\n" +
                "marker-start: url(#beginArrow);\n" +
                "marker-end: url(#endArrow);\"/>\n" +
                "<text transform=\"rotate(-90 15,_yText_)\" x=\"_xText_\" y=\"_yText_\">_dim_</text>\n";
        yDim = yDim.replace("_x1_", Integer.toString(x1/10));
        yDim = yDim.replace("_x2_", Integer.toString(x2/10));
        yDim = yDim.replace("_y1_", Integer.toString(y1/10));
        yDim = yDim.replace("_y2_", Integer.toString(y2/10));
        yDim = yDim.replace("_xText_", Integer.toString(xText/10));
        yDim = yDim.replace("_yText_", Integer.toString(yText/10));
        yDim = yDim.replace("_dim_", Integer.toString(dim));
        return yDim;
    }

    public static int nummerisk(int tal) {
        int tempTal;
        if (tal > 0) {
            tempTal = tal;
        } else {
            tempTal = -1 * tal;
        }
        return tempTal;
    }

    public  static double afrund (double tal, int n) {

        int tital = (int) Math.pow(10, n);
        double juster = 5/Math.pow(10, n+1);
        double result = ((tal+juster)*tital-((tal+juster)*tital)%1)/tital;
        return result;
    }

    public static Koordinat[][] stolpXY(int l, int b, int sl, int sb) {
        Koordinat[][] arrayPost = new Koordinat[9][2];
        for (int j = 0; j <2 ; j++) {
            for (int i = 0; i < 9; i++) {
                arrayPost[i][j] = new Koordinat(0, 0);
            }
        }
        arrayPost[0][0]=new Koordinat(0,0); //skal holde antal stolper
        int n_Xafst = ((l - 900) / 3000) + 1;//antal stolpe afstande
        int st_Xafst = (l - 900) / n_Xafst;  //stolpeafstand uden for skur
        int nSh_Xafst = 0;                   //antal stolper indenfor skur
        int stSh_Xafst = 0;                  //stolpeafstand indenfor skur
        int antalS=0;
        for (int p = 0; p < 2; p++) {
            if (sl == 0) {
                for (int i = 0; i < n_Xafst + 1; i++) {
                    arrayPost[i+1][p] = new Koordinat(600 + st_Xafst * i, 300 + (b - 700) * p);
                }
            } else {
                if (sl > 3000) {
                    if (l - 900 - sl > 0) {
                        n_Xafst = ((l - 900 - sl) / 3000) + 1;
                        st_Xafst = (l - 900 - sl) / n_Xafst;
                        int i = 0;
                        for (i = 0; i < n_Xafst + 1; i++) {
                            arrayPost[i+1][p] = new Koordinat(600 + st_Xafst * i, 300 + (b - 700) * p);
                        }
                        nSh_Xafst = sl / 3000 + 1;
                        stSh_Xafst = sl / nSh_Xafst;
                        for (int j = 0; j < nSh_Xafst + 1; j++) {
                            arrayPost[i + j][p] = new Koordinat(arrayPost[i][p].getX() + stSh_Xafst * j, 300 + (b - 700) * p);
                        }
                    } else {
                        nSh_Xafst = sl / 3000 + 1;
                        stSh_Xafst = sl / nSh_Xafst;
                        for (int j = 0; j < nSh_Xafst + 1; j++) {
                            arrayPost[j+1][p] = new Koordinat(600 + stSh_Xafst * j, 300 + (b - 700) * p);
                        }
                    }

                } else {
                    n_Xafst = ((l - 900 - sl) / 3000) + 1;
                    st_Xafst = (l - 900 - sl) / n_Xafst;
                    for (int i = 0; i < n_Xafst; i++) {
                        arrayPost[i+1][p] = new Koordinat(600 + st_Xafst * i, 300 + (b - 700) * p);
                    }
                    arrayPost[n_Xafst+1][p] = new Koordinat(arrayPost[n_Xafst ][p].getX() + st_Xafst, 300 + (b - 700) * p);
                    arrayPost[n_Xafst + 2][p] = new Koordinat(arrayPost[n_Xafst+1][p].getX() + sl, 300 + (b - 700) * p);
                }


            }

        }

        //stolper indv. i skur øverst
        if (sl!=0) {
            if (sb < b - 600) {
                arrayPost[7][0] = new Koordinat(l - sl - 300, b - sb - 300);
                arrayPost[8][0] = new Koordinat(l - 300, b - sb - 300);
            }
        }
        // antal stolper
        arrayPost[0][0].setX(0);
        for (int p = 0; p <2 ; p++) {
            for (int i = 0; i <9 ; i++) {
                if (arrayPost[i][p].getX()!=0) {
                    antalS = antalS +1;
                }
            }
        }
        arrayPost[0][0].setX(antalS);

        return arrayPost;
    }

    public static void stykList (HttpServletRequest request, int cl, int cW, int shedLen, int shedWid, String userType) throws FogException {

        boolean emp=false;
        if (userType.equals("employee")){
            emp=true;
        }

        HttpSession session = request.getSession();
        System.out.println("Er i metode for stykliste genering");

        int[] arrayRafter = rafter(cl, cW);

        int[] arrayStern = stern(cl, cW);

        int[] arrayRoof = roofFlat(cl, cW);

        double[] arrayShedL = shedWall(shedLen+140);

        double[] arrayShedW = shedWall(shedWid);


        //Beregnig af stolper
        Koordinat[][] postArray = new Koordinat[9][2];
        postArray = CalculateFacade.stolpXY(cl, cW, shedLen, shedWid);


        int remShareX = CalculateFacade.remShare(cl,postArray);


        List<Wood> woodList = DBAccess.ItemMapper.readWoodList();
        List<Roof> roofList = DBAccess.ItemMapper.readRoofList();
        HashMap<Integer, ItemForList> rafterMap = new HashMap<>();
        HashMap<Integer, ItemForList> postMap = new HashMap<>();
        HashMap<Integer, ItemForList> uSternMap = new HashMap<>();
        HashMap<Integer, ItemForList> oSternMap = new HashMap<>();
        HashMap<Integer, ItemForList> roofMap = new HashMap<>();
        ItemForList beklaedItem = new ItemForList();

        HashMap<String, Description> descMap = DBAccess.ItemMapper.readDescMap();

        ItemForList tempItem = new ItemForList();
        String tempDesc = "";

        for (int i = 0; i <woodList.size() ; i++) {
            //remme og spær
            if ((woodList.get(i).getWoodDim1() == 45) && (woodList.get(i).getWoodDim2() == 195)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempItem = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit(),woodList.get(i).getWoodPrice());
                rafterMap.put(woodList.get(i).getWoodLength(), tempItem);
            }
            //stolper
            if ((woodList.get(i).getWoodDim1() == 97) && (woodList.get(i).getWoodDim2() == 97)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempItem = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit(),woodList.get(i).getWoodPrice());
                postMap.put(woodList.get(i).getWoodLength(), tempItem);
            }
            //understernbrædder
            if ((woodList.get(i).getWoodDim1() == 25) && (woodList.get(i).getWoodDim2() == 200)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempItem = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit(),woodList.get(i).getWoodPrice());
                uSternMap.put(woodList.get(i).getWoodLength(), tempItem);
            }
            //oversternbrædder
            if ((woodList.get(i).getWoodDim1() == 25) && (woodList.get(i).getWoodDim2() == 125)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                tempItem = new ItemForList(tempDesc,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit(),woodList.get(i).getWoodPrice());
                oSternMap.put(woodList.get(i).getWoodLength(), tempItem);
            }

            //beklædningsbrædder kun 1 længde (2100)
            if ((woodList.get(i).getWoodDim1() == 19) && (woodList.get(i).getWoodDim2() == 100)) {
                tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                beklaedItem = new ItemForList(tempDesc,
                        Integer.toString(2100),
                        woodList.get(i).getWoodUnit(),woodList.get(i).getWoodPrice());
            }

        }

        String roofType = "Plastmo Ecolite";

        //tagplader

        for (int i = 0; i <roofList.size() ; i++) {
            if (roofList.get(i).getRoofDesc().equals(roofType)) {
                tempDesc = roofList.get(i).getRoofDesc() + " " + roofList.get(i).getRoofColor();
                tempItem = new ItemForList(tempDesc, Integer.toString(roofList.get(i).getRoofLength()),
                        roofList.get(i).getRoofUnit(),roofList.get(i).getRoofPrice());
                roofMap.put(roofList.get(i).getRoofLength(), tempItem);
            }
        }


/* for (Integer i:rafterMap.keySet()) {
             System.out.println("key: " + i + " value. " +rafterMap.get(i).toString());
        }
*/


        //Stykliste Genering ******************

        ArrayList<OrderLine> tempStykList = new ArrayList();

        double totalPrice=0;

        if (emp) {

            //System.out.println("er under Employee i stykliste");

            //Stolper
            tempStykList.add(new OrderLine(postMap.get(3000), Integer.toString(postArray[0][0].getX()),
                    descMap.get("stolp").getUseDesc(), postArray[0][0].getX() * postMap.get(3000).getPrice()));

            //Remme

            if (cl >= 6901 && cl <= 9000) {
                tempStykList.add(new OrderLine(rafterMap.get(((remShareX / 300) + 1) * 300 + 300), Integer.toString(2),
                        descMap.get("rem01").getUseDesc(),2*rafterMap.get(((remShareX / 300) + 1) * 300 + 300).getPrice()));
                tempStykList.add(new OrderLine(rafterMap.get((((cl - remShareX) / 300) + 1) * 300 + 300), Integer.toString(2),
                        descMap.get("rem01").getUseDesc(),2*rafterMap.get((((cl - remShareX) / 300) + 1) * 300 + 300).getPrice()));

            } else {
                tempStykList.add(new OrderLine(rafterMap.get(cl + 300), Integer.toString(2),
                        descMap.get("rem01").getUseDesc(),2*rafterMap.get(cl + 300).getPrice()));
            }


            //Spær
            tempStykList.add(new OrderLine(rafterMap.get(arrayRafter[3]), Integer.toString(arrayRafter[0]),
                    descMap.get("spaer").getUseDesc(),arrayRafter[0]*rafterMap.get(arrayRafter[3]).getPrice()));


            //Stern (under)
            tempStykList.add(new OrderLine(uSternMap.get(arrayStern[4]), Integer.toString(arrayStern[0]),
                    descMap.get("usb_g").getUseDesc(),arrayStern[0]*uSternMap.get(arrayStern[4]).getPrice()));
            if (cW > 5700) {
                tempStykList.add(new OrderLine(uSternMap.get(arrayStern[5]), Integer.toString(arrayStern[1]),
                        descMap.get("usb_g").getUseDesc(),arrayStern[1]*uSternMap.get(arrayStern[5]).getPrice()));
            }
            tempStykList.add(new OrderLine(uSternMap.get(arrayStern[6]), Integer.toString(arrayStern[2]),
                    descMap.get("usb_s").getUseDesc(),arrayStern[2]*uSternMap.get(arrayStern[6]).getPrice()));

            if (cl > 5700) {
                tempStykList.add(new OrderLine(uSternMap.get(arrayStern[7]), Integer.toString(arrayStern[3]),
                        descMap.get("usb_s").getUseDesc(),arrayStern[3]*uSternMap.get(arrayStern[7]).getPrice()));
            }

            //Stern (over)

            tempStykList.add(new OrderLine(oSternMap.get(arrayStern[4]), Integer.toString(arrayStern[0]),
                    descMap.get("osb_g").getUseDesc(),arrayStern[0]*oSternMap.get(arrayStern[4]).getPrice()));
            if (cW > 5700) {
                tempStykList.add(new OrderLine(oSternMap.get(arrayStern[5]), Integer.toString(arrayStern[1]),
                        descMap.get("osb_g").getUseDesc(),arrayStern[1]*oSternMap.get(arrayStern[5]).getPrice()));
            }
            tempStykList.add(new OrderLine(oSternMap.get(arrayStern[6]), Integer.toString(arrayStern[2]),
                    descMap.get("osb_s").getUseDesc(),arrayStern[2]*oSternMap.get(arrayStern[6]).getPrice()));

            if (cl > 5700) {
                tempStykList.add(new OrderLine(oSternMap.get(arrayStern[7]), Integer.toString(arrayStern[3]),
                        descMap.get("osb_s").getUseDesc(),arrayStern[3]*oSternMap.get(arrayStern[7]).getPrice()));
            }

/*
        for (int i = 0; i <tempStykList.size() ; i++) {
            System.out.println(tempStykList.get(i).getItem().getDesc()+" "+tempStykList.get(i).getItem().getLength()+" "+
                    tempStykList.get(i).getNumber()+" "+tempStykList.get(i).getItem().getUnit()+
                    " "+tempStykList.get(i).getComments());
        }
*/

            //Beklædningsbrædder
            tempStykList.add(new OrderLine(beklaedItem, Integer.toString((int) (4 * (arrayShedL[0] + arrayShedW[0] + 1))),
                    descMap.get("beklaed").getUseDesc(),(4 * (arrayShedL[0] + arrayShedW[0] + 1)*beklaedItem.getPrice())));


            //Tagplader Fladt
            tempStykList.add(new OrderLine(roofMap.get(arrayRoof[0]), Integer.toString(arrayRoof[1] * arrayRoof[2]),
                    descMap.get("tag_fl").getUseDesc(),(arrayRoof[1] * arrayRoof[2])*roofMap.get(arrayRoof[0]).getPrice()));

            //Beregne totalpris
            for (int i = 0; i <tempStykList.size() ; i++) {
                totalPrice=totalPrice+tempStykList.get(i).getSumPrice();
            }

            session.setAttribute("totalPrice",Double.toString(totalPrice));


        } else { // customer

            System.out.println("er under Customer i stykliste");
            //Stolper
            tempStykList.add(new OrderLine(postMap.get(3000), Integer.toString(postArray[0][0].getX()),
                    descMap.get("stolp").getUseDesc()));

            //Remme

            if (cl >= 6901 && cl <= 9000) {
                tempStykList.add(new OrderLine(rafterMap.get(((remShareX / 300) + 1) * 300 + 300), Integer.toString(2),
                        descMap.get("rem01").getUseDesc()));
                tempStykList.add(new OrderLine(rafterMap.get((((cl - remShareX) / 300) + 1) * 300 + 300), Integer.toString(2), descMap.get("rem01").getUseDesc()));

            } else {
                tempStykList.add(new OrderLine(rafterMap.get(cl + 300), Integer.toString(2), descMap.get("rem01").getUseDesc()));
            }


            //Spær
            tempStykList.add(new OrderLine(rafterMap.get(arrayRafter[3]), Integer.toString(arrayRafter[0]), descMap.get("spaer").getUseDesc()));


            //Stern (under)
            tempStykList.add(new OrderLine(uSternMap.get(arrayStern[4]), Integer.toString(arrayStern[0]), descMap.get("usb_g").getUseDesc()));
            if (cW > 5700) {
                tempStykList.add(new OrderLine(uSternMap.get(arrayStern[5]), Integer.toString(arrayStern[1]), descMap.get("usb_g").getUseDesc()));
            }
            tempStykList.add(new OrderLine(uSternMap.get(arrayStern[6]), Integer.toString(arrayStern[2]), descMap.get("usb_s").getUseDesc()));

            if (cl > 5700) {
                tempStykList.add(new OrderLine(uSternMap.get(arrayStern[7]), Integer.toString(arrayStern[3]), descMap.get("usb_s").getUseDesc()));
            }

            //Stern (over)

            tempStykList.add(new OrderLine(oSternMap.get(arrayStern[4]), Integer.toString(arrayStern[0]), descMap.get("osb_g").getUseDesc()));
            if (cW > 5700) {
                tempStykList.add(new OrderLine(oSternMap.get(arrayStern[5]), Integer.toString(arrayStern[1]), descMap.get("osb_g").getUseDesc()));
            }
            tempStykList.add(new OrderLine(oSternMap.get(arrayStern[6]), Integer.toString(arrayStern[2]), descMap.get("osb_s").getUseDesc()));

            if (cl > 5700) {
                tempStykList.add(new OrderLine(oSternMap.get(arrayStern[7]), Integer.toString(arrayStern[3]), descMap.get("osb_s").getUseDesc()));
            }

            //Beklædningsbrædder
            tempStykList.add(new OrderLine(beklaedItem, Integer.toString((int) (4 * (arrayShedL[0] + arrayShedW[0] + 1))),
                    descMap.get("beklaed").getUseDesc()));


            //Tagplader Fladt
            tempStykList.add(new OrderLine(roofMap.get(arrayRoof[0]), Integer.toString(arrayRoof[1] * arrayRoof[2]),
                    descMap.get("tag_fl").getUseDesc()));

        }


        session.setAttribute("styklist",tempStykList);
    }

    public static void drawing (HttpServletRequest request, int cl, int cW, int shedLen, int shedWid) {



        HttpSession session = request.getSession();
        System.out.println("Er i metode for tegning genering");

        //Beregnig af stolper
        Koordinat[][] postArray = new Koordinat[9][2];
        postArray = CalculateFacade.stolpXY(cl, cW, shedLen, shedWid);


        int remShareX = CalculateFacade.remShare(cl,postArray);

//******GENERERING AF TEGNING*******************************************************************************
        boolean shed=true;
        if ((shedLen==0)&&(shedWid==0)) shed=false;

        int[] arrayRafter = rafter(cl, cW);

        double[] arrayShedL = shedWall(shedLen+140);

        double[] arrayShedW = shedWall(shedWid);

        int xShedStart = cl-300-shedLen;//anvendes til skurbeklædning
        int yShedStart = cW-300-shedWid;


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
        dim5FlatSvg = dim5FlatSvg + dimHor(700,cW+800,700+600,cW+800,700+150,cW+800,600);
        dim5FlatSvg = dim5FlatSvg + dimHor(700+cl-300,cW+800,700+cl,cW+800,700+cl-300,cW+800,300);
        for (int p = 0; p <2 ; p++) {
            for (int i = 0; i <9; i++) {
                if (postArray[i][p].getY()!=0) {
                    postFlatSvg=postFlatSvg+ rectDraw(postArray[i][p].getX()-50,postArray[i][p].getY(),100,100);
                    if (postArray[i][p].getY()==300) {
                        //MålSÆTNING
                        if (n>0) {
                            dim5FlatSvg = dim5FlatSvg + dimHor(tempX+700,cW+800,postArray[i][p].getX()+700,
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

        //remFlatSvg = remFlatSvg + rectDraw(0,30,cl/10,45/10);
        //remFlatSvg = remFlatSvg + rectDraw(0,(cW-345)/10,cl/10,45/10);

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

    }

    public static int remShare(int cl, Koordinat[][] postArray) {

        int remShareX = 0;
        if (cl >= 6901 && cl <= 9000) {
            int min = cl;
            int diff = 0;
            for (int p = 0; p < 2; p++) {
                for (int i = 0; i < 9; i++) {
                    diff = nummerisk(cl / 2 - postArray[i][p].getX());
                    if (diff < min) {
                        min = diff;
                        remShareX = postArray[i][p].getX();
                        //System.out.println("remShareX = " + remShareX);
                    }
                }
            }
        }

        return remShareX;
    }
}
