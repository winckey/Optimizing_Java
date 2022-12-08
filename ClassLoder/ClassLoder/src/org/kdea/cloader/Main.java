package org.kdea.cloader;


import java.time.LocalDateTime;

public class Main
{


    public static void main(String[] args)
    {
        ClassA a = new ClassA();
        ClassA a2 = new ClassA();
        Thread thread1 = new Thread(() -> {
            a.run("스레드1");
        });
        Thread thread2 = new Thread(() -> {
            a2.run("스레드2");
        });
        thread1.start();
        thread2.start();
    }
}
