package tech.codingclub.utility;

import java.util.Scanner;

public class ThreadExample extends Thread{

    private String threadName;
    private  int counter;
    private  int waitTimeWhileLoop;

    public ThreadExample(String threadName, int counter, int waitTimeWhileLoop){
        this.threadName= threadName;
        this.counter=counter;
        this.waitTimeWhileLoop=waitTimeWhileLoop;
    }

    //We are overriding how run will work
    public  void  run(){
        //we will define what process we want to run parallel
        while (counter<1000){
            counter++;
            //sleep!

            try {
                Thread.sleep(waitTimeWhileLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            System.out.println(threadName+":"+counter);
        }
    }

    public static void main(String[] args) {
        ThreadExample thread1= new ThreadExample("THREAD_A",0,500);
        ThreadExample thread2= new ThreadExample("THREAD_B",0,1000);
        ThreadExample thread3= new ThreadExample("THREAD_C",0,2000);

        thread1.start();
        thread2.start();
        thread3.start();

        Scanner scanner = new Scanner(System.in);
        int x= scanner.nextInt();
    }
}
