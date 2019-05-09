package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChoiceJ extends Command {


    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        System.out.println("Er i ChoiceJ");
        List<Roof> roofList = DBAccess.ItemMapper.readRoofList();

        /*for (int i = 0; i <roofList.size() ; i++) {
            System.out.println(roofList.get(i).toString());
        }
*/

        List<Roof> menuList = DBAccess.ItemMapper.makeRoofMenu(roofList);

  /*      for (int i = 0; i <menuList.size() ; i++) {
            System.out.print(menuList.get(i).getRoofId()+"  "+menuList.get(i).getRoofDesc());
            System.out.println();
        }
*/
        session.setAttribute("roofMenu",menuList);


        /*List<Wood> woodList = DBAccess.ItemMapper.readWoodList();

        HashMap<Integer, ItemForList> rafterMap = new HashMap<>();
        HashMap<Integer, ItemForList> postMap = new HashMap<>();
        
        HashMap<String, Description> descMap = DBAccess.ItemMapper.readDescMap();

        ItemForList rafterWood = new ItemForList();
        ItemForList postWood = new ItemForList();
        String descRaft = "";
        String descPost = "";


        for (int i = 0; i <woodList.size() ; i++) {
            if ((woodList.get(i).getWoodDim1() == 45) && (woodList.get(i).getWoodDim2() == 195)) {
                descRaft = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                rafterWood = new ItemForList(descRaft,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit());
                rafterMap.put(woodList.get(i).getWoodLength(), rafterWood);
            }

            if ((woodList.get(i).getWoodDim1() == 97) && (woodList.get(i).getWoodDim2() == 97)) {
                descPost = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                        Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                        woodList.get(i).getWoodDesc();

                postWood = new ItemForList(descPost,
                        Integer.toString(woodList.get(i).getWoodLength()),
                        woodList.get(i).getWoodUnit());
                postMap.put(woodList.get(i).getWoodLength(), postWood);
            }

        }

       *//* for (Integer i:rafterWood.keySet()) {
             System.out.println("key: " + i + " value. " +rafterWood.get(i).toString());
        }
*//*




        String number = "5";
        String comments = "Sådan gør du";
        String code = "rem01";
        OrderLine testOrderLine = new OrderLine(rafterMap.get(390),number,comments);

        ArrayList<OrderLine> tempStykList = new ArrayList();

        tempStykList.add(new OrderLine(rafterMap.get(420),"7",descMap.get(code).getUseDesc()));
        tempStykList.add(new OrderLine(rafterMap.get(330),"8",comments));
        tempStykList.add(new OrderLine(rafterMap.get(570),"2",descMap.get("spaer").getUseDesc()));
        tempStykList.add(new OrderLine(rafterMap.get(390),"14",descMap.get("stolp").getUseDesc()));

        for (int i = 0; i <tempStykList.size() ; i++) {
            System.out.println(tempStykList.get(i).getItem().getDesc()+" "+tempStykList.get(i).getItem().getLength()+" "+
                    tempStykList.get(i).getNumber()+" "+tempStykList.get(i).getItem().getUnit()+
                    " "+tempStykList.get(i).getComments());
        }

        session.setAttribute("styklist",tempStykList);
       */



        return "pitchedroofstep1" + "page";
    }
}
