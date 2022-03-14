/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, November 2021
*/
package turboparts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SettingsController implements Initializable {
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToSearch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
        
        /* scene switch */
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToSaved(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SavedPage.fxml"));
        
        /* scene switch */
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
