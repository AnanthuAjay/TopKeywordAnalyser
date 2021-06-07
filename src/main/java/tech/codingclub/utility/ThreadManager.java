package tech.codingclub.utility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {


    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager(100);
        for (int i=0;i<1000;i++){
        RunnableExample temp= new RunnableExample("THREAD-No_"+i,0,500+i);
        taskManager.waitTillQueueIsFreeAndAddTask(temp);
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$"+i);
        }
        System.out.println("#################################################################################");

        //1.TaskManager for N no of threads parallel
        //2.Main Thread should pause when there is enough queue size

    }
}
