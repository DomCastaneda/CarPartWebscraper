package turboparts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author jaepark
 */
public class SignUpController implements Initializable
{
    @FXML
    private Label label;
   
    @FXML 
    private Pane content;
    
    @FXML 
    private TextField email;
    
    @FXML
    private TextField fullname;
    
    @FXML 
    private PasswordField password;
    
    @FXML
    private Button btnClose;
    
    @FXML
    private Button btnLogin;  
    
    @FXML
    private Button btnSignUp;
    
    @FXML 
    private Label errorMessageLabel;
    private String errorMessage = "";
    
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
        btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!email.getText().trim().isEmpty() && !password.getText().trim().isEmpty()) {
                    DBUtils.signUpUser(event, email.getText(), password.getText());
                }  else {
                    System.out.println("Please fill in all information.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in username and password to sign up.");
                    alert.show();
                }
            }
        });
    }
}