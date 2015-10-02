package com.zakioussama.treemerger;

import java.io.File;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Repository class, represent a set of file to be processed
 * 
 * @author Oussama Zaki
 */
public class Repository {

    private final Logger logger = Logger.getLogger(this.getClass());

    private Set<File> files;

    /**
     * Default Constructor, initiliaze en empty set
     * 
     */
    public Repository() {
        files = new HashSet<>();
    }
    
    /**
     * Constructor with a list of paths
     * 
     * @param paths array of strings 
     */
    public Repository(final String[] paths) {
        files = new HashSet<>();
        
        for (String file : paths) {
                this.addFile(file);
        }
    }

    /**
     * get the site of files
     * 
     * @return Set<this.class>
     */
    public Set<File> getFiles() {
        return files;
    }
    
    
    /**
     * add a file to the set
     * 
     * @param path the file path
     */
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
    
    /**
     * return the number of files in the set
     * 
     * @return int
     */
    public int size(){
        return files.size();
    }

}
