package com.zakioussama.treemerger;

import java.io.File;
import java.io.FileNotFoundException;
import org.apache.log4j.Logger;


/**
 *
 * @author Oussama Zaki
 */
public class TreeMerger {
    
    private static final Logger logger = Logger.getLogger("Main");
    private static Tree theTree;
    private static final String[] strs = {"./files/File1.txt", "./files/File2.txt"};
     
    public static void main(String[] args) {
        theTree = new Tree();
        Repository repository = new Repository(strs);
        for (File file : repository.getFiles()) {
            try{
                theTree.process(file);
                logger.info(file + " successuflly processes");
            }catch (Exception e){
                logger.info(e.getMessage());
            }
        }
        System.out.println(theTree);
        try {
            theTree.toFile("./files/Result.txt");
        } catch (FileNotFoundException ex) {
            logger.error("error writing into file");
        }
    }
}
