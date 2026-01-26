package main.java.com.upb.agripos.controller;

import main.java.com.upb.agripos.model.Product;
import main.java.com.upb.agripos.service.*;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.util.Callback;

public class PosController {
    private ProductService productService = new ProductService();
    private CartService cartService = new CartService();

    // 1. Simpan Produk ke DB
    public void handleAddProduct(String code, String name, double price, int stock, TableView<Product> table) {
        try {
            Product p = new Product(code, name, price, stock);
            productService.addProduct(p); 
            setupTable(table); 
            new Alert(Alert.AlertType.INFORMATION, "Produk berhasil disimpan!").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Gagal simpan: " + e.getMessage()).show();
        }
    }

    // 2. Hapus Produk dari DB (Dipanggil oleh tombol di Tabel)
    public void deleteProduct(Product p, TableView<Product> table) {
        try {
            productService.deleteProduct(p.getCode()); 
            setupTable(table); // Refresh tabel agar baris hilang
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Gagal hapus: " + e.getMessage()).show();
        }
    }

// 3. Reset/Refresh Keranjang Belanja
public void handleResetCart(Label lblTotal) {
    // 1. Kosongkan data di CartService
    cartService.clearCart(); 
    
    // 2. Reset tampilan label total menjadi Rp 0.00
    lblTotal.setText("Total: Rp 0.00");
    
    // 3. Tampilkan notifikasi (Opsional untuk laporan)
    new Alert(Alert.AlertType.INFORMATION, "Keranjang telah disegarkan/dikosongkan!").show();
}

    // 4. Tambah ke Keranjang
    public void handleAddToCart(Product selected, Label lblTotal) {
        if (selected != null) {
            try {
                cartService.add(selected, 1);
                lblTotal.setText("Total: Rp " + cartService.getTotal());
            } catch (Exception e) {
                new Alert(Alert.AlertType.WARNING, e.getMessage()).show();
            }
        }
    }

    // 5. Setup Tabel & Tombol Hapus Otomatis
    public void setupTable(TableView<Product> table) {
        if (table == null) return;
        try {
            table.setItems(FXCollections.observableArrayList(productService.loadProducts()));
            
            boolean hasActionCol = table.getColumns().stream()
                                   .anyMatch(col -> col.getText().equals("Aksi"));

            if (!hasActionCol) {
                TableColumn<Product, Void> actionCol = new TableColumn<>("Aksi");
                actionCol.setCellFactory(param -> new TableCell<>() {
                    private final Button btnDelete = new Button("Hapus");
                    {
                        btnDelete.setStyle("-fx-background-color: #ff4444; -fx-text-fill: white;");
                        btnDelete.setOnAction(event -> {
                            Product p = getTableView().getItems().get(getIndex());
                            deleteProduct(p, table);
                        });
                    }
                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : btnDelete);
                    }
                });
                table.getColumns().add(actionCol);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}