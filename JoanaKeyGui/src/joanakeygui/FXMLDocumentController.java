/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author holgerklein
 */
public class FXMLDocumentController implements Initializable {

    private JoanaView joanaView = new JoanaView(this);
    private Stage stage;

    @FXML
    private ComboBox<String> mainClassesCB;
    @FXML
    private AnchorPane srcSinkAP;

    @FXML
    public void onAddSrc() {
        System.out.println("add");
    }

    @FXML
    public void onRemoveSrc() {

    }

    @FXML
    public void onAddSink() {

    }

    @FXML
    public void onRemoveSink() {

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
        srcSinkAP.setDisable(true);
        mainClassesCB.setDisable(true);
        mainClassesCB.setOnAction((event) -> {
            joanaView.setCurrentMainClass(mainClassesCB.getSelectionModel().getSelectedItem());
        });

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    void letUserChooseMainClass(List<String> allClassesContainingMainMethod) {
        mainClassesCB.getItems().clear();
        mainClassesCB.getItems().addAll(allClassesContainingMainMethod);
        mainClassesCB.setDisable(false);
    }

    void letUserAddSinksAndSrcs() {
        srcSinkAP.setDisable(false);
    }

}
