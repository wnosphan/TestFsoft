/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.News;
import service.DBContext;

/**
 *
 * @author ADMIN
 */
public class NewsDAO extends DBContext{
            List<News> news=new ArrayList<>();

       
    public List<News> getAll(){
        String sql = "select * from listofnews ";
        try {
            PreparedStatement st=connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {                
                News i = new News(rs.getInt("ID"), rs.getString("title"), rs.getString("content"),rs.getString("author"),rs.getString("createdDate"),rs.getInt("views"));
                news.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return news;
    }
     public ArrayList<News> searchAuthor(Predicate<News> p) {
        ArrayList<News> st = new ArrayList<>();
        for (News i : news) {
            if (p.test(i)) {
                st.add(i);
            }
        }

        return st;

     }}