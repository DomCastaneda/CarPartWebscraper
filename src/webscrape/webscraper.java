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

    private List<PartPrice> partList = new ArrayList<>();

    public void add(PartPrice item){

        partList.add(item);
    }

    public double getTotalCost(){
        for (PartPrice pricelist : partList) {
            cost += pricelist.getCost();
        }
        return cost;
    }
    
    //public void setCost(double cost) {this.cost = cost;}
    //public double getCost() {return this.cost;}
}
class PartPrice{
    String name;
    int quantity;
    double pricePerPart;

    PartPrice(String name, int quantity, double pricePerPart){
        this.name=name;
        this.quantity=quantity;
        this.pricePerPart=pricePerPart;
    }

    public double getCost(){
        return pricePerPart*quantity;
    }

    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
}
