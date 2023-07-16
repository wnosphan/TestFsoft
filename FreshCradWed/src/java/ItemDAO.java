
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class ItemDAO extends DBContext{
    public List<Item> getAll(){
        List<Item> item=new ArrayList<>();
        String sql = "select * from ListofItems ";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                Item i = new Item(rs.getString("product"), rs.getString("amount"), rs.getString("status"));
                item.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return item;
    }
    public static void main(String[] args) {
        ItemDAO i= new ItemDAO();
        List<Item> list=i.getAll();
        System.out.println(list.get(0).getProduct());
        
    }
}
