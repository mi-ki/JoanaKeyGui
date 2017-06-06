/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package joanakeygui.JoanaHandler;

import joanakeygui.joanahandler.Helper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author holgerklein
 */
public class HelperTest {

    public HelperTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllClassesContainingMainMethod method, of class Helper.
     */
    @Test
    public void testGetAllClassesContainingMainMethod() {
        File f = new File("testdata/multipleClassesFalsePos");
        List<String> allClassesContainingMainMethod = Helper.getAllClassesContainingMainMethod(f);        
    }

    @Test
    public void testGetAllClassesInProj() {
        File f = new File("testdata/multipleClassesFalsePos");
        List<File> javaFiles = new ArrayList<>();
        Helper.getAllJaveFilesRec(f, javaFiles);
    }

}
