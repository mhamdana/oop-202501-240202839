package main.java.com.upb.agripos.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import main.java.com.upb.agripos.AppJavaFX;
import main.java.com.upb.agripos.controller.PosController;

public class ProductFormView {
    private GridPane root;
    private PosController controller = new PosController();

    public ProductFormView() {
        root = new GridPane();
        root.setPadding(new Insets(20));
        root.setHgap(10); root.setVgap(10);

        TextField txtCode = new TextField();
        TextField txtName = new TextField();
        TextField txtPrice = new TextField();
        TextField txtStock = new TextField();
        Button btnSave = new Button("Simpan & Lanjut ke Kasir");
        TableView<main.java.com.upb.agripos.model.Product> productTable = new TableView<>();

        root.add(new Label("Kode Produk:"), 0, 0); root.add(txtCode, 1, 0);
        root.add(new Label("Nama Produk:"), 0, 1); root.add(txtName, 1, 1);
        root.add(new Label("Harga:"), 0, 2); root.add(txtPrice, 1, 2);
        root.add(new Label("Stok:"), 0, 3); root.add(txtStock, 1, 3);
        root.add(btnSave, 1, 4);

        btnSave.setOnAction(e -> {
            try {
                // Simpan ke Database via Controller
                controller.handleAddProduct(
                    txtCode.getText(), 
                    txtName.getText(), 
                    Double.parseDouble(txtPrice.getText()), 
                    Integer.parseInt(txtStock.getText()),
                    productTable
                );
                
                // PINDAH HALAMAN ke Kelola Produk/Kasir
                AppJavaFX.showManagePage();
                
            } catch (Exception ex) {
                new Alert(Alert.AlertType.ERROR, "Input tidak valid: " + ex.getMessage()).show();
            }
        });
    }

    public Parent getView() {
        return root;
    }
}