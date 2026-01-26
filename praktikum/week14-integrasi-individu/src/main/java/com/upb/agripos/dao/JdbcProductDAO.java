package main.java.com.upb.agripos.dao;

import main.java.com.upb.agripos.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductDAO implements ProductDAO {
    private Connection connect() throws SQLException {
        // Memastikan driver dimuat secara manual jika otomatis gagal
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan! Cek Referenced Libraries.");
            e.printStackTrace();
        }

        String url = "jdbc:postgresql://localhost:5432/agri_pos";
        return DriverManager.getConnection(url, "postgres", "zapzap123");
    }

    @Override
    public List<Product> findAll() throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (Connection conn = connect(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Product(
                    rs.getString("code"), 
                    rs.getString("name"), 
                    rs.getDouble("price"), 
                    rs.getInt("stock")
                ));
            }
        }
        return list;
    }

@Override
public void delete(String code) throws Exception {
    String sql = "DELETE FROM products WHERE code = ?";
    try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, code);
        ps.executeUpdate();
    }
}
    @Override
    public void save(Product p) throws Exception {
        String sql = "INSERT INTO products (code, name, price, stock) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.setString(2, p.getName());
            ps.setDouble(3, p.getPrice());
            ps.setInt(4, p.getStock());
            ps.executeUpdate();
        }
    }
}