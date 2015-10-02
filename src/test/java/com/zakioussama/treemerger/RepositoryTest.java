package com.zakioussama.treemerger;


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
