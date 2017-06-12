/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui;

import edu.kit.joana.api.sdg.SDGProgramPart;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import joanakeygui.joanahandler.JoanaInstance;

/**
 * FXML Controller class
 *
 * @author holger
 */
public class AddSourceDialogController implements Initializable {

    @FXML
    private ComboBox<String> selectMethodCB;
    @FXML
    private ComboBox<String> selectionCB;

    private Stage stage;
    private JoanaInstance joanaInstance;

    private String[] addingMethods = {"programPart", "method"};

    public void setJoanaInstance(JoanaInstance joanaInstance) {
        this.joanaInstance = joanaInstance;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectMethodCB.getItems().addAll(addingMethods);
        selectMethodCB.valueProperty().addListener((observable) -> {
            selectionCB.getItems().clear();
            String selected = selectMethodCB.getSelectionModel().getSelectedItem();
            if (selected.equals("programPart")) {
                selectionCB.getItems().addAll(joanaInstance.getAllProgramPartsString());
            } else {
                selectionCB.getItems().addAll(joanaInstance.getAllMethodsString());
            }
        });
    }

    public void showForSink() {
        stage.showAndWait();
    }

    public void showForSrc() {
        stage.showAndWait();
    }

}
