package org.kdea.cloader;



public class ClassA
{
    public static synchronized  void run(String th)
    {
        System.out.println(th + " lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        System.out.println(th + " unlock");
    }
}