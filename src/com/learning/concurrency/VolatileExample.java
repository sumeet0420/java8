package com.learning.concurrency;

public class VolatileExample {
    //If volatile is removed, the program runs in infinite loop.
    //Volatile variables are stored in Main Memory.
    private static /*volatile*/ boolean done = false;
    private static int count;

    public static synchronized boolean getDone(){
        return done;
    }

    public static synchronized void setDone(boolean value){
        done = value;
    }
    //Shared Mutuality is the root cause of multiple concurrency problems..
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        new Thread(() -> runTillDone()).start();
        Thread.sleep(5000);
        System.out.println("changing done");
        setDone(true);;
    }

    public static void runTillDone() {
        while (!getDone()) {
            count++;
        }
        System.out.println("DONE!!!");
    }
}
