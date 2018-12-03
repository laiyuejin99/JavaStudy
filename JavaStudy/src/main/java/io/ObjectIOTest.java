package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
就是object的序列化反序列化
类必须继承Serializable 接口
 */

public class ObjectIOTest implements Serializable {
    int id;
    String name;
    int age;

    public ObjectIOTest(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static void main(String args[]) throws Exception {
        File file = new File(new File("").getAbsoluteFile(), "/src/main/java/io/aObject");
        ObjectIOTest objectIO = new ObjectIOTest(1, "jin", 22);


        List<ObjectIOTest> data = new ArrayList<ObjectIOTest>();
        data.add(new ObjectIOTest(1, "jinjin2", 33));
        data.add(new ObjectIOTest(2, "jinjin3", 33));
        data.add(new ObjectIOTest(3, "jinjin4", 33));

        //写到文件
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(data);
        //读出
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        List<ObjectIOTest> readObject = (List<ObjectIOTest>) objectInputStream.readObject();//read object
        System.out.println(readObject.get(0).name);
        objectInputStream.close();
        objectOutputStream.close();

    }
}
