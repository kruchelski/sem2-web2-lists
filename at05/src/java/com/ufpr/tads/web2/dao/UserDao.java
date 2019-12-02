package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.LoginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.beans.UserBean;

public class UserDao {
    Connection conn;
    ConnectionFactory cf = new ConnectionFactory();
    
    public List<UserBean> getUsers() {
        List<UserBean> users = new ArrayList<>();
        try {
            conn = cf.getConnection();
            String sql = "SELECT id, name, login, password FROM tb_user";
            PreparedStatement ps  = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserBean ub = new UserBean();
                ub.setId(rs.getInt("id"));
                ub.setLogin(rs.getString("login"));
                ub.setUserName(rs.getString("name"));
                ub.setPassword(rs.getString("password"));
                users.add(ub); 
            }
            return users;
            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com banco de dados " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão com banco de dados " + e.getMessage());
            }
        }
        return null;
    }
    
    public LoginBean userLogin(String login, String password) {
        try {
            conn = cf.getConnection();
            String sql = "SELECT id, name, login, password FROM tb_user WHERE login = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LoginBean loggedUser = new LoginBean();
                loggedUser.setId(rs.getInt("id"));
                loggedUser.setLogin(rs.getString("login"));
                return loggedUser;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com banco de dados " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão com banco de dados " + e.getMessage());
            }
        }
        return null;
    }
    
    public int insertUser(UserBean u) {
        try {
            conn = cf.getConnection();
            String sql = "INSERT INTO tb_user values(DEFAULT, ?, ?, ?) RETURNING id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getLogin());
            ps.setString(3, u.getPassword());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int idTemp = rs.getInt("id");
            return idTemp;
            
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com banco de dados " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Erro ao encerrar conexão com banco de dados " + e.getMessage());
            }
        }
        return -1;
    }
}
