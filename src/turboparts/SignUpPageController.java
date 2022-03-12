/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import static javafx.application.Application.launch;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/**
 * FXML Controller class
 *
 * @author jaepark
 */
public class SignUpPageController extends Application 
{
    Stage window;
    Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpPage.fxml"));
//        stage.setTitle("Sign Up");
//        stage.setScene(new Scene(root, 1220, 740));
//        stage.show();
        /* scene setup */
        window = stage;
        scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
     {
        launch(args);
    }
    
}
