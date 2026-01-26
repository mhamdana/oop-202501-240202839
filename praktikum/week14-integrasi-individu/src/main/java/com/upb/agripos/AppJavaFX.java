package main.java.com.upb.agripos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.com.upb.agripos.view.*;

public class AppJavaFX extends Application {
    private static BorderPane root = new BorderPane(); // Wadah utama

    @Override
    public void start(Stage primaryStage) {
        // Halaman pertama yang muncul: Tambah Produk
        showAddProductPage();

        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Agri-POS - Sistem Terintegrasi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Fungsi untuk memanggil Halaman Tambah
    public static void showAddProductPage() {
        ProductFormView formView = new ProductFormView();
        root.setCenter(formView.getView());
    }

    // Fungsi untuk memanggil Halaman Kelola/Kasir
    public static void showManagePage() {
        PosView manageView = new PosView();
        root.setCenter(manageView.getView());
    }

    public static void main(String[] args) { launch(args); }
}