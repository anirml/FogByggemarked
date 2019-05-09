package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

/**
 * The purpose of LogicFacade is to...
 * @author kasper
 */
public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    public static User createUser( String name ,String email, String password,
                                   String address, String zipcode, String city, String phone  ) throws LoginSampleException {
        User user = new User(name, email, password, address, zipcode, city, phone, "customer");
        UserMapper.createUser( user );
        return user;
    }

    public static void createRequest(String name, String address, String zipcode, String city, String phone, String email, String lenght, String width, String roof, String toolShed, String angle, String toolShedWidth,
                                     String toolShedLenght, String comment) throws LoginSampleException {

        Order order = new Order("0",comment,angle,roof,lenght,width,toolShed,toolShedLenght,toolShedWidth);
        User user = new User(name,email,"",address,zipcode,city,phone,"customer");
        OrderMapper.createRequest(order,user);
    }
}