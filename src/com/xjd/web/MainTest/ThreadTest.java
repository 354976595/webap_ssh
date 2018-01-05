package com.xjd.web.MainTest;

/**
 * Created by Administrator on 2018/1/4.
 */
public class ThreadTest {

    public static void main(String[] args) {
        ThreadClass threadClass=new ThreadClass(5);
        Thread thread1=new Thread(threadClass,"thread1");
        Thread thread2=new Thread(threadClass,"thread2");
        Thread thread3=new Thread(threadClass,"thread3");
        thread1.start();
        thread2.start();
        thread3.start();

    }


    static class ThreadClass implements Runnable{
        private Integer ticket;
        public ThreadClass(Integer ticket) {
            this.ticket = ticket;
        }

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public  void run() {
            try {
               Thread.sleep(100);
                synchronized (this){
                    System.out.println("线程:\t" + Thread.currentThread().getName() + "\nticket=" + ticket);
                    ticket--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
