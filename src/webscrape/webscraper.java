/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class webscraper extends Application{
    
    Button searchButton;
    
    public static void main(String[] args){
      Application.launch(args); 
   }
    
    @Override
    public void start(Stage stage) throws IOException{	
    
    stage.setTitle("Car Part Webscraper");
    
    StackPane layout = new StackPane();
    BorderPane root = new BorderPane();
    
    //search  button
    searchButton = new Button();
    searchButton.setText("Search");
    root.setRight(searchButton);
     
    Label priceMsg = new Label();
    
    Label makeMsg = new Label("Make:");
    HBox makeHbox = new HBox();
    //makeHbox.setPadding(new Insets(10, 10, 10, 10));
    makeHbox.getChildren().add(makeMsg);
    root.setBottom(makeHbox);
    
    //comboboxes for make 
    // model, part (category, part type, part)
    ComboBox<String> make = new ComboBox();
    //make.setPadding(new Insets(15, 12, 15, 12));
    ObservableList<String> makeList = make.getItems();
    root.setLeft(make);
    
    //combobox for year
    ComboBox<String> year = new ComboBox();
    //year.setPadding(new Insets(15, 12, 15, 12));
    ObservableList<String> yearList = year.getItems();
    root.setCenter(year);
    
    //combobox for model
    /*ComboBox<String> model = new ComboBox();
    //year.setPadding(new Insets(15, 12, 15, 12));
    ObservableList<String> modelList = model.getItems();
    root.setCenter(model);*/
    
    /*makeList.add("AUDI");
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
    makeList.add("LINCOLN");*/
    makeList.add("MAZDA");
    makeList.add("MERCEDES-BENZ");
    /*makeList.add("MERCURY");
    makeList.add("NISSAN");
    makeList.add("PORSCHE");
    makeList.add("SUBARU");
    makeList.add("TOYOTA");
    makeList.add("VOLKSWAGEN");*/
    
    make.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    yearList.clear();
                    
                    if(make.valueProperty().get() == "MERCEDES-BENZ"){
                        yearList.add("2021");
                        yearList.add("2020");
                        yearList.add("2019");
                    }
                    if(make.valueProperty().get() == "MAZDA"){
                        yearList.add("2022");
                        yearList.add("2021");
                    }
                }
            });
    
    /*modelList.add("A220");
    modelList.add("AMG GT");
    modelList.add("AMG GT 63");
    root.setCenter(model);*/
    
    //root.setLeft(make + year + model);

    
    //JSoup webscraping package test
    String html = "https://www.buyautoparts.com/buynow/2019/Mercedes-Benz/C63_AMG/A-C_Compressor/60-04703_NA";
    try {
     	//get Document object after parsing the html from given url
	Document doc = Jsoup.connect(html).get();
 
	//get title from document object
	String title = doc.title();
 
	//print title
	System.out.println("Part: " + title);
        
        //get price for particular element
        Elements content = doc.getElementsByClass("saved-price-green");
        //System.out.println(content);
        Elements price = content.first().getElementsByTag("i");
        
        for(Element e: price)
        {
            HBox priceHbox = new HBox();
            priceHbox.getChildren().add(priceMsg);
            root.setBottom(priceHbox);
            searchButton.setOnAction(new EventHandler<ActionEvent>(){
                @Override
                public void handle(ActionEvent event){
                    priceMsg.setText(make.valueProperty().get() + "\n" + year.valueProperty().get() + "\n" + "C63 AMG A/C Compressor All Models 60-04703 NA" + "\n" + "Price: " + e.text());
                }
            });
        }
        
    } catch (IOException e) {
	e.printStackTrace();
    }
    
    //combobox for model
    ComboBox model = new ComboBox();
    
    //combobox for part category
    ComboBox partCategory = new ComboBox();
    
    //combobox for part type
    ComboBox partType = new ComboBox();

    //combobox for part
    ComboBox part = new ComboBox();
    
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
