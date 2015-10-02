package com.zakioussama.treemerger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileNotFoundException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author samsung
 */
public class RepositoryTest {

    private Repository repository;

    public RepositoryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        repository = new Repository();
    }

    @After
    public void tearDown() {
    }

    
    @Test
    public void addingNonExistingFile() {
        String file = "./files/test2.txt";
        repository.addFile(file);
        assertEquals(repository.size(), 0);
    }
    
    @Test
    public void addingExistingFile() {
        String file = "./files/test1.txt";
        repository.addFile(file);
        assertEquals(repository.size(), 1);
    }
}
