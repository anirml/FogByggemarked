package DBAccess;

import FunctionLayer.Description;
import FunctionLayer.Roof;
import FunctionLayer.Wood;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemMapper {

    public  static List<Roof> readRoofList() {

        List<Roof> roofList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.roof_material;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int roofId =resultSet.getInt("roof_id");
                String roofDesc = resultSet.getString("roof_desc");
                String roofColor = resultSet.getString("roof_color");
                int roofLength = resultSet.getInt("roof_length");
                int roofWidth = resultSet.getInt("roof_width");
                int roofLenDeck = resultSet.getInt("roof_len_deck");
                int roofWidDeck = resultSet.getInt("roof_wid_deck");
                String roofUnit = resultSet.getString("roof_unit");
                double roofPrice = resultSet.getDouble("roof_price");
                int roofStatus = resultSet.getInt("roof_status");
                int roofMenu = resultSet.getInt("roof_menu");
                Roof tempRoof = new Roof(roofId, roofDesc, roofColor, roofLength, roofWidth,
                                         roofLenDeck, roofWidDeck, roofUnit, roofPrice, roofStatus, roofMenu);
                roofList.add(tempRoof);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roofList;
    }

    public static List<Roof> makePitchRoofMenu(List<Roof> roofList) {

        List<Roof> menuPitchList = new ArrayList<>();
        int roofId;
        String roofDescT;

        for (int i = 0; i < roofList.size(); i++) {
            if (roofList.get(i).getRoofMenu() == 1) {
                roofId = roofList.get(i).getRoofId();
                roofDescT = roofList.get(i).getRoofDesc() + " " + roofList.get(i).getRoofColor();
                menuPitchList.add(new Roof(roofId, roofDescT));
            }
        }
        return menuPitchList;
    }

    public static List<Roof> makeFlatRoofMenu(List<Roof> roofList) {

        List<Roof> menuFlatList = new ArrayList<>();
        int roofId;
        String roofDescT;
        String tempType="";

        for (int i = 0; i < roofList.size(); i++) {
            if (roofList.get(i).getRoofMenu() == 0) {
                roofId = roofList.get(i).getRoofId();
                roofDescT = roofList.get(i).getRoofDesc() + " " + roofList.get(i).getRoofColor();

                if (!tempType.equals(roofDescT)) {
                    menuFlatList.add(new Roof(roofId, roofDescT));
                    tempType = roofDescT;
                }
            }
        }
        return menuFlatList;
    }

    public  static HashMap<Integer,Wood> readWoodMap() {

        HashMap<Integer,Wood> woodMap = new HashMap<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.wood_material;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int woodId =resultSet.getInt("wood_id");
                int woodDim1 = resultSet.getInt("wood_dim1");
                int woodDim2 = resultSet.getInt("wood_dim2");
                String woodDesc = resultSet.getString("wood_description");
                int woodlength = resultSet.getInt("wood_length");
                String woodUnit = resultSet.getString("wood_unit");
                double woodPrice = resultSet.getDouble("wood_price");
                Wood tempWood = new Wood(woodId, woodDim1, woodDim2, woodDesc, woodlength, woodUnit, woodPrice);
                woodMap.put(woodId,tempWood);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return woodMap;
    }

    public static List<Wood> readWoodList() {
        List<Wood> woodList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.wood_material;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int woodId =resultSet.getInt("wood_id");
                int woodDim1 = resultSet.getInt("wood_dim1");
                int woodDim2 = resultSet.getInt("wood_dim2");
                String woodDesc = resultSet.getString("wood_description");
                int woodlength = resultSet.getInt("wood_length");
                String woodUnit = resultSet.getString("wood_unit");
                double woodPrice = resultSet.getDouble("wood_price");
                Wood tempWood = new Wood(woodId, woodDim1, woodDim2, woodDesc, woodlength, woodUnit, woodPrice);
                woodList.add(tempWood);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return woodList;
    }

    public  static HashMap<String, Description> readDescMap() {

        HashMap<String, Description> descMap = new HashMap<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.use_description;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int useId =resultSet.getInt("use_id");
                String useDesc = resultSet.getString("use_description");
                String useCode = resultSet.getString("use_code");
                Description tempDesc = new Description(useId, useDesc, useCode);
                descMap.put(useCode, tempDesc);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return descMap;
    }

    public static List<Wood> editWood() {
        List<Wood> woodList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String sql = "INSERT INTO `fog_byggemarked`.`wood_material` (`wood_id`, `wood_dim1`, `wood_dim2`, `wood_description`, `wood_length`, `wood_unit`, `wood_price`) " +
                    "VALUES ('', '50', '200', 'testwood', '8000', 'stk', '1');";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int woodId =resultSet.getInt("wood_id");
                int woodDim1 = resultSet.getInt("wood_dim1");
                int woodDim2 = resultSet.getInt("wood_dim2");
                String woodDesc = resultSet.getString("wood_description");
                int woodlength = resultSet.getInt("wood_length");
                String woodUnit = resultSet.getString("wood_unit");
                double woodPrice = resultSet.getDouble("wood_price");
                Wood tempWood = new Wood(woodId, woodDim1, woodDim2, woodDesc, woodlength, woodUnit, woodPrice);
                woodList.add(tempWood);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return woodList;
    }

}
