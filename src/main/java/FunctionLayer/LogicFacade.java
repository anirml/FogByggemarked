package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;

import java.util.List;


public class LogicFacade {

    public static User login(String id, String email, String password) throws LoginSampleException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String name, String email, String password,
                                  String address, String zipcode, String city, String phone) throws LoginSampleException {

        User user = new User(name, email, password, address, zipcode, city, phone, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static void createRequest(String comment, String lenght, String width, String roof, String angle, String toolShedWidth,
                                     String toolShedLenght) throws LoginSampleException {
    }

        public static void createRequest (List < String > list) throws LoginSampleException {

            String orderShed = "";
            String orderLength = "";
            String orderWidth = "";

            System.out.println("\n\n");
            System.out.println(list.get(0));
            System.out.println(list.get(1));
            System.out.println(list.get(2));
            System.out.println(list.get(3));
            System.out.println(list.get(4));
            System.out.println(list.get(5));
            System.out.println(list.get(6));

            if (list.get(4).equals("0") || list.get(5).equals("0")) {
                orderShed = null;
                orderLength = null;
                orderWidth = null;

            }
            if (!list.get(4).equals("0") || !list.get(5).equals("0")) {
                orderShed = "1";
                orderLength = list.get(5);
                orderWidth = list.get(4);
            }

            Order order = new Order("0", list.get(6), list.get(3), list.get(2), list.get(1), list.get(0), orderShed, orderLength, orderWidth);
            User user = new User(list.get(7));
            OrderMapper.createRequest(order, user);
        }
    }



