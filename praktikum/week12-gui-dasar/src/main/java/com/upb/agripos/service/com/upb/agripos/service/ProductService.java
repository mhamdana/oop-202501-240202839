package com.upb.agripos.service;

import com.upb.agripos.model.Product;

import com.upb.agripos.dao.ProductDAOImpl;

import com.upb.agripos.dao.ProductDAO;

public class ProductService {
    // EDIT: Pastikan memanggil ProductDAOImpl (Implementasi)
    private ProductDAO dao = new ProductDAOImpl(null); 

    // EDIT: Nama metode harus "addProduct" (Bukan tambahProduk)
    public void addProduct(Product p) throws Exception { 
        dao.insert(p);
    }
}
