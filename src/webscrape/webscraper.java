/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, November 2021
*/
package webscrape;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class webscraper extends Application
{
    
    Stage window;
    Scene scene;
    Button searchButton;
    
    public static void main(String[] args){
      Application.launch(args); 
   }
    
    @Override
    public void start(Stage stage) throws IOException{	
        window = stage;
        window.setTitle("Car Part Webscraper");
        
        //search  button
        searchButton = new Button();
        searchButton.setText("Search");
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        //label outputs cheapest price, product info and seller's  website
        Label priceMsg = new Label();

        //combobox for make 
        ComboBox<String> make = new ComboBox();
        make.setPromptText("Select Make: ");
        ObservableList<String> makeList = make.getItems();

        //combobox for year
        ComboBox<String> year = new ComboBox();
        year.setPromptText("Select Year: ");
        ObservableList<String> yearList = year.getItems();

        makeList.add("MAZDA");
        makeList.add("MERCEDES-BENZ");

        make.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event){
                yearList.clear();

                if(make.valueProperty().get() == "MERCEDES-BENZ")
                {
                    yearList.add("2021");
                    yearList.add("2020");
                    yearList.add("2019");
                }
                if(make.valueProperty().get() == "MAZDA")
                {
                    yearList.add("2022");
                    yearList.add("2021");
                }
            }
        });

        HBox priceHbox = new HBox();
        
        //JSoup webscraping car part sellers for prices
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
                priceHbox.getChildren().add(priceMsg);
                
                searchButton.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        priceMsg.setText(make.valueProperty().get() + "\n" + year.valueProperty().get() + "\n" + "C63 AMG A/C Compressor All Models 60-04703 NA" + "\n" + "Price: " + e.text());
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        layout.getChildren().addAll(make);
        layout.getChildren().addAll(year);
        layout.getChildren().addAll(searchButton);
        layout.getChildren().addAll(priceHbox);

        scene = new Scene(layout, 500, 450);
        window.setScene(scene);
        window.show();
    }
    
    double cost = 0;
    List<Part> partList = new ArrayList<Part>();

    public void addPart(Part newPart)
    {
        partList.add(newPart);
    }
    
}

class Part
{
    public String name;
    public double price;
    
    public Part()
    {   //start constructor
        name = "";   //default values
        price = 0.00;
    } 

    public Part(String name, double price)
    {
        this.name=name;
        this.price=price;
    }

    public double getPrice()
    {
        return price;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
