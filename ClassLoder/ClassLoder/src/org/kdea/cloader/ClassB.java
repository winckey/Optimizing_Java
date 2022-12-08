package org.kdea.cloader;

public class ClassB
{

    public synchronized  void run(String th)
    {
        System.out.println(th + " lock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(th + " unlock");
    }
}