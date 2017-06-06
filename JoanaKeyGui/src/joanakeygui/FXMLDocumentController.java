/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author holgerklein
 */
public class FXMLDocumentController implements Initializable {

    private JoanaView joanaView = new JoanaView();
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void onChooseJarFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Jar file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Jar", "*.jar")
        );
        File chosenJarFile = fileChooser.showOpenDialog(stage);
        joanaView.setCurrentJarFile(chosenJarFile);
    }

    @FXML
    public void onChooseSrcFolder() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Navigate to source directory");
        File chosenSrcDir = directoryChooser.showDialog(stage);
        joanaView.setCurrentJavaFolderFile(chosenSrcDir);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
