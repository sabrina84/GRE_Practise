package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

/**
 * Created by ASUS on 12/9/2015.
 */
public class signinController {
    @FXML
    private Button sin;
    @FXML
    public TextField user;
    @FXML
    public PasswordField pass;
    @FXML
    public PasswordField repass;
    public Main main;

    @FXML
    public void Signin(ActionEvent e) throws Exception{
        String userName = user.getText();
        String password = pass.getText();
        String repassword = repass.getText();
        FileWriter fw = new FileWriter("profile.csv",true);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("\n"+userName+","+password);
        bw.close();
        fw.close();
        try {
            //Whatever the file path is.
            File statText = new File("E:/projects/termProject1/termProject1/"+userName+".csv");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write("POTATO!!!");
            w.close();
        } catch (IOException ex) {
            System.err.println("Problem writing to the file statsTest.txt");
        }

    }
    public void setSignin(Main main){
        this.main=main;
    }

}
