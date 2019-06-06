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
}