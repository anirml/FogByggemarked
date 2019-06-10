package DBAccess;

import FunctionLayer.Description;
import FunctionLayer.FogException;
import FunctionLayer.FogException;
import FunctionLayer.Roof;
import FunctionLayer.Wood;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemMapper {

    public  static List<Roof> readRoofList() throws FogException {

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

        } catch (ClassNotFoundException ex) {
            throw new FogException(ex.toString(), "Class not found fejl i readRoofList");
        } catch (SQLException ex) {
            throw new FogException(ex.toString(), "SQL fejl i readRoofList");
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

    public  static HashMap<Integer,Wood> readWoodMap() throws FogException {

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

        } catch (ClassNotFoundException ex) {
            throw new FogException(ex.toString(), "Class not found fejl i readWoodMap");
        } catch (SQLException ex) {
            throw new FogException(ex.toString(), "SQL fejl i readWoodMap");
        }
        return woodMap;
    }

    public static List<Wood> readWoodList() throws FogException{
        List<Wood> woodList = new ArrayList<>();
        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.wood_material;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery(sql);

            while (resultSet.next()) {
                int woodId = resultSet.getInt("wood_id");
                int woodDim1 = resultSet.getInt("wood_dim1");
                int woodDim2 = resultSet.getInt("wood_dim2");
                String woodDesc = resultSet.getString("wood_description");
                int woodlength = resultSet.getInt("wood_length");
                String woodUnit = resultSet.getString("wood_unit");
                double woodPrice = resultSet.getDouble("wood_price");
                Wood tempWood = new Wood(woodId, woodDim1, woodDim2, woodDesc, woodlength, woodUnit, woodPrice);
                woodList.add(tempWood);
            }

        } catch (ClassNotFoundException ex) {
            throw new FogException(ex.toString(), "Class not found fejl i readWoodList");
        } catch (SQLException ex) {
            throw new FogException(ex.toString(), "SQL fejl i readWoodList");
        }
        return woodList;
    }

    public  static HashMap<String, Description> readDescMap() throws FogException {

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

        } catch (ClassNotFoundException ex) {
            throw new FogException(ex.toString(), "CNF fejl i readDescMap");
        } catch (SQLException ex) {
            throw new FogException(ex.toString(), "SQL fejl i readDescMap");
        }
        return descMap;
    }

    public static void createWood( Wood wood ) throws FogException {
        try {
            Connection con = Connector.connection();

            String SQL = "INSERT INTO wood_material (wood_dim1, wood_dim2, wood_description, wood_length, wood_unit, wood_price)" +
                    " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, Integer.toString(wood.getWoodDim1()) );
            ps.setString( 2, Integer.toString(wood.getWoodDim2()) );
            ps.setString( 3, wood.getWoodDesc() );
            ps.setString( 4, Integer.toString(wood.getWoodLength())  );
            ps.setString( 5, wood.getWoodUnit() );
            ps.setString( 6, Double.toString(wood.getWoodPrice()) );
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new FogException(ex.toString(), "Fejl i createWood");
        }
    }

    public static void editWood( Wood wood ) throws FogException {
        try {
            Connection con = Connector.connection();

            String SQL = "UPDATE wood_material SET wood_dim1=?, wood_dim2=?,wood_description=?,wood_length=?,wood_unit=?,wood_price=? WHERE (wood_id=?);\n";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, Integer.toString(wood.getWoodDim1()) );
            ps.setString( 2, Integer.toString(wood.getWoodDim2()) );
            ps.setString( 3, wood.getWoodDesc() );
            ps.setString( 4, Integer.toString(wood.getWoodLength())  );
            ps.setString( 5, wood.getWoodUnit() );
            ps.setString( 6, Double.toString(wood.getWoodPrice()) );
            ps.setString( 7, Integer.toString(wood.getWoodId()));
            ps.executeUpdate();
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new FogException( ex.toString(), "Fejl i editWood" );
        }
    }
}