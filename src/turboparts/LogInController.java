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
public class LogInController implements Initializable
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
    private Label errorMessageLabel;
    private String errorMessage = "";
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private boolean isFieldFilled()
    {
        boolean isFilled = true;
        if(email.getText().isEmpty())
        {
            isFilled = false;
            errorMessage = "Fill in Email Address";
        }
        
        if(fullname.getText().isEmpty())
        {
            isFilled = false;
            errorMessage = "Fill in Full Name";
        }
        
        if(password.getText().isEmpty())
        {
            isFilled = false;
            if(errorMessage.isEmpty())
            {
                errorMessage = "Password is empty";
            }
            else{
                errorMessage += "\nPassword is empty";
            }
        }
        errorMessageLabel.setText(errorMessage);
        return isFilled;
    }
    
    
    private boolean isValid()
    {
        boolean isValid = false;
        if(email.getText().equals(TurboParts.EMAIL))
        {
            isValid = true;
            errorMessage = "Invalid Email";
        }
        
        if(fullname.getText().equals(TurboParts.NAME))
        {
            isValid = true;
            errorMessage = "Invalid Name";
        }
        
        if(password.equals(TurboParts.PASSWORD))
        {
            isValid = false;
            if(errorMessage.isEmpty())
            {
                errorMessage = "Invalid Password";
            }
            else{
                errorMessage += "\nInvalid Password";
            }
        }
        errorMessageLabel.setText(errorMessage);
        
        if(isValid == true){
            btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event)
                {
                    errorMessage = "";
                    if(isFieldFilled() && isValid())
                    {
                        //do something;
                    }
                }
            }); 
        }
        return isValid;
    }
    
    public void switchToSearch(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchPage.fxml"));
        
        /* scene switch */
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        /* btnClose.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                System.exit(0);
            }
        }); 
        */
        
        /* btnLogin.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                errorMessage = "";
                if(isFieldFilled() && isValid())
                {
                    //do something;
                }
            }
    }); 
    */
    }
}