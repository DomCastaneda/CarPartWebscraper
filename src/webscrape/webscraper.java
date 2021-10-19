/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscrape;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class webscraper extends Application{
    public static void main(String[] args){
      Application.launch(args); 
   }
    
    @Override
    public void start(Stage stage) throws IOException{
      
      Document doc = Jsoup.connect("http://www.javatpoint.com").get();  
      String title = doc.title();  
      System.out.println("title is: " + title); 
        
    }
    double cost = 0;
    List<Part> partList = new ArrayList<Part>();

    public void addPart(Part newPart){
        partList.add(newPart);
    }
    
    //public void setCost(double cost) {this.cost = cost;}
    //public double getCost() {return this.cost;}
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
