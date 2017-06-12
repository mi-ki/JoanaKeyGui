/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import joanakeygui.joanahandler.JoanaInstance;

/**
 *
 * @author holger
 */
public class SourceSinkAdderDialogHandler {
    
    private ListView<String> sourcesList;
    private ListView<String> sinkList;
    private List<Source> sources = new ArrayList<>();
    private List<Sink> sinks = new ArrayList<>();
    private JoanaInstance joanaInstance;
    AddSourceDialogController controller;
    
    public SourceSinkAdderDialogHandler(ListView<String> sourcesList, ListView<String> sinkList) throws IOException {
        this.sourcesList = sourcesList;
        this.sinkList = sinkList;
        FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("AddSourceDialog.fxml"));
        
        Parent root = fXMLLoader.load();
        controller = (AddSourceDialogController) fXMLLoader.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        controller.setStage(stage);
    }
    
    public void letUserAddSink(Stage parentStage) {
        controller.showForSink();
    }
    
    public void letUserAddSrc(Stage parentStage) {
        controller.showForSrc();
    }
    
    public void removeSelectedSrc() {
        
    }
    
    public void removeSelectedSink() {
        
    }
    
    void setJoanaInstance(JoanaInstance joanaInstance) {
        this.joanaInstance = joanaInstance;
        controller.setJoanaInstance(joanaInstance);
    }
    
}
