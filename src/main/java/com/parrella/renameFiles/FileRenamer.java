package com.parrella.renameFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRenamer {


    public static final String PATHNAME = "/Users/vincentparrella/Desktop/sys design";

    public static void main(String[] args) {
        File[] files =  new File(PATHNAME).listFiles();
        Arrays.sort(files, org.apache.commons.io.comparator.LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
        Stream.of(files)
           .filter(file -> !file.isDirectory())
           .map(file -> {
               String fileName = file.getName();
               int end = fileName.indexOf(" - Grokking");
               if (end > 0) {
                   fileName = fileName.substring(0, end);
               }
               return PATHNAME + "/" + fileName;
           })
           .collect(Collectors.toSet())
                .forEach(System.out::println);
        // just need to add the call where files are actually renamed
    }
}
