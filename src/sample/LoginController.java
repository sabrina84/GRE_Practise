:package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LoginController {

    private Main main;

    @FXML
    private TextField userText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button resetButton;

    @FXML
    private Button loginButton;

    @FXML
    public void loginAction(ActionEvent event) {
        /*String validUserName = "admin";
        String validPassword = "123";*/
        String userName = userText.getText();
        String password = passwordText.getText();
        BufferedReader br=null;
        ArrayList<String> al = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader("profile.csv"));
            String read = null;
            while ((read = br.readLine()) != null) {
                String[] splited = read.split(",");
                for (String part : splited) {
                    al.add(part);
                    // System.out.println(part);
                }
            }
        } catch (IOException e) {
            System.out.println("There was a problem: " + e);
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
            }
        }
        int flag=0;
        for(int k=0; k<al.size(); k+=2){
            String validUserName=al.get(k);
            String validPassword=al.get(k+1);
            if (userName.equals(validUserName) && password.equals(validPassword)) {
            // successful login
                try{
                    //main.showTableWindow();
                    main.showProfile(userName);
                    flag=1;
                    break;

                }catch(Exception e){

                }

            }
        }
        if(flag==0){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();
        }

    }

    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }

    void setLogin(Main main) {
        this.main = main;
    }

}
