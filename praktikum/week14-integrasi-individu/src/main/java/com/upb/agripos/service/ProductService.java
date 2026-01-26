package main.java.com.upb.agripos.service;

import main.java.com.upb.agripos.model.Product;
import main.java.com.upb.agripos.dao.JdbcProductDAO;
import java.util.List;

public class ProductService {
    private JdbcProductDAO productDAO = new JdbcProductDAO();

    public void addProduct(Product p) throws Exception {
        productDAO.save(p);
    }

    public List<Product> loadProducts() throws Exception {
        return productDAO.findAll();
    }

    // REVISI: Sekarang benar-benar menghapus data
    public void deleteProduct(String code) throws Exception {
        productDAO.delete(code);
    }
}