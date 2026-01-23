package com.upb.agripos.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;


public class ProductFormView {
    public TextField txtCode = new TextField();
    public TextField txtName = new TextField();
    public TextField txtPrice = new TextField();
    public TextField txtStock = new TextField();
    public Button btnAdd = new Button("Add Product");
    public ListView<String> listView = new ListView<>();

    public Parent getLayout() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Code:"), 0, 0);  grid.add(txtCode, 1, 0);
        grid.add(new Label("Name:"), 0, 1);  grid.add(txtName, 1, 1);
        grid.add(new Label("Price:"), 0, 2); grid.add(txtPrice, 1, 2);
        grid.add(new Label("Stock:"), 0, 3); grid.add(txtStock, 1, 3);
        grid.add(btnAdd, 1, 4);
        grid.add(listView, 0, 5, 2, 1);

        return grid;
    }
}