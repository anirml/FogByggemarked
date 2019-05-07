package FunctionLayer;

import DBAccess.UserMapper;

import java.util.HashMap;
import java.util.List;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name ,String email, String password,
                                    String address, String zipcode, String city, String phone  ) throws LoginSampleException {
        User user = new User(name, email, password, address, zipcode, city, phone, "customer");
        UserMapper.createUser( user );
        return user;
    }

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

    public static int[] post (int len) {
        //arrayPost[0] = numberPost pr. side
        //arrayPost[1] = postDist (mellemafstand)
        //arrayPost[2] = remlænge på 1. rem
        //arrayPost[3] = remlænge på del 2
        int [] arrayPost = new int [4];
        final int POSTDIST_START = 900;
        final int POSTDIST_END = 300;
        if (len>=2400&&len<=3900) {
            arrayPost[0]=2;
            arrayPost[1] = len - POSTDIST_START - POSTDIST_END;
            arrayPost[2] = len + 300;
        }
        if (len>=3901&&len<=6900) {
            arrayPost[0]=3;
            arrayPost[1] = (len - POSTDIST_START - POSTDIST_END) / 2;
            arrayPost[2] = len + 300;
        }
        if (len>=6901&&len<=9000) {
            arrayPost[0]=4;
            arrayPost[1] = (len - POSTDIST_START - POSTDIST_END) / 3;
            arrayPost[2] = ((POSTDIST_START + arrayPost[1])/300+1)*300 + 300;
            arrayPost[3] = (((len - (POSTDIST_START + arrayPost[1]))/300)+1)*300+300;
        }
        return arrayPost;
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
        if (len>5700){
            arrayStern[3] = 2;
            arrayStern[6] = (((len-300)/2)/300+1)*300;
            arrayStern[7] = arrayStern[6]+300;
        }
        return arrayStern;
    }

/*

    public static HashMap<Integer, ItemForList> xMap (List tempWoodList, int dim1, int dim2, int i){

        List<Wood> woodList = DBAccess.ItemMapper.readWoodList();
        HashMap<Integer, ItemForList> xMap = new HashMap<>();
        ItemForList tempWood = new ItemForList();
        String tempDesc = "";

        if ((woodList.get(i).getWoodDim1() == dim1) && (woodList.get(i).getWoodDim2() == dim2)) {
            tempDesc = Integer.toString(woodList.get(i).getWoodDim1()) + "x" +
                    Integer.toString(woodList.get(i).getWoodDim2()) + " mm " +
                    woodList.get(i).getWoodDesc();

            tempWood = new ItemForList(tempDesc,
                    Integer.toString(woodList.get(i).getWoodLength()),
                    woodList.get(i).getWoodUnit());
            xMap.put(woodList.get(i).getWoodLength(), tempWood);
        }

        return xMap;
    }
*/
}
