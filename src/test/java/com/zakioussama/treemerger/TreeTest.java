package com.zakioussama.treemerger;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 *
 * @author samsung
 */
public class TreeTest {

    private Tree theTree;

    public TreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        theTree = new Tree();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldThrow1() {
        try {
            theTree.process(new File("./files/test2.txt"));
        } catch (Exception exception) {
            String message = "line 1 not well formatted";
            assertEquals(message, exception.getMessage());
        }
    }
    
    @Test
    public void shouldThrow2() {
        try {
            theTree.process(new File("./files/test3.txt"));
        } catch (Exception exception) {
            String message = "line 1 weight error";
            assertEquals(message, exception.getMessage());
        }
    }
    
    @Test
    public void shouldThrow3() {
        try {
            theTree.process(new File("./files/test4.txt"));
        } catch (Exception exception) {
            String message = "line 1 no path found";
            assertEquals(message, exception.getMessage());
        }
    }
}
