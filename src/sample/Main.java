package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
    Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showHomeWindow();
    }
    public void showTableWindow() throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("WordList.fxml"));
        Parent root = loader.load();
        wordListController wordlist = loader.getController();
        wordlist.setWordlist(this);
    }

    public void showloginWindow() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        LoginController login = loader.getController();
        login.setLogin(this);
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
    public void showSigninWindow() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("sign in.fxml"));
        Parent root = loader.load();
        signinController sign= loader.getController();
        sign.setSignin(this);
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
    public void showHomeWindow() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        homepageController home= loader.getController();
        home.setHome(this);
        stage.setTitle("Client");
        stage.setScene(new Scene(root, 400, 400));
        stage.show();
    }
    public void showProfile(String userName){
        FlowPane pane = new FlowPane();
        Label usernameLabel = new Label(userName);
        pane.getChildren().add(usernameLabel);

        Scene scene = new Scene(pane, 200, 100);
        stage.setScene(scene);
        stage.setTitle("Hello, " + userName);
        stage.show();
    }

    /*public void showProfileWindow() throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("messageBox.fxml"));
        Parent root = loader.load();
        ProfileCOntroller controller = loader.getController();
        stage.setTitle("");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }*/


    /*Stage stage;
    Parent parent;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        showWordList();
        //primaryStage.show();
    }

    public void showWordList() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("wordList.fxml"));
        stage.setTitle("Word list");
        stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
