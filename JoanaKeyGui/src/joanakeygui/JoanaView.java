/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui;

import java.io.File;

/**
 *
 * @author holgerklein
 */
public class JoanaView {

    private File currentJarFile;
    private File currentJavaFolderFile;
    private String currentMainClass;

    public void setCurrentJarFile(File currentJarFile) {
        this.currentJarFile = currentJarFile;
    }

    public void setCurrentJavaFolderFile(File currentJavaFolderFile) {
        this.currentJavaFolderFile = currentJavaFolderFile;
    }

    public void setCurrentMainClass(String currentMainClass) {
        this.currentMainClass = currentMainClass;
    }

   
    
    
}
