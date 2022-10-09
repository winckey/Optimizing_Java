public class ModelAARunner {
    public static void main(String[] args) {
        /* Using Runnable Interface */

        Runnable r = new ModelAllocator();
        Thread t = new Thread(r);
        t.start();
    }
}