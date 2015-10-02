package com.zakioussama.treemerger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 *
 * @author Oussama Zaki
 */
public class Tree {

    private final Logger logger = Logger.getLogger(this.getClass());

    public final Pattern weightSeparator = Pattern.compile(" : ");
    public final Pattern pathSeparator = Pattern.compile("\\.|\\/");

    SortedMap<String, Integer> tree;

    /**
     * Constructor
     *
     */
    public Tree() {
        SortedMap<String, Integer> map = new TreeMap<>();
        this.tree = (SortedMap) Collections.synchronizedSortedMap(map);
    }

    /**
     * merge a file in a tree
     *
     * @param file
     * @throws java.lang.Exception
     */
    public void process(File file) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int lineCount = 0;
            while ((line = br.readLine()) != null) {
                lineCount++;
                final String[] path_weight = weightSeparator.split(line);

                if (path_weight.length != 2) {
                    //logger.error("line " + lineCount + " not well formatted");
                    throw new Exception("line " + lineCount + " not well formatted");
                }

                if (!Util.tryParseInt(path_weight[1])) {
                    //logger.error("line " + lineCount + " weight error");
                    throw new Exception("line " + lineCount + " weight error");
                }

                if (Util.isBlank(path_weight[0])) {
                    //logger.error("line " + lineCount + " no path found");
                    throw new Exception("line " + lineCount + " no path found");
                }

                int weight = Integer.parseInt(path_weight[1]);
                final String[] nodes = pathSeparator.split(path_weight[0]);

                int size = nodes.length;

                for (int i = 0; i < nodes.length; i++) {
                    if (Util.isBlank(nodes[i])) {
                        logger.warn("line " + lineCount + " found a umpty node, skipped!");
                        continue;
                    }
                    if (i != 0) {
                        nodes[i] = Util.concatPath(nodes[i - 1], nodes[i], '/');
                    }
                    if (tree.containsKey(nodes[i])) {
                        tree.put(nodes[i], tree.get(nodes[i]) + weight);
                    } else {
                        tree.put(nodes[i], weight);
                    }
                }
            }
        } catch (IOException e) {
            //logger.error("File is broken");
            throw new Exception("File is broken");
        }
    }
    
    /**
     * convert the tree to a string
     *
     * @return a string
     */
    @Override
    public String toString() {
        String res = "";
        for (SortedMap.Entry<String, Integer> entry : tree.entrySet()) {
            res += entry.getKey() + " : " + entry.getValue() + "\n";
        }
        return res;
    }

    /**
     * print the tree in a file
     *
     * @param path
     * @throws java.io.FileNotFoundException
     */
    public void toFile(String path) throws FileNotFoundException {
        File file = new File(path);
        try (PrintWriter printWriter = new PrintWriter(file)) {
            for (SortedMap.Entry<String, Integer> entry : tree.entrySet()) {
                printWriter.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }
}
