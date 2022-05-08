package turboparts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Settings Controller class
 *
 * @author jaepark
 */


public class SettingsController implements Initializable 
{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    @FXML
    private Button confirm;
    
    @FXML 
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML 
    private ComboBox comboBox;
    
    public void switchToSearch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
        
        /* scene switch */
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void switchToLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LogInPage.fxml"));
        
        /* scene switch */
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!username.getText().trim().isEmpty() && !password.getText().trim().isEmpty()) {
                    DBUtils.updateUser(event, username.getText(), password.getText());
                }  else {
                    System.out.println("Please fill in all information.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in username and password.");
                    alert.show();
                }
            }
        });
    }
}

//class ComboBoxExperiments extends Application  
//{
//
//
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        primaryStage.setTitle("ComboBox Experiment 1");
//
//        ComboBox comboBox = new ComboBox();
//
//        comboBox.getItems().add("Choice 1");
//        comboBox.getItems().add("Choice 2");
//        comboBox.getItems().add("Choice 3");
//
//
//        HBox hbox = new HBox(comboBox);
//
//        Scene scene = new Scene(hbox, 200, 120);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }
//
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//}

class changeUser{
    public String username;
    public String newUsername;
    public changeUser() {
        username = "";
        newUsername = "";
    }
    public changeUser(String username, String newUsername) {
        this.username = username;
        this.newUsername = newUsername;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNewUsername() {
        return newUsername;
    }
    public void SetNewUsername(String newUsername){
        this.newUsername = newUsername;
    }
}
