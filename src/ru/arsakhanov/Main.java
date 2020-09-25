package ru.arsakhanov;

import java.io.File;

public class Main {
   public static void main(String[] args) throws Exception {

        Compil javac = new Compil();
        File myClassFile = javac.getJavac();
        StartClass startClass = new StartClass();
        startClass.start(myClassFile);
    }
}
