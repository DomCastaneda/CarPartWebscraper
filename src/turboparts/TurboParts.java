/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, November 2021
*/
package turboparts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javafx.stage.StageStyle;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class TurboParts extends Application
{
    Stage window;
    Scene scene;
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String PASSWORD = "123";
    
    public static void main(String[] args)
    {
        launch(args); 
    }
    
    @Override
    public void start(Stage stage) throws Exception 
    {	
        Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    /* finds cheapest of three websites */
    public static double min(double web1, double web2) {
        return Math.min(web1, web2);
    }
}

class Part {
    public String name;
    public double price;
    
    public Part() {       /* start constructor */
        name = "";        /* default values */
        price = 0.00;
    } 

    public Part(String name, double price) {
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}