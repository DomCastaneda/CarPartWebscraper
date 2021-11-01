/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import javafx.geometry.Insets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class webscraper extends Application{
    
    Button searchButton;
    
    public static void main(String[] args){
      Application.launch(args); 
   }
    
    @Override
    public void start(Stage stage) throws IOException{
    
    //JSoup webscraping package test
    Document doc = Jsoup.connect("http://www.javatpoint.com").get();  
    String keywords = doc.select("meta[name=keywords]").first().attr("content");  
    System.out.println("Meta keyword : " + keywords);  
    String description = doc.select("meta[name=description]").get(0).attr("content");  
    System.out.println("Meta description : " + description);   
    
    stage.setTitle("Car Part Webscraper");
    
    StackPane layout = new StackPane();
    BorderPane root = new BorderPane();
    
    //comboboxes for make, year, model, part category, part type, part
    ComboBox<String> make = new ComboBox();
    //make.setPadding(new Insets(15, 12, 15, 12));
    ObservableList<String> makeList = make.getItems();
    makeList.add("AUDI");
    makeList.add("BMW");
    makeList.add("BUICK");
    makeList.add("CHEVROLET");
    makeList.add("CHRYSLER");
    makeList.add("DODGE");
    makeList.add("FIAT");
    makeList.add("FORD");
    makeList.add("GMC");
    makeList.add("HONDA");
    makeList.add("HYUNDAI");
    makeList.add("INFINITI");
    makeList.add("JAGUAR");
    makeList.add("JEEP");
    makeList.add("KIA");
    makeList.add("LAND ROVER");
    makeList.add("LEXUS");
    makeList.add("LINCOLN");
    makeList.add("MAZDA");
    makeList.add("MERCEDES-BENZ");
    makeList.add("MERCURY");
    makeList.add("NISSAN");
    makeList.add("PORSCHE");
    makeList.add("SUBARU");
    makeList.add("TOYOTA");
    makeList.add("VOLKSWAGEN");
    root.setLeft(make);
    
    Label makeMsg = new Label("Make:");
    HBox makeHbox = new HBox();
    //makeHbox.setPadding(new Insets(10, 10, 10, 10));
    makeHbox.getChildren().add(makeMsg);
    root.setBottom(makeHbox);
    
    make.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            makeMsg.setText(make.valueProperty().get());
        }
    });
    
    /*
    //combobox for year
    ComboBox<String> year = new ComboBox();
    //year.setPadding(new Insets(15, 12, 15, 12));
    ObservableList<String> yearList = year.getItems();
    yearList.add("2021");
    yearList.add("2020");
    root.setCenter(year);
    
    Label yearMsg = new Label("Year:");
    HBox yearHbox = new HBox();
    yearHbox.setPadding(new Insets(10, 10, 10, 10));
    yearHbox.getChildren().add(yearMsg);
    root.setBottom(yearHbox);
    
    year.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event){
            yearMsg.setText(year.valueProperty().get());
        }
    });*/
    
    //combobox for model
    ComboBox model = new ComboBox();
    
    //combobox for part category
    ComboBox partCategory = new ComboBox();
    
    //combobox for part type
    ComboBox partType = new ComboBox();

    //combobox for part
    ComboBox part = new ComboBox();
    
    //search  button
    searchButton = new Button();
    searchButton.setText("Search");
    root.setRight(searchButton);
    
    Scene scene = new Scene(root, 500, 450);
    stage.setScene(scene);
    stage.show();
        
    }
    
    double cost = 0;
    List<Part> partList = new ArrayList<Part>();

    public void addPart(Part newPart){
        partList.add(newPart);
    }
    
}
class Part{
    public String name;
    public double price;
    
    public Part(){   //start constructor
        name = "";   //default values
        price = 0.00;
    } 

    public Part(String name, double price){
        this.name=name;
        this.price=price;
    }

    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
