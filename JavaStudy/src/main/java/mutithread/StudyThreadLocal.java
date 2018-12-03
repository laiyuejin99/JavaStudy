package mutithread;

import java.util.Random;

public class StudyThreadLocal {
    //我们要实现一个线程 有一个独立的类
    //首先我们可以使用HashMap<Thread,Data> 来实现
    //但是ThreadLocal是一个更优雅的实现方式


    public static void main(String args[]) {
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    System.out.println(Thread.currentThread() + "  " + Data.getInstance().data);
                }
            }.start();
        }

    }

    private static class Data {
        static ThreadLocal<Data> myThreadLocal = new ThreadLocal<>();
        int data;

        public static Data getInstance() {
            Data instance = myThreadLocal.get();
            if (instance == null) {
                instance = new Data();
                instance.data = new Random().nextInt();
                myThreadLocal.set(instance);
            }
            return instance;
        }

    }

}
