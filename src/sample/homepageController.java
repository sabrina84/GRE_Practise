package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

/**
 * Created by ASUS on 12/9/2015.
 */
public class homepageController {
    @FXML
    private Button homelogin;
    @FXML
    private Button signin;
    public Main main;
    @FXML
    public void wantsToLogin(ActionEvent e) throws Exception{
        main.showloginWindow();
    }
    @FXML
    public void wantsToSignin(ActionEvent e) throws Exception{
        main.showSigninWindow();

    }
    public void setHome(Main main){
        this.main=main;
    }

}
