package sample;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.scene.control.TableView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class wordListController {
    @FXML
    private TableView tableView;

    @FXML
    private Button buttonA;
    public Main main;

    public void initializeColumns() {
        TableColumn<Words, String> keyCol = new TableColumn<>("Word");
        keyCol.setMinWidth(100);
        keyCol.setCellValueFactory(new PropertyValueFactory<>("key"));
        keyCol.setCellFactory(TextFieldTableCell.<Words>forTableColumn());

        TableColumn<Words, String> meanCol = new TableColumn<>("Meaning");
        meanCol.setMinWidth(100);
        meanCol.setCellValueFactory(new PropertyValueFactory<>("meaning"));
        meanCol.setCellFactory(TextFieldTableCell.<Words>forTableColumn());

        TableColumn<Words, String> synCol = new TableColumn<>("Synonym");
        synCol.setMinWidth(200);
        synCol.setCellValueFactory(new PropertyValueFactory<>("synonym"));
        synCol.setCellFactory(TextFieldTableCell.<Words>forTableColumn());

        TableColumn<Words, String> actionCol2 = new TableColumn<>("Select");
        actionCol2.setCellValueFactory(new PropertyValueFactory<>("select"));
        Callback<TableColumn<Words, String>, TableCell<Words, String>> cellFactory =
                new Callback<TableColumn<Words, String>, TableCell<Words, String>>() {
                    @Override
                    public TableCell call(final TableColumn<Words, String> param) {
                        final TableCell<Words, String> cell = new TableCell<Words, String>() {
                            final Button btn2 = new Button("Select");

                            @Override
                            public void updateItem(String item, boolean empty) {
                                // action of 'Select' button click
                                btn2.setOnAction((ActionEvent event) -> {
                                           Words person = getTableView().getItems().get(getIndex());
                                            String name = person.getKey() + " Meaning " + person.getMeaning() + "" + person.getSynonym();
                                            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                                            a.setContentText(name);
                                            a.showAndWait();
                                        }
                                );
                                setGraphic(btn2);
                                setText(null);
                            }
                        };
                        return cell;
                    }
                };
        actionCol2.setCellFactory(cellFactory);


        TableColumn<Words, String> actionCol = new TableColumn<>("Save");
        actionCol.setCellValueFactory(new PropertyValueFactory<>("save"));

        cellFactory = new Callback<TableColumn<Words, String>, TableCell<Words, String>>() {
            @Override
            public TableCell call(final TableColumn<Words, String> param) {
                final TableCell<Words, String> cell = new TableCell<Words, String>() {
                    final Button btn = new Button("Save");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        // action of 'Select' button click
                        btn.setOnAction((ActionEvent event) -> {

                                }
                        );
                        setGraphic(btn);
                        setText(null);
                    }
                };
                return cell;
            }
        };
        actionCol.setCellFactory(cellFactory);

        tableView.getColumns().addAll(keyCol, meanCol,synCol,actionCol,actionCol2);
    }

    @FXML
    void AbuttonAction(ActionEvent event) {
        initializeColumns();

        BufferedReader br=null;
        ArrayList<String> al = new ArrayList<>();
  	/*FileReader fr = new FileReader("wordlist.csv");
  	BufferedReader br=new BufferedReader(fr);
  	while(true)
  	{
  		String s=br.readLine();
  		if(s==null) break;
  		System.out.println (s);
  	}
  	br.close();
  	fr.close();*/
        try {
            br = new BufferedReader(new FileReader("wordlist.csv"));
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
        final ObservableList<Words> data = FXCollections.observableArrayList();
        for(int k=0; k<al.size(); k+=3){
            data.add(new Words(al.get(k),al.get(k+1), al.get(k+2)));
        }
        //data.addAll();
        //tableView.setEditable(true);
        tableView.setItems(data);

    }
    public void setWordlist(Main main){
        this.main=main;
    }
}