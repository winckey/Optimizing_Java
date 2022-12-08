import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ModelAllocator implements Runnable{

    private volatile boolean shutdown =false;

    private double chanceOfLongLived = 0.02;
    private int multiplierForLongLived = 20;
    private int x = 1024;
    private int y = 1024;
    private int mbPerSec = 110;// 초당 50개를 생성
    private int shortLivedMs = 100; // 객체 생존 시간
    private int nThreds = 8;
    private Executor exec = Executors.newFixedThreadPool(nThreds);// 스레드풀은 8개로 진행


    @Override
    public void run() {
        final  int mainSleep = (int)(1000.0 / mbPerSec); // 50 이면 20ms만큼 멈춘다 -> 초당 50개 보넨다



        while (!shutdown){
            for (int i = 0; i < mbPerSec; i++) {
                ModelObjectAllocation to = new ModelObjectAllocation( x , y , lifetime());
                exec.execute(to);

                try {
                    Thread.sleep(mainSleep);// 할당률 설정

                } catch (InterruptedException e) {
                    shutdown = true;
                }
            }
        }
    }

    private int lifetime() {
        if(Math.random() < chanceOfLongLived){
            return multiplierForLongLived * shortLivedMs;// 일정확률로 오래 생존하는 객체 생성
        }
        return shortLivedMs;
    }
}