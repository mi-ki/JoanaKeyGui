/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui.joanahandler;

/**
 *
 * @author holgerklein
 */
public class JoanaInstance {
    private String currentJarPath;
    private String currentJavaFolderPath;
    private String currentMainMethod;

    public JoanaInstance(String currentJarPath, String currentJavaFolderPath, String currentMainMethod) {
        this.currentJarPath = currentJarPath;
        this.currentJavaFolderPath = currentJavaFolderPath;
        this.currentMainMethod = currentMainMethod;
    }

    
}
