package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDao {
    Connection conn;
    ConnectionFactory cf = new ConnectionFactory();
    
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            conn = cf.getConnection();
            String sql = "SELECT id, name, login, password FROM tb_user";
            PreparedStatement ps  = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User (
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password")
                    )
                );
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
    
    public User userLogin(String login, String password) {
        try {
            conn = cf.getConnection();
            String sql = "SELECT id, name, login, password FROM tb_user WHERE login = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password")
                );
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
    
    public int insertUser(User u) {
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
