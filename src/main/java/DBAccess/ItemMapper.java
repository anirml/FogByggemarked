package DBAccess;

import FunctionLayer.Roof;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMapper {

    public  static List<Roof> readRoofList() {

        List<Roof> roofList = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String sql = "SELECT * FROM fog_byggemarked.roof_material";
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

    public static List<Roof> makeRoofMenu(List<Roof> roofList) {

        List<Roof> menuList = new ArrayList<>();
        int roofId;
        String roofDescT;

        for (int i = 0; i < roofList.size(); i++) {
            if (roofList.get(i).getRoofMenu() == 1) {
                roofId = roofList.get(i).getRoofId();
                roofDescT = roofList.get(i).getRoofDesc() + " " + roofList.get(i).getRoofColor();
                menuList.add(new Roof(roofId, roofDescT));
            }
        }
        return menuList;
    }
}
