package io;

import java.io.File;
//字节流与字符流 区别: 字符流是有缓存的 所以在结束时要flush，字符流只能处理char
//而字节流 能处理图像 文字 视频等
//https://blog.csdn.net/lwang_it/article/details/78886186
public class ReaderWriterTest {

    public static void main(String args[]) {
        File file = new File(new File("").getAbsoluteFile(), "/src/main/java/io/aObject");

    }
}
