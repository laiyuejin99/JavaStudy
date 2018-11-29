package mutithread;

public class StudyNotify {
    //这里我们实现 线程相互切换的问题
    //子线程循环10次，主线程循环10次 然后 子线程再循环10次 主线程20次  重复50遍
    // 需要唤醒wait的线程就需要使用 notify 方法 而且需要在用到while
    //记住 要用上 synchronized 关键字

    public static class Business {
        boolean canSubThread = true;

        public synchronized void subThreadLoop(int time) {
            while (!canSubThread) { //用while 的目的可以看下源码，他可以防止假唤醒
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("Sub Thread：" + time + " --" + Thread.currentThread() + "  " + i);
            }
            canSubThread = false;
            this.notify();//唤醒等待线程

        }


        public synchronized void mainThreadLoop(int time) {
            while (canSubThread) {//
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("main Thread:" + time + " -- " + Thread.currentThread() + "  " + i);

            }
            canSubThread = true;
            this.notify();//唤醒等待线程
            this.notifyAll();//唤醒等待线程
        }
    }


    public static void main(String argsp[]) {
        final Business business = new Business();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    business.subThreadLoop(i);
                }
            }
        });
        thread.start();

        for (int i = 0; i < 50; i++) {
            business.mainThreadLoop(i);
        }

    }

}
