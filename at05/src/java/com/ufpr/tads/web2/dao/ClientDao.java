package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ufpr.tads.web2.beans.ClientBean;

public class ClientDao {
    Connection conn;
    ConnectionFactory cf = new ConnectionFactory();
    
    public List<ClientBean> getClients() {
        List<ClientBean> clients = new ArrayList<>();
        try {
            conn = cf.getConnection();
            String sql = "SELECT clientid, clientcpf, clientname, clientemail FROM tb_client";
            PreparedStatement ps  = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClientBean cb = new ClientBean();
                cb.setId(rs.getInt("clientid"));
                cb.setCpf(rs.getString("clientcpf"));
                cb.setEmail(rs.getString("clientname"));
                cb.setEmail(rs.getString("clientemail"));
                clients.add(cb); 
            }
            return clients;
            
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
        
    public int insertClient(ClientBean c) {
        try {
            conn = cf.getConnection();
            String sql = "INSERT INTO tb_client values(DEFAULT, ?, ?, ?) RETURNING id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getCpf());
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
