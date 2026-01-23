package com.upb.agripos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.upb.agripos.view.ProductFormView;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.controller.ProductController;

public class AppJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        ProductFormView view = new ProductFormView();
        ProductService service = new ProductService();
        new ProductController(view, service);

        Scene scene = new Scene(view.getLayout(), 400, 500);
        primaryStage.setTitle("Agri-POS Week 12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}