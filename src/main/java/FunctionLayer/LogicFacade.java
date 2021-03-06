package FunctionLayer;

import DBAccess.ItemMapper;
import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.List;

public class LogicFacade {

    public static User login(String email, String password) throws FogException {
        return UserMapper.login( email, password );
    } 

    public static User createUser( String name ,String email, String password,
                                    String address, String zipcode, String city, String phone  ) throws FogException {

        User user = new User(name, email, password, address, zipcode, city, phone, "customer");
        UserMapper.createUser( user );
        return user;
    }
    public static Wood createWood( int woodId ,int woodDim1, int woodDim2,
                                   String woodDesc, int woodLength, String woodUnit, double woodPrice  ) throws FogException {

        Wood wood = new Wood(woodId, woodDim1, woodDim2, woodDesc, woodLength, woodUnit, woodPrice);
        ItemMapper.createWood(wood);
        return wood;
    }

    public static Wood editWood( int woodId ,int woodDim1, int woodDim2,
                                   String woodDesc, int woodLength, String woodUnit, double woodPrice  ) throws FogException {

        Wood wood = new Wood(woodId, woodDim1, woodDim2, woodDesc, woodLength, woodUnit, woodPrice);
        ItemMapper.editWood(wood);
        return wood;
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
/*

//Gammel stolpe beregning
    public static int[] post (int len) {
        //arrayPost[0] = numberPost pr. side
        //arrayPost[1] = postDist (mellemafstand)
        //arrayPost[2] = remlænge på 1. rem
        //arrayPost[3] = remlænge på del 2
        int [] arrayPost = new int [4];
        final int POSTDIST_START = 600;
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

*/

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


}
