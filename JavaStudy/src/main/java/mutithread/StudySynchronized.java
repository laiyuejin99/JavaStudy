package mutithread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class StudySynchronized {
//    synchronized 关键字是锁定一个对象 或者 方法， 记住是单个对象，如果不同的对象是无法实现同步安全的

    //锁住单个对象  单个方法
    public synchronized void printSomething() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread() + "  " + i);
        }
    }

    //此方法也能成功 但是锁住了整个对象  不建议
    public void printSomething2() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "  " + i);
            }
        }
    }

    //更低效  锁住了整个类, 任意对象想执行这个方法 都会锁住整个类块
    public void printSomething3() {
        synchronized (StudySynchronized.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread() + "  " + i);
            }
        }
    }


    public static void main(String args[]) {
        //创建 5个线程同时执行 printSomething
        final StudySynchronized instance = new StudySynchronized();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {

                    instance.printSomething3();
                }
            };

            executor.execute(runnable);
        }
    }

}
