package main.java.com.upb.agripos.dao;

import main.java.com.upb.agripos.model.Product;
import java.util.List;

public interface ProductDAO {
    // Gunakan findAll agar sinkron dengan Controller
    List<Product> findAll() throws Exception;
    
    // Pastikan ini ada dan TIDAK static
    void save(Product p) throws Exception;

    void delete(String code) throws Exception;
}