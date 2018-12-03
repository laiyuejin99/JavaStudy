package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class RandomAccessTest {

    public static void main(String args[]) throws Exception {
        File file = new File(new File("").getAbsoluteFile(), "/src/main/java/io/test");

        RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rws");
        String str = "I like you";
        randomAccessFile.write(str.getBytes(),0,str.getBytes().length);
//        randomAccessFile.
//        randomAccessFile.write();
        randomAccessFile.close();
    }
}
