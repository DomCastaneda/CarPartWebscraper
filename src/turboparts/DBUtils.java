/*
* Copyright (C) Dominic Castaneda - All Rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited 
* Proprietary and confidential
* Written by Dominic Castaneda <dcastaneda2828@gmail.com>, April 2022
* References: WittCode JavaFX Login and Signup Form with Database Connection
*/
package turboparts;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class DBUtils {
    public static void signUpUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;
        Parent root = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-accounts?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "toor");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            psCheckUserExists.setString(1, username);
            resultSet = psCheckUserExists.executeQuery();
            
            if(resultSet.isBeforeFirst()) {
                System.out.println("User Already Exists.");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setGraphic(null);
                alert.setContentText("That username already exists.");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                psInsert.setString(1, username);
                psInsert.setString(2, password);
                psInsert.executeUpdate();
                
                Alert welcome = new Alert(AlertType.INFORMATION);
                welcome.setGraphic(null);
                welcome.setHeaderText(null);
                welcome.setContentText("Welcome " + username + "!");
                welcome.show();
                
                try {
                    FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("SearchPage.fxml"));
                    root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root, 980, 683));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch(SQLException e) {
            
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Parent root = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx-accounts?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "toor");
            preparedStatement = connection.prepareStatement("SELECT password FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User not found.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect.");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                       try {
                            Alert welcome = new Alert(AlertType.INFORMATION);
                            welcome.setGraphic(null);
                            welcome.setHeaderText(null);
                            welcome.setContentText("Welcome " + username + "!");
                            welcome.show();
                            
                            FXMLLoader loader = new FXMLLoader(DBUtils.class.getResource("SearchPage.fxml"));
                            root = loader.load();
                            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            stage.setScene(new Scene(root, 980, 683));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    } else {
                        System.out.println("Passwords did not match.");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided password is incorrect.");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
