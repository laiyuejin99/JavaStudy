package io;

import java.io.*;

public class FileIOStreamTest {
    //input 就是从输入到程序里
    //output就是从程序内输出


    public static void main(String args[]) throws Exception {
//        FileIOStreamTest f = new FileIOStreamTest();
//        System.out.println(f.getClass().getResource(""));
        File file = new File(new File("").getAbsoluteFile(), "/src/main/java/io/test");
        InputStream io = new FileInputStream(file);
        byte[] buffer = new byte[200];
        int length = 0;

        //output
        File outFile = new File(file.getParent(), "output");
        OutputStream outputStream = new FileOutputStream(outFile);
        while (-1 != (length = io.read(buffer))) {
            String string = new String(buffer, 0, length);
            System.out.println(string);
            outputStream.write(buffer, 0, length);
        }
        io.close();
        outputStream.close();
    }
}
