package gc;

public class ModelObjectAllocation implements Runnable{


    private final int[][] allcoated;
    private final int lifeTime;

    public ModelObjectAllocation(final int x , final int y, int lifeTime) {
        this.allcoated = new int [x][y];// 객체 크기
        this.lifeTime = lifeTime;
    }





    @Override
    public void run() {
        try {
            Thread.sleep(lifeTime);// 스레드 생존시간 실행하고 나면 죽음
            System.err.println(System.currentTimeMillis() + " " + allcoated.length  + " " + lifeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}