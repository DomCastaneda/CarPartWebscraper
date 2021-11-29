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
import javafx.scene.control.Hyperlink;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class webscraper extends Application
{
    
    Stage window;
    Scene scene;
    Button searchButton;
    String htmlBAP = "https://www.buyautoparts.com/buynow/2019/mercedes-benz/a220/tire_pressure_monitoring_system_sensor_tpms/73-70485_fnmr";
    String htmlAAP = "https://shop.advanceautoparts.com/p/huf-north-america-intellisens-universal-tpms-sensor-433mhz-metal-valve-included-uvs4040/11925017-P";
    String outputTitleString = "";
    HBox outputHbox = new HBox();
    Hyperlink partLink = new Hyperlink("Seller's Website");
    
    double priceBAP = 0.0;
    double priceAAP = 0.0;
    
    public static void main(String[] args){
      Application.launch(args); 
   }
    
    @Override
    public void start(Stage stage) throws IOException
    {	
        window = stage;
        window.setTitle("Car Part Webscraper");
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        //search  button
        searchButton = new Button();
        searchButton.setText("Search");
        
        //combobox for make 
        ComboBox<String> make = new ComboBox();
        make.setPromptText("Select Make: ");
        ObservableList<String> makeList = make.getItems();

        //combobox for year
        ComboBox<String> year = new ComboBox();
        year.setPromptText("Select Year: ");
        ObservableList<String> yearList = year.getItems();
        
        //combobox for model
        ComboBox<String> model = new ComboBox();
        model.setPromptText("Select Model: ");
        ObservableList<String> modelList = model.getItems();
        
        //combobox for part
        ComboBox<String> part = new ComboBox();
        part.setPromptText("Select Part: ");
        ObservableList<String> partList = part.getItems();
        
        //adds make to initial combobox
        makeList.add("MAZDA");
        makeList.add("MERCEDES-BENZ");

        //updates yearList once make is selected
        make.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                yearList.clear();
                
                ////=================[MERCEDES-BENZ YEARS]=================
                //outputs year from chosen make
                if(make.valueProperty().get() == "MERCEDES-BENZ")
                {
                    yearList.add("2019");
                    yearList.add("2018");
                }
                
                ////=================[MAZDA YEARS]=================
                //outputs year from chosen make
                if(make.valueProperty().get() == "MAZDA")
                {
                    yearList.add("2019");
                    yearList.add("2018");
                }
            }
        });
        
        //updates modelList once year is selected
        year.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
             public void handle(ActionEvent event)
             {
                modelList.clear();
            
                ////=================[2019 MERCEDES-BENZ MODELS]=================
                //outputs model from chosen make and years
                if(make.valueProperty().get() == "MERCEDES-BENZ" && year.valueProperty().get() == "2019")
                {
                    modelList.add("A220");
                    modelList.add("AMG GT");
                }
                ////=================[2018 MERCEDES-BENZ MODELS]=================
                //outputs model from chosen make and years
                if(make.valueProperty().get() == "MERCEDES-BENZ" && year.valueProperty().get() == "2018")
                {
                    modelList.add("AMG GT");
                    modelList.add("AMG GT C");
                }
                
                ////=================[2019 MAZDA MODELS]=================
                //outputs model from chosen make and years
                if(make.valueProperty().get() == "MAZDA" && year.valueProperty().get() == "2019")
                {
                    modelList.add("CX-3");
                    modelList.add("CX-5");
                }
                ////=================[2018 MAZDA MODELS]=================
                //outputs model from chosen make and years
                if(make.valueProperty().get() == "MAZDA" && year.valueProperty().get() == "2018")
                {
                    modelList.add("3");
                    modelList.add("6");
                }
             }
        });
        
        //updates partList once model is selected
        model.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
             public void handle(ActionEvent event)
             {
                partList.clear();
            
                ////=================[2019 MERCEDES-BENZ A220 Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2019" && model.valueProperty().get() == "A220")
                {
                    partList.add("Tire Pressure Monitoring System Sensor");
                }
                
                ////=================[2019 MERCEDES-BENZ AMG GT Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2019" && model.valueProperty().get() == "AMG GT")
                {
                    partList.add("Tire Pressure Monitoring System Sensor");
                }
                
                ////=================[2018 MERCEDES-BENZ AMG GT Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2018" && model.valueProperty().get() == "AMG GT")
                {
                    partList.add("Brake Pad Set");
                }
                
                ////=================[2018 MERCEDES-BENZ AMG GT C Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2018" && model.valueProperty().get() == "AMG GT C")
                {
                    partList.add("Starter");
                }
                
                ////=================[2019 MAZDA CX-3 Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2019" && model.valueProperty().get() == "CX-3")
                {
                    partList.add("A/C Compressor");
                }
                
                ////=================[2019 MAZDA CX-5 Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2019" && model.valueProperty().get() == "CX-5")
                {
                    partList.add("A/C Compressor");
                }
                
                ////=================[2018 MAZDA 3 Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2018" && model.valueProperty().get() == "3")
                {
                    partList.add("Rack and Pinion");
                }
                
                ////=================[2018 MAZDA 6 Parts]=================
                //outputs part from chosen year and model
                if(year.valueProperty().get() == "2018" && model.valueProperty().get() == "6")
                {
                    partList.add("A/C Compressor");
                }
             }
        });
        //updates Jsoup urls once search is selected
        part.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
             public void handle(ActionEvent event)
             {
                ////=================[2019 MERCEDES-BENZ A220 Parts]=================
                if(model.valueProperty().get() == "A220" && part.valueProperty().get() == "Tire Pressure Monitoring System Sensor")
                {
                    //checks buyautoparts website pricing
                    htmlBAP = "https://www.buyautoparts.com/buynow/2019/mercedes-benz/a220/tire_pressure_monitoring_system_sensor_tpms/73-70485_fnmr";
                    htmlAAP = "https://shop.advanceautoparts.com/p/huf-north-america-intellisens-universal-tpms-sensor-433mhz-metal-valve-included-uvs4040/11925017-P";
                    
                    outputPriceBAP();
                    outputPriceAAP();
                }
                
                ////=================[2019 MERCEDES-BENZ AMG GT Parts]=================
                if(model.valueProperty().get() == "AMG GT" && part.valueProperty().get() == "Tire Pressure Monitoring System Sensor")
                {
                    //checks buyautoparts website pricing
                    htmlBAP = "https://www.buyautoparts.com/buynow/2019/mercedes-benz/amg_gt/tire_pressure_monitoring_system_sensor_tpms/73-70426_fnmr?xref=152929232";
                    htmlAAP = "https://shop.advanceautoparts.com/p/huf-north-america-oe-funct-tpms-433mhz-rde036v21/12339110-P?searchTerm=2019+Mercedes+Benz+AMG+GT+TPMS";

                    outputPriceBAP();
                    outputPriceAAP();
                }
                
                ////=================[2018 MERCEDES-BENZ AMG GT Parts]=================
                if(model.valueProperty().get() == "AMG GT" && part.valueProperty().get() == "Brake Pad Set")
                {
                    htmlBAP = "https://www.buyautoparts.com/buynow/2018/mercedes-benz/amg_gt/brake_pad_set/70-07414_bhkq";
                    htmlAAP = "https://shop.advanceautoparts.com/p/carquest-professional-platinum-semi-metallic-brake-pads-rear-4-pad-set-pmd1681h/10866442-P?searchTerm=2018+Mercedes+Benz+AMG+GT+Brake+Pad+Set";
                    
                    outputPriceBAP();
                    outputPriceAAP();
                }
                
                ////=================[2018 MERCEDES-BENZ AMG GT C Parts]=================
                if(model.valueProperty().get() == "AMG GT C" && part.valueProperty().get() == "Starter")
                {
                    htmlBAP = "https://www.buyautoparts.com/buynow/2018/mercedes-benz/amg_gt_c/starter/30-05815_an";
                    htmlAAP = "https://shop.advanceautoparts.com/p/carquest-premium-starter-remanufactured-52080s/11888517-P?searchTerm=2018+Mercedes+Benz+AMG+GT+C+Starter";
                    
                    outputPriceBAP(); 
                    outputPriceAAP();
                }
                
                ////=================[2019 MAZDA CX-3 Parts]=================
                if(model.valueProperty().get() == "CX-3" && part.valueProperty().get() == "A/C Compressor")
                {
                    htmlBAP = "https://www.buyautoparts.com/buynow/2019/mazda/cx-3/a-c_compressor/60-04633_nc";
                    htmlAAP = "https://shop.advanceautoparts.com/p/carquest-premium-new-compressor-with-clutch-gm-a6-t58047/20897902-P?searchTerm=2019+Mazda+CX-3+A%2FC+Compressor";
                    
                    outputPriceBAP(); 
                    outputPriceAAP();
                }
                
                ////=================[2019 MAZDA CX-5 Parts]=================
                if(model.valueProperty().get() == "CX-5" && part.valueProperty().get() == "A/C Compressor")
                {
                    htmlBAP = "https://www.buyautoparts.com/buynow/2019/mazda/cx-5/a-c_compressor/60-03943_na";
                    htmlAAP = "https://shop.advanceautoparts.com/p/red-dot-a-c-a-c-compressor-12-volt-que-a-c-compressor-w-clutch-replacement-for-sanden-1027t6-75r89582q/11279032-P?searchTerm=2019+Mazda+CX-5+A%2FC+Compressor";
                    
                    outputPriceBAP(); 
                    outputPriceAAP();
                }
                
                ////=================[2018 MAZDA 3 Parts]=================
                if(model.valueProperty().get() == "3" && part.valueProperty().get() == "Rack and Pinion")
                {
                    htmlBAP = "https://www.buyautoparts.com/buynow/2018/mazda/3/rack_and_pinion/80-70399_r";
                    htmlAAP = "https://shop.advanceautoparts.com/p/cardone-rack-and-pinion-assembly-1g-2009/12043173-P?searchTerm=Rack+and+Pinion";
                    
                    outputPriceBAP(); 
                    outputPriceAAP();
                }
                ////=================[2018 MAZDA 6 Parts]=================
                if(model.valueProperty().get() == "6" && part.valueProperty().get() == "A/C Compressor")
                {
                    htmlBAP = "https://www.buyautoparts.com/buynow/2018/mazda/6/a-c_compressor/60-03942_nc";
                    htmlAAP = "https://shop.advanceautoparts.com/p/mando-new-oe-ac-compressor-with-clutch-pre-filled-oil-direct-replacement-10a1441/12217827-P?searchTerm=A%2FC+Compressor";
                    
                    outputPriceBAP(); 
                    outputPriceAAP();
                }
             }
        });
        
        //updates link to seller based on cheaper website
        partLink.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try {
                    if(priceBAP < priceAAP)
                    {  
                        Desktop.getDesktop().browse(new URL(htmlBAP).toURI());
                    }
                    if(priceAAP < priceBAP)
                    {
                        Desktop.getDesktop().browse(new URL(htmlAAP).toURI());
                    }
                } catch (Exception e) {}
            }
        });
      
        //adds ui elements to layout
        layout.getChildren().addAll(make);
        layout.getChildren().addAll(year);
        layout.getChildren().addAll(model);
        layout.getChildren().addAll(part);
        layout.getChildren().addAll(searchButton);
        layout.getChildren().addAll(outputHbox);
        layout.getChildren().addAll(partLink);
        
        //scene setup
        scene = new Scene(layout, 500, 350);
        window.setScene(scene);
        window.show();
    }
    
    //finds cheapest of three websites
    public static double min(double web1, double web2) 
    {
        return Math.min(web1, web2);
    }
    
    //outputs price for BUYAUTOPARTS
    public void outputPriceBAP()
    {
        //label outputs cheapest price, product info and seller's  website
        Label outputPrice = new Label();
        
        //clear outputHbox
        outputHbox.getChildren().clear();

        //JSoup webscraping car part sellers for prices

        try {
            //get Document object after parsing the html from given url
            Document doc = Jsoup.connect(htmlBAP).get();

            //get title from document object
            String title = doc.title();
            Elements titleContent = doc.getElementsByClass("cad_header");
            Elements partTitleElement = titleContent.first().select("span[itemprop]");
            for(Element e: partTitleElement)
            {  
                outputTitleString = "Part: " + e.text();
            }

            //get price for particular element
            Elements priceContent = doc.getElementsByClass("saved-price-green");
            Elements price = priceContent.first().getElementsByTag("i");

            for(Element e: price)
            {
                outputHbox.getChildren().add(outputPrice);
                
                //makes element e to a String
                String elementToString = e.text().toString();
                
                //remove $ from elementToString for parsing
                String priceString = elementToString.replace("$", "");
                System.out.println("Buy Auto Parts: " + priceString);
                
                //parses priceString
                priceBAP = Double.parseDouble(priceString);
                
                searchButton.setOnAction(new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        outputPrice.setText(outputTitleString + "\n" +
                                "Cheapest Price: $" + min(priceBAP, priceAAP));
                    }
                });
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //outputs price for BUYAUTOPARTS
    public void outputPriceAAP()
    {
        //label outputs cheapest price, product info and seller's  website
        Label outputPrice = new Label();
        
        //clear outputHbox
        //outputHbox.getChildren().clear();

        //JSoup webscraping car part sellers for prices

        try {
            //get Document object after parsing the html from given url
            Document doc = Jsoup.connect(htmlAAP).get();

            //get price for particular element
            Elements priceContent = doc.getElementsByClass("css-fr1cma");
            outputHbox.getChildren().add(outputPrice);

            //remove $ from elementToString for parsing
            String elementToString = priceContent.text().toString();
                
            //remove $ from elementToString for parsing
            String priceString = elementToString.replace("Special Offers $", "");
            System.out.println("Advance Auto Parts: " + priceString);

            //parses priceString
            priceAAP = Double.parseDouble(priceString);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
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
