/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import joanakeygui.joanahandler.JoanaInstance;

/**
 *
 * @author holgerklein
 */
public class FXMLDocumentController implements Initializable {

    private JoanaView joanaView = new JoanaView(this);
    private SourceSinkAdderDialogHandler sourceSinkAdderDialogHandler;
    private Stage stage;

    private ListView<String> sourcesList;
    private ListView<String> sinkList;
    private JoanaInstance joanaInstance;

    @FXML
    private ComboBox<String> mainClassesCB;
    @FXML
    private AnchorPane srcSinkAP;
    @FXML
    private TextField javaPathText;
    @FXML
    private TextField jarPathText;

    @FXML
    public void onAddSrc() {
        sourceSinkAdderDialogHandler.letUserAddSrc(stage);
    }

    @FXML
    public void onRemoveSrc() {
        sourceSinkAdderDialogHandler.removeSelectedSrc();
    }

    @FXML
    public void onAddSink() {
        sourceSinkAdderDialogHandler.letUserAddSink(stage);
    }

    @FXML
    public void onRemoveSink() {
        sourceSinkAdderDialogHandler.removeSelectedSink();
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
        try {
            sourceSinkAdderDialogHandler = new SourceSinkAdderDialogHandler(sourcesList, sinkList);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean debug = true;
        if (debug) {
            joanaView.setCurrentJarFile(new File("testdata/multipleClassesFalsePos/MultipleClassesFalsePos/dist/MultipleClassesFalsePos.jar"));
            joanaView.setCurrentJavaFolderFile(new File("testdata/multipleClassesFalsePos/MultipleClassesFalsePos/src"));
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    void letUserChooseMainClass(List<String> allClassesContainingMainMethod) {
        mainClassesCB.getItems().clear();
        mainClassesCB.getItems().addAll(allClassesContainingMainMethod);
        mainClassesCB.setDisable(false);
    }

    void letUserAddSinksAndSrcs(JoanaInstance joanaInstance) {
        this.joanaInstance = joanaInstance;
        sourceSinkAdderDialogHandler.setJoanaInstance(joanaInstance);
        srcSinkAP.setDisable(false);
    }

    void setJarPAth(String absolutePath) {
        jarPathText.setText(absolutePath);
    }

    void setFolderPath(String absolutePath) {
        javaPathText.setText(absolutePath);
    }

}
