/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zakioussama.treemerger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author Oussama Zaki
 */
public class Repository {

    private final Logger logger = Logger.getLogger(this.getClass());

    private Set<File> files;

    public Repository() {
        files = new HashSet<>();
    }
    
    public Repository(final String[] paths) {
        files = new HashSet<>();

        for (String file : paths) {
                this.addFile(file);
        }
    }

    public Set<File> getFiles() {
        return files;
    }
    
    

    public final void addFile(final String path){
        try {
            File f = new File(path);
            if (f.exists() && f.isFile()) {
                files.add(f);
            }
        } catch (Exception e) {
            logger.error("Error occured while adding the file : " + path);
        }
    }
    
    public int size(){
        return files.size();
    }

}
