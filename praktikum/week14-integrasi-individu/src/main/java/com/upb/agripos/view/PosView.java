package main.java.com.upb.agripos.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import main.java.com.upb.agripos.AppJavaFX;
import main.java.com.upb.agripos.controller.PosController;
import main.java.com.upb.agripos.model.Product;

public class PosView {
    private VBox root;
    private TableView<Product> table = new TableView<>();
    private PosController controller = new PosController();
    private Label lblTotal = new Label("Total: Rp 0.00");

    public PosView() {
        root = new VBox(10);
        root.setStyle("-fx-padding: 20;");

        // Tombol Navigasi
        Button btnBack = new Button("⬅ Kembali ke Tambah Produk");
        
        // Setup Tabel Produk
        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(d -> d.getValue().codeProperty());
        
        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(d -> d.getValue().nameProperty());

        TableColumn<Product, Number> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(d -> d.getValue().priceProperty());

        table.getColumns().addAll(colCode, colName, colPrice);
        
        // Memanggil setupTable (Termasuk tombol Hapus di tiap baris)
        controller.setupTable(table);

        // Bagian Aksi Keranjang
        Button btnAddCart = new Button("➕ Tambah ke Keranjang");
        btnAddCart.setStyle("-fx-background-color: #5cb85c; -fx-text-fill: white;");
        
        // REVISI: Tambahkan tombol Refresh Keranjang
        Button btnRefresh = new Button("🔄 Refresh Keranjang");
        btnRefresh.setStyle("-fx-background-color: #f0ad4e; -fx-text-fill: white;");

        lblTotal.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Layout untuk Total dan Refresh agar sejajar
        HBox cartActions = new HBox(15, lblTotal, btnRefresh);
        cartActions.setAlignment(Pos.CENTER_LEFT);

        // EVENT HANDLERS
        btnAddCart.setOnAction(e -> {
            Product selected = table.getSelectionModel().getSelectedItem();
            controller.handleAddToCart(selected, lblTotal);
        });

        btnRefresh.setOnAction(e -> {
            controller.handleResetCart(lblTotal);
        });

        btnBack.setOnAction(e -> AppJavaFX.showAddProductPage());

        // Menyusun elemen ke Root
        root.getChildren().addAll(
            btnBack, 
            new Label("Menu Kelola Produk & Kasir Agri-POS"), 
            table, 
            btnAddCart, 
            cartActions
        );
    }

    public Parent getView() {
        return root;
    }
}